package MOBLIMA.configure;

import java.io.IOException;
import java.util.Scanner;
import MOBLIMA.configurables.peakPricing;

/**
 * Represents a configure class to display the current settings and obtains the
 * user's input.
 */
public class configurePeakPricing implements configure {
    /**
     * Prints on the console the current saved ticket pricing settings.
     */
    public void displaySetting() throws IOException {
        System.out.println("Current Ticket Pricing Multipliers:");
        System.out.print("Non-peak (Mon,Tues,Wed,Fri): x ");
        System.out.println(peakPricing.getNonPeakMultiplier());
        System.out.print("Non-peak (Thurs): x ");
        System.out.println(peakPricing.getThursMultiplier());
        System.out.print("Peak (Weekend, PH, Specified dates): x ");
        System.out.println(peakPricing.getPeakMultiplier());
        System.out.print("Platinum Movie Suite Surcharge: ");
        System.out.println(peakPricing.getPremiumPrice());
        System.out.print("Elite Seat multiplier: x ");
        System.out.println(peakPricing.getPriceOfElite());
        System.out.print("Ultima Seat multiplier: x ");
        System.out.println(peakPricing.getPriceOfUltima());
        System.out.println("_____________________________________________________________");
    }

    /**
     * Obtains the user console input for a new set of ticket pricing settings..
     */
    public void getNewSetting() throws IOException {
        Scanner sc = new Scanner(System.in);
        Double multiplier = (double) 0;
        System.out.println("Please new non-peak (Mon,Tues,Wed,Fri) multiplier:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        multiplier = sc.nextDouble();
        peakPricing.setNonPeakMultiplier(multiplier);

        System.out.println("Please new non-peak (Thurs) multiplier:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        multiplier = sc.nextDouble();
        peakPricing.setThursMultiplier(multiplier);

        System.out.println("Please new Peak (Weekend, PH, Specified dates) multiplier:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        multiplier = sc.nextDouble();
        peakPricing.setPeakMultiplier(multiplier);

        System.out.println("Please new Platinum Movie Suite surcharge:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        Double extra = sc.nextDouble();
        peakPricing.setPremiumPrice(extra);

        System.out.println("Please new Elite seat surcharge:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        extra = sc.nextDouble();
        peakPricing.setPriceOfElite(extra);

        System.out.println("Please new Ultima seat surcharge:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        extra = sc.nextDouble();
        peakPricing.setPriceOfUltima(extra);

        peakPricing.saveMultipliers();
    }
}