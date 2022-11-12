package MOBLIMA.listing;

import java.util.Scanner;
import java.io.IOException;
import java.util.*;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.retrieval.retrieveMovie;

public class movieListing implements Listing {
    private String user;
    private Movie chosenMovie;
    private ArrayList movieArray;
    private String filename = "MOBLIMA/databases/movie.txt";
    private ArrayList<Movie> validMovies;
    private boolean isAdmin = false;

    public void setuser(String ui) {
        this.user = ui;
    }

    public ArrayList<Movie> getValidMovies() {
        return this.validMovies;
    }

    // need constructor
    public movieListing(boolean admin) throws IOException {
        isAdmin = admin;
        movieArray = retrieveMovie.readMovie(filename);
        validMovies = new ArrayList<Movie>(movieArray);
        if (!isAdmin) {
            validMovies.removeIf(Movie -> Movie.getIsDeleted() != 0);
        }
    }

    public void displayListing() throws IOException {
        if (validMovies.size() == 0) {
            System.out.println("No movies available currently.");
        } else {
            System.out.println("Movies available: ");
            for (int i = 0; i < this.validMovies.size(); i++) {
                Movie m = this.validMovies.get(i);
                System.out.print((i + 1) + ": " + m.getTitle());
                if (isAdmin) {
                    System.out.print(" | Delete Status: " + ((m.getIsDeleted() == 1) ? "True" : "False"));
                }
                System.out.println();
            }
        }
    }

    public void show() throws IOException {
        Scanner scc = new Scanner(System.in);
        displayListing();
        System.out.println("Select one movie to continue");
        int opt;
        while (true) {
            String input = scc.next();
            opt = 0;
            try {
                opt = Integer.parseInt(input);
                if (opt < 1 || opt > validMovies.size()) {
                    System.out.println("Please key in a number from the list above only!");
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ne) {
                System.out.println("Please key in a number only!");
            }
        }
        for (int h = 0; h < validMovies.size(); h++) {
            Movie m2 = (Movie) validMovies.get(h);
            if (opt == h + 1) {
                System.out.println("Movie Selected: " + m2.getTitle());
                chosenMovie = m2;
            }
        }
    }

    public String getUser() {
        return user;
    }

    public Movie getChosenMovie() {
        return chosenMovie;
    }

}
