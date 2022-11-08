package MOBLIMA.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.Transaction;

import MOBLIMA.listingInterface.Listing;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.utils.dateTime;

public class TransactionDetailsListing implements Listing {

    private Transaction t1;

    public void settransaction(Transaction t) {
        this.t1 = t;
    }

    public void displayListing() throws IOException {
        System.out.println("Transaction ID: " + t1.getTransactionId());

        System.out.println("Purchase Date: " + dateTime.convertDate(t1.getPurchaseDate()));

        System.out.println("Purchase Time: " + dateTime.convertTime(t1.getPurchaseTime()));

        System.out.println("User ID: " + t1.getUserId());

        System.out.println("\nprinting additonal ticket details...");

        TransactionShowTimeListing TSL = new TransactionShowTimeListing();
        TSL.sett(t1);
        TSL.displayListing();

        // System.out.println("Movie ID: " + t1.getMovieId());

        // String filename = "MOBLIMA/databases/movie.txt";
        // ArrayList movieArray = retrieveMovie.readMovie(filename);

        // for (int i = 0; i < movieArray.size(); i++) {
        //     Movie m1 = (Movie) movieArray.get(i);
        //     if (m1.getMovieId() == t1.getMovieId()) {
        //         System.out.println("Movie: " + m1.getTitle());
        //     }
        // }

        // System.out.println("Cinema: " + t1.getCinema());

        // System.out.println("Total Cost: $" + t1.getTotalCost());

        // System.out.println("Total Tickets Count: " + t1.getTicketCount());

        // String[] cats = t1.getArrayOfTicketCatgeory();
        // int [][] seats = t1.getArrayOfSeatAllocation();

        // for (int m = 0; m < cats.length; m++) {
        //     String ans = "";

        //     int k = Integer.parseInt(cats[m]);

        //     int [] exact = seats[m];

        //     int row = exact[0];

        //     int column = exact[1];


        //     if(k == 0){
        //         ans = "Child";
        //     }

        //     else if(k == 1){
        //         ans = "Adult";
        //     }

        //     else if(k == 2){
        //         ans = "Senior Citizen";
        //     }

        //     int n = m + 1;
        //     System.out.println("Ticket " + n + " : " + ans + " Ticket" + " || " + "Row : " + row + " Column " + column);
       // }



    }

}
