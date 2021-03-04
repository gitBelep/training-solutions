package architecture;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {
    private final DataSource ds;

    public EmployeesDao(DataSource ds) {
        this.ds = ds;
    }

    public void createEmployee(String name) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO employees (emp_name) VALUES (?)")
        ) {
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public List<String> listEmployeeNames() {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT emp_name FROM employees")
        ) {
            return getNamesFromPreparedStatement(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot connect", se);
        }
    }

    private List<String> getNamesFromPreparedStatement(PreparedStatement ps) {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()){
                result.add(rs.getString("emp_name"));
            }
            return result;
        } catch (SQLException sse) {
            throw new IllegalStateException("Cannot query", sse);
        }
    }

}
