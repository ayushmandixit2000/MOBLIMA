package MOBLIMA.dataStructure;

public class Showtime {
    private String cineplex;
    private int cinema;
    private String date;
    private int timeSlot;
    private int movieId;
    private int[][] seating;

    public Showtime(String cp, int c, String d, int t, int m, int[][] s) {
        cineplex = cp;
        cinema = c;
        date = d;
        timeSlot = t;
        movieId = m;
        seating = s;
    }

    public String getCineplex() {
        return cineplex;
    }

    public int getCinema() {
        return cinema;
    }

    public String getDate() {
        return date;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public int getMovieId() {
        return movieId;
    }

    public int[][] getSeating() {
        return seating;
    }
}
