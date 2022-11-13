package MOBLIMA.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import MOBLIMA.configurables.peakDates;
import MOBLIMA.dataStructure.Cinema;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrieveCinema;
import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.utils.compareDates;

/**
 * Helper class to identify the showtime the moviegoer is interested in
 * booking.
 */
public class CustomerBookingHandler {
    /**
     * The movie selected by the moviegoer.
     */
    private Movie m;

    /**
     * The id of the moviegoer.
     */
    private String user;

    /**
     * Changes the id of the moviegoer.
     * 
     * @param ui The new id of the moviegoer.
     */
    public void setuser(String ui) {
        this.user = ui;
    }

    /**
     * Changes the showtime of the movieticket(s).
     * 
     * @param s The moveticket(s)'s new showtime.
     */
    public void setmovie(Movie m1) {
        this.m = m1;
    }

    /**
     * Displays the relevant options and obtains the moviegoer's input for the
     * required information to book.
     */
    public void display() throws IOException {
        String movt = "";
        if (m.getMovieType() == 0) {
            movt = "--3D";
        }

        if (m.getMovieType() == 1) {
            movt = "--Blockbuster";
        }

        if (m.getMovieType() == 2) {
            movt = "--2D";
        }

        if (m.getShowStatus() == 0) {
            System.out.println("This movie is coming soon, please check back in a few days");
            return;
        }

        if (m.getShowStatus() == 3) {
            System.out.println("This movie is no longer showing. Please choose another movie");
            return;
        }

        if (m.getShowStatus() == 1) {
            System.out.println("Movie Status - Preview");
        }

        if (m.getShowStatus() == 2) {
            System.out.println("Movie Status - Now Showing");
        }

        String filename = "MOBLIMA/databases/showtime.txt";
        ArrayList showTimeArray = retrieveShowtime.readShowtime(filename);
        List<Showtime> optionlist = new ArrayList<Showtime>();
        Collections.sort(showTimeArray, new compareDates());

        for (int i = 0; i < showTimeArray.size(); i++) {
            Showtime s = (Showtime) showTimeArray.get(i);
            if (s.getMovieId() == m.getMovieId()) {
                optionlist.add(s);
            }
        }

        if (optionlist.size() == 0) {
            System.out.println();
            System.out.println("This movie currently have no showitmes, please try again later!");
            System.out.println();
            return;
        }

        System.out.println("Please select a show for " + m.getTitle());
        Scanner scc = new Scanner(System.in);

        for (int j = 0; j < optionlist.size(); j++) {
            System.out.println(
                    "__________________________________________________________________________________________________________________________________________________________");
            Showtime s1 = optionlist.get(j);
            new peakDates();
            String s = "";
            if (peakDates.isPeak(s1.getDate())) {
                s = "\t--Peak period";
            } else if (peakDates.isThurs(s1.getDate())) {
                s = "\t--Thursday";
            }

            String agep = "";

            if (peakDates.isDicountApplicable(s1.getDate(), s1.getTime()) && m.getMovieRating() != 3
                    && m.getMovieRating() != 4 && m.getMovieRating() != 5) {
                agep = "\t--Age Group discounts available";
            }

            String suite = "";

            String filename4 = "MOBLIMA/databases/Cinema.txt";
            ArrayList cinemaArray = retrieveCinema.readCinema(filename4);
            for (int i = 0; i < cinemaArray.size(); i++) {
                Cinema c = (Cinema) cinemaArray.get(i);
                if (c.getCinema().equals(s1.getCinema())) {
                    if (c.getMovieClass() == 1) {
                        suite = "\t--Premium Movie Suite";
                    } else {
                        suite = "";
                    }
                    break;
                }
            }

            System.out.println(j + 1 + ": Cinema :" + s1.getCinema() + " ||" + "Date: " + s1.getDate() + " ||"
                    + "Time: " + s1.getTime() + " ||Movie Type: " + movt + s + suite + agep);
        }

        System.out.println();
        System.out.println();
        System.out.println("-----------------------------Note------------------------------");

        System.out.println("1: Age group discounts are only available on Mon-Fri before 6pm");
        System.out.println("2: Movies on Thursday will cost more");
        System.out.println("3: Movies on Public Holidays, Weekends and Cinema indicated peak days will cost more");
        System.out.println("4: Movies in Premium Cinemas will cost more");

        System.out.println(
                "___________________________________________________________________________________________________________");

        System.out.println("Please select a show for " + m.getTitle());
        int option;

        while (true) {
            String input = scc.next();
            option = 0;
            try {
                option = Integer.parseInt(input);
                if (option > optionlist.size() || option < 1) {
                    System.out.println("Please key in a valid number!");
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ne) {
                System.out.println("Please key in a number only!");
            }
        }

        for (int l = 0; l < optionlist.size(); l++) {
            if (option == l + 1) {
                Showtime s2 = optionlist.get(l);

                SeatAvailabilityHandler sa = new SeatAvailabilityHandler();
                sa.setshow(s2);
                sa.setuser(user);
                sa.display();
            }
        }
    }
}
