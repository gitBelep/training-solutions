package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.*;

class CitizenDaoTest {
    CitizenDao tdao = new CitizenDao();

    @BeforeEach
    public void init() {
//        MariaDbDataSource ds = new MariaDbDataSource();
//        Properties prop = new Properties();
//        try (InputStream is = CitizenDaoTest.class.getResourceAsStream("db.properties")){
//            prop.load(is);
//            ds.setUrl(prop.getProperty("url"));
//            ds.setUser(prop.getProperty("user"));
//            ds.setPassword(prop.getProperty("password", "doctor"));
//        } catch (IOException |SQLException e){
//            System.out.println("Cannot access DB");
//        }

        Flyway flyway = Flyway.configure()
                .locations("/db/migration/covid")
                .dataSource(tdao.getDs())
                .load();
        flyway.clean();
        flyway.migrate();
    }

//    @Test
//    public void




    @Test
    void reportTest7 (){
        System.out.println(tdao.reportForOneZipCode("3000"));
        assertEquals(3, tdao.reportForOneZipCode("3000").size());
    }


}