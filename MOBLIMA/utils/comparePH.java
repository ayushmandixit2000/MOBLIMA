package MOBLIMA.utils;

import java.time.LocalDate;
import java.util.Comparator;

/**
 * Helper class to compare dates.
 */
public class comparePH implements Comparator<LocalDate> {
    /**
     * Compares the following 2 dates:
     * 
     * @param s1 first date to compare.
     * @param s2 second date to compare.
     * @return value indicating the ordering of the two provided dates.
     */
    public int compare(LocalDate s1, LocalDate s2) {
        return s1.compareTo(s2);
    }
}