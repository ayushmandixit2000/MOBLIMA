package MOBLIMA.configurables;

import java.time.LocalDate;

public class peakDates {
    private static LocalDate[] peakDates; // for public holis

    public peakDates(LocalDate[] p) {
        peakDates = p;
    }

    public LocalDate[] getPeakDates() {
        return peakDates;
    }

    public void setPeakDates(LocalDate[] peakDates) {
        this.peakDates = peakDates;
    }

    public static boolean isPeak(LocalDate date) {
        for (int i = 0; i < peakDates.length; i++) {
            if (date == peakDates[i]) {
                return true;
            }
        }
        String dayOfWeek = date.getDayOfWeek().toString();
        if ("SATURDAY".equalsIgnoreCase(dayOfWeek) || "SUNDAY".equalsIgnoreCase(dayOfWeek)) {
            return true;
        }
        return false;
    }
}
