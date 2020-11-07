package week02;
import java.util.Scanner;

public class Controller {
    private Office office;

    public Office readOffice(){
        Office off = new Office();
        System.out.println("Hány Tárgyaló van?");
        Scanner sc1 = new Scanner(System.in);
        int answer = sc1.nextInt();
        for (int i=0; i<answer; i++){
            sc1.nextLine();
            System.out.println("Add meg a nevet:");
            String name = sc1.nextLine();
            System.out.println("Hossza:");
            int length = sc1.nextInt();
            sc1.nextLine();
            System.out.println("Szélessége:");
            int width = sc1.nextInt();
            MeetingRoom meet = new MeetingRoom(name,length,width);
            off.addMeetingRoom(meet);
        }
        return off;
    }

    public void printMenu(){
        System.out.println(" * MENÜ *");
        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafele sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
    }

    public void runMenu(Office off){
        System.out.println("Mivel folytassuk?");
        Scanner sc2 = new Scanner(System.in);
        int number = sc2.nextInt();
        sc2.nextLine();
        if (number == 1){off.printNames();}
        if (number == 2){off.printNamesReverse();}
        if (number == 3){off. printEvenNames(); }
        if (number == 4){off.Areas(); }
        if (number == 5){
            System.out.println("Név:");
            String name = sc2.nextLine();
            off.printMeetingRoomsWithName(name);
        }
        if (number == 6){
            System.out.println("Név részlete:");
            System.out.println();
            String part = sc2.nextLine();
            off.printMeetingRoomsContains(part);
        }
        if (number == 7){
            System.out.println("Minimum terület");
            int area = sc2.nextInt();
            off.printAreasLargerThan(area);
        }
    }

    public static void main(String[] args) {
        Controller co = new Controller();
        Office wholeOffice = co.readOffice();
        co.printMenu();
        co.runMenu(wholeOffice);
    }
}
