package MOBLIMA.save;

import java.io.IOException;
import MOBLIMA.dataStructure.Cinema;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.MovieGoer;
import MOBLIMA.dataStructure.Review;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.dataStructure.Transaction;
import MOBLIMA.retrieval.retrieveCinema;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.retrieval.retrieveMovieGoer;
import MOBLIMA.retrieval.retrieveReview;
import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.retrieval.retrieveTransaction;

import java.util.ArrayList;

public class saveCode {
    public static void main(String[] args) throws IOException {
        // to use, copy the relevant code and resolve the issues via quick fix- import
        // and add IOException
        // take note you will be editing the text files directly so use with care

        String filename = "MOBLIMA/databases/cinema.txt";
        ArrayList cinemaArray = retrieveCinema.readCinema(filename); // retrieve current array
        int[][] layout = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Cinema c = new Cinema("cinema", 1, 1, layout); // new cinema
        cinemaArray.add(c);
        saveCinema.saveCinemaArray(filename, cinemaArray); // overwrite file

        filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename); // retrieve current array
        Movie m = new Movie("2", "title", 2, "director", new String[] { "cast1", "cast2" }, "synopsis", 1, 1, 0, 0);// add
                                                                                                                    // new
                                                                                                                    // movie
        movieArray.add(m);
        saveMovie.saveMovieArray(filename, movieArray);// overwrite file

        filename = "MOBLIMA/databases/movieGoer.txt";
        ArrayList movieGoerArray = retrieveMovieGoer.readMovieGoer(filename); // retrieve current array
        MovieGoer mg = new MovieGoer("userid", "name", 91223132, "email");// add new movieGoer
        movieGoerArray.add(mg);
        saveMovieGoer.saveMovieGoerArray(filename, movieGoerArray);// overwrite file

        filename = "MOBLIMA/databases/review.txt";
        ArrayList reviewArray = retrieveReview.readReview(filename); // retrieve current array
        Review r = new Review(2, 3, "review");// add new review
        reviewArray.add(r);
        saveReview.saveReviewArray(filename, reviewArray);// overwrite file

        filename = "MOBLIMA/databases/Showtime.txt";
        ArrayList showtimeArray = retrieveShowtime.readShowtime(filename); // retrieve current array
        int[][] seating = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Showtime s = new Showtime("cp", 1, "date", 2000, 1, seating); // add new showtime
        showtimeArray.add(s);
        saveShowtime.saveShowtimeArray(filename, showtimeArray);// overwrite file

        filename = "MOBLIMA/databases/transactions.txt";
        ArrayList transactionArray = retrieveTransaction.readTransaction(filename); // retrieve current array
        int[][] seatings = { { 1, 2 }, { 4, 5 } };
        Transaction t = new Transaction("tid", "purchaseDate", 2000, "userid", 2, "date", 2100, "cinema", 10, 2,
                new String[] { "0", "1" }, seatings);// add new transaction
        transactionArray.add(t);
        saveTransaction.saveTransactionArray(filename, transactionArray);// overwrite file
    }
}