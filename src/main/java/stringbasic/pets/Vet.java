package stringbasic.pets;

import java.util.ArrayList;
import java.util.List;

public class Vet {
    private List<Pet> pets = new ArrayList<>();

    public void add (Pet pet){
        List<String> regNrs = new ArrayList<>();
        for (Pet p:pets){
            regNrs.add(p.getRegNr());
        }
        if (!regNrs.contains(pet.getRegNr())) {
            pets.add(pet);
        }
    }

    public List<Pet> getPets (){
        return pets;
    }
}
