package classstructuremethods;

public class Client {
    private String name;
    private int yearOfBirth;
    private String address;

    public String getName(){
        return name;
    }

    public int getYearOfBirth(){
        return yearOfBirth;
    }

    public String getAddress(){
        return address;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setYearOfBirth(int year){
        this.yearOfBirth = year;
    }

    public void migrate(String newAddress){
        this.address = newAddress;
    }

}
