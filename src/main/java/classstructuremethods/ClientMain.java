package classstructuremethods;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client1 = new Client();
        client1.setName("John Doe");
        client1.setYearOfBirth(1985);
        client1.migrate("1025 Fa út 7");
        System.out.println(client1.getName() + ", " + client1.getYearOfBirth() + ", " + client1.getAddress());

        System.out.println("Adj uj címet:");
        Scanner scAddress = new Scanner(System.in);
        String newAddress = scAddress.nextLine();
        client1.migrate(newAddress);
        System.out.println("Eltárolva: " + client1.getAddress());

    }
}
