package MOBLIMA.facade;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

import MOBLIMA.listingInterface.*;
import MOBLIMA.create.createShowtime;

public class EditShowtimeFacade {

    public static void main(String[] args) throws IOException {
        adminShowtimeAction action = new adminShowtimeAction();
        // Display Cineplex
        cpxl.displayListing();
        cineplex = CineplexListing.getListing();

        // Cinema
        cnml.displayListing();
        cinema = CineplexListing.getListing();

        // Showtime
        sl.displayListing();
        showtime =sl.getListing();



        action.displayListing();
        int todo = action.getListing();

        switch(todo){
            case 0: // Create Showtime
            createShowtime.create();

            case 1: // Update Showtime

            case 2: // Remove Showtime
        }
        
    }
}
