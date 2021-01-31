package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {
    private static final String LOG_PARSER = "\n";
    private static final String LINE_PARSER = ":";
    private static final DateTimeFormatter FORM = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final int POS_IP = 0;
    private static final int POS_LOGIN = 2;

            //"176.121.45.124:2016-12-03:ggrrrr\n";
    public Map<String, List<Entry>> parseLog(String log) {
        if (!log.contains(LOG_PARSER)){
            throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
        }
        String[] lines = log.split(LOG_PARSER);
        Map<String, List<Entry>> logs = new HashMap<>();
        for (String s : lines) {
            String[] data = s.split(LINE_PARSER);
            try {
                fillTheMap(data, logs);      //átadom neki a Map-et, és azon dolgozik
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Incorrect log: incorrect date",e);
            }
        }
        return logs;
    }

    private void fillTheMap(String[] data, Map<String, List<Entry>> logs){
        List<Entry> toPut = new ArrayList<>();
        LocalDate logDate = LocalDate.parse(data[1], FORM);
        if ((logs.get(data[POS_IP])) == null) {
            toPut.add(new Entry(data[POS_LOGIN], data[POS_IP], logDate));
            logs.put(data[POS_IP], toPut);
        } else {
            toPut = logs.get(data[POS_IP]);
            toPut.add(new Entry(data[POS_LOGIN], data[POS_IP], logDate));
            logs.put(data[POS_IP], toPut);
        }
    }

}
//            DateTimeFormatter form2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//            LocalDateTime anyDay = LocalDateTime.parse("2017-03-08 10:00", form2);
