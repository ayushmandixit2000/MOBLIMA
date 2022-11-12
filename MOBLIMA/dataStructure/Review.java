package MOBLIMA.dataStructure;

import java.io.IOException;

/**
 * Represents a Review that can be created by any user for a particular movie.
 * 
 * @author Wong Yu Fei
 * @version 1.0
 */
public class Review {
    /**
     * The id of the movie referenced by this Review.
     */
    private int movieId;

    /**
     * The rating of the movie referenced by this Review.
     * The rating is constrainted to be between 1 and 5 (inclusive).
     */
    private int rating;

    /**
     * The review of the movie referenced by this Review.
     */
    private String review;

    /**
     * Creates a Review with the following attributes:
     * 
     * @param m  This Review's referenced movie's id.
     * @param rt This Review's rating.
     * @param r  This Review's review.
     */
    public Review(int m, int rt, String r) throws IOException {
        movieId = m;
        rating = rt;
        review = r;
    }

    /**
     * Gets the id of the movie referenced by this Review.
     * 
     * @return This Review's referenced movie's id.
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * Gets the rating of this Review.
     * 
     * @return This Review's rating.
     */
    public int getRating() {
        return rating;
    }

    /**
     * Gets the review of this Review.
     * 
     * @return This Review's review.
     */
    public String getReview() {
        return review;
    }
}
