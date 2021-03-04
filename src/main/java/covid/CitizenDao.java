package covid;

import org.mariadb.jdbc.MariaDbDataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CitizenDao {
    private static MariaDbDataSource ds;

    static {
        try {
            ds = new MariaDbDataSource();
            ds.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            ds.setUser("doctor");
            ds.setPassword("doctor");
        } catch (SQLException sq) {
            throw new IllegalStateException("Cannot connect", sq);
        }
    }

    public List<String> findCityToZip(String zipCode) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT `city` FROM `cities` WHERE `zip` = ?")
        ) {
            ps.setString(1, zipCode);
            return selectStringListByPreparedStatement(ps);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("ZIP code is not valid.");
        }
    }

    private List<String> selectStringListByPreparedStatement(PreparedStatement ps) {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String cityName = rs.getString("city");
                result.add(cityName);
            }
            return result;
        } catch (SQLException se) {
            throw new IllegalArgumentException("Wrong ZIP Code", se);
        }
    }

    public void registerCitizen(List<Citizen> citizens) {
        try (Connection conn = ds.getConnection()) {
            conn.setAutoCommit(false);
            writeCitizenToDb(citizens, conn);
        } catch (SQLException se) {
            throw new IllegalArgumentException("Cannot write DB. ", se);
        }
    }

    private void writeCitizenToDb(List<Citizen> citizens, Connection conn) throws SQLException {
        int lineCounter = 1;
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO `citizens` (`citizen_name`, `zip`,`age`, `email`, `taj`, `number_of_vaccination`) VALUES (?,?,?,?,?,?)"
        )) {
            for (Citizen citizen : citizens) {
                ps.setString(1, citizen.getName());
                ps.setString(2, citizen.getZipCode());
                ps.setInt(3, citizen.getAge());
                ps.setString(4, citizen.getEmail());
                ps.setString(5, citizen.getTaj());
                ps.setInt(6, citizen.getNumberOfVaccination());
                ps.executeUpdate();
                lineCounter++;
            }
            conn.commit();
        } catch (SQLException se) {
            conn.rollback();
            throw new IllegalArgumentException("False data in row: " + lineCounter);
        }
    }

    public List<Citizen> chooseCitizensForVaccination(String zipStr) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT * FROM `citizens` WHERE `zip` = ? AND`number_of_vaccination` = 0 OR (`number_of_vaccination` = 1 AND `last_vaccination` < ?) ORDER BY `age` DESC, `citizen_name` LIMIT 16"
             )) {
            ps.setString(1, zipStr);
            ps.setDate(2, Date.valueOf(LocalDate.now().minusDays(15)));
            return selectCitizensByPreparedStatement(ps);
        } catch (SQLException se) {
            throw new IllegalArgumentException("Wrong ZIP Code", se);
        }
    }

    private List<Citizen> selectCitizensByPreparedStatement(PreparedStatement ps) {
        List<Citizen> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString(2);
                String zip = rs.getString(3);
                int age = rs.getInt(4);
                String email = rs.getString(5);
                String taj = rs.getString(6);
                int numberOfVaccination = rs.getInt(7);
                int id = rs.getInt(1);
                result.add(new Citizen(name, zip, age, email, taj, numberOfVaccination, id));
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("Wrong ZIP Code", se);
        }
        return result;
    }

    public String searchVaccinationType(String tajStr) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT `number_of_vaccination`, `vaccination_type` FROM `citizens` LEFT JOIN `vaccinations` ON citizens.citizen_id = vaccinations.citizen_id WHERE citizens.taj = ?")
        ) {
            ps.setString(1, tajStr);
            return selectTypeByPreparedStatement(ps);
        } catch (SQLException se) {
            throw new IllegalArgumentException("Wrong ZIP Code", se);
        }
    }

    private String selectTypeByPreparedStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                long numberOfVaccination = rs.getLong("number_of_vaccination");
                if (numberOfVaccination == 1) {
                    return rs.getString("vaccination_type");
                } else if (numberOfVaccination == 0) {
                    return "";
                } else {
                    throw new IllegalArgumentException("Már többször( " + numberOfVaccination + " ) beoltva.");
                }
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("", se);
        }
        throw new IllegalArgumentException("");
    }

    public void registerVaccination(String tajStr, String type) {
        try (Connection conn = ds.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement ps = conn.prepareStatement(
                    "UPDATE `citizens` SET `number_of_vaccination` = (SELECT `number_of_vaccination` FROM `citizens` WHERE taj = ?) + 1 WHERE `taj` = ?"
            )) {
                ps.setString(1, tajStr);
                ps.setString(2, tajStr);
                ps.executeUpdate();
                try (PreparedStatement ps2 = conn.prepareStatement(
                        "INSERT INTO `vaccinations` (`citizen_id`, `vaccination_date`, `status`, `note`, `vaccination_type`) VALUES (?, ?, 'OK', '-', ?)"
                )) {
                    int id = getCitizenIdToTaj(conn, tajStr);
                    ps2.setInt(1, id);
                    ps2.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                    ps2.setString(3, type);
                    ps2.executeUpdate();
                }
                conn.commit();
            } catch (SQLException se) {
                conn.rollback();
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("Wrong TAJ code", se);
        }
    }

    private int getCitizenIdToTaj(Connection conn, String tajStr) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM citizens WHERE taj = ?"
        )) {
            ps.setString(1, tajStr);
            return selectCitizensByPreparedStatement(ps).get(0).getId();
        }
    }

    public int existCitizenToTaj(String tajStr){
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT `id` FROM `citizens` WHERE taj = ?")
        ) {
            ps.setString(1, tajStr);
            return getCitizenIdToTaj(conn, tajStr);
        } catch (SQLException se) {
            throw new IllegalArgumentException("Wrong TAJ Code", se);
        }
    }


    public void registerFailedVaccination(String tajStr, String note) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO `vaccinations` (`citizen_id`, `vaccination_date`, `status`, `note`, `vaccination_type`) VALUES (?, ?, 'FAILED', ?, '-')"
        )) {
            int id = getCitizenIdToTaj(conn, tajStr);
            ps.setInt(1, id);
            ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            ps.setString(3, note);
            ps.executeUpdate();
        }
        catch (SQLException se) {
            throw new IllegalArgumentException("Cannot insert vaccination", se);
        }
    }


    public Map<Integer, Integer> reportForOneZipCode(String zipCode) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT number_of_vaccination, COUNT(zip) FROM `citizens` WHERE zip = ? GROUP BY number_of_vaccination")
        ) {
            ps.setString(1, zipCode);
            return sumVaccinatedsByPreparedStatement(ps);
        } catch (SQLException se) {
            throw new IllegalArgumentException("Wrong ZIP Code", se);
        }
    }

    private Map<Integer, Integer> sumVaccinatedsByPreparedStatement(PreparedStatement ps) {
        Map<Integer, Integer> result = new HashMap<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int numberOfVaccination = rs.getInt("number_of_vaccination");
                int sumCitizens = rs.getInt("count(zip)");
                result.put(numberOfVaccination, sumCitizens);
            }
            return result;
        } catch (SQLException se) {
            throw new IllegalArgumentException("Wrong ZIP Code", se);
        }
    }

    public List<String> report() {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT `zip`, `number_of_vaccination`, COUNT(zip) FROM `citizens` GROUP BY `zip`, `number_of_vaccination`")
        ) {
            return choseCitizenToZip(ps);
        } catch (SQLException se) {
            throw new IllegalArgumentException("Cannot acces DB", se);
        }
    }

    private List<String> choseCitizenToZip(PreparedStatement ps) {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String zip = rs.getString("zip");
                int numberOfVaccination = rs.getInt("number_of_vaccination");
                int sumCitizens = rs.getInt("count(zip)");
                result.add(zip +";"+ numberOfVaccination +";"+ sumCitizens);
            }
            return result;
        } catch (SQLException se) {
            throw new IllegalArgumentException("Wrong ZIP Code", se);
        }
    }

}
