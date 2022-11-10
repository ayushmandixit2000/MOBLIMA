package MOBLIMA.configurables;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import MOBLIMA.retrieval.retrievePH;
import MOBLIMA.save.savePublicHoli;

//for ppl to get public holi dates
// new peakDates();
// String filename = "MOBLIMA/databases/publicholidays.txt";
// ArrayList al = retrievePH.readPH(filename);
// for (int i = 0; i < al.size(); i++) {
//     LocalDate date = (LocalDate) al.get(i);
//     System.out.println(dateTime.convertDate(date));
// }

public class peakDates {
    private static boolean weekends = true;
    private static String filename = "MOBLIMA/databases/publicholidays.txt";
    private static ArrayList publicHoli; // for public holis

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
