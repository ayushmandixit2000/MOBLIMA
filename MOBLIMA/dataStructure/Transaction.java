package MOBLIMA.dataStructure;

public class Transaction {
    private String transactionId;
    private String purchaseDate; // supposed to be date
    private int purchaseTime;
    private String userId;
    private int movieId;
    private String date;
    private int time;
    private String cinema;
    private int totalCost;
    private int ticketCount;
    private String arrayOfTicketCatgeory;// array of integers
    private String arrayOfSeatAllocation;// array of seat allocation tuple

    public Transaction(String tid, String pd, int pt, String uid, int mid, String d, int t, String c, int tc, int tickCount,
            String arrayCat, String arraySeats) {
        transactionId = tid;
        purchaseDate = pd;
        purchaseTime = pt;
        userId = uid;
        movieId= mid;
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

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public int getPurchaseTime() {
        return purchaseTime;
    }

    public String getUserId() {
        return userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getDate() {
        return date;
    }

    public int getTime() {
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

    public String getArrayOfTicketCatgeory() {
        return arrayOfTicketCatgeory;
    }

    public String getArrayOfSeatAllocation() {
        return arrayOfSeatAllocation;
    }
}
