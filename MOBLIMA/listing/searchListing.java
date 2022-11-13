package MOBLIMA.listing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.retrieval.retrieveMovie;

/**
 * Helper class to obtain the search term supplied by the moviegoer and display
 * the corresponding movie matches and obtains the moviegoer's selection.
 */
public class searchListing implements Listing {
    /**
     * The selected movie.
     */
    private Movie chosenMovie;

    /**
     * The file path to the movie database.
     */
    private String filename = "MOBLIMA/databases/movie.txt";

    /**
     * The movies obtained from the movie databse.
     */
    private ArrayList movieArray;

    /**
     * The movies that matches the search term.
     */
    private List<Movie> optionlist;

    /**
     * Flag to determine whether any movie matches the search term.
     */
    private boolean found = false;

    /**
     * A movie's title.
     */
    private String movie;

    /**
     * Displays movies stored in the movie database that matches the search term.
     */
    public void displayListing() throws IOException {
        movieArray = retrieveMovie.readMovie(filename);
        optionlist = new ArrayList<Movie>();

        for (int i = 0; i < movieArray.size(); i++) {
            Movie m1 = (Movie) movieArray.get(i);
            String m = m1.getTitle().toLowerCase();
            found = m.contains(movie);
            if (found == true && m1.getIsDeleted() == 0) {
                optionlist.add(m1);
                found = false;
            }
        }

        if (optionlist.size() == 0) {
            return;
        }

        else {
            System.out.println("\nPlease Select the movie based on the options(enter number): ");
            for (int j = 0; j < optionlist.size(); j++) {
                Movie m2 = (Movie) optionlist.get(j);
                System.out.println(j + 1 + " : " + m2.getTitle());
            }
        }
    }

    /**
     * Obtains the movie-goer supplied search term, displays the matches and
     * obtains the movie chosen by the moviegoer
     * 
     */
    public void show() throws IOException {
        Scanner scc = new Scanner(System.in);
        System.out.println("\nPlease key in the movie you would like to inquire about: ");
        String movie1 = scc.next();
        movie = movie1.toLowerCase();
        displayListing();

        if (optionlist.size() == 0) {
            System.out.println("No Movie Found...");
            return;
        }

        int movie_chosen;

        while (true) {
            String input = scc.next();
            movie_chosen = 0;
            try {
                movie_chosen = Integer.parseInt(input);
                if (movie_chosen > optionlist.size() || movie_chosen < 1) {
                    System.out.println("Please key in a valid number!");
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ne) {
                System.out.println("Please key in a number only!");
            }
        }

        for (int j = 0; j < optionlist.size(); j++) {
            if (movie_chosen == j + 1) {
                Movie m3 = (Movie) optionlist.get(j);
                System.out.println();
                System.out.println("You have Selected: " + m3.getTitle());
                System.out.println();
                chosenMovie = m3;
            }
        }
    }

    /**
     * Gets the movie selected by the moviegoer.
     * 
     * @return The movie selected by the moviegoer.
     */
    public Movie getChosenMovie() {
        return chosenMovie;
    }
}
