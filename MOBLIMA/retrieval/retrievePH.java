package MOBLIMA.retrieval;

import java.io.IOException;
import java.time.LocalDate;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;
import MOBLIMA.utils.dateTime;
import java.util.List;
import java.util.ArrayList;

/**
 * Helper class to retrieve localDate objects from the peakDates database.
 */
public class retrievePH {
    /**
     * Separator used to separate localDate objects from the peakDates database.
     */
    public static final String SEPARATOR = "|";

    /**
     * Converts data read from the file into different localDate object.
     * 
     * @param filename The file path to the file of interest.
     * @return LocalDate objects obtained from the file of interest.
     */
    public static ArrayList readPH(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();
        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);
            LocalDate d = dateTime.convertDate(star.nextToken().trim());
            alr.add(d);
        }
        return alr;
    }

    /**
     * Reads data from a specific file.
     * 
     * @param fileName The file path to the file of interest.
     * @return Data read from the specific file.
     */
    public static List read(String fileName) throws IOException {
        List data = new ArrayList();
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        try {
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
        } finally {
            scanner.close();
        }
        return data;
    }
}
