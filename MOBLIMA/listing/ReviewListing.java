package MOBLIMA.listing;

import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.Review;
import MOBLIMA.retrieval.retrieveReview;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Helper class to list customer reviews and ratings of a particular movie.
 */
public class ReviewListing implements Listing {

    /**
     * The selected movie to view reviews of.
     */
    private Movie m1;

    /**
     * Changes the selected movie.
     * 
     * @param m The new selected movie.
     */
    public void setmovie(Movie m) {
        this.m1 = m;
    }

    /**
     * Displays the customer ratings and reviews of the selected movie.
     */
    public void displayListing() throws IOException {
        int movid = m1.getMovieId();

        String filename = "MOBLIMA/databases/review.txt";
        ArrayList reviewArray = retrieveReview.readReview(filename);

        for (int i = 0; i < reviewArray.size(); i++) {
            Review r = (Review) reviewArray.get(i);
            if (r.getMovieId() == movid) {
                System.out.println("\nRating out of 5: " + r.getRating() + " || Review: " + r.getReview());
            }
        }
    }
}
