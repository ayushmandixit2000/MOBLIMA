package MOBLIMA.dataStructure;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import MOBLIMA.retrieval.retrieveReview;

/**
 * Represents a Movie that can be screened at a cinema.
 * Each movie has configurable attributes.
 * 
 * @author Wong Yu Fei
 * @version 1.0
 */
public class Movie implements Serializable {
    /**
     * The assigned id for this Movie.
     * This is obtained from this Movie's index in the movie database.
     */
    private int movieId;

    /**
     * The title of this Movie.
     */
    private String title;

    /*
     * The index of this Movie's show status (0: Coming Soon, 1:
     * Preview, 2: Now Showing, 3: End of Showing)
     */
    private int showStatus;

    /**
     * The director of this Movie.
     */
    private String director;

    /**
     * The casts of this Movie.
     * The number of casts can be varied.
     */
    private String[] cast;

    /**
     * The Synopsis of this Movie.
     */
    private String synopsis;

    /**
     * The index of the movie rating of this Movie (0: G, 1: PG, 2: M, 3: R16,
     * 4: TBC).
     */
    private int movieRating;

    /**
     * The index of the movie type of this Movie (0: 3D, 1: Blockbuster).
     */
    private int movieType;

    /**
     * The total amount of movie spent on movie tickets for This Movie.
     */
    private Double sales;

    /**
     * The index of the delete status of this Movie (0: not deleted, 1: deleted).
     */
    private int isDeleted;

    /**
     * The number of customer reviews for this Movie.
     */
    private int numReviews;

    /**
     * The average customer rating given to this Movie.
     */
    private double avgRating;

    /**
     * The file path to this Movie's database.
     */
    private String filename = "MOBLIMA/databases/movie.txt";

    /**
     * Creates a new Movie with the given attributes.
     * For use when initialising a Movie as sales, numReviews and avgRating is
     * set to 0.
     * 
     * @param mid This Movie's id.
     * @param t   This Movie's title.
     * @param ss  This Movie's show status index.
     * @param d   This Movie's director.
     * @param c   This Movie's cast(s).
     * @param s   This Movie's synopsis.
     * @param mr  This Movie's movie rating index.
     * @param mt  This Movie's movie type index.
     * @param id  This Movie's delete status.
     */
    public Movie(int mid, String t, int ss, String d, String[] c, String s, int mr, int mt, int id) throws IOException {
        movieId = mid;
        title = t;
        showStatus = ss;
        director = d;
        cast = c;
        synopsis = s;
        movieRating = mr;
        movieType = mt;
        sales = (double) 0;
        isDeleted = id;
        numReviews = 0;
        avgRating = 0;
    }

    /**
     * Creates a new Movie with the given attributes.
     * For use when reading the Movie from the database as it will populate the
     * sales, numReviews and avgRating.
     * 
     * @param mid This Movie's id.
     * @param t   This Movie's title.
     * @param ss  This Movie's show status index.
     * @param d   This Movie's director.
     * @param c   This Movie's cast(s).
     * @param s   This Movie's synopsis.
     * @param mr  This Movie's movie rating index.
     * @param mt  This Movie's movie type index.
     * @param id  This Movie's delete status.
     * @param nr  This Movie's number of customer reviews.
     * @param ar  This Movie's average customer rating.
     */
    public Movie(int mid, String t, int ss, String d, String[] c, String s, int mr, int mt, Double sa, int id, int nr,
            double ar) throws IOException {
        movieId = mid;
        title = t;
        showStatus = ss;
        director = d;
        cast = c;
        synopsis = s;
        movieRating = mr;
        movieType = mt;
        sales = sa;
        isDeleted = id;
        numReviews = nr;
        avgRating = ar;
    }

    /**
     * Gets the id of this Movie.
     * 
     * @return This Movie's id.
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * Gets the title of this Movie.
     * 
     * @return This Movie's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the show status index of this Movie.
     * 
     * @return This Movie's show status index.
     */
    public int getShowStatus() {
        return showStatus;
    }

    /**
     * Gets the director of this Movie.
     * 
     * @return This Movie's director.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Gets the cast(s) of this Movie.
     * 
     * @return This Movie's cast(s).
     */
    public String[] getCast() {
        return cast;
    }

