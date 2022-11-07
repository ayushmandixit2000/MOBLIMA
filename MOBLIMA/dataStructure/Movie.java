package MOBLIMA.dataStructure;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.save.saveMovie;

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
    private int avgRating;

    public Movie(int mid, String t, int ss, String d, String[] c, String s, int mr, int mt, int sa, int id, int nr,
            int ar) {
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

    public Movie(int mid, String t, int ss, String d, String[] c, String s, int mr, int mt, int id) {
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

    public int getNumReviews() {
        return numReviews;
    }

    public int getAvgRating() {
        return avgRating;
        // jodi needa implement logic here (check the req from the assignment pdf)
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShowStatus(int showStatus) throws IOException {
        this.showStatus = showStatus;
        if (showStatus == 3) {
            // String filename = "MOBLIMA/databases/movie.txt";
            // System.out.println("triggered");
            // ArrayList movieArray = retrieveMovie.readMovie(filename); // retrieve current
            // array
            // for (int i = 0; i < movieArray.size(); i++) {
            // System.out.println(this.movieId);
            // if (((Movie) movieArray.get(i)).getMovieId() == this.movieId) {
            // // overwrite file
            // System.out.println("successfully deleted");
            // return true;
            // }
            // }
            // System.out.println("failed to delete");
            // return false;
            // }
            // return true;
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

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setNumReviews(int numReviews) {
        this.numReviews = numReviews;
    }
}
