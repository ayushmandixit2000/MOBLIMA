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

public class TransactionProccessingHandler {
    private MovieTicket[] customertickers;

    private String user;

    public void setuser(String ui) {
        this.user = ui;
    }

    public void settickets(MovieTicket[] tickets) {
        this.customertickers = tickets;
    }

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