    /**
     * Gets the synopsis of this Movie.
     * 
     * @return This Movie's synopsis.
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Gets the movie rating index of this Movie.
     * 
     * @return This Movie's movie rating index.
     */
    public int getMovieRating() {
        return movieRating;
    }

    /**
     * Gets the movie type index of this Movie.
     * 
     * @return This Movie's movie type index.
     */
    public int getMovieType() {
        return movieType;
    }

    /**
     * Gets the sales of this Movie.
     * 
     * @return This Movie's sales.
     */
    public Double getSales() {
        return sales;
    }

    /**
     * Gets the delete status of this Movie.
     * 
     * @return This Movie's delete status.
     */
    public int getIsDeleted() {
        return isDeleted;
    }

    /**
     * Changes the title of this Movie.
     * 
     * @param title This Movie's new assigned title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Changes the show status index of this Movie.
     * When show status is set to be 3 (End of Showing), its
     * isDeleted status will be set to 1 (true)
     * 
     * @param showStatus This Movie's new assigned show status index.
     */
    public void setShowStatus(int showStatus) throws IOException {
        this.showStatus = showStatus;
        if (showStatus == 3) {
            setIsDeleted(1);
        }
        return;
    }

    /**
     * Changes the director of this Movie.
     * 
     * @param director This Movie's new assigned director.
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Changes the cast(s) of this Movie.
     * 
     * @param cast This Movie's new assigned cast(s).
     */
    public void setCast(String[] cast) {
        this.cast = cast;
    }

    /**
     * Changes the synopsis of this Movie.
     * 
     * @param synopsis This Movie's new assigned synopsis.
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /*
     * Changes the movie rating index of this Movie.
     * 
     * @param movieRating This Movie's new assigned movie rating index.
     */
    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    /**
     * Changes the movie type index of this Movie.
     * 
     * @param movieType This Movie's new assigned movie type index.
     */
    public void setMovieType(int movieType) {
        this.movieType = movieType;
    }

    /**
     * 
     * Changes the sales of this Movie.
     * 
     * @param sales This Movie's new assigned sales.
     */
    public void setSales(Double sales) {
        this.sales = sales;
    }

    /**
     * Changes the delete status of this Movie.
     * 
     * @param isDeleted Thie Movie's new assigned delete status.
     */
    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * Gets the number of customer reviews of this Movie.
     * 
     * @return This Movie's number of customer reviews.
     */
    public int getNumReviews() {
        return numReviews;
    }

    /**
     * Gets the average customer rating of this Movie.
     * 
     * @return This Movie's average customer rating.
     */
    public double getAvgRating() {
        return avgRating;
    }

    /**
     * Changes the assigned number of customer reviews of this Movie.
     * Saves the changes into the movie database.
     */
    public void setNumReviews() throws IOException {
        String filename = "MOBLIMA/databases/review.txt";
        ArrayList reviewArray = retrieveReview.readReview(filename);
        int counter = 0;
        for (int i = 0; i < reviewArray.size(); i++) {
            Review r = (Review) reviewArray.get(i);
            if (r.getMovieId() == this.movieId) {
                counter++;
            }
        }
        this.numReviews = counter;
    }

    /**
     * Calculates the average customer rating for this Movie and assigned it.
     * Saves the changes into the movie database.
     */
    public void setAvgRating() throws IOException {
        int sum = 0;
        if (numReviews == 0) {
            this.avgRating = 0;
            return;
        }
        String filename = "MOBLIMA/databases/review.txt";
        ArrayList reviewArray = retrieveReview.readReview(filename);
        for (int i = 0; i < reviewArray.size(); i++) {
            Review r = (Review) reviewArray.get(i);
            if (r.getMovieId() == this.movieId) {
                sum += r.getRating();
            }
        }
        double x = this.numReviews;
        this.avgRating = sum / x;
        double k = this.avgRating;
        k = round(k, 1);
        this.avgRating = k;
    }

    /**
     * Rounds off Doubles to a specified precision.
     * 
     * @param value     The value to be evaluated.
     * @param precision The intended precision.
     * @return A Double with the specified precision.
     */
    private static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
