package MOBLIMA.retrieval;

import java.io.IOException;
import java.util.ArrayList;

import MOBLIMA.dataStructure.Cinema;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.MovieGoer;
import MOBLIMA.dataStructure.Review;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.dataStructure.Transaction;

public class retrieveCode {
    public static void main(String[] args) throws IOException {
        // to use, copy the relevant code and resolve the issues via quick fix- import
        // and add IOException

        String filename = "MOBLIMA/databases/Cinema.txt";
        ArrayList cinemaArray = retrieveCinema.readCinema(filename);
        for (int i = 0; i < cinemaArray.size(); i++) {
            Cinema c = (Cinema) cinemaArray.get(i); // access each Cinema object here
            System.out.println("CinemaId " + c.getCinema());
        }

        filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename);
        for (int i = 0; i < movieArray.size(); i++) {
            Movie m = (Movie) movieArray.get(i);// access each Movie object here
            System.out.println("MovieTitle " + m.getTitle());
        }

        filename = "MOBLIMA/databases/movieGoer.txt";
        ArrayList movieGoerArray = retrieveMovieGoer.readMovieGoer(filename);
        for (int i = 0; i < movieGoerArray.size(); i++) {
            MovieGoer m = (MovieGoer) movieGoerArray.get(i);// access each MovieGoer object here
            System.out.println("Name: " + m.getName());
        }

        filename = "MOBLIMA/databases/review.txt";
        ArrayList reviewArray = retrieveReview.readReview(filename);
        for (int i = 0; i < reviewArray.size(); i++) {
            Review r = (Review) reviewArray.get(i);// access each Review object here
            System.out.println("Review: " + r.getReview());
        }

        filename = "MOBLIMA/databases/showtime.txt";
        ArrayList showTimeArray = retrieveShowtime.readShowtime(filename);
        for (int i = 0; i < showTimeArray.size(); i++) {
            Showtime s = (Showtime) showTimeArray.get(i);// access each Showtime object here
            System.out.println("MovieId " + s.getMovieId());
        }

        filename = "MOBLIMA/databases/transactions.txt";
        ArrayList transactionArray = retrieveTransaction.readTransaction(filename);
        for (int i = 0; i < transactionArray.size(); i++) {
            Transaction t = (Transaction) transactionArray.get(i);// access each Transaction object here
            System.out.println("Transaction " + t.getTransactionId());
        }
    }
}
