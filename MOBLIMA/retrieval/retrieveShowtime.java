package MOBLIMA.retrieval;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.utils.compareDates;
import MOBLIMA.utils.dateTime;

/**
 * Helper class to retrieve showtime objects from the showtime database.
 */
public class retrieveShowtime {
    /**
     * The number of rows in a cinema seating layout.
     */
    public static final int ROWS = 9;

    /**
     * The number of columns in
     * cinema seating layout.
     */
    public static final int COLUMNS = 19;

    /**
     * Separator used to denote different data boundaries in the showtime database.
     */
    public static final String SEPARATOR = "|";

    /**
     * Converts data read from the file into fields of the showtime object.
     * 
     * @param filename The file path to the file of interest.
     * @return Showtime objects obtained from the file of interest.
     */
    public static ArrayList readShowtime(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String cinema = star.nextToken().trim();
            LocalDate date = dateTime.convertDate(star.nextToken().trim());
            LocalTime timeSlot = dateTime.convertTime(star.nextToken().trim());
            int movieId = Integer.parseInt(star.nextToken().trim());

            String[] seatinArray = star.nextToken().trim().split("\\.");
            int[][] seating = new int[ROWS][COLUMNS];
            for (int j = 0; j < ROWS; j++) {
                String[] row = seatinArray[j].split("\\,");
                for (int k = 0; k < COLUMNS; k++) {
                    seating[j][k] = Integer.valueOf(row[k]);
                }
            }
            String showTimeId = star.nextToken().trim(); // not used

            Showtime s = new Showtime(cinema, date, timeSlot, movieId, seating);
            alr.add(s);
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
