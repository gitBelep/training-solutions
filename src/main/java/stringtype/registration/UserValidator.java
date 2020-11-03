package stringtype.registration;
public class UserValidator {
    private String name;
    private String psw1;
    private String psw2;
    private String email;

    public UserValidator(String name, String psw1, String psw2, String email) {
        this.name = name;
        this.psw1 = psw1;
        this.psw2 = psw2;
        this.email = email;
    }

    public boolean isOkName(){
        return name.length() > 0;
    }
    public boolean isOkPsw(){
        return psw1.length() >7 && psw1.equals(psw2);
    }
    public boolean isOkEmail(){
        int whereAt = email.indexOf("@");
    /* Igen, megnéztem a megoldást.
     * int whereDot = email.indexOf(".");  --nem az első pont kell!
     * return whereAt > 0 && whereDot > (whereAt+1) && whereDot < (email.length()-1);
     */
        int whereDot = email.substring(whereAt+1).indexOf(".");
        return whereAt > 0 && whereDot < (email.substring(whereAt+1).length()-1) && whereDot>0;
    }
}
