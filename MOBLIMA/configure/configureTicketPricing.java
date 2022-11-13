package MOBLIMA.configure;

import java.io.IOException;
import java.util.Scanner;
import MOBLIMA.configurables.ageGroupPricing;

/**
 * Represents a configure class to display age category ticket pricing and
 * obtains the
 * user's input.
 */
public class configureTicketPricing implements configure {
    public void displaySetting() throws IOException {
        System.out.println("Current ticket pricing for each age category:");
        System.out.print("Child: $");
        System.out.println(ageGroupPricing.getPriceOfChild());
        System.out.print("Adult: $");
        System.out.println(ageGroupPricing.getPriceOfAdult());
        System.out.print("Senior Citizen: $");
        System.out.print(ageGroupPricing.getPriceOfSnrCitizen());
        System.out.println("_____________________________________________________________");
    }

    /**
     * Obtains the user console input for a new age category ticket pricing.
     */
    public void getNewSetting() throws IOException {
        Scanner sc = new Scanner(System.in);
        Double price = (double) 0;
        System.out.println("Please input new child ticket price:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        price = sc.nextDouble();
        ageGroupPricing.setPriceOfChild(price);
        System.out.println("Please input new adult ticket price:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        price = sc.nextDouble();
        ageGroupPricing.setPriceOfAdult(price);
        System.out.println("Please input new senior citizen ticket price:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        price = sc.nextDouble();
        ageGroupPricing.setPriceOfSnrCitizen(price);
        ageGroupPricing.savePricing();
    }
}