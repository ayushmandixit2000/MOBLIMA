package MOBLIMA.dataStructure;

public class Cinema {
    private String cineplex;
    private int cinema;
    private int movieClass;
    private String layout; // int[][]

    public Cinema(String cp, int c, int mc, String l) {
        cineplex = cp;
        cinema = c;
        movieClass = mc;
        layout = l;
    }

    public String getCineplex() {
        return cineplex;
    }

    public int getCinema() {
        return cinema;
    }

    public int getMovieClass() {
        return movieClass;
    }

    public String getLayout() {
        return layout;
    }

}
