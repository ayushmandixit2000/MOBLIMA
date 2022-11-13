package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import MOBLIMA.dataStructure.Cinema;

/**
 * Helper class to retrieve cinema objects from the cinema database.
 */
public class retrieveCinema {
    /**
     * Separator used to denote different data boundaries in the cinema database.
     */
    public static final String SEPARATOR = "|";

    /**
     * Converts data read from the file into fields of the cinema object.
     * 
     * @param filename The file path to the file of interest.
     * @return Cinema objects obtained from the file of interest.
     */
    public static ArrayList readCinema(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String cineplex = star.nextToken().trim();
            int cinema = Integer.parseInt(star.nextToken().trim());
            int movieClass = Integer.parseInt(star.nextToken().trim());

            Cinema c = new Cinema(cineplex, cinema, movieClass);
            alr.add(c);
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
