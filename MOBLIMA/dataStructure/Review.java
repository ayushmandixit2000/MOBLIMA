package MOBLIMA.dataStructure;

import java.io.IOException;
import java.util.ArrayList;

import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.save.saveMovie;

public class Review {
    private int movieId;
    private int rating;
    private String review;

    public Review(int m, int rt, String r) throws IOException {
        movieId = m;
        rating = rt;
        review = r;
        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename);
        for (int i = 0; i < movieArray.size(); i++) {
            Movie mov = (Movie) movieArray.get(i);
            if (mov.getMovieId() == this.movieId) {
                mov.setNumReviews(mov.getNumReviews() + 1);
            }
        }
        saveMovie.saveMovieArray(filename, movieArray);
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
