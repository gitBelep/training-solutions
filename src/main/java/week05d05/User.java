package week05d05;

public class User {
    private String firstName;
    private String lastName;
    private String eMail;


    public User(String firstName, String lastName, String eMail){
        this.firstName = firstName;
        this.lastName = lastName;
        if (eMail.contains(".") && eMail.contains("@")) {
            this.eMail = eMail;
        } else {
            throw new IllegalArgumentException("e-mail should contain \".\" and \"@\" !");
        }
    }

    public String geteMail() {
        return eMail;
    }

    public String getFullName(){
        return firstName +" "+ lastName;
    }
}
