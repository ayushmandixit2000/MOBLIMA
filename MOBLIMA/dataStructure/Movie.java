package MOBLIMA.dataStructure;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import MOBLIMA.retrieval.retrieveReview;

public class Movie implements Serializable {
    private int movieId;
    private String title;
    private int showStatus;
    private String director;
    private String[] cast;
    private String synopsis;
    private int movieRating;
    private int movieType;
    private int sales;
    private int isDeleted;
    private int numReviews;
    private double avgRating;

    /**
     * 
     * @param mid- integer denoting the movie id which is the movie's index in the
     *             movie database
     * @param t-   string denoting the movie's title
     * @param ss-  integer denoting the movie's show status (0: Coming Soon, 1:
     *             Preview, 2: Now Showing, 3: End of Showing)
     * @param d-   string denoting the movie's director
     * @param c-   string array denoting the movie's casts
     * @param s-   string denoting the movie's synopsis
     * @param mr-  integer denoting the movie's rating (0: G, 1: PG, 2: M, 3: R16,
     *             4: TBC)
     * @param mt-  integer denoting the movie's type (0: 3D, 1: Blockbuster)
     * @param id-  integer denoting whether the movie is deleted (0: no, 1: yes).
     *             Additionally, if the movie's show status is "End of Showing", the
     *             movie is considered to be deleted.
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
        sales = 0;
        isDeleted = id;
        numReviews = 0;
        avgRating = 0;
    }

    public Movie(int mid, String t, int ss, String d, String[] c, String s, int mr, int mt, int sa, int id, int nr,
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

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public int getShowStatus() {
        return showStatus;
    }

    public String getDirector() {
        return director;
    }

    public String[] getCast() {
        return cast;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public int getMovieType() {
        return movieType;
    }

    public int getSales() {
        return sales;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShowStatus(int showStatus) throws IOException {
        this.showStatus = showStatus;
        if (showStatus == 3) {
            setIsDeleted(1);
        }
        return;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    public void setMovieType(int movieType) {
        this.movieType = movieType;
    }

    public void setSales(int sales){
        this.sales = sales;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getNumReviews() {
        return numReviews;
    }

    public double getAvgRating() {
        return avgRating;
    }

    /**
     * Counts the number of reviews users have left for that particular movie and
     * saves it into the movie database
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
     * Calculates the average rating users left for that particular movie and saves
     * it into the movie database
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

    private static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
