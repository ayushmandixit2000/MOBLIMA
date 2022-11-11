package MOBLIMA.dataStructure;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import MOBLIMA.facade.pastTransactionsFacade;
import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.save.saveShowtime;
import MOBLIMA.utils.dateTime;

public class Showtime {
    private String cinema;
    private LocalDate date;
    private LocalTime time;
    private int movieId;
    private int[][] seating;
    private String showtimeId;
    private String filename = "MOBLIMA/databases/showtime.txt";

    /**
     * 
     * @param c- 3 letter string denoting the cinema code
     * @param d
     * @param t
     * @param m
     * @param s
     */

    public Showtime(String c, LocalDate d, LocalTime t, int m, int[][] s) {
        cinema = c;
        date = d;
        time = t;
        movieId = m;
        seating = s;
        showtimeId = c + dateTime.convertDate(d) + dateTime.convertTime(t);
    }

    public String getCinema() {
        return cinema;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getMovieId() {
        return movieId;
    }

    public int[][] getSeating() {
        return seating;
    }

    public String getShowtimeId() {
        return showtimeId;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setSeating(int[][] seating) {
        this.seating = seating;
    }

    public void addSeating(int row, int column) throws IOException {
        if (this.seating[row][column] == 0) {
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
