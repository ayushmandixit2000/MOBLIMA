package MOBLIMA.configure;

import java.io.IOException;
import java.util.Scanner;
import MOBLIMA.configurables.peakPricing;

public class configurePeakPricing implements configure {
    public void displaySetting() throws IOException {
        System.out.println("Current ticket pricing multipliers:");
        System.out.print("Non-peak(mon,tues,wed,fri): x ");
        System.out.println(peakPricing.getNonPeakMultiplier());
        System.out.print("Non-peak(Thurs): x ");
        System.out.println(peakPricing.getThursMultiplier());
        System.out.print("Peak (Weekend, PH, specific dates): x m ");
        System.out.println(peakPricing.getPeakMultiplier());
        System.out.print("Platinium Movie Suite Surcharge: ");
        System.out.println(peakPricing.getPremiumPrice());
        System.out.print("Elite Seat multiplier: x ");
        System.out.println(peakPricing.getPriceOfElite());
        System.out.print("Ultima Seat multiplier: x ");
        System.out.println(peakPricing.getPriceOfUltima());
        System.out.println("_____________________________________________________________");
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

        System.out.println("Please new elite seat surcharge:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        extra = sc.nextDouble();
        peakPricing.setPriceOfElite(extra);

        System.out.println("Please new ultima seat surcharge:");
        while (!sc.hasNextDouble()) {
            System.out.println("Please input a double:");
            sc.next();
        }
        extra = sc.nextDouble();
        peakPricing.setPriceOfUltima(extra);

        peakPricing.saveMultipliers();
    }
}