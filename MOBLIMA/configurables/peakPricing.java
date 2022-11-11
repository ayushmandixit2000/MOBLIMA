package MOBLIMA.configurables;

import java.io.IOException;

import MOBLIMA.retrieval.retrievePeakPricing;
import MOBLIMA.save.savePeakPricing;

//for ppl doing the price configuring
// new peakPricing();
// System.out.println(peakPricing.getPeakMultiplier());
// peakPricing.setPeakMultiplier(2);
// peakPricing.saveMultipliers();

public class peakPricing {
    private static double nonPeakMultiplier;
    private static double peakMultiplier;
    private static double premiumPrice;
    static String filename = "MOBLIMA/databases/peakPricing.txt";

    public peakPricing() throws IOException {
        String data = retrievePeakPricing.readPeakPricing(filename);
        nonPeakMultiplier = Double.parseDouble(data.split("\\,")[0]);
        peakMultiplier = Double.parseDouble(data.split("\\,")[1]);
        premiumPrice = Double.parseDouble(data.split("\\,")[2]);

    }

    public static double getPremiumPrice() {
        return premiumPrice;
    }

    public static double getNonPeakMultiplier() {
        return nonPeakMultiplier;
    }

    public static double getPeakMultiplier() {
        return peakMultiplier;
    }

    public static void setPremiumPrice(double premiumPrice) {
        peakPricing.premiumPrice = premiumPrice;
    }

    public static void setNonPeakMultiplier(double newNonPeak) {
        nonPeakMultiplier = newNonPeak;
    }

    public static void setPeakMultiplier(double newPeak) {
        peakMultiplier = newPeak;
    }

    public static void saveMultipliers() throws IOException {
        String data = String.valueOf(getNonPeakMultiplier()) + "," + String.valueOf(getPeakMultiplier()) + ","
                + String.valueOf(getPremiumPrice());
        savePeakPricing.savePeakPricingString(filename, data);
    }
}
