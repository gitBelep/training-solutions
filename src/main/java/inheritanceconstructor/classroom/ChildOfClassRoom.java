package inheritanceconstructor.classroom;

public class ChildOfClassRoom extends ClassRoom {

    public ChildOfClassRoom(String location, int capacity, Facility facility) {
        super(location, capacity, facility);
    }
    public String giveAnswer(){
        return "Sikerült. Át kell venni a szülő konstruktorait.";
    }
}
