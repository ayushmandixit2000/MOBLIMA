package MOBLIMA.dataStructure;

import java.io.Serializable;

public class Movie implements Serializable {
    private String movieId;
    private String title;
    private int showStatus;
    private String director;
    private String cast; // for now its a huge string
    private String synopsis;
    private int movieRating;
    private int movieType;
    private int sales;
    private int isDeleted;

    public Movie(String mid, String t, int ss, String d, String c, String s, int mr, int mt, int sa, int id) {
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
    }

    public String getMovieId() {
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

    public String getCast() {
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

    // public boolean equals(Object o) {
    // if (o instanceof movie) {
    // movie m = (movie) o;
    // return (getMovieId().equals(m.getMovieId()));
    // }
    // return false;
    // }
}
