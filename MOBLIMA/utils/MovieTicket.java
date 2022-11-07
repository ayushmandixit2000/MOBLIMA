package MOBLIMA.utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieTicket {
    private String movieTicketId;
    private int ageCat;
    private int seatingRow;
    private int seatingColumn;
    private LocalDate date;
    private LocalTime time;
    private double price;

    public MovieTicket(String mt, int a, int sr, int sc, LocalDate d, LocalTime t) {
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
