package MOBLIMA.dataStructure;

public class Cinema {
    private String cinema;
    private int cineplex;
    private int movieClass;

    /**
     * @param c-  3 letter string assigned to individual cinemas (first 2 letters
     *            are starting and ending of cineplex name and last letter is the
     *            cinema number)
     * @param cp- integer denoting the 3 managed cineplex
     * @param mc- integer denoting whether cinema is Default (0) or Platinum Movie
     *            Suite (1)
     */

    public Cinema(String c, int cp, int mc) {
        cinema = c;
        cineplex = cp;
        movieClass = mc;
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

    public boolean setCinema(String cinema) {
        this.cinema = cinema;
        return true;
    }

    public boolean setCineplex(int cineplex) {
        this.cineplex = cineplex;
        return true;
    }

    public boolean setMovieClass(int movieClass) {
        this.movieClass = movieClass;
        return true;
    }
}