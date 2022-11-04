package MOBLIMA.dataStructure;

public class Cinema {
    private String cinema;
    private int cineplex;
    private int movieClass;
    private String layout; // int[][]

    public Cinema( String c,int cp,int mc, String l) {
        cinema = c;
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

    public String getLayout() {
        return layout;
    }

}
