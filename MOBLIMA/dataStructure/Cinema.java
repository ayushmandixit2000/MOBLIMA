package MOBLIMA.dataStructure;

/**
 * Represents a cinema that belongs to a cineplex.
 * Each Cinema can only have 1 movie class.
 * Each Cinema has a fixed seating layout which moviegoers can book seats for
 * (seat allocation is done in Showtime)
 * 
 * @author Wong Yu Fei
 * @version 1.0
 */
public class Cinema {
    /**
     * The unique cinema code which has 3 letters- first 2 are the starting and
     * ending letter of the cineplex name while the last letter is the cinema number
     */
    private String cinema;

    /*
     * The index of the cineplex which is assigned to a cineplex name (0- Vivocity,
     * 1- Bishan and 2- Ang Mo Kio)
     */
    private int cineplex;

    /*
     * The index of the movie class which is assigned to a movie class (0- Default,
     * 1- Platinium Movie Suite)
     */
    private int movieClass;

    /**
     * Creates a new Cinema with a given cinema code, assigned cineplex and
     * movieClass.
     * 
     * @param c-  This Cinema's cinema code.
     * @param cp- This Cinema's assigned cineplex index.
     * @param mc- This Cinema's movie class index.
     */
    public Cinema(String c, int cp, int mc) {
        cinema = c;
        cineplex = cp;
        movieClass = mc;
    }

    /**
     * Gets the index of the assigned cineplex index of this Cinema.
     * 
     * @return this Movie's assigned cinplex index.
     */
    public int getCineplex() {
        return cineplex;
    }

    /**
     * Gets the cinema code of this Cinema.
     * 
     * @return this Cinema's cinema code.
     */
    public String getCinema() {
        return cinema;
    }

    /**
     * Gets the movie class of this Cinema.
     * 
     * @return this Cinema's movie class.
     */
    public int getMovieClass() {
        return movieClass;
    }

    /**
     * /**
     * Changes the cinema code of this Cinema.
     * 
     * @param cinema This Cinema's new cinema code.
     */
    public void setCinema(String cinema) {
        this.cinema = cinema;
        return;
    }

    /**
     * Changes the assigned cineplex index of this Cinema.
     * 
     * @param cineplex This Cinema's new assigned cineplex index.
     */
    public void setCineplex(int cineplex) {
        this.cineplex = cineplex;
        return;
    }

    /**
     * Changes the movie class index of this Cinema.
     * 
     * @param movieClass This Cinema's new movie class index.
     */
    public void setMovieClass(int movieClass) {
        this.movieClass = movieClass;
        return;
    }
}