package MOBLIMA.listing;

import java.io.IOException;
import MOBLIMA.dataStructure.Transaction;
import MOBLIMA.utils.dateTime;

/**
 * Helper class to display the general information of a particular transaction.
 */
public class TransactionDetailsListing implements Listing {

    /**
     * The transaction to display details of.
     */
    private Transaction t1;

    /**
     * Changes the selected transaction to display general information of.
     * 
     * @param t The new transaction to display general information of.
     */
    public void settransaction(Transaction t) {
        this.t1 = t;
    }

    /**
     * Display the general information of the selected transaction.
     */
    public void displayListing() throws IOException {
        System.out.println();
        System.out.println("__________________________________________________");
        System.out.println("Transaction ID: " + t1.getTransactionId());

        System.out.println("Purchase Date:  " + dateTime.convertDate(t1.getPurchaseDate()));

        System.out.println("Purchase Time:  " + dateTime.convertTime(t1.getPurchaseTime()));

        System.out.println("User ID:        " + t1.getUserId());

        System.out.println("__________________________________________________");

        System.out.println();

        System.out.println("\nprinting additonal ticket details...");

        TransactionShowTimeListing TSL = new TransactionShowTimeListing();
        TSL.sett(t1);
        TSL.displayListing();
    }
}
