package MOBLIMA.listing;

import java.io.IOException;
import java.util.Scanner;

public class configureListing implements Listing {
    public void displayListing() throws IOException {
        System.out.println();
        System.out.println("_____________________________________________________________");
        System.out.println("Please select what you would like to configure:");
        System.out.println("1: Edit Ticket Base Pricing");
        System.out.println("2: Edit Ticket Peak, Premium Class, Elite and Ultima Seat Pricing");
        System.out.println("3: Edit Peak Dates");
        System.out.println("4: Edit Rating View Options");
        System.out.print("5: Quit");
        System.out.println("_____________________________________________________________");
    }

    public int userInput() {
        Scanner sc = new Scanner(System.in);
        int option;
        while (true) {
            String input = sc.next();
            option = 0;
            try {
                option = Integer.parseInt(input);
                if (option > 5 || option < 1) {
                    System.out.println("Please key in a valid number!");
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ne) {
                System.out.println("Please key in a number only!");
            }
        }
        return option;
    }
}
