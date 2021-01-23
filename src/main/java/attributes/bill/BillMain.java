package attributes.bill;

public class BillMain {

    public static void main(String[] args) {
        Bill b = new Bill();

        b.addItem(new Item("Zsír", 1, 100.1));
        b.addItem(new Item("zsömle", 2, 200.2));
        b.addItem(new Item("víz", 3, 300.3));

        System.out.println("Total: "+ b.calculateTotalPrise());
    }
}
