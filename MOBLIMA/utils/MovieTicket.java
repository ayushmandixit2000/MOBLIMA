package MOBLIMA.utils;

public class MovieTicket {
    private String movieTicketId;
    private int ageCat;
    private int seatingRow;
    private int seatingColumn;
    private int date;
    private String time;
    private double price;

    public MovieTicket(String mt, int a, int sr, int sc, int d, String t) {
        movieTicketId = mt;
        ageCat = a;
        seatingRow = sr;
        seatingColumn = sc;
        date = d;
        time = t;
        price = TicketPrice.calculatePrice(d, a);

    }
    // movie ticket id
    // check for seat availability

}
