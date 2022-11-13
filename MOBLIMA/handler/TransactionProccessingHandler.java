package MOBLIMA.handler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import MOBLIMA.dataStructure.MovieTicket;
import MOBLIMA.dataStructure.Transaction;
import MOBLIMA.retrieval.retrieveTransaction;
import MOBLIMA.save.saveTransaction;
import MOBLIMA.utils.dateTime;

/**
 * Helper class to save the completed transactions into the transaction
 * database.
 */
public class TransactionProccessingHandler {
    /**
     * The id(s) of the movieticket(s) purchased during the transaction.
     */
    private MovieTicket[] customertickers;

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
     * Changes the id(s) of the movieticket(s) purchased during the transaction.
     * 
     * @param tickets The new id(s) of the movieticket(s).
     */
    public void settickets(MovieTicket[] tickets) {
        this.customertickers = tickets;
    }

    /**
     * Displays the status of the saving process and saves the new transactions into
     * the transaction database.
     * 
     */
    public void display() throws IOException {
        System.out.println("Completing Transaction...");

        String[] ticketids = new String[customertickers.length];

        for (int i = 0; i < customertickers.length; i++) {
            String id = customertickers[i].getMovieTicketId();
            ticketids[i] = id;
        }

        String date = dateTime.convertDate(LocalDate.now());
        String time = dateTime.convertTime(LocalTime.now());

        String filename = "MOBLIMA/databases/transactions.txt";
        ArrayList transactionArray = retrieveTransaction.readTransaction(filename); // retrieve current array
        Transaction t = new Transaction(date, time, user, ticketids);// add new
        transactionArray.add(t);
        saveTransaction.saveTransactionArray(filename, transactionArray);// overwrite file
    }
}
