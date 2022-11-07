import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.Review;
import MOBLIMA.listingInterface.Listing;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.retrieval.retrieveReview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReviewListing implements Listing {

    private Movie m1;

    public void setmovie(Movie m) {
        this.m1 = m;
    }

    public void displayListing() throws IOException {
        int movid = m1.getMovieId();

        String filename = "MOBLIMA/databases/review.txt";
        ArrayList reviewArray = retrieveReview.readReview(filename);

        for (int i = 0; i < reviewArray.size(); i++) {
            Review r = (Review) reviewArray.get(i);
            if(r.getMovieId() == movid){
            System.out.println("Review: " + r.getReview());
            }
        }
    }
}
