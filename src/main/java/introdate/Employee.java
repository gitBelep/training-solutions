package introdate;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {
    private String name;
    private LocalDate DateOfBirth;
    private LocalDateTime beginEmployment;

    public Employee(int year,int month,int day,String name){
        this.name=name;
        this.beginEmployment = LocalDateTime.now();
        this.DateOfBirth = DateOfBirth.of(year,month,day);
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }
    public String getName(){
        return name;
    }
    public LocalDateTime getBeginEmployment(){
        return beginEmployment;
    }
    public void setName(String eName){
        name = eName;
    }



}
