package exceptionclass.course;

public class InvalidTimeException extends RuntimeException {
//    private int hour;
//    private int minute;

    public InvalidTimeException(String msg) {
        super(msg);
    }

//    public InvalidTimeException(int hour, String msg) {
//        super(msg);
//        this.hour = hour;
//    }


}
