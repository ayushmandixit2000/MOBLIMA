package MOBLIMA.configurables;

import java.io.IOException;
import MOBLIMA.retrieval.retrieveTicketPricing;
import MOBLIMA.save.saveTicketPricing;

public class ageGroupPricing {
    private static double priceOfChild;
    private static double priceOfAdult;
    private static double priceOfSnrCitizen;
    static String filename = "MOBLIMA/databases/ticketPricing.txt";

    /**
     * helper class that is configurable and consists of prices for different movie
     * ticket age categories
     * 
     */
    public ageGroupPricing() throws IOException {
        String data = retrieveTicketPricing.readTicketPricing(filename);
        priceOfChild = Double.parseDouble(data.split("\\,")[0]);
        priceOfAdult = Double.parseDouble(data.split("\\,")[1]);
        priceOfSnrCitizen = Double.parseDouble(data.split("\\,")[2]);
    }

    public static double getPriceOfChild() {
        return priceOfChild;
    }

    public static double getPriceOfAdult() {
        return priceOfAdult;
    }

    public static double getPriceOfSnrCitizen() {
        return priceOfSnrCitizen;
    }

    public static void setPriceOfChild(double newChild) {
        priceOfChild = newChild;
    }

    public static void setPriceOfAdult(double newAdult) {
        priceOfAdult = newAdult;
    }

    public static void setPriceOfSnrCitizen(double newSC) {
        priceOfSnrCitizen = newSC;
    }

    public static void savePricing() throws IOException {
        String data = String.valueOf(getPriceOfChild()) + "," + String.valueOf(getPriceOfAdult()) + ","
                + String.valueOf(getPriceOfSnrCitizen());
        saveTicketPricing.saveTicketPricingString(filename, data);
    }

}
