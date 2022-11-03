package MOBLIMA.dataStructure;

public class Showtime {
    private int cineplex;
    private String cinema;
    private String date;
    private int timeSlot;
    private int movieId;
    private String seating; // instead of int[][]

    public Showtime(int cp, String c, String d, int t, int m, String s) {
        cineplex = cp;
        cinema = c;
        date = d;
        timeSlot = t;
        movieId = m;
        seating = s;
    }

    public int getCineplex() {
        return cineplex;
    }

    public String getCinema() {
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

    public String getSeating() {
        return seating;
    }
}
