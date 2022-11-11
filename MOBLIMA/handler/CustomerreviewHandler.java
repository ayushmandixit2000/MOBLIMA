package MOBLIMA.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.Review;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.retrieval.retrieveReview;
import MOBLIMA.save.saveMovie;
import MOBLIMA.save.saveReview;

public class CustomerreviewHandler {
    private Movie m1;

    public void setmovie(Movie m) {
        this.m1 = m;
    }

    public void review() throws IOException {

        m1.setAvgRating();
        m1.setNumReviews();
        Scanner scc = new Scanner(System.in);
        System.out.println("Please rate this movie out of 5:");

        int score;

        while (true) {
            String input = scc.next();
            score = 0;
            try {
                score = Integer.parseInt(input);
                if (score > 5 || score < 1) {
                    System.out.println("Please key in a number between 1-5 only");
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ne) {
                System.out.println("Please key in a number only!");
            }
        }

        String review = "";
        scc.nextLine();
        while (review == "") {
            System.out.println("How did you find this movie? Please add your review here: ");
            review = scc.nextLine();
        }

        // double rat = m1.getAvgRating();
        // int num = m1.getNumReviews();

        // double newavg = (rat * num) / (num + 1);

        String filename = "MOBLIMA/databases/review.txt";
        ArrayList reviewArray = retrieveReview.readReview(filename); // retrieve current array
        Review r = new Review(m1.getMovieId(), score, review);// add new review
        reviewArray.add(r);
        saveReview.saveReviewArray(filename, reviewArray);// overwrite file
        m1.setNumReviews();
        m1.setAvgRating();

        filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename); // retrieve current array
        movieArray.set(m1.getMovieId(), m1);
        saveMovie.saveMovieArray(filename, movieArray);// overwrite file
    }

}
