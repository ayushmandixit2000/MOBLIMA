package MOBLIMA.listing;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.utils.compareDates;

/**
 * Helper class to display showtimes of a movie screening at a particular
 * cinema and obtains the moviegoer's selected showtime.
 */
public class ShowtimeListing implements Listing {

    /**
     * The showtime's cineplex.
     */
    private String cineplex;
    /**
     * The showtime's cinema's number.
     */
    private int cinema;
    /**
     * The showtime's cinema's code.
     */
    private String cinemaCode;
    /**
     * Counter for number of showtimes available at that specific cinema and
     * cineplex,
     * screening that movie.
     */
    private int validShowtimes;

    /**
     * Obtains the showtimes of a particular movie at a particular cinema and
     * cineplex.
     */
    public void displayListing() throws IOException {

        String filename = "MOBLIMA/databases/showtime.txt";
        ArrayList showTimeArray = retrieveShowtime.readShowtime(filename);
        filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename);

        int counter = 0;

        System.out.println(
                "Displaying showtime at... \nCineplex: " + cineplex + "   Cinema: " + cinema + "   Cinema Code: "
                        + cinemaCode + "\n");

        System.out.println("Showtime: ");

        Collections.sort(showTimeArray, new compareDates());
        for (int i = 0; i < showTimeArray.size(); i++) {
            Showtime s = (Showtime) showTimeArray.get(i);
            if ((s.getCinema()).equals(cinemaCode)) {
                System.out.print(counter + " - ");
                counter++;
                System.out.print("Date " + s.getDate());
                System.out.print("  Showtime " + s.getTime());
                // System.out.print(" MovieId " + s.getMovieId());
                for (int j = 0; j < movieArray.size(); j++) {
                    Movie m = (Movie) movieArray.get(j);
                    if (m.getMovieId() == s.getMovieId()) {
                        System.out.println("  Movie: " + m.getTitle());
                        break;
                    }
                }
            }
        }
        this.validShowtimes = counter;
        System.out.println("");
        if (counter == 0) {
            System.out.println("Sorry there are no showtime created yet\n");
        }
    }

    /**
     * Obtains the moviegoer's input for a particular showtime.
     * Input is validated with
     * 
     * @return The time of the showtime.
     */
    public LocalTime getListing() throws IOException {

        String filename = "MOBLIMA/databases/showtime.txt";
        ArrayList showTimeArray = retrieveShowtime.readShowtime(filename);
        Scanner sc = new Scanner(System.in);
        LocalTime time = LocalTime.now();
        System.out.println("Enter your choice: ");
        int userindex = sc.nextInt();

        System.out.println("userindex " + userindex);
        int counter = 0;
        Collections.sort(showTimeArray, new compareDates());
        for (int i = 0; i < showTimeArray.size(); i++) {
            Showtime s = (Showtime) showTimeArray.get(i);
            if ((s.getCinema()).equals(cinemaCode)) {
                if (counter == userindex) {
                    time = s.getTime();
                }
                counter++;
            }
        }
        return time;
    }

    /**
     * Changes the following attributes:
     * 
     * @param cnplx The new showtime's cineplex.
     * @param cnm   The new showtime's cinema's number.
     * @param cc    The new showtime's cinema's code.
     */
    public void populate(String cnplx, int cnm, String cc) {
        this.cineplex = cnplx;
        this.cinema = cnm;
        this.cinemaCode = cc;
    }

    /**
     * Gets the number of showtimes available at that specific cinema and cineplex,
     * screening that movie.
     * 
     * @return the number of showtimes available for the mentioned criteria.
     */
    public int getValidShowtimes() {
        return this.validShowtimes;
    }

}
