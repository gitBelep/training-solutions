package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeSheetItem {
    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem ts) {
        this.employee = ts.employee;
        this.project = ts.project;
        this.from = ts.from;
        this.to = ts.to;
    }

    public static TimeSheetItem withDifferentDay(TimeSheetItem ti, LocalDate date) {
        TimeSheetItem newTsi = new TimeSheetItem(ti);
        newTsi.from =  makeLdt(ti.from.toString(), date);
        newTsi.to = makeLdt(ti.to.toString(), date);
        return newTsi;
    }
//Megoldásból: nem kell splittelni, hanem  LocalDateTime.toLocalTime()
//newTimeSheetItem.to = LocalDateTime.of(localDate, newTimeSheetItem.to.toLocalTime());

    private static LocalDateTime makeLdt(String dateTime, LocalDate newDate) {
        String[] time = dateTime.split(":");
        int hour = Integer.parseInt(time[0].substring(time[0].length() - 2));
        int minute = Integer.parseInt(time[1]);
        LocalTime lt = LocalTime.of(hour, minute);
        return LocalDateTime.of(newDate, lt);
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }
}
