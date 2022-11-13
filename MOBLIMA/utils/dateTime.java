package MOBLIMA.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Helper class to aid in the conversion between String and LocalDate or
 * LocalTime.
 */
public class dateTime {
    /**
     * Converts String to LocalDate.
     * 
     * @param date The date in String to convert into LocalDate.
     * @return The date in LocalDate.
     */
    public static LocalDate convertDate(String date) {
        int year = Integer.valueOf(date.split("\\/")[0]);
        int month = Integer.valueOf(date.split("\\/")[1]);
        int day = Integer.valueOf(date.split("\\/")[2]);
        LocalDate d = LocalDate.of(year, month, day);
        return d;
    }

    /**
     * Converts String to LocalTime.
     * 
     * @param time The time in String to convert into LocalTime.
     * @return The time in LocalTime.
     */
    public static LocalTime convertTime(String time) {
        int hr = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(2, 4));
        LocalTime t = LocalTime.of(hr, min, 0, 0);
        return t;
    }

    /**
     * Converts LocalDate to String.
     * 
     * @param date The date in LocalDate to convert into String.
     * @return The date in String.
     */
    public static String convertDate(LocalDate date) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return date.format(myFormatObj);
    }

    /**
     * Converts LocalTime to String.
     * 
     * @param time The time in LocalTime to convert into Time.
     * @return The time in String.
     */
    public static String convertTime(LocalTime time) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HHmm");
        return time.format(myFormatObj);
    }
}
