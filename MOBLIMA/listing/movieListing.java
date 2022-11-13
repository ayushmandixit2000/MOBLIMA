package MOBLIMA.listing;

import java.util.Scanner;
import java.io.IOException;
import java.util.*;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.retrieval.retrieveMovie;

/**
 * Helper class to display the appropriate movies based on the user and obtains
 * the a selected
 * movie.
 */
public class movieListing implements Listing {
    /**
     * The id of the user
     */
    private String user;
    /**
     * The movie selected by the user.
     */
    private Movie chosenMovie;
    /**
     * The movies obtained from the movie database.
     */
    private ArrayList movieArray;
    /*
     * The file path to the movie database.
     */
    private String filename = "MOBLIMA/databases/movie.txt";
    /**
     * The appropriate movies obtained from the MovieArray
     */
    private ArrayList<Movie> validMovies;
    /**
     * The user's admin privileges.
     */
    private boolean isAdmin = false;

    /**
     * Changes the user's admin privileges
     * 
     * @param ui The user's new admin privileges
     */
    public void setuser(String ui) {
        this.user = ui;
    }

    /**
     * Gets the appropriate movies.
     * 
     * @return The apppropriate movies.
     */
    public ArrayList<Movie> getValidMovies() {
        return this.validMovies;
    }

    /**
     * Obtains movies from the movie database.
     * Populates movies based on user's admin privileges.
     * 
     * @param admin The user's admin privileges
     */
    public movieListing(boolean admin) throws IOException {
        isAdmin = admin;
        movieArray = retrieveMovie.readMovie(filename);
        validMovies = new ArrayList<Movie>(movieArray);
        if (!isAdmin) {
            validMovies.removeIf(Movie -> Movie.getIsDeleted() != 0);
        }
    }

    /**
     * Displays the appropriate movies (if any).
     */
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

    /**
     * Obtains the user's input for a selected movie from the appropriate movies.
     */
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

    /**
     * Gets the user's id.
     * 
     * @return The id of the user.
     */
    public String getUser() {
        return user;
    }

    /**
     * Gets the selected movie.
     * 
     * @return The selected movie.
     */
    public Movie getChosenMovie() {
        return chosenMovie;
    }
}
