package MOBLIMA.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrieveShowtime;

public class MovieTicket {
    private String movieTicketId;
    private String ageCat;
    private int seatingRow;
    private int seatingColumn;
    private LocalDate date;
    private LocalTime time;
    private double price;
    private static int movieId;

    public MovieTicket(String mt, String a, int sr, int sc, LocalDate d, LocalTime t, int m) {
        movieTicketId = m + dateTime.convertDate(d) + dateTime.convertTime(t) + String.valueOf(sr) + String.valueOf(sc);
        ageCat = a;
        seatingRow = sr;
        seatingColumn = sc;
        date = d;
        time = t;
        price = TicketPrice.calculatePrice(d, Integer.valueOf(a));
        movieId = m;
    }

    // check for seat availability
    public static boolean checkSeat(int row, int column) throws IOException {
        String filename = "MOBLIMA/databases/showtime.txt";
        ArrayList showTimeArray = retrieveShowtime.readShowtime(filename);
        for (int i = 0; i < showTimeArray.size(); i++) {
            Showtime s = (Showtime) showTimeArray.get(i);
            if (s.addSeating(row, column) == true) {
                return true;
            }
        }
        return false;
    }

    public String getMovieTicketId() {
        return movieTicketId;
    }

    public String getAgeCat() {
        return ageCat;
    }

    public int getSeatingRow() {
        return seatingRow;
    }

    public int getSeatingColumn() {
        return seatingColumn;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public int getMovieId() {
        return movieId;
    }
}
