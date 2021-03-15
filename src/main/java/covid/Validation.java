package covid;

public class Validation {

    public String nameIsValid(String name) {
        if (isEmpty(name)){
            throw new IllegalArgumentException("Name must not be empty.");
        }
        for (Character c : name.toCharArray()){
            if (!Character.isLetter(c) && ". ,'-".indexOf(c) < 0){
                throw new IllegalArgumentException("Name is not valid.");
            }
        }
        return name;
    }

    public boolean isEmpty(String str) {
        return str == null || str.trim().equals("");
    }

    public String isZipValid(String zipString){
        if (isEmpty(zipString) || zipString.trim().length() != 4){
            throw new IllegalArgumentException("4 digit ZIP code must not be empty.");
        }
        try {
            int zipCode = Integer.parseInt(zipString);
            return zipString;
        } catch (NumberFormatException nfe){
            throw new IllegalArgumentException("ZIP code is not valid.");
        }
    }

    public int getAge(String strAge){
        try {
            int age = Integer.parseInt(strAge);
            if (10 < age && age < 150) {
                return age;
            }
        } catch (NumberFormatException n){
            throw new IllegalArgumentException("Age is not valid.");
        }
        throw new IllegalArgumentException("Age is not valid.");
    }

    public String isEmailValid(String email1, String email2){
        if (isEmpty(email1) || isEmpty(email2)){
            throw new IllegalArgumentException("E-mail address is not valid.");
        }
        if (email1.equalsIgnoreCase(email2) &&
                email1.indexOf('@') > 0 &&
                email1.length() >= 3){
            return email1;
        }
        throw new IllegalArgumentException("E-mail address is not valid.");
    }

    public String isTajValid(String strRow){
        if (strRow.trim().length() != 9){
            throw new NumberFormatException("TAJ number is too short.");
        }
        String strTAJ = strRow.trim().substring(0,9);
        int sum = 0;
        try{
            for (int i = 0; i < 8; i = i + 2){
                sum += 3 * Integer.parseInt(strTAJ.substring(i, i+1));
                sum += 7 * Integer.parseInt(strTAJ.substring(i+1, i+2));
            }
            if (sum % 10 == Integer.parseInt(strTAJ.substring(8))){
                return strTAJ;
            }
        } catch (NumberFormatException n){
            throw new IllegalArgumentException("TAJ number is not valid. "+ n.getMessage());
        }
        throw new IllegalArgumentException("TAJ number is not valid.");
    }

}
