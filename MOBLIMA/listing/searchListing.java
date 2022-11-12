package MOBLIMA.listing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import MOBLIMA.dataStructure.Movie;
import MOBLIMA.retrieval.retrieveMovie;

public class searchListing implements Listing {
    private Movie chosenMovie;
    private String filename = "MOBLIMA/databases/movie.txt";
    private ArrayList movieArray;
    private List<Movie> optionlist;
    private boolean found = false;
    private String movie;

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
            System.out.println("No Movie Found...");
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

    public void show() throws IOException {
        Scanner scc = new Scanner(System.in);
        System.out.println("\nPlease key in the movie you would like to inquire about: ");
        String movie1 = scc.next();
        movie = movie1.toLowerCase();
        displayListing();
        if (chosenMovie == null) {
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

    public Movie getChosenMovie() {
        return chosenMovie;
    }
}
