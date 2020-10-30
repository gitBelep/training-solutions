package classsctructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book bbook = new Book("Gárdonyi", "Egri");
        bbook.register("1234/56");
        System.out.println("Adatok: " + bbook.getAuthor() + ": "+ bbook.getTitle() +" "+ bbook.getRegNumber());
    }
}
