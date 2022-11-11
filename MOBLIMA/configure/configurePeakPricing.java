package MOBLIMA.configure;

import java.io.IOException;
import java.util.Scanner;
import MOBLIMA.configurables.peakPricing;

public class configurePeakPricing implements configure {
    public void displaySetting() throws IOException {
        System.out.println("Current ticket pricing multipliers:");
        System.out.print("Non-peak: x");
        System.out.println(peakPricing.getNonPeakMultiplier());
        System.out.print("Peak: x");
        System.out.println(peakPricing.getPeakMultiplier());
        System.out.print("Premium Surcharge: ");
        System.out.println(peakPricing.getPremiumPrice());
    }

    public void getNewSetting() throws IOException {
        Scanner sc = new Scanner(System.in);
        Double multiplier = (double) 0;
        System.out.println("Please new non-peak multiplier:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        multiplier = sc.nextDouble();
        peakPricing.setNonPeakMultiplier(multiplier);

        System.out.println("Please new peak multiplier:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        multiplier = sc.nextDouble();
        peakPricing.setPeakMultiplier(multiplier);

        System.out.println("Please new premium surcharge:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        Double extra = sc.nextDouble();
        peakPricing.setPremiumPrice(extra);
        peakPricing.saveMultipliers();
    }
}