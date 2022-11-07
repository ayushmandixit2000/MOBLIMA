package MOBLIMA.dataStructure;

public class Cinema {
    private String cinema;
    private int cineplex;
    private int movieClass;
    private int[][] layout;

    public Cinema(String c, int cp, int mc, int[][] l) {
        cinema = c;// cinemaCode
        cineplex = cp;
        movieClass = mc;
        layout = l;
    }

    public int getCineplex() {
        return cineplex;
    }

    public String getCinema() {
        return cinema;
    }

    public int getMovieClass() {
        return movieClass;
    }

    public int[][] getLayout() {
        return layout;
    }

    public boolean setCinema(String cinema) {
        this.cinema = cinema;
        return true;
    }

    public boolean setCineplex(int cineplex) {
        this.cineplex = cineplex;
        return true;
    }

    public boolean setLayout(int[][] layout) {
        this.layout = layout;
        return true;
    }

    public boolean setMovieClass(int movieClass) {
        this.movieClass = movieClass;
        return true;
    }

}
