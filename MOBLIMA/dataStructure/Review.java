package MOBLIMA.dataStructure;

import java.io.IOException;

public class Review {
    private int movieId;
    private int rating;
    private String review;

    public Review(int m, int rt, String r) throws IOException {
        movieId = m;
        rating = rt;
        review = r;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }
}
