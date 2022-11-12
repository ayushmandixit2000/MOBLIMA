package MOBLIMA.configurables;

import java.io.IOException;
import MOBLIMA.retrieval.retrieveTicketPricing;
import MOBLIMA.save.saveTicketPricing;

/**
 * Helper class that is configurable and holds prices for each age category
 * movie ticket.
 */
public class ageGroupPricing {
    /**
     * The price of a child movie ticket.
     */
    private static double priceOfChild;

    /**
     * The price of an adult movie ticket.
     */
    private static double priceOfAdult;

    /**
     * The price of a senior citizen movie ticket.
     */
    private static double priceOfSnrCitizen;

    /**
     * The file path to the movie ticket pricing database.
     */
    static String filename = "MOBLIMA/databases/ticketPricing.txt";

    /**
     * Generates a AgeGroupPricing with each of the pricing obtained from the movie
     * ticket pricing database.
     */
    public ageGroupPricing() throws IOException {
        String data = retrieveTicketPricing.readTicketPricing(filename);
        priceOfChild = Double.parseDouble(data.split("\\,")[0]);
        priceOfAdult = Double.parseDouble(data.split("\\,")[1]);
        priceOfSnrCitizen = Double.parseDouble(data.split("\\,")[2]);
    }

    /**
     * Gets the price of a child movie ticket.
     * 
     * @return This AgeGroupPricing's child movie ticket's priceing.
     */
    public static double getPriceOfChild() {
        return priceOfChild;
    }

    /**
     * Gets the price of an adult movie ticket.
     * 
     * @return This AgeGroupPricing's adult movie ticket's priceing.
     */
    public static double getPriceOfAdult() {
        return priceOfAdult;
    }

    /**
     * Gets the price of a senior citizen movie ticket.
     * 
     * @return This AgeGroupPricing's senior citizen movie ticket's priceing.
     */
    public static double getPriceOfSnrCitizen() {
        return priceOfSnrCitizen;
    }

    /**
     * Changes the price of a child movie ticket.
     * 
     * @param newChild This AgeGroupPricing's new child movie ticket pricing.
     */
    public static void setPriceOfChild(double newChild) {
        priceOfChild = newChild;
    }

    /**
     * Changes the price of an adult movie ticket.
     * 
     * @param newAdult This AgeGroupPricing's new adult movie ticket pricing.
     */
    public static void setPriceOfAdult(double newAdult) {
        priceOfAdult = newAdult;
    }

    /**
     * Changes the price of a senior citizen movie ticket.
     * 
     * @param newSC This AgeGroupPricing's new senior citizen movie ticket pricing.
     */
    public static void setPriceOfSnrCitizen(double newSC) {
        priceOfSnrCitizen = newSC;
    }

    /**
     * Saves the set prices of the different movie ticket age categories into the
     * movie ticket pricing database.
     * 
     * @throws IOException
     */
    public static void savePricing() throws IOException {
        String data = String.valueOf(getPriceOfChild()) + "," + String.valueOf(getPriceOfAdult()) + ","
                + String.valueOf(getPriceOfSnrCitizen());
        saveTicketPricing.saveTicketPricingString(filename, data);
    }
}
