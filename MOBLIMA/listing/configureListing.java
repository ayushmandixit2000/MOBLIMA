package MOBLIMA.listing;

import java.io.IOException;
import java.util.Scanner;

/**
 * Helper class to list configurable options.
 */
public class configureListing implements Listing {
    private int option;

    /**
     * List configurable options.
     */
    public void displayListing() throws IOException {
        System.out.println();
        System.out.println("_____________________________________________________________");
        System.out.println("Please select what you would like to configure:");
        System.out.println("1: Edit Ticket Age Catgeory Pricing");
        System.out.println("2: Edit Ticket Pricings");
        System.out.println("3: Edit Peak Dates");
        System.out.println("4: Edit Rating View Options");
        System.out.println("5: Quit");
        System.out.println("_____________________________________________________________");
    }

    /**
     * Obtains admin's input of intended option.
     * 
     * @return the admin's intended option.
     */
    public int getUserInput() {
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
