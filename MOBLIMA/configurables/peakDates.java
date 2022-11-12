package MOBLIMA.configurables;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import MOBLIMA.retrieval.retrievePH;
import MOBLIMA.save.savePublicHoli;
import MOBLIMA.utils.dateTime;

/**
 * Helper class to check whether the date and time of a showtime is applicable
 * to discounts or peak.
 */
public class peakDates {
    /**
     * The file path to the specified peak dates database.
     */
    private static String filename = "MOBLIMA/databases/publicholidays.txt";

    /**
     * The specified dates which are indicated to be peak.
     */
    private static ArrayList publicHoliday;

    /**
     * Creates a PeakDates and populates its specified peak dates from the specified
     * peak dates database.
     * 
     */
    public peakDates() throws IOException {
        publicHoliday = retrievePH.readPH(filename);
    }

    /**
     * Gets the specified peak dates.
     * 
     * @return This PeakDate's specified peak dates.
     */
    public static ArrayList getPublicHoli() {
        return publicHoliday;
    }

    /**
     * Changes the specified peak dates.
     * 
     * @param publicHoli This PeakDate's new specified peak dates.
     */
    public void setPeakDates(ArrayList publicHoli) {
        publicHoliday = publicHoli;
    }

    /**
     * Adds a specified peak date into PeakDate's specified peak dates.
     * Saves the new addition into the specified peak dates database.
     * 
     * @param d New added specified peak date.
     */
    public static void addPeakDate(LocalDate d) throws IOException {
        publicHoliday.add(d);
        savePublicHoli.savePHArray(filename, publicHoliday);
    }

    /**
     * Evaluates whether a specified date is a peak date, checking against its
     * specified peak dates and weekends
     * 
     * @param date Date to be evaluated.
     * @return Evaluation result on whether the provided Date is peak.
     */
    public static boolean isPeak(LocalDate date) {
        for (int i = 0; i < publicHoliday.size(); i++) {
            if (date.isEqual((ChronoLocalDate) publicHoliday.get(i))) {
                return true;
            }
        }
        String dayOfWeek = date.getDayOfWeek().toString();
        if ("SATURDAY".equalsIgnoreCase(dayOfWeek) || "SUNDAY".equalsIgnoreCase(dayOfWeek)) {
            return true;
        }
        return false;
    }

    /**
     * Evaluates whether a specified date is a Thursday.
     * 
     * @param date Date to be evaluated.
     * @return Evaluation result on whether the provided Date is a Thursday.
     */
    public static boolean isThurs(LocalDate date) {
        String dayOfWeek = date.getDayOfWeek().toString();
        if ("THURSDAY".equalsIgnoreCase(dayOfWeek)) {
            return true;
        }
        return false;
    }

    /**
     * Evaluates whether a specified date is applicable for age category discounts.
     * 
     * @param date Date to be evaluated.
     * @param time Time to be evaluated.
     * @return Evaluation result on whether the provided Date is applicable for age
     *         category discounts..
     */
    public static boolean isDicountApplicable(LocalDate date, LocalTime time) {
        LocalTime sixPM = dateTime.convertTime("1800");
        String dayOfWeek = date.getDayOfWeek().toString();
        for (int i = 0; i < publicHoliday.size(); i++) {
            if (date.isEqual((ChronoLocalDate) publicHoliday.get(i))) {
                return false;
            }
        }
        if (!"SATURDAY".equalsIgnoreCase(dayOfWeek) && !"SUNDAY".equalsIgnoreCase(dayOfWeek)) {
            if (time.compareTo(sixPM) == -1) {
                return true;
            }
        }
        return false;
    }
}
