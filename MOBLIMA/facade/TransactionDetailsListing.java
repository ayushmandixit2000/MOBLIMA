package MOBLIMA.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import MOBLIMA.dataStructure.Transaction;

import MOBLIMA.listingInterface.Listing;
import MOBLIMA.utils.dateTime;

public class TransactionDetailsListing implements Listing {

    private Transaction t1;

    public void settransaction(Transaction t) {
        this.t1 = t;
    }

    public void displayListing() throws IOException {
        System.out.println("Transaction ID: " + t1.getTransactionId());

        System.out.println("Purchase Date: " + dateTime.convertDate(t1.getDate()));
    }

}
