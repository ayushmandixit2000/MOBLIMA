package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import MOBLIMA.dataStructure.Movie;

/**
 * Helper class to retrieve movie objects from the movie database.
 */
public class retrieveMovie {
    /**
     * Separator used to denote different data boundaries in the movie database.
     */
    public static final String SEPARATOR = "|";

    /**
     * Converts data read from the file into fields of the movie object.
     * 
     * @param filename The file path to the file of interest.
     * @return Movie objects obtained from the file of interest.
     */
    public static ArrayList readMovie(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            int movieId = Integer.parseInt(star.nextToken().trim());
            String title = star.nextToken().trim();
            int showStatus = Integer.parseInt(star.nextToken().trim());
            String director = star.nextToken().trim();
            String[] cast = star.nextToken().trim().split("\\,");
            String synopsis = star.nextToken().trim();
            int movieRating = Integer.parseInt(star.nextToken().trim());
            int movieType = Integer.parseInt(star.nextToken().trim());
            Double sales = Double.parseDouble(star.nextToken().trim());
            int isDeleted = Integer.parseInt(star.nextToken().trim());
            int numReviews = Integer.parseInt(star.nextToken().trim());
            Double avgReview = Double.parseDouble(star.nextToken().trim());

            Movie m = new Movie(movieId, title, showStatus, director, cast, synopsis, movieRating, movieType, sales,
                    isDeleted, numReviews, avgReview);
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
