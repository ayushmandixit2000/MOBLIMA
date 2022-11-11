package MOBLIMA.configurables;

import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import MOBLIMA.retrieval.retrievePH;
import MOBLIMA.save.savePublicHoli;
import MOBLIMA.utils.dateTime;

public class peakDates {
    private static boolean weekends = true;
    private static String filename = "MOBLIMA/databases/publicholidays.txt";
    private static ArrayList publicHoliday;

    /**
     * helper class that is configurable and can be used to evaluate whether dates
     * are peak
     * 
     */

    public peakDates() throws IOException {
        publicHoliday = retrievePH.readPH(filename);
    }

    public static ArrayList getPublicHoli() {
        return publicHoliday;
    }

    public static boolean getWeekends() {
        return weekends;
    }

    public static void setWeekends(boolean weekends) {
        peakDates.weekends = weekends;
    }

    public void setPeakDates(ArrayList publicHoli) {
        publicHoliday = publicHoli;
    }

    public static void addPeakDate(LocalDate d) throws IOException {
        publicHoliday.add(d);
        savePublicHoli.savePHArray(filename, publicHoliday);
    }

    public static boolean isPeak(LocalDate date) { // old function to be removed
        if (weekends) {
            for (int i = 0; i < publicHoliday.size(); i++) {
                if (date == publicHoliday.get(i)) {
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

    public static boolean isThurs(LocalDate date) {// thurs check
        String dayOfWeek = date.getDayOfWeek().toString();
        if ("THURSDAY".equalsIgnoreCase(dayOfWeek)) {
            return true;
        }
        return false;
    }

    public static boolean isPeak(LocalDate date, LocalTime time) { // weekends + fri after 6pm
        LocalTime sixPM = dateTime.convertTime("1800");
        String dayOfWeek = date.getDayOfWeek().toString();
        if ("SATURDAY".equalsIgnoreCase(dayOfWeek) || "SUNDAY".equalsIgnoreCase(dayOfWeek)) {
            return true;
        } else if ("FRIDAY".equalsIgnoreCase(dayOfWeek) && time.compareTo(sixPM) == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPeak(dateTime.convertDate("2022/11/10"), dateTime.convertTime("1759")));
        System.out.println(isThurs(dateTime.convertDate("2022/11/10")));
    }
}
