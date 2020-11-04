package introcontrol;
import java.util.Scanner;

public class IntroControl {
    private int number;

    public IntroControl(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int substractTenIfGreaterThanTen(int number) {
        if (number <= 10) {
            return number;
        } else {
            return number - 10;
        }
    }

    public String describeNumber(int number) {
        if (number == 0) {
            return "zero";
        } else {
            return "not zero";
        }
    }

    public void printNumbersBetweenAnyDirection(int a, int b) {
        if (a > b) {
            for (int i = a; i >= b; i = i - 1) {
                System.out.print(i + ", ");
            }

        } else {
            for (int i=a; i<=b; i++){
                System.out.print(i +", ");
            }
        }
    }
}