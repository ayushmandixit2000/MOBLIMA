package MOBLIMA.dataStructure;

import java.time.LocalDate;
import java.time.LocalTime;

public class Showtime {
    private String cinema;
    private LocalDate date;
    private LocalTime time;
    private int movieId;
    private int[][] seating;

    public Showtime(String c, LocalDate d, LocalTime t, int m, int[][] s) {
        cinema = c;
        date = d;
        time = t;
        movieId = m;
        seating = s;
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

    public boolean addSeating(int row, int column) {
        if (this.seating[row][column] == 0) {
            this.seating[row][column] = 1;
            return true;
        }
        return false;
    }
}
