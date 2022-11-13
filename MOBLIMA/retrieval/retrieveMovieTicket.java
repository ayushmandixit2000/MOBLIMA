package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import MOBLIMA.dataStructure.MovieTicket;

/**
 * Helper class to retrieve cinema objects from the movieTicket database.
 */
public class retrieveMovieTicket {
    /**
     * Separator used to denote different data boundaries in the movieTicket
     * database.
     */
    public static final String SEPARATOR = "|";

    /**
     * Converts data read from the file into fields of the movieTicket object.
     * 
     * @param filename The file path to the file of interest.
     * @return movieTicket objects obtained from the file of interest.
     */
    public static ArrayList readMovieTicket(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String movieTicketId = star.nextToken().trim();
            String ageCat = star.nextToken().trim();
            int row = Integer.parseInt(star.nextToken().trim());
            int column = Integer.parseInt(star.nextToken().trim());
            double price = Double.parseDouble(star.nextToken().trim());
            String showtimeId = star.nextToken().trim();
            int seatClass = Integer.parseInt(star.nextToken().trim());

            MovieTicket mt = new MovieTicket(ageCat, row, column, showtimeId, seatClass); // price is calculated
            alr.add(mt);
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
