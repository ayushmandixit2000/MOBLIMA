package MOBLIMA.configurables;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import MOBLIMA.retrieval.retrievePH;
import MOBLIMA.save.savePublicHoli;

public class peakDates {
    private static boolean weekends = true;
    private static String filename = "MOBLIMA/databases/publicholidays.txt";
    private static ArrayList publicHoli;

    /**
     * helper class that is configurable and can be used to evaluate whether dates
     * are peak
     * 
     */

    public peakDates() throws IOException {
        publicHoli = retrievePH.readPH(filename);
    }

    public static ArrayList getPublicHoli() {
        return publicHoli;
    }

    public static boolean getWeekends() {
        return weekends;
    }

    public static void setWeekends(boolean weekends) {
        peakDates.weekends = weekends;
    }

    public void setPeakDates(LocalDate[] publicHoli) {
        publicHoli = publicHoli;
    }

    public static void addPeakDate(LocalDate d) throws IOException {
        publicHoli.add(d);
        savePublicHoli.savePHArray(filename, publicHoli);
    }

    /**
     * this evaluates whether a specified date is peak
     * 
     * @param date- LocalDate variable denoting the date on which the movie is
     *              showing on
     * @return- boolean indicating whether the date is a peak date
     */
    public static boolean isPeak(LocalDate date) {
        if (weekends) {
            for (int i = 0; i < publicHoli.size(); i++) {
                if (date == publicHoli.get(i)) {
                    return true;
                }
            }
        }
        String dayOfWeek = date.getDayOfWeek().toString();
        if ("SATURDAY".equalsIgnoreCase(dayOfWeek) || "SUNDAY".equalsIgnoreCase(dayOfWeek)) {
            return true;
        }
        return false;
    }
}
