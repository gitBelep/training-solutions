package transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeesDao {
    private final DataSource ds;

    public EmployeesDao(DataSource ds) {
        this.ds = ds;
    }

    public void createEmployees(List<String> names) {
        try (Connection conn = ds.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement ps = conn.prepareStatement(
               "INSERT INTO employees(emp_name) VALUES (?)")
            ) {
                for (String s : names) {
                    if (s.toLowerCase().startsWith("x")) {
                        throw new IllegalArgumentException("False name");
                    } else {
                        ps.setString(1, s);
                        ps.executeUpdate();
                    }
                }
                conn.commit();
            } catch (IllegalArgumentException ia) {
                conn.rollback();
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot access", se);
        }
    }

//    public List<String> listEmployeeNames(){
//
//    }

}
