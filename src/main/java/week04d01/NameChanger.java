package week04d01;

public class NameChanger {
    private String fullName;

    public NameChanger(String fullName) {
        if (fullName == null || "".equals(fullName.trim())){
            throw new IllegalArgumentException("Invalid Name:" + fullName);
        }
        this.fullName = fullName;
    }
    public void changeFirstName(String firstName){
        String lastName = fullName.split(" ")[1];
        this.fullName = firstName +" " +lastName;
    }

    public String getFullName() {
        return fullName;
    }
}
