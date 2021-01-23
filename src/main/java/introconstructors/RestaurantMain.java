package introconstructors;

public class RestaurantMain {

    public static void main(String[] args) {
        Restaurant resti = new Restaurant("Késdobáló", 5);
        System.out.println(resti.getName() +" "+ resti.getCapacity() +" főnek");
        System.out.println("Kaja: "+ resti.getMenu());
    }
    
}
