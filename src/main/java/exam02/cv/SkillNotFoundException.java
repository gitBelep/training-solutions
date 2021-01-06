package exam02.cv;

public class SkillNotFoundException extends RuntimeException {
    private String ex;

    public SkillNotFoundException(String ex) {
        this.ex = ex;
    }

}
