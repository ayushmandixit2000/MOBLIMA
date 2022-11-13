package MOBLIMA.listing;

import MOBLIMA.dataStructure.Movie;
import java.io.IOException;
import java.util.Scanner;

/**
 * Help class to display various attributes of a selected movie.
 */
public class MovieDetailsListing implements Listing {

    /**
     * The selected movie to display attributes of.
     */
    private Movie m1;

    /**
     * Changes the selected movie to display attributes of.
     * 
     * @param m The new selected movie to display attributes of.
     */
    public void setmovie(Movie m) {
        this.m1 = m;
    }

    public void displayListing() throws IOException {
        System.out.println(m1.getTitle());
        m1.setAvgRating();
        m1.setNumReviews();
        System.out.println("______________________________________________________");
        System.out.println("Movie Title:    " + m1.getTitle());
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
        System.out.println("Show Status:    " + showstatus);

        System.out.println("Movie Director: " + m1.getDirector());

        String[] casts = m1.getCast();
        System.out.println("____________________");
        System.out.println("Movie Cast: ");

        for (int k = 0; k < casts.length; k++) {
            System.out.println(k + 1 + ": " + casts[k]);
        }

        System.out.println("____________________");

        System.out.println("Movie Synopsis: " + m1.getSynopsis());

        String rat = "";

        if (m1.getMovieRating() == 0) {
            rat = "G";
        }

        else if (m1.getMovieRating() == 1) {
            rat = "PG";
        }

        else if (m1.getMovieRating() == 2) {
            rat = "PG13";
        }

        else if (m1.getMovieRating() == 3) {
            rat = "NC16";
        }

        else if (m1.getMovieRating() == 4) {
            rat = "M18";
        }

        else if (m1.getMovieRating() == 5) {
            rat = "R21";
        }

        System.out.println("Movie Rating:   " + rat);

        String movietype = "";

        if (m1.getMovieType() == 0) {
            movietype = "3D";
        }

        else if (m1.getMovieType() == 1) {
            movietype = "Blockbuster";
        }

        else if (m1.getMovieType() == 2) {
            movietype = "2D";
        }

        System.out.println("Movie Type:     " + movietype);

        System.out.println("Movie Sales:    $" + m1.getSales());

        if (m1.getNumReviews() > 1) {
            System.out.println("\nAverage Rating: " + m1.getAvgRating());
        }

        else {
            System.out.println("\nNA: Average Rating is not determined due to insufficent reviews");
        }

        System.out.println("______________________________________________________");

        System.out.println();
        System.out.println();

        System.out.println("Do you want to see ratings and reviews?");
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
            if (m1.getNumReviews() > 1) {
                System.out.println("\nAverage Rating: " + m1.getAvgRating());
            }

            else {
                System.out.println("\nNA: Average Rating is not determined due to insufficent reviews");
            }
            ReviewListing reviews = new ReviewListing();
            reviews.setmovie(m1);
            reviews.displayListing();
        }

        // CustomerAction CA = new CustomerAction();
        // CA.setaction(this.action);
        // CA.setuser(user);
        // CA.setmovie(m1);
        // CA.displayaction();

    }
}
