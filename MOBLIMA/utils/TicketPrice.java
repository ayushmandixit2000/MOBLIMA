package MOBLIMA.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import MOBLIMA.configurables.ageGroupPricing;
import MOBLIMA.configurables.peakDates;
import MOBLIMA.configurables.peakPricing;
import MOBLIMA.dataStructure.Cinema;
import MOBLIMA.retrieval.retrieveCinema;

/**
 * Helper class to calculate price of a movieticket based on factors of date,
 * age catgeory discounts (if applicable), cinema class and seat class.
 */
public class TicketPrice {
    /**
     * Calculates the price of a ticket based on the below factors.
     * Transverses the cinema database to identify the cinema class from the
     * showtimeId.
     * 
     * @param date       The date of the showtime.
     * @param ageCat     The age category of the movie ticket.
     * @param showtimeId The id of the showtime.
     * @param seatClass  The seat class of the assigned seat.
     * @return The price of the movie ticket.
     */
    public static double calculatePrice(LocalDate date, int ageCat, String showtimeId, int seatClass)
            throws IOException {
        double price = 0;
        switch (ageCat) {
            case 0:
                price = ageGroupPricing.getPriceOfChild();
                break;
            case 1:
                price = ageGroupPricing.getPriceOfAdult();
                break;
            case 2:
                price = ageGroupPricing.getPriceOfSnrCitizen();
                break;
            case 3:
                price = ageGroupPricing.getPriceOfAdult();
                break;
        }
        new peakDates();
        new ageGroupPricing();
        new peakPricing();
        if (peakDates.isPeak(date)) {
            price = price * peakPricing.getPeakMultiplier();
        } else {
            if (peakDates.isThurs(date)) {
                price = price * peakPricing.getThursMultiplier();
            } else {
                price = price * peakPricing.getNonPeakMultiplier();
            }
        }
        switch (seatClass) {
            case 1:
                price = price * peakPricing.getPriceOfElite();
                break;
            case 2:
                price = price * peakPricing.getPriceOfUltima();
                break;
        }

        String cin = showtimeId.substring(0, 3);
        String filename = "MOBLIMA/databases/Cinema.txt";
        ArrayList cinemaArray = retrieveCinema.readCinema(filename);
        for (int i = 0; i < cinemaArray.size(); i++) {
            Cinema c = (Cinema) cinemaArray.get(i);
            if (c.getCinema().equals(cin)) {
                if (c.getMovieClass() == 1) {
                    price += peakPricing.getPremiumPrice();
                    return price;
                }
            }
        }
        return price;
    }
}
