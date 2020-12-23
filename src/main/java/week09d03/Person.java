package week09d03;
import java.util.List;
import java.util.Random;

public class Person {
    private int age;
    private String name;
    private Present present;
    final static List<Present> PRESENTS = List.of(Present.TOY, Present.HOUSEKEEPING, Present.ELECTRONIC, Present.DECORATION);

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setPresent() {
        Random rnd = new Random();
        int a = rnd.nextInt(4);
        switch (a) {
            case 1:
                this.present = PRESENTS.get(1);
                break;
            case 3:
                this.present = PRESENTS.get(3);
                break;
            case 2:
                this.present = PRESENTS.get(2);
                break;
            case 0:
                if (getAge() > 14) {
                    setPresent();
                    System.out.println("Túl idős volt, új sorsolás");
                    break;
                }
                this.present = PRESENTS.get(0);
        }
    }

//Fent: switch nehezen bővíthető. Így: csak hozzáírok az enumokhoz.
    public void setPresent2() {
        Random rnd = new Random();
        if (age > 14) {
            present = Present.values()[rnd.nextInt(Present.values().length - 1) + 1];
        } else {
            present = Present.values()[rnd.nextInt(Present.values().length - 1)];
        }
    }

    public Present getPresent() {
        return present;
    }
    public int getAge() {
        return age;
    }
}
