package MOBLIMA.listingInterface;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.listingInterface.*;
import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.utils.compareDates;
import MOBLIMA.utils.dateTime;

public class ShowtimeListing implements Listing{

    private String cineplex;
    private int cinema;
    private String cinemaCode; 

    public void displayListing() throws IOException {

        String filename = "MOBLIMA/databases/showtime.txt";
        ArrayList showTimeArray = retrieveShowtime.readShowtime(filename);
        //System.out.println(showTimeArray);
        
        int counter = 0;
        System.out.println("Displaying showtime at... \nCineplex: " + cineplex   + " Cinema: " + cinema + " Cinema Code: " + cinemaCode);
        System.out.println("Showtime: ");
        Collections.sort(showTimeArray, new compareDates());
        for (int i = 0; i < showTimeArray.size(); i++) {
            Showtime s = (Showtime) showTimeArray.get(i);
            if ((s.getCinema()).equals(cinemaCode))
            {
                System.out.print(counter + " - " );
                counter++;
                System.out.print("Date " + s.getDate());
                System.out.print("  showtime " + s.getTime());
                System.out.println("  MovieId " + s.getMovieId());
            }
        }
        if (counter == 0) {
            System.out.println("Sorry there are no showtime created yet");
        }
    }







    public LocalTime getListing() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        while (choice < 0 || choice > 6) {
            System.out.println("please input your choice");
            choice = sc.nextInt();
        }

        System.out.println("choice: " + choice);
        LocalTime localtime = dateTime.convertTime("0100");
        switch(choice) {

            }

            return localtime;
    }



    // populate the attributes
    public void populate(String cnplx, int cnm, String cc){
        this.cineplex = cnplx;
        this.cinema = cnm;
        this.cinemaCode = cc;
    }


    // Test code works!
    public static void main(String[] args) throws IOException {
        ShowtimeListing listing = new ShowtimeListing();

        listing.populate("Ang Mo Kio",2,"Ao2" );

        listing.displayListing();

        LocalTime lt = listing.getListing();

        System.out.println(lt);

    }

}