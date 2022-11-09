package MOBLIMA.Listings;

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

        



    }

}
