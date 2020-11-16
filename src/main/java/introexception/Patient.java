package introexception;

public class Patient {
    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Név nem lehet üres");
        } else {
            this.name = name;
        }

        if (yearOfBirth < 1900){
            throw new IllegalArgumentException("Túl öreg");
        }else{
            this.yearOfBirth = yearOfBirth;
        }


        if (!new SsnValidator().isValidSsn(socialSecurityNumber)){
            throw new IllegalArgumentException("Nem jó szám: " + socialSecurityNumber);
        } else {
            this.socialSecurityNumber = socialSecurityNumber;
        }
    }

    public String getName() {
        return name;
    }
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
