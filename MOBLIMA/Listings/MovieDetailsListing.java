package MOBLIMA.Listings;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.listingInterface.Listing;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.useractions.CustomerAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDetailsListing implements Listing {

    private Movie m1;

    private int action;

    public void setaction(int act){
        this.action = act;
    }

    public void setmovie(Movie m) {
        this.m1 = m;
    }

    public void displayListing() throws IOException {
        m1.setAvgRating();
        m1.setNumReviews();
        System.out.println("Movie Title: " + m1.getTitle());
        Scanner scc = new Scanner(System.in);
        String showstatus = "";
        if (m1.getShowStatus() == 0) {
            showstatus = "Coming Soon";
        } else if (m1.getShowStatus() == 1) {
            showstatus = "Preview";
        } else if (m1.getShowStatus() == 2) {
            showstatus = "Now Showing";
        }

        else if (m1.getShowStatus() == 3) {
            showstatus = "End of Show";
        }
        System.out.println("Movie Show Status: " + showstatus);

        System.out.println("Movie Director: " + m1.getDirector());

        String[] casts = m1.getCast();
        System.out.println("Movie Cast: ");

        for (int k = 0; k < casts.length; k++) {
            System.out.println(k + 1 + ": " + casts[k]);
        }

        System.out.println("Movie Synopsis: " + m1.getSynopsis());

        String rat = "";

        if (m1.getMovieRating() == 0) {
            rat = "G";
        }

        else if (m1.getMovieRating() == 1) {
            rat = "PG";
        }

        else if (m1.getMovieRating() == 2) {
            rat = "M";
        }

        else if (m1.getMovieRating() == 3) {
            rat = "R16";
        }

        else if (m1.getMovieRating() == 4) {
            rat = "TBC";
        }
        System.out.println("Movie Rating: " + rat);

        String movietype = "";

        if (m1.getMovieType() == 0) {
            movietype = "3D";
        }

        else if (m1.getMovieType() == 1) {
            movietype = "Blockbuster";
        }

        System.out.println("Movie Type: " + movietype);

        System.out.println("Movie Sales: " + m1.getSales());

        System.out.println("\nDo you want to see ratings and reviews?");
        System.out.println("1: Yes");
        System.out.println("2: No");

        int additionalopt = scc.nextInt();


        if (additionalopt == 1) {
            if(m1.getNumReviews() > 1){
            System.out.println("\nAverage Rating: " + m1.getAvgRating());
            }
            
            else{
                System.out.println("\nNA: Average Rating is not determined due to insufficent reviews");
            }
            ReviewListing reviews = new ReviewListing();
            reviews.setmovie(m1);
            reviews.displayListing();
        }

        CustomerAction CA = new CustomerAction();
        CA.setaction(this.action);
        CA.setmovie(m1);
        CA.displayaction();

    }
}