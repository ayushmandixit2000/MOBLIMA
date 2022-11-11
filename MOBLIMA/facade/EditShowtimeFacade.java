package MOBLIMA.facade;

import java.io.IOException;
import MOBLIMA.listing.*;
import MOBLIMA.action.adminShowtimeAction;
import MOBLIMA.handler.createShowtimeHandler;
import MOBLIMA.handler.removeShowtimeHandler;
import MOBLIMA.handler.updateShowtimeHandler;

public class editShowtimeFacade {

    public static String cineplex;
    public static int cinema;
    public static String cinemaCode;

    public void run() throws IOException {
        // Cineplex Listing
        CineplexListing cpxl = new CineplexListing();
        cpxl.displayListing();
        cineplex = cpxl.getListing();

        // Cinema Listing
        CinemaListing cnml = new CinemaListing();
        cnml.displayListing();
        cinema = cnml.getListing();

        int cineplexlength = cineplex.length();

        // cinemaCode
        // First + last letter of cineplex + cinema number
        String cinemaCode = String.valueOf(cineplex.charAt(0)) + String.valueOf(cineplex.charAt(cineplexlength - 1))
                + String.valueOf(cinema);

        // Showitme Listing
        ShowtimeListing sl = new ShowtimeListing();
        sl.populate(cineplex, cinema, cinemaCode);
        sl.displayListing();

        // Ask use what would they like to do?
        adminShowtimeAction asa = new adminShowtimeAction();
        asa.displayChoices();
        int todo = asa.getChoice();
        switch (todo) {
            case 1: // Create Showtime
                createShowtimeHandler.run(cineplex, cinema, cinemaCode);
                break;

            case 2: // Update Showtime
                updateShowtimeHandler.run(cineplex, cinema, cinemaCode);
                break;

            case 3: // Remove Showtime
                removeShowtimeHandler.run(cineplex, cinema, cinemaCode);
                break;

            case 4:
                System.out.println("Exiting");
                break;
        }

    }
}