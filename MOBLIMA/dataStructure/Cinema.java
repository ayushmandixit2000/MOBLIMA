package MOBLIMA.dataStructure;

/**
 * Represents a cinema that belongs to a cineplex.
 * Each Cinema can only have 1 movie class.
 * Each Cinema has a fixed seating layout which moviegoers can book seats for
 * (seat allocation is done in Showtime)
 * @author Wong Yu Fei
 * @version 1.0
 */
public class Cinema {
    /**
     * The unique cinema code which has 3 letters- first 2 are the starting and ending letter of the cineplex name while the last letter is the cinema number
     */
    private String cinema;
    /*
     * The index of the cineplex which is assigned to a cineplex name (0- Ang Mo Kio, 1- Vivocity and 2- Bishan)
     */
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