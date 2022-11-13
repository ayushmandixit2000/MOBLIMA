package MOBLIMA.dataStructure;

import java.io.IOException;
import java.time.LocalDate;
import MOBLIMA.utils.TicketPrice;
import MOBLIMA.utils.dateTime;

/**
 * Represents a MovieTicket that has selected by a MovieGoer.
 * 
 */
public class MovieTicket {
    /**
     * The id of this MovieTicket.
     * This is obtained from concatenating the assigned showtimeId, assigned seat's
     * row and assigned seat's column.
     */
    private String movieTicketId;

    /*
     * The index of the age category of this MovieTicket (0:
     * Child, 1: Adult, 2: Senior Citizen).
     */
    private String ageCat;

    /**
     * The index of the assigned seat's row of this MovieTicket (0: Child, 1: Adult,
     * 2: Senior Citizen).
     */
    private int seatingRow;

    /**
     * The index of the assigned seat's column of this MovieTicket.
     */
    private int seatingColumn;

    /**
     * The price of this MovieTicket.
     * This is dependent on several factors. (Date and time of showtime, movie class
     * of cinema, seat class of seat)
     */
    private double price;

    /**
     * The assigned showtieId of this MovieTicket.
     */
    private String showtimeId;

    /**
     * The seat class index of the assigned seat of this MovieTicket (0: Normal, 1:
     * Elite, 2: Ultima)
     */
    private int seatClass;

    /**
     * Creates a MovieTicket with the following attributes:
     * This will calculate the price of this MovieTicket using helper classes based
     * on the above-mentioned factors.
     * 
     * @param a         This MovieTicket's assigned age category.
     * @param sr        This MovieTicket's assigned seat's row index.
     * @param sc        This MovieTicket's assigned seat's column index.
     * @param st        This MovieTicket's assigned showtimeId.
     * @param seatClass This MovieTicket's assigned seat's seat class.
     */
    public MovieTicket(String a, int sr, int sc, String st, int seatClass) throws NumberFormatException, IOException {
        movieTicketId = st + String.valueOf(sr) + String.valueOf(sc) + String.valueOf(seatClass);
        ageCat = a;
        seatingRow = sr;
        seatingColumn = sc;
        LocalDate d = dateTime.convertDate(st.substring(3, 13));
        price = TicketPrice.calculatePrice(d, Integer.valueOf(a), st, seatClass);
        showtimeId = st;
        this.seatClass = seatClass;
    }

    /**
     * Gets the seat class index of the assigned seat of this MovieTicket.
     * 
     * @return This MovieTicket's assigned seat's seat class.
     */
    public int getSeatClass() {
        return seatClass;
    }

    /**
     * Changes the seat class index of the assigned seat of this MovieTicket.
     * 
     * @param seatClass This MovieTicket's new seat class index of the assigned
     *                  seat.
     */
    public void setSeatClass(int seatClass) {
        this.seatClass = seatClass;
    }

    /**
     * Gets the id of this MovieTicket.
     * 
     * @return This MovieTicket's id.
     */
    public String getMovieTicketId() {
        return movieTicketId;
    }

    /**
     * Gets the age category of this MovieTicket.
     * 
     * @return This MovieTicket's age category.
     */
    public String getAgeCat() {
        return ageCat;
    }

    /**
     * Gets the assigned seat's row index of this MovieTicket.
     * 
     * @return This MovieTicket's assgined seat's row index.
     */
    public int getSeatingRow() {
        return seatingRow;
    }

    /**
     * 
     * Gets the assigned seat's column index of this MovieTicket.
     * 
     * @return This MovieTicket's assigned seat's column index.
     */
    public int getSeatingColumn() {
        return seatingColumn;
    }

    /**
     * Gets the price of this MovieTicket.
     * 
     * @return This MovieTicket's price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the showtime of this MovieTicket.
     * 
     * @return This MovieTicket's showtimeId.
     */
    public String getShowtimeId() {
        return showtimeId;
    }
}
