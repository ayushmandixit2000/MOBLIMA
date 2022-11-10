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

    public Transaction(String date, String time, String u, String[] tickIds) {
        transactionId = date + time + tickIds[0].substring(0, 3);
        purchaseDate = dateTime.convertDate(date);
        purchaseTime = dateTime.convertTime(time);
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
