package MOBLIMA.utils;

import java.io.IOException;
import java.time.LocalDate;

import MOBLIMA.configurables.ageGroupPricing;
import MOBLIMA.configurables.peakDates;
import MOBLIMA.configurables.peakPricing;

public class TicketPrice {
    public static double calculatePrice(LocalDate date, int ageCat) throws IOException {
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
        new peakDates();
        new ageGroupPricing();
        new peakPricing();
        if (peakDates.isPeak(date)) {
            return (price * peakPricing.getPeakMultiplier());
        } else {
            return (price * peakPricing.getNonPeakMultiplier());
        }

    }
}
