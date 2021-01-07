package exceptionclass.course;

public class Course {
    private String name;
    private SimpleTime begin;

    public Course(String name, SimpleTime begin) {
        if (name == null || begin == null) {
            throw new IllegalArgumentException("Please provide both name and begin");
        }
        this.name = name;
        this.begin = begin;
    }

    @Override
    public String toString() {
        return new String(String.format("%s: %s", begin.toString(), name));
    }

    public String getName() {
        return name;
    }

    public SimpleTime getBegin() {
        return begin;
    }
}
