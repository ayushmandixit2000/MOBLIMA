package MOBLIMA.dataStructure;

public class Review {
    private int movieId;
    private int rating;
    private String review;

    public Review(int m, int rt, String r) {
        movieId = m;
        rating = rt;
        review = r;
        // jodi logic to increment numReview in movie & calculate new avg
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
