package MOBLIMA.listingInterface;

import java.io.IOException;
import java.util.Scanner;

public class configureListing implements Listing {

    public void displayListing() throws IOException {
        System.out.println("Please select what you would like to configure:\n");
        System.out.println("1: Edit Ticket Base Pricing");
        System.out.println("2: Edit Ticket Peak Pricing Multiplier");
        System.out.println("3: Edit Peak Dates");
        System.out.println("4: Edit Rating View Options");
        System.out.println("5: Quit");
    }

    public int userInput() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int option = 0;
        while (loop) {
            option = sc.nextInt();
            if (option <= 5 && option > 0) {
                loop = false;
            }
        }
        sc.close();
        return option;
    }
}
