package MOBLIMA.dataStructure;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.save.saveShowtime;
import MOBLIMA.utils.dateTime;

/**
 * Represents a showtime of an assigned cinema.
 * Each showtime has a seating availability that can be edited based on
 * moviegoers' bookings
 */
public class Showtime {
    /**
     * The cinema of this Showtime.
     */
    private String cinema;

    /*
     * The date of this Showtime.
     */
    private LocalDate date;

    /**
     * The time of this Showtime.
     */
    private LocalTime time;

    /**
     * The id of the movie screen during this Showtime.
     */
    private int movieId;

    /**
     * The seating availability of this Showtime.
     * Stored as a 2D array with the following representations:
     * 0: Available , 1: Occupied, 2: Not Seats, 3: Elite, 4: Ultima, 5: Couple
     */
    private int[][] seating;

    /**
     * The id of this Showtime.
     * Obtained from concatentating the cinema, date and time of the showtime.
     */
    private String showtimeId;

    /**
     * The file path to the showtime database.
     */
    private String filename = "MOBLIMA/databases/showtime.txt";

    /**
     * Creates a Showtime with the following attributes:
     * 
     * @param c  The cinema of this Showtime.
     * @param d  The date of this Showtime.
     * @param t  The time of this Showtime.
     * @param m  The id of the movie screened at this Showtime.
     * @param s- The seating availability of this Showtime.
     */

    public Showtime(String c, LocalDate d, LocalTime t, int m, int[][] s) {
        cinema = c;
        date = d;
        time = t;
        movieId = m;
        seating = s;
        showtimeId = c + dateTime.convertDate(d) + dateTime.convertTime(t);
    }

    /**
     * Gets the cinema of this Showtime.
     * 
     * @return This Showtime's cinema.
     */
    public String getCinema() {
        return cinema;
    }

    /**
     * Gets the date of this Showtime.
     * 
     * @return This Showtime's date.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets the time of this Showtime.
     * 
     * @return This Showtime's time.
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Gets the id of the movie screened at this Showtime.
     * 
     * @return This Showtime's movie's id.
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * Gets the seating availability of this Showtime.
     * 
     * @return This Showtime's seating availability.
     */
    public int[][] getSeating() {
        return seating;
    }

    /**
     * Gets the id of this Showtime.
     * 
     * @return This showtime's id.
     */
    public String getShowtimeId() {
        return showtimeId;
    }

    /**
     * Changes the cinema of this Showtime.
     * 
     * @param cinema This Showtime's new assigned cinema.
     */
    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    /**
     * Changes the date of this Showtime.
     * 
     * @param date This Showtime's new date.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Changes the time of this Showtime.
     * 
     * @param time This Showtime's new time.
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Changes the id of movie screened at this Showtime.
     * 
     * @param movieId This Showtime's screened movie's id.
     */
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    /**
     * Changes the seating availability of this Showtime.
     * 
     * @param seating This Showtime's seating availability.
     */
    public void setSeating(int[][] seating) {
        this.seating = seating;
    }

    /**
     * Books the indicated seat for this Showtime.
     * Saves the changesS into the showtime database
     * 
     * @param row    This Showtime's seats' row to be booked.
     * @param column This Showtime's seats' column to be booked.
     */
    public void addSeating(int row, int column) throws IOException {
        if (this.seating[row][column] == 0 || this.seating[row][column] == 3 || this.seating[row][column] == 4 || this.seating[row][column] == 5) {
            this.seating[row][column] = 1;
            ArrayList showTimeArray = retrieveShowtime.readShowtime(filename);
            for (int i = 0; i < showTimeArray.size(); i++) {
                Showtime s = (Showtime) showTimeArray.get(i);
                if (this.getShowtimeId().equals(s.getShowtimeId())) {
                    s.setSeating(this.seating);
                }
            }
            saveShowtime.saveShowtimeArray(filename, showTimeArray);
            return;
        }
        return;
    }
}
