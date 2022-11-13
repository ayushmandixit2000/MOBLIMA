package MOBLIMA.utils;

import java.util.Comparator;
import MOBLIMA.dataStructure.Showtime;

/**
 * Helper class to compare showtimes based on date, followed by time and then
 * cinema code.
 */
public class compareDates implements Comparator<Showtime> {

    /**
     * Compares the following 2 showtimes based on date, time and cinema code.
     * 
     * @param s1 first showtime to compare.
     * @param s2 second showtime to compare.
     * @return value indicating the ordering of the two provided showtimes.
     */
    public int compare(Showtime s1, Showtime s2) {
        int comp1 = s1.getDate().compareTo(s2.getDate());
        if (comp1 != 0) {
            return comp1;
        }
        int comp2 = s1.getTime().compareTo(s2.getTime());
        if (comp2 != 0) {
            return comp2;
        }
        return s1.getCinema().compareTo(s2.getCinema());
    }
}
