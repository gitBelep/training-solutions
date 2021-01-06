package exam02.cv;

public class SkillNotFoundException extends RuntimeException {
    private String txt;

    public SkillNotFoundException(String txt) {
        this.txt = txt;
    }

}
