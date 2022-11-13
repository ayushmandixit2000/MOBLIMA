package MOBLIMA.save;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import MOBLIMA.utils.dateTime;
import java.util.ArrayList;

/**
 * Helper class to LocalDate objects into the peakDates database.
 */
public class savePublicHoli extends save {
    /**
     * Converts LocalDate objects into data.
     * 
     * @param filename The file path to the file to be written into.
     * @param al       The LocalDate objects to be written.
     */
    public static void savePHArray(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store data
        for (int i = 0; i < al.size(); i++) {
            LocalDate date = (LocalDate) al.get(i);
            alw.add(dateTime.convertDate(date));
        }
        write(filename, alw);
    }
}