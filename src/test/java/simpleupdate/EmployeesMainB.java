package simpleupdate;

import org.mariadb.jdbc.MariaDbDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeesMainB {

    public static void main(String[] args)  {
        MariaDbDataSource ds = new MariaDbDataSource();
        try {
            ds.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
            ds.setUser("employees");
            ds.setPassword("employees");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot set", e);
        }

        try (
            Connection conn = ds.getConnection();
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO `employees` (emp_name) VALUES (?)"))
            {
            pstm.setString(1, "Első Aárvíztűrő");
//            pstm.setString(2, "Második");
            pstm.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }
}
