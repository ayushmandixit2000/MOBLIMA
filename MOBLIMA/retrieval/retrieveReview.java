package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import MOBLIMA.dataStructure.Review;

/**
 * Helper class to retrieve review objects from the reviews database.
 */
public class retrieveReview {
    /**
     * Separator used to denote different data boundaries in the reviews database.
     */
    public static final String SEPARATOR = "|";

    /**
     * Converts data read from the file into fields of the review object.
     * 
     * @param filename The file path to the file of interest.
     * @return Review objects obtained from the file of interest.
     */
    public static ArrayList readReview(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            int movieId = Integer.parseInt(star.nextToken().trim());
            int rating = Integer.parseInt(star.nextToken().trim());
            String review = star.nextToken().trim();
            Review r = new Review(movieId, rating, review);
            alr.add(r);
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
