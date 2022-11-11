package MOBLIMA.dataStructure;

import java.io.IOException;
import java.time.LocalDate;
import MOBLIMA.utils.TicketPrice;
import MOBLIMA.utils.dateTime;

public class MovieTicket {
    private String movieTicketId;
    private String ageCat;
    private int seatingRow;
    private int seatingColumn;
    private double price;
    private String showtimeId;
    private int seatClass;

    /**
     * @param a-         String denoting the age category of the movie ticket (0:
     *                   Child, 1: Adult, 2: Senior Citizen)
     * @param sr-        int denoting the assigned seat row
     * @param sc-        int denoting the assigned seat column
     * @param st-        String indicating the showtime id (cinema code + date +
     *                   time)
     * @param seatClass- int denoting the seat's class (0: normal, 1: elite, 2:
     *                   ulitma)
     */
    public MovieTicket(String a, int sr, int sc, String st, int seatClass) throws NumberFormatException, IOException {
        movieTicketId = st + String.valueOf(sr) + String.valueOf(sc) + String.valueOf(seatClass); // dont need
                                                                                                  // movieTicketId- will
                                                                                                  // be populated
        ageCat = a;
        seatingRow = sr;
        seatingColumn = sc;
        LocalDate d = dateTime.convertDate(st.substring(3, 13));
        price = TicketPrice.calculatePrice(d, Integer.valueOf(a), st, seatClass);
        showtimeId = st;
        this.seatClass = seatClass;
    }

    public int getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(int seatClass) {
        this.seatClass = seatClass;
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

    public double getPrice() {
        return price;
    }

    public String getShowtimeId() {
        return showtimeId;
    }
}
