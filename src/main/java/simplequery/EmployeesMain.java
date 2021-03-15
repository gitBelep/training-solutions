package simplequery;

import org.mariadb.jdbc.MariaDbDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesMain {

    public static void main(String[] args) {
        MariaDbDataSource ds = new MariaDbDataSource();
        try {
            ds.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            ds.setUser("employees");
            ds.setPassword("employees");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot set", e);
        }

        try (Connection conn = ds.getConnection();
             PreparedStatement pstm = conn.prepareStatement("SELECT emp_name FROM employees WHERE id = ? OR id = ?")
        ) {
            pstm.setLong(1, 1L);
            pstm.setLong(2, 4L);

            try (ResultSet rs = pstm.executeQuery()) {
//if (rs.next()) { //ha egyet kérdezek le is kell if, h biztos létezzen a next
                while (rs.next()) {
                    String name = rs.getString("emp_name");
                    System.out.println(name);
                }
            } catch (SQLException sse) {
                throw new IllegalStateException("Cannot query", sse);
            }

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot set", se);
        }
    }

}
