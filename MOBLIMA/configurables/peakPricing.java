package MOBLIMA.configurables;

import java.io.IOException;
import MOBLIMA.retrieval.retrievePeakPricing;
import MOBLIMA.save.savePeakPricing;

/**
 * Helper class to provide configurable extra chargers for different
 * preferences.
 */
public class peakPricing {
    /**
     * The price multiplier for non-peak dates.
     */
    private static double nonPeakMultiplier;

    /**
     * The price multiplier for Thursdays.
     */
    private static double thursMultiplier;

    /**
     * The price multiplier for peak dates.
     */
    private static double peakMultiplier;

    /**
     * The price extra charge for Platinum Movie Suites.
     */
    private static double premiumPrice;

    /**
     * The price multiplier for Elite seats.
     */
    private static double priceOfElite;

    /**
     * The price multiplier of Ultima seats.
     */
    private static double priceOfUltima;

    /**
     * The file path for peak pricing database.
     */
    static String filename = "MOBLIMA/databases/peakPricing.txt";

    /**
     * Creates a PeakPricing and populate it with data from the peak pricing
     * database.
     * 
     */
    public peakPricing() throws IOException {
        String data = retrievePeakPricing.readPeakPricing(filename);
        nonPeakMultiplier = Double.parseDouble(data.split("\\,")[0]);
        thursMultiplier = Double.parseDouble(data.split("\\,")[1]);
        peakMultiplier = Double.parseDouble(data.split("\\,")[2]);
        premiumPrice = Double.parseDouble(data.split("\\,")[3]);
        priceOfElite = Double.parseDouble(data.split("\\,")[4]);
        priceOfUltima = Double.parseDouble(data.split("\\,")[5]);
    }

    /**
     * Gets the price multiplier of Elite seats.
     * 
     * @return price multiplier of Elite seats.
     */
    public static double getPriceOfElite() {
        return priceOfElite;
    }

    /**
     * Gets the price multiplier of Ultima seats.
     * 
     * @return price multiplier of Ultima seats.
     */
    public static double getPriceOfUltima() {
        return priceOfUltima;
    }

    /**
     * Gets the price surcharge for Platinum Movie Suite.
     * 
     * @return Price surcharge for Platinum Movie Suite.
     */
    public static double getPremiumPrice() {
        return premiumPrice;
    }

    /**
     * Gets the price multiplier for non-peak dates.
     * 
     * @return Price multiplier for non-peak dates.
     */
    public static double getNonPeakMultiplier() {
        return nonPeakMultiplier;
    }

    /**
     * Gets the price multiplier for Thursdays.
     * 
     * @return Price multiplier for Thursdays.
     */
    public static double getThursMultiplier() {
        return thursMultiplier;
    }

    /**
     * Gets the price multiplier for peak dates.
     * 
     * @return Price multiplier for peak dates.
     */
    public static double getPeakMultiplier() {
        return peakMultiplier;
    }

    /**
     * Gets the price multiplier for Elite seats.
     * 
     * @return Price multiplier for Elite seats.
     */
    public static void setPriceOfElite(double priceOfElite) {
        peakPricing.priceOfElite = priceOfElite;
    }

    /**
     * Changes the price multiplier of Ultima seats.
     * 
     * @param priceOfUltima New price multiplier of Ultima seats.
     */
    public static void setPriceOfUltima(double priceOfUltima) {
        peakPricing.priceOfUltima = priceOfUltima;
    }

    /**
     * Changes the price surcharge of Platinum Movie Suite.
     * 
     * @param premiumPrice New price surcharge of Platinum Movie Suite.
     */
    public static void setPremiumPrice(double premiumPrice) {
        peakPricing.premiumPrice = premiumPrice;
    }

    /**
     * Changes the price multiplier of non-peak dates.
     * 
     * @param newNonPeak New price multiplier of non-peak dates.
     */
    public static void setNonPeakMultiplier(double newNonPeak) {
        nonPeakMultiplier = newNonPeak;
    }

    /**
     * Changes the price multiplier of Thursdays.
     * 
     * @param thursMultiplier New price multiplier of Thursdays.
     */
    public static void setThursMultiplier(double thursMultiplier) {
        peakPricing.thursMultiplier = thursMultiplier;
    }

    /**
     * Changes the price multiplier of peak dates.
     * 
     * @param newPeak New price multiplier of peak dates.
     */
    public static void setPeakMultiplier(double newPeak) {
        peakMultiplier = newPeak;
    }

    /**
     * Saves the set prices of the different preferences into the peak pricing
     * database.
     * 
     */
    public static void saveMultipliers() throws IOException {
        String data = String.valueOf(getNonPeakMultiplier()) + "," + String.valueOf(getThursMultiplier()) + ","
                + String.valueOf(getPeakMultiplier()) + ","
                + String.valueOf(getPremiumPrice()) + "," + String.valueOf(getPriceOfElite()) + ","
                + String.valueOf(getPriceOfUltima());
        savePeakPricing.savePeakPricingString(filename, data);
    }
}
