package generatedid;

import javax.sql.DataSource;
import java.sql.*;

public class EmployeesDao {
    private DataSource ds;

    public EmployeesDao(DataSource ds) {
        this.ds = ds;
    }

    public long createEmployee(String name) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO employees (emp_name) VALUES (?)",
                     Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, name);
            ps.executeUpdate();
            return executeAndGetKey(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    private long executeAndGetKey(PreparedStatement ps) {
        try(ResultSet rs = ps.getGeneratedKeys()){
            if(rs.next()) {
                return rs.getLong("id");
            } else {
                throw new SQLException("Cannot get id");
            }
        }catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    public String findEmployeeNameById(long idIn){
        try (Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(
            "SELECT * FROM employees WHERE id = ?")
        ){
            ps.setLong(1, idIn);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()) {
                    return rs.getString("emp_name");
                } else {
                    throw new SQLException("Cannot get name");
                }
            }catch (SQLException sqle) {
                    throw new IllegalArgumentException("Error by query", sqle);
                }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot access", se);
        }
    }

}
