package MOBLIMA.facade;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

import MOBLIMA.listingInterface.*;
import MOBLIMA.create.createShowtime;

public class EditShowtimeFacade {

    public static String cineplex;
    public static int cinema;
    public static String cinemaCode;

    public static void main(String[] args) throws IOException {

        CinemaListing cnml = new CinemaListing();
        ShowtimeListing sl = new ShowtimeListing();
        CineplexListing cpxl = new CineplexListing();
        adminShowtimeAction action = new adminShowtimeAction();
        
        // Cineplex Listing
        cpxl.displayListing();
        cineplex = cpxl.getListing();

        // Cinema Listing
        cnml.displayListing();
        cinema = cnml.getListing();

        int cineplexlength = cineplex.length();
        // System.out.println(cineplex.charAt(cineplexlength-1));

        // cinemaCode
        // First + last letter of cineplex + cinema number
        String cinemaCode = String.valueOf(cineplex.charAt(0)) + String.valueOf(cineplex.charAt(cineplexlength-1)) + String.valueOf(cinema);
        System.out.println("Cinema Code: " + cinemaCode);

        // Showitme Listing
        sl.populate(cineplex, cinema, cinemaCode);
        sl.displayListing();

        // Ask use what would they like to do?
        action.displayListing();
        Scanner sc = new Scanner(System.in);
        int todo = sc.nextInt();

        switch(todo){
            case 0: // Create Showtime
            createShowtime.create();

            case 1: // Update Showtime

            case 2: // Remove Showtime
        }
        
    }
}
