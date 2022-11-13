package MOBLIMA.listing;

import java.io.IOException;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.dataStructure.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Helper class to display top 5 movie based on sales and obtains the user's
 * selected movie.
 */
public class top5SalesListing {

    /**
     * The selected movie.
     */
    private Movie m1;

    /**
     * Displays top 5 movie ranked on sales from the movie database and obtains the
     * moviegoer's selected movie.
     */
    public void displayListing() throws IOException {

        Scanner scc = new Scanner(System.in);
        String filename1 = "MOBLIMA/databases/movie.txt";
        String filename2 = "MOBLIMA/databases/movieTicket.txt";
        System.out.println("The top 5 movies are...");
        ArrayList movieObjects = retrieveMovie.readMovie(filename1); // this creates an array of movie objects
        // ArrayList movieTickets = retrieveMovieTicket.readMovieTicket(filename2); //
        // array of movie tickets
        int arraySize = movieObjects.size();

        ArrayList<titleSales> salesTitle = new ArrayList<titleSales>(); // create array for the objects with title and
                                                                        // // sales number
        for (int i = 0; i < arraySize; i++) {
            Movie m = (Movie) movieObjects.get(i); // pulls one movie object from the arraylist
            Double salesNo = m.getSales();
            String title = m.getTitle();
            // MovieTicket t = (MovieTicket) movieTickets.get(i);
            // int totalSales = (int)totalsales;
            if (m.getIsDeleted() == 0) {
                titleSales newObject = new titleSales(title, salesNo);
                // salesTitle[i] = newObject;
                salesTitle.add(newObject);
            }
        }

        String[] ids = new String[5];
        // Arrays.sort(salesTitle);
        Collections.sort(salesTitle,
                Comparator.comparingDouble(titleSales::getTotalSales));

        int count = 0;
        if (salesTitle.size() < 5) {
            int num = 1;
            for (int j = salesTitle.size() - 1; j > -1; j--) {
                System.out.println(
                        num + ":   Sales: [$" + salesTitle.get(j).getTotalSales() + "]\t"
                                + salesTitle.get(j).getTitle());
                ids[num - 1] = salesTitle.get(j).getTitle();
                num++;
            }
            count = num;
        } else {
            int num = 1;
            for (int j = salesTitle.size() - 1; j > salesTitle.size() - 6; j--) {
                System.out.println(
                        num + ":   Rated: [" + salesTitle.get(j).getTotalSales() + "]\t"
                                + salesTitle.get(j).getTitle());
                ids[num - 1] = salesTitle.get(j).getTitle();
                num++;
            }
            count = num;
        }

        System.out.println("Would you like to continue with a movie?");
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
            System.out.println(
                    "Please select a movie you want to find out more about (enter the number beside the movie)");

            int additional;

            while (true) {
                String input = scc.next();
                additional = 0;
                try {
                    additional = Integer.parseInt(input);
                    if (additional > count || additional < 1) {
                        System.out.println("Please key in a valid number!");
                        continue;
                    } else {
                        break;
                    }
                } catch (NumberFormatException ne) {
                    System.out.println("Please key in a number only!");
                }
            }

            String titlechosen = ids[additional - 1];

            String filename = "MOBLIMA/databases/movie.txt";
            ArrayList movieArray = retrieveMovie.readMovie(filename);
            for (int i = 0; i < movieArray.size(); i++) {
                Movie m = (Movie) movieArray.get(i);
                if (m.getTitle().equalsIgnoreCase(titlechosen)) {
                    this.m1 = m;
                }
            }
        }
    }

    /**
     * Gets the selected movie.
     * 
     * @return The selected movie.
     */
    public Movie getmovie() {
        return this.m1;
    }
}

/**
 * Helper class to compare movies, used for ranking by sales.
 */
class titleSales implements Comparable<titleSales> {
    /**
     * The movie's title.
     */
    private String title;

    /**
     * The movie's customer rating.
     */
    private Double totalSales;

    /**
     * Creates a TitleRating with the following attributes:
     * 
     * @param title  The movie's title.
     * @param rating The movie's customer rating.
     */
    public titleSales(String title, Double totalSales) {
        this.title = title;
        this.totalSales = totalSales;
    }

    /**
     * Gets the movie's title.
     * 
     * @return The movie's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the movie's sales.
     * 
     * @return The movie's sales.
     */
    public Double getTotalSales() {
        return totalSales;
    }

    /**
     * Compares 2 movies based on their sales and title.
     * 
     * @return a result indicating which movie is ordered first.
     */
    public int compareTo(titleSales o) {
        return this.title.compareTo(o.getTitle());
    }
}