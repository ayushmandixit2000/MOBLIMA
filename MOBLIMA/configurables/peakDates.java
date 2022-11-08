package MOBLIMA.configurables;

import java.time.LocalDate;

public class peakDates {
    private static LocalDate[] publicHoli; // for public holis

    public peakDates(LocalDate[] p) {
        publicHoli = p;
    }

    public static LocalDate[] getPublicHoli() {
        return publicHoli;
    }

    public void setPeakDates(LocalDate[] publicHoli) {
        publicHoli = publicHoli;
    }

    public static boolean isPeak(LocalDate date) {
        // for (int i = 0; i < peakDates.length; i++) {
        // if (date == peakDates[i]) {
        // return true;
        // }
        // }
        String dayOfWeek = date.getDayOfWeek().toString();
        if ("SATURDAY".equalsIgnoreCase(dayOfWeek) || "SUNDAY".equalsIgnoreCase(dayOfWeek)) {
            return true;
        }
        return false;
    }
}
