package exam02.cv;
import java.util.ArrayList;
import java.util.List;

public class Cv {
    private String name;
    private List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public void addSkills(String... skills){
        String cutName = "";
        String cutLevel = "";
        for (String s : skills){
            cutName = s.substring(0, s.length()-3).trim();
            cutLevel = s.substring(s.indexOf("(")+1, s.indexOf(")"));
            int level = getLevel(cutLevel);
            this.skills.add( new Skill(cutName, level) );
        }
    }

    private int getLevel(String cutLevel){
        int level = 0;
        try {
            level = Integer.parseInt(cutLevel);
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
        return level;
    }

    public int findSkillLevelByName(String find){
        for (Skill sk : skills){
            if ( find.equals(sk.getName()) ){
                return sk.getLevel();
            }
        }
        throw new SkillNotFoundException("Skill not found");
    }

    public String getName() {
        return name;
    }
    public List<Skill> getSkills() {
        return skills;
    }
}
