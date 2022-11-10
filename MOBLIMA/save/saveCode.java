package MOBLIMA.save;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import MOBLIMA.dataStructure.Cinema;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.MovieGoer;
import MOBLIMA.dataStructure.MovieTicket;
import MOBLIMA.dataStructure.Review;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.dataStructure.Transaction;
import MOBLIMA.retrieval.retrieveCinema;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.retrieval.retrieveMovieGoer;
import MOBLIMA.retrieval.retrieveMovieTicket;
import MOBLIMA.retrieval.retrieveReview;
import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.retrieval.retrieveTransaction;
import MOBLIMA.utils.dateTime;

import java.util.ArrayList;

public class saveCode {
        public static void main(String[] args) throws IOException {
                // to use, copy the relevant code and resolve the issues via quick fix- import
                // and add IOException
                // take note you will be editing the text files directly so use with care

                String filename = "MOBLIMA/databases/cinema.txt";
                ArrayList cinemaArray = retrieveCinema.readCinema(filename); // retrieve current array
                Cinema c = new Cinema("cin", 1, 1); // new cinema
                cinemaArray.add(c);
                saveCinema.saveCinemaArray(filename, cinemaArray); // overwrite file

                filename = "MOBLIMA/databases/movie.txt";
                ArrayList movieArray = retrieveMovie.readMovie(filename); // retrieve current array
                Movie m = new Movie(2, "title", 2, "director", new String[] { "cast1", "cast2" }, "synopsis", 1, 1, 0);// add
                // new
                // movie
                movieArray.add(m);
                Movie m1 = new Movie(5, "title", 2, "director",
                                new String[] { "cast1", "cast2" }, "synopsis", 1, 1, 0);// add new movie without sales
                movieArray.add(m1);
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
                int[][] seating = { { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                                { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                                { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                                { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                                { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                                { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                                { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                                { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                                { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 2 } };
                LocalDate date = dateTime.convertDate("2022/12/20");
                LocalTime time = dateTime.convertTime("1900");
                Showtime s = new Showtime("cin", date, time, 1, seating); // add new showtime
                showtimeArray.add(s);
                saveShowtime.saveShowtimeArray(filename, showtimeArray);// overwrite file

                filename = "MOBLIMA/databases/MovieTicket.txt";
                ArrayList movieTicketArray = retrieveMovieTicket.readMovieTicket(filename); // retrieve current array
                MovieTicket mt = new MovieTicket("0", 1, 5, "Dog2022/12/141630");// add new showtime
                movieTicketArray.add(mt);
                saveMovieTicket.saveMovieTicketArray(filename, movieTicketArray);// save to same file

                filename = "MOBLIMA/databases/transactions.txt";
                ArrayList transactionArray = retrieveTransaction.readTransaction(filename); // retrieve current array
                Transaction t = new Transaction("2022/12/20", "1900", "userid", new String[] { "ABC2022/12/12190014" });// add new
                                                                                                              // transaction
                transactionArray.add(t);
                saveTransaction.saveTransactionArray(filename, transactionArray);// overwrite file
        }
}