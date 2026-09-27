package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        
        int count = scanner.nextInt();
        Rental[] rentals = new Rental[count];

        for (int i = 0; i < count; i++) {
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int unit = scanner.nextInt();
            
            if (type.equalsIgnoreCase("LAPTOP")) {
                rentals[i] = new LaptopRental(id, days);
            } else {
                rentals[i] = new ProjectorRental(id, days);
            }
        }

        for (Rental rental : rentals) {
            System.out.println(rental.summary());
        }
    }
}