package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {

    ActivityDao dao;

    @BeforeEach
    public void init() {
        MariaDbDataSource ds;

        try {
            ds = new MariaDbDataSource();
            ds.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            ds.setUser("activitytracker");
            ds.setPassword("activitytracker");
        } catch (SQLException sq) {
            throw new IllegalStateException("Cannot connect", sq);
        }

        Flyway flyway = Flyway.configure()
                .locations("/db/migration/activitytracker")
                .dataSource(ds)
                .load();
        flyway.clean();
        flyway.migrate();

        dao = new ActivityDao(ds);
    }

    @Test
    public void beforeDate(){
        assertEquals(3, dao.activitiesBeforeDate(LocalDate.of(2019, 1,5)).size());
    }

    @Test
    void getAll(){
        assertEquals(4, dao.selectAllActivities().size());
    }

    @Test
    void findByType(){
        assertEquals(2, dao.selectActivityByType(Type.BIKING).size());
        assertEquals(0, dao.selectActivityByType(Type.RUNNING).size());
    }

    @Test
    void saveActivity() {

        Activity a5 = new Activity(LocalDateTime.of(2020, 5, 23, 10, 7, 0), "Bicó Bük", Type.BIKING);
        dao.saveActivity(a5);

        assertEquals(5, dao.selectAllActivities().size());
        assertEquals(2020, dao.selectById(5).getStartTime().getYear());
        assertEquals(3, dao.selectActivityByType(Type.BIKING).size());
    }

    @Test
    public void testSaveTrackPoints(){
        Activity a1 = new Activity(LocalDateTime.of(2011, 1, 23, 10, 7, 0), "Hozzáadott,id 5 lesz", Type.BIKING);
        List<TrackPoint> tps = List.of(
        new TrackPoint(LocalDateTime.of(2011,1,23,10,8,0), 1.45, 10.25),
        new TrackPoint(LocalDateTime.of(2011,1,23,11,8,0), 2.70, 11.25525),
        new TrackPoint(LocalDateTime.of(2011,1,23,12,8,0), 3.452548, 12.25));

        a1.setTrackPoint(tps);
        dao.saveActivity(a1);

        //3 2011-01-23T12:08 3.45 12.25
        assertEquals(12.25, dao.selectById(5).getTrackPoint().get(2).getLon() );
    }

    @Test
    public void testSaveTrackPointsRollback(){
        Activity a1 = new Activity(LocalDateTime.of(2011, 1, 23, 10, 7, 0), "Hozzáadott,id 5 lesz", Type.BIKING);
        List<TrackPoint> tps = List.of(
                new TrackPoint(LocalDateTime.of(2011,1,23,10,8,0), 1.45, 10.25),
                new TrackPoint(LocalDateTime.of(2011,1,23,11,8,0), 2.70, 11.25),
                new TrackPoint(LocalDateTime.of(2011,1,23,12,8,0), 3.45, 200.01));

        a1.setTrackPoint(tps);
        System.out.println("Nem kerülhet be: "+ a1.getTrackPoint().get(2) );

        assertThrows(IllegalStateException.class, () -> dao.saveActivity(a1));
    }

}
