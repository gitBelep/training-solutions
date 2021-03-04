package covid;

public class Citizen {
    private String name;
    private String zipCode;
    private int age;
    private String email;
    private String taj;
    private int numberOfVaccination;
    private int id;

    public Citizen(String name, String zipCode, int age, String email, String taj, int numberOfVaccination){
        this.name = name;
        this.zipCode = zipCode;
        this.age = age;
        this.email = email;
        this.taj = taj;
        this.numberOfVaccination = numberOfVaccination;
    }

    public Citizen(String name, String zipCode, int age, String email, String taj, int numberOfVaccination, int id){
        this.name = name;
        this.zipCode = zipCode;
        this.age = age;
        this.email = email;
        this.taj = taj;
        this.numberOfVaccination = numberOfVaccination;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTaj() {
        return taj;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfVaccination() {
        return numberOfVaccination;
    }

    public String toShortString() {
        return name +";"+ zipCode +";"+ age +";"+ email +";"+ taj;
    }

}
