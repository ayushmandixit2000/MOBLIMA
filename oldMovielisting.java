public class oldMovielisting {
    
}
package MOBLIMA.listing;

import java.util.Scanner;
import java.io.IOException;
import java.util.*;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.retrieval.retrieveMovie;

public class MovieListing implements Listing {
    private String user;
    private Movie chosenMovie;
    private Movie[] mov;
    private ArrayList movieArray;
    private String filename = "MOBLIMA/databases/movie.txt";
    

    public void setuser(String ui) {
        this.user = ui;
    }

    public void displayListing() throws IOException {
        movieArray = retrieveMovie.readMovie(filename);
        int count = 0;
        for (int i = 0; i < movieArray.size(); i++) {
            Movie m1 = (Movie) movieArray.get(i);
            if (m1.getIsDeleted() == 1) {
                count++;
            }
        }
        mov = new Movie[movieArray.size() - count];
        int in = 0;
        for (int j = 0; j < movieArray.size(); j++) {
            Movie m2 = (Movie) movieArray.get(j);
            if (m2.getIsDeleted() == 0) {
                mov[in] = m2;
                in++;
            }
        }
        for (int f = 0; f < mov.length; f++) {
            System.out.println((f + 1) + ": " + mov[f].getTitle());
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
                if (opt < 1 || opt > mov.length) {
                    System.out.println("Please key in a number from the list above only!");
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ne) {
                System.out.println("Please key in a number only!");
            }
        }
        for (int h = 0; h < mov.length; h++) {
            Movie m2 = (Movie) mov[h];
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
