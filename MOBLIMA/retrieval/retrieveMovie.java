package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import MOBLIMA.dataStructure.Movie;

public class retrieveMovie {
    public static final String SEPARATOR = "|";

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

    public static void main(String[] aArgs) {
        String filename = "MOBLIMA/databases/movie.txt";
        try {
            ArrayList al = retrieveMovie.readMovie(filename);
            for (int i = 0; i < al.size(); i++) {
                Movie m = (Movie) al.get(i);
                System.out.println("MovieTitle " + m.getTitle());
                System.out.println(Arrays.toString(m.getCast()));
                m.setNumReviews();
                m.setAvgRating();
                System.out.println(m.getAvgRating());
            }
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
