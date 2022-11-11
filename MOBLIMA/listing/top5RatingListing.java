package MOBLIMA.listing;

import java.io.IOException;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.dataStructure.Movie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class top5RatingListing {
    public void displayListing() throws IOException {
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
        Collections.sort(ratingsTitle,
                Comparator.comparingDouble(titleRatings::getRating));

        if (ratingsTitle.size() < 5) {
            int num = 1;
            for (int j = ratingsTitle.size() -1 ; j > -1; j--) {
                System.out.println(
                    num + ":   Rated: [" + ratingsTitle.get(j).getRating() + "]     " + ratingsTitle.get(j).getTitle());
                    num++;
            }
        } else {
            int num1 = 1;
            for (int j = ratingsTitle.size()-1; j > ratingsTitle.size() - 6; j--) {
                System.out.println(
                    num1 + ":   Rated: [" + ratingsTitle.get(j).getRating() + "]     " + ratingsTitle.get(j).getTitle());
                    num1++;
            }
        }
    }

}

class titleRatings implements Comparable<titleRatings> {
    private String title;
    private double rating;

    public titleRatings(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public int compareTo(titleRatings o) {
        /*
         * if(this.rating != o.getRating())
         * {
         * return (Double)(this.rating - o.getRating());
         * }
         */
        return this.title.compareTo(o.getTitle());
    }
}
