package MOBLIMA.facade;

import java.util.Scanner;
import java.io.IOException;
import java.util.*;

import MOBLIMA.Listings.MovieDetailsListing;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.retrieval.retrieveMovie;

public class list {

    private int action = 0;

    public void setaction(int act) {
        this.action = act;
    }

    public void show() throws IOException {
        Scanner scc = new Scanner(System.in);
        System.out.println("Select one movie to continue: ");

        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename);
        for (int i = 0; i < movieArray.size(); i++) {
            Movie m1 = (Movie) movieArray.get(i);
            if (m1.getIsDeleted() == 1) {
                i--;
                continue;
            }
            System.out.println(i + 1 + ": " + m1.getTitle());
        }

        int opt = scc.nextInt();

        if (opt == 0) {
            return;
        }

        for (int i = 0; i < movieArray.size(); i++) {
            Movie m2 = (Movie) movieArray.get(i);
            if (m2.getIsDeleted() == 1) {
                i--;
                continue;
            }
            if (i + 1 == opt) {
                System.out.println("Movie Selected: " + m2.getTitle());
                MovieDetailsListing moviedetails = new MovieDetailsListing();
                moviedetails.setaction(action);
                moviedetails.setmovie(m2);
                moviedetails.displayListing();
            }

        }

    }

}
