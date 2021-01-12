package week07d05;

public class VehicleMain {

    public static void main(String[] args) {

//    Vehicle v = new Vehicle();   abstract
        Motorcycle mAlap = new Motorcycle();
        System.out.println(mAlap.getNumberOfGears() + "" + mAlap.getTransmissionType());

        Car c = new Car(5,TransmissionType.SEQUENTIAL);
        Car c2 = new Car();
        System.out.println(c.getNumberOfGears() +""+ c.getTransmissionType());
        System.out.println(c2.getNumberOfGears() +""+ c2.getTransmissionType());

        Truck t = new Truck(11, TransmissionType.MANUAL);
        Truck t2 = new Truck();
        System.out.println(t.getNumberOfGears() +""+t.getTransmissionType());
        System.out.println(t2.getNumberOfGears() +""+t2.getTransmissionType());
    }
}
