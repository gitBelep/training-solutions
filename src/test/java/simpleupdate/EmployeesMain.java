package simpleupdate;

import org.mariadb.jdbc.MariaDbDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

        try (
        Connection conn = ds.getConnection();
        Statement stm = conn.createStatement() ){

            stm.execute("INSERT INTO `employees` (emp_name) VALUES ('John Doe2');");
            stm.execute( "INSERT INTO `employees` (emp_name) VALUES ('John Doe3');");

     //nem működnek
// stm.execute("INSERT INTO `employees` (emp_name) VALUES ('John Doe2');" +
//                    "INSERT INTO `employees` (emp_name) VALUES ('John Doe3');");

// stm.execute("INSERT INTO `employees` (emp_name) VALUES ('John Doe2'); INSERT INTO `employees` (emp_name) VALUES ('John Doe3');");

        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }
}
