import java.util.Date;

public class Transaction {
    private Date transactionTime;
    private MovieTicket[] tickets;

    public Transaction(Date transactionTime, MovieTicket[] tickets) {
        this.transactionTime = transactionTime;
        this.tickets = tickets;
    }

    public String getTransactionID() {
        return "formatted TID"; // using time and cinemacode
    }

    public double getTotalCost() {
        double cost = 0;
        for (int i = 0; i < tickets.length; i++) {
            cost += tickets[i].getPrice();
        }
        return cost;
    }

}
