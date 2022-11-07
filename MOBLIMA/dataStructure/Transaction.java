package MOBLIMA.dataStructure;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private String transactionId;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
    private String userId;
    private int movieId;
    private LocalDate date;
    private LocalTime time;
    private String cinema;
    private int totalCost;
    private int ticketCount;
    private String[] arrayOfTicketCatgeory;
    private int[][] arrayOfSeatAllocation;// array of seat allocation, separated by .

    public Transaction(String tid, LocalDate pd, LocalTime pt, String uid, int mid, LocalDate d, LocalTime t, String c,
            int tc,
            int tickCount,
            String[] arrayCat, int[][] arraySeats) {
        transactionId = tid;
        purchaseDate = pd;
        purchaseTime = pt;
        userId = uid;
        movieId = mid;
        date = d;
        time = t;
        cinema = c;
        totalCost = tc;
        ticketCount = tickCount;
        arrayOfTicketCatgeory = arrayCat;
        arrayOfSeatAllocation = arraySeats;
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

    public int getMovieId() {
        return movieId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getCinema() {
        return cinema;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public String[] getArrayOfTicketCatgeory() {
        return arrayOfTicketCatgeory;
    }

    public int[][] getArrayOfSeatAllocation() {
        return arrayOfSeatAllocation;
    }
}
