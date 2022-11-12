package MOBLIMA.dataStructure;

import java.time.LocalDate;
import java.time.LocalTime;
import MOBLIMA.utils.dateTime;

/**
 * Represents a transaction made by a moviegoer
 */
public class Transaction {
    /**
     * The id of this Transaction.
     * Obtained from concatenating the ciname, purchase date and purchase time.
     */
    private String transactionId;

    /**
     * The purchase date of this Transaction.
     */
    private LocalDate purchaseDate;

    /**
     * The purchase time of this Transaction.
     */
    private LocalTime purchaseTime;

    /**
     * The user's id who made this Transaction.
     */
    private String userId;

    /**
     * The id(s) of the movie ticket(s) of this Transaction.
     */
    private String[] arrayofMovieTickets;

    /**
     * Creates a transactioon with the following attributes:
     * 
     * @param date    This Transaction's purchase date.
     * @param time    This Transactions's purchase time.
     * @param u       This Transaction's user's id.
     * @param tickIds This Transaction's movie ticket(s)'s id(s).
     */

    public Transaction(String date, String time, String u, String[] tickIds) {
        transactionId = date + time + tickIds[0].substring(0, 3);
        purchaseDate = dateTime.convertDate(date);
        purchaseTime = dateTime.convertTime(time);
        userId = u;
        arrayofMovieTickets = tickIds;
    }

    /**
     * Gets the id of this Transaction.
     * 
     * @return This Transaction's id.
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Gets the purchase date of this Transaction.
     * 
     * @return This Transaction's purchase date.
     */
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Gets the purchase time of this Transaction.
     * 
     * @return This Transaction's purchase time.
     */
    public LocalTime getPurchaseTime() {
        return purchaseTime;
    }

    /**
     * Gets the id of the user of this Transaction.
     * 
     * @return This Transaction's user's id.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Gets the id(s) of the movie ticket(s) of this Transaction.
     * 
     * @return This Transaction's movie ticket(s)'s id(s).
     */
    public String[] getArrayofMovieTickets() {
        return arrayofMovieTickets;
    }
}
