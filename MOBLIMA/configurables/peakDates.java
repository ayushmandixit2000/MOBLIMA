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
    static String filename = "MOBLIMA/databases/publicholidays.txt";
    private static ArrayList publicHoli; // for public holis

    public peakDates() throws IOException {
        publicHoli = retrievePH.readPH(filename);
    }

    public static ArrayList getPublicHoli() {
        return publicHoli;
    }

    public void setPeakDates(LocalDate[] publicHoli) {
        publicHoli = publicHoli;
    }

    public void addPeakDate(LocalDate d) throws IOException {
        publicHoli.add(d);
        savePublicHoli.savePHArray(filename, publicHoli);
    }

    public static boolean isPeak(LocalDate date) {
        for (int i = 0; i < publicHoli.size(); i++) {
            if (date == publicHoli.get(i)) {
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
