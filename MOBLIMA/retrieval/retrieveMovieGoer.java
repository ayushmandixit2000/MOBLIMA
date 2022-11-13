package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import MOBLIMA.dataStructure.MovieGoer;

/**
 * Helper class to retrieve moviegoer objects from the moviegoer database.
 */
public class retrieveMovieGoer {
    /**
     * Separator used to denote different data boundaries in the movie database.
     */
    public static final String SEPARATOR = "|";

    /**
     * Converts data read from the file into fields of the movie object.
     * 
     * @param filename The file path to the file of interest.
     * @return movie objects obtained from the file of interest.
     */
    public static ArrayList readMovieGoer(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String userId = star.nextToken().trim();
            String name = star.nextToken().trim();
            int mobileNumber = Integer.parseInt(star.nextToken().trim());
            String email = star.nextToken().trim();

            MovieGoer m = new MovieGoer(userId, name, mobileNumber, email);
            alr.add(m);
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
