package MOBLIMA.dataStructure;

public class Showtime {
    private String cinema;
    private String date;
    private int timeSlot;
    private int movieId;
    private int[][] seating;

    public Showtime(String c, String d, int t, int m, int[][] s) {
        cinema = c;
        date = d;
        timeSlot = t;
        movieId = m;
        seating = s;
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

    public int[][] getSeating() {
        return seating;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
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
