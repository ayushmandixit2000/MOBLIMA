package MOBLIMA.dataStructure;

import java.time.LocalDate;
import java.time.LocalTime;

import MOBLIMA.utils.dateTime;

public class Transaction {
    private String transactionId;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
    private String userId;
    private String[] arrayofMovieTickets;

    public Transaction(LocalDate d, LocalTime t, String u, String[] tickIds) {
        transactionId = dateTime.convertDate(d) + dateTime.convertTime(t)+ tickIds[0].substring(0,3);
        purchaseDate = d;
        purchaseTime = t;
        userId = u;
        arrayofMovieTickets = tickIds;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public LocalTime getPurchaseTime() {
        return purchaseTime;
    }

    public String getUserId() {
        return userId;
    }

    public String[] getArrayofMovieTickets() {
        return arrayofMovieTickets;
    }

}
