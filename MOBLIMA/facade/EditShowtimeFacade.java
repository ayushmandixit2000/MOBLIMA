package MOBLIMA.facade;

import java.io.IOException;
import MOBLIMA.listing.*;
import MOBLIMA.action.adminShowtimeAction;
import MOBLIMA.handler.createShowtimeHandler;
import MOBLIMA.handler.removeShowtimeHandler;
import MOBLIMA.handler.updateShowtimeHandler;

/**
 * Consolidated class to link all the required classes together to execute the
 * Edit Showtime functionality.
 */
public class editShowtimeFacade {
    /**
     * The showtime's cineplex.
     */
    public static String cineplex;
    /**
     * The showtime's cinema's number.
     */
    public static int cinema;
    /**
     * The showtime's cinema's code
     */
    public static String cinemaCode;

    /**
     * Display the options users have and to instantantiate related classes and
     * execute their required functionalities.
     */
    public void run() throws IOException {
        // Cineplex Listing
        CineplexListing cpxl = new CineplexListing();
        cpxl.displayListing();
        cpxl.getUserInput();
        cineplex = cpxl.getCineplex();
        CinemaListing cnml = new CinemaListing();
        cnml.displayListing();
        cnml.getUserInput();
        cinema = cnml.getCinema();
        int cineplexlength = cineplex.length();
        String cinemaCode = String.valueOf(cineplex.charAt(0)) + String.valueOf(cineplex.charAt(cineplexlength - 1))
                + String.valueOf(cinema);
        ShowtimeListing sl = new ShowtimeListing();
        sl.populate(cineplex, cinema, cinemaCode);
        sl.displayListing();
        adminShowtimeAction asa = new adminShowtimeAction();
        asa.displayChoices();
        int todo = asa.getChoice();
        switch (todo) {
            case 1:
                createShowtimeHandler.run(cineplex, cinema, cinemaCode);
                break;

            case 2:
                updateShowtimeHandler.run(cineplex, cinema, cinemaCode);
                break;

            case 3:
                removeShowtimeHandler.run(cineplex, cinema, cinemaCode);
                break;

            case 4:
                System.out.println("Exiting");
                break;
        }

    }
}