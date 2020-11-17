package stringbasic.pets;

import java.time.LocalDate;

public class Pet {
    private String name;
    private LocalDate date;
    private Gender g;
    private String regNr;

    public Pet(String name, LocalDate date, Gender g, String regNr) {
        this.name = name;
        this.date = date;
        this.g = g;
        this.regNr = regNr;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public Gender getG() {
        return g;
    }

    public String getRegNr() {
        return regNr;
    }

}
