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
    private static double priceOfElite;
    private static double priceOfUltima;
    static String filename = "MOBLIMA/databases/peakPricing.txt";

    public peakPricing() throws IOException {
        String data = retrievePeakPricing.readPeakPricing(filename);
        nonPeakMultiplier = Double.parseDouble(data.split("\\,")[0]);
        peakMultiplier = Double.parseDouble(data.split("\\,")[1]);
        premiumPrice = Double.parseDouble(data.split("\\,")[2]);
        priceOfElite = Double.parseDouble(data.split("\\,")[3]);
        priceOfUltima = Double.parseDouble(data.split("\\,")[4]);

    }

    public static double getPriceOfElite() {
        return priceOfElite;
    }

    public static double getPriceOfUltima() {
        return priceOfUltima;
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

    public static void setPriceOfElite(double priceOfElite) {
        peakPricing.priceOfElite = priceOfElite;
    }

    public static void setPriceOfUltima(double priceOfUltima) {
        peakPricing.priceOfUltima = priceOfUltima;
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
                + String.valueOf(getPremiumPrice()) + "," + String.valueOf(getPriceOfElite()) + ","
                + String.valueOf(getPriceOfUltima());
        savePeakPricing.savePeakPricingString(filename, data);
    }
}
