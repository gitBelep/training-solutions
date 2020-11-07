package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List <MeetingRoom> rooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meet){
        rooms.add(meet);
    }

    public void printNames(){
        for (int i = 0; i<rooms.size(); i++){
            System.out.print(rooms.get(i).getName() +", ");
        }
        System.out.println();
    }
    public void printNamesReverse() {
        int rev = rooms.size();
        for (int i = rooms.size() - 1; i > -1; i--) {
            System.out.print(rooms.get(i).getName() +", ");
        }
        System.out.println();
    }

    public void printEvenNames() {
        for (int i = 1; i < rooms.size(); i = i + 2) {
            System.out.print(rooms.get(i).getName() +", ");
        }
        System.out.println();
    }

    public void Areas(){
        for (int i = 0; i<rooms.size(); i++){
            System.out.print(rooms.get(i).getName() +" "+ rooms.get(i).getWidth() +"m "+ rooms.get(i).getLength() +"m " +rooms.get(i).getArea(rooms.get(i)) +"m2");
        }
        System.out.println();
    }

    public void printMeetingRoomsWithName(String name){
        for (int i = 0; i<rooms.size(); i++){
            if (rooms.get(i).getName().equals(name)){
                System.out.print(rooms.get(i).getName() +" "+ rooms.get(i).getWidth() +"m "+ rooms.get(i).getLength() +"m " +rooms.get(i).getArea(rooms.get(i)) +"m2");
            }
        }
        System.out.println();
    }

    public void printMeetingRoomsContains(String part){
        for (int i = 0; i<rooms.size(); i++){
            part = part.toUpperCase();
            if (rooms.get(i).getName().toUpperCase().contains(part)){
                System.out.print(rooms.get(i).getName() +" "+ rooms.get(i).getWidth() +"m "+ rooms.get(i).getLength() +"m " +rooms.get(i).getArea(rooms.get(i)) +"m2 ");
            }
        }
        System.out.println();
    }
    public void printAreasLargerThan(int area){
        for (int i =0; i < rooms.size(); i++){
            if (rooms.get(i).getArea(rooms.get(i)) > area) {
                System.out.print(rooms.get(i).getName() +" "+ rooms.get(i).getWidth() +"m "+ rooms.get(i).getLength() +"m " +rooms.get(i).getArea(rooms.get(i)) +"m2");
            }
        }
        System.out.println();
    }

}
