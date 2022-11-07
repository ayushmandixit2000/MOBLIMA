package MOBLIMA.utils;

import java.time.LocalDate;

import MOBLIMA.configurables.ageGroupPricing;
import MOBLIMA.configurables.peakDates;
import MOBLIMA.configurables.peakPricing;

public class TicketPrice {
    public static double calculatePrice(LocalDate date, int ageCat) {
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
        }
        if (peakDates.isPeak(date)) {
            return (price * peakPricing.getPeakMultiplier());
        } else {
            return (price * peakPricing.getNonPeakMultiplier());
        }

    }
}
