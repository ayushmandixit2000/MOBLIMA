package MOBLIMA.listing;

import java.io.IOException;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.dataStructure.Movie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Helper class to display top 5 movie based on rating and obtains the user's
 * selected movie.
 */
public class top5RatingListing {

    /**
     * The selected movie.
     */
    private Movie m1;

    /**
     * Displays top 5 movie ranked on rating from the movie database and obtains the
     * moviegoer's selected movie.
     */
    public void displayListing() throws IOException {
        Scanner scc = new Scanner(System.in);
        String filename1 = "MOBLIMA/databases/movie.txt";
        System.out.println("The top 5 movies are...");
        ArrayList movieObjects = retrieveMovie.readMovie(filename1); // this creates an array of movie objects
        int arraySize = movieObjects.size();
        // titleRatings[] ratingsTitle = new titleRatings[100];
        // create array for the objects with title and ratings number
        ArrayList<titleRatings> ratingsTitle = new ArrayList<titleRatings>();
        for (int i = 0; i < arraySize; i++) {
            Movie m = (Movie) movieObjects.get(i); // pulls one movie object from the arraylist
            String title = m.getTitle();
            double rating = m.getAvgRating();
            if (m.getNumReviews() >= 1 && m.getIsDeleted() == 0) {
                titleRatings newObject = new titleRatings(title, rating);
                ratingsTitle.add(newObject);
            }
        }

        String[] ids = new String[5];
        Collections.sort(ratingsTitle,
                Comparator.comparingDouble(titleRatings::getRating));

        int count = 0;
        if (ratingsTitle.size() < 5) {
            int num = 1;
            for (int j = ratingsTitle.size() - 1; j > -1; j--) {
                System.out.println(
                        num + ":   Rated: [" + ratingsTitle.get(j).getRating() + "]     "
                                + ratingsTitle.get(j).getTitle());
                ids[num - 1] = ratingsTitle.get(j).getTitle();
                num++;
            }
            count = num;
        } else {
            int num = 1;
            for (int j = ratingsTitle.size() - 1; j > ratingsTitle.size() - 6; j--) {
                System.out.println(
                        num + ":   Rated: [" + ratingsTitle.get(j).getRating() + "]     "
                                + ratingsTitle.get(j).getTitle());
                ids[num - 1] = ratingsTitle.get(j).getTitle();
                num++;
            }
            count = num;
        }

        System.out.println("Would you like to continue with a movie?");
        System.out.println("1: Yes");
        System.out.println("2: No");

        int additionalopt;

        while (true) {
            String input = scc.next();
            additionalopt = 0;
            try {
                additionalopt = Integer.parseInt(input);
                if (additionalopt > 2 || additionalopt < 1) {
                    System.out.println("Please key in a valid number!");
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ne) {
                System.out.println("Please key in a number only!");
            }
        }

        if (additionalopt == 1) {
            System.out.println(
                    "Please select a movie you want to find out more about (enter the number beside the movie)");

            int additional;

            while (true) {
                String input = scc.next();
                additional = 0;
                try {
                    additional = Integer.parseInt(input);
                    if (additional > count || additional < 1) {
                        System.out.println("Please key in a valid number!");
                        continue;
                    } else {
                        break;
                    }
                } catch (NumberFormatException ne) {
                    System.out.println("Please key in a number only!");
                }
            }

            String titlechosen = ids[additional - 1];

            String filename = "MOBLIMA/databases/movie.txt";
            ArrayList movieArray = retrieveMovie.readMovie(filename);
            for (int i = 0; i < movieArray.size(); i++) {
                Movie m = (Movie) movieArray.get(i);
                if (m.getTitle().equalsIgnoreCase(titlechosen)) {
                    this.m1 = m;
                }
            }
        }

    }

    /**
     * Gets the selected movie.
     * 
     * @return The selected movie.
     */
    public Movie getmovie() {
        return this.m1;
    }

}

/**
 * Helper class to compare movies, used for ranking by ratings.
 */
class titleRatings implements Comparable<titleRatings> {
    /**
     * The movie's title.
     */
    private String title;

    /**
     * The movie's customer rating.
     */
    private double rating;

    /**
     * Creates a TitleRating with the following attributes:
     * 
     * @param title  The movie's title.
     * @param rating The movie's customer rating.
     */
    public titleRatings(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    /**
     * Gets the movie's title.
     * 
     * @return The movie's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the movie's customer rating.
     * 
     * @return The movie's customer rating.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Compares 2 movies based on their rating and title.
     * 
     * @return a result indicating which movie is ordered first.
     */
    public int compareTo(titleRatings o) {
        return this.title.compareTo(o.getTitle());
    }
}
