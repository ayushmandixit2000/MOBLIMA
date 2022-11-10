package MOBLIMA.dataStructure;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.utils.TicketPrice;
import MOBLIMA.utils.dateTime;

public class MovieTicket {
    private String movieTicketId;
    private String ageCat;
    private int seatingRow;
    private int seatingColumn;
    private double price;
    private String showtimeId;

    public MovieTicket(String a, int sr, int sc, String st) throws NumberFormatException, IOException {
        movieTicketId = st + String.valueOf(sr) + String.valueOf(sc); // dont need movieTicketId- will be populated
        ageCat = a;
        seatingRow = sr;
        seatingColumn = sc;
        LocalDate d = dateTime.convertDate(st.substring(3, 13));
        price = TicketPrice.calculatePrice(d, Integer.valueOf(a));
        showtimeId = st;
    }

    // check for seat availability
    // public static boolean checkSeat(String showtimeId, int row, int column) throws IOException {
    //     String filename = "MOBLIMA/databases/showtime.txt";
    //     ArrayList showTimeArray = retrieveShowtime.readShowtime(filename);
    //     for (int i = 0; i < showTimeArray.size(); i++) {
    //         Showtime s = (Showtime) showTimeArray.get(i);
    //         if (showtimeId.equals(s.getShowtimeId())) {
    //             if (s.addSeating(row, column) == true) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

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

    public double getPrice() {
        return price;
    }

    public String getShowtimeId() {
        return showtimeId;
    }
}
