package MOBLIMA.listing;

import java.io.IOException;
import java.util.ArrayList;
import MOBLIMA.dataStructure.Cinema;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.MovieTicket;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.dataStructure.Transaction;
import MOBLIMA.retrieval.retrieveCinema;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.retrieval.retrieveMovieTicket;
import MOBLIMA.retrieval.retrieveShowtime;

public class TransactionShowTimeListing implements Listing {

    private Transaction t;

    public void sett(Transaction t1) {
        this.t = t1;
    }

    public void displayListing() throws IOException {
        // TODO Auto-generated method stub
        String filename = "MOBLIMA/databases/movieTicket.txt";
        ArrayList al = retrieveMovieTicket.readMovieTicket(filename);

        String filename1 = "MOBLIMA/databases/showtime.txt";
        ArrayList showTimeArray = retrieveShowtime.readShowtime(filename1);

        String filename2 = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename2);

        String[] tickets = t.getArrayofMovieTickets();

        System.out.println("\nNumber of tickets purchased: " + tickets.length);

        for (int i = 0; i < tickets.length; i++) {
            int count = i + 1;
            System.out.println("__________________________________________________");
            System.out.println("\nTicket " + count + ": " + tickets[i]);
            String tikid = tickets[i];

            for (int k = 0; k < al.size(); k++) {
                MovieTicket mt = (MovieTicket) al.get(k);
                String mtid = mt.getMovieTicketId();
                if (tikid.contains(mtid)) {
                    String st = mt.getShowtimeId();

                    for (int l = 0; l < showTimeArray.size(); l++) {
                        Showtime s = (Showtime) showTimeArray.get(l);

                        if (s.getShowtimeId().contains(st)) {
                            int movid = s.getMovieId();

                            for (int z = 0; z < movieArray.size(); z++) {
                                Movie m = (Movie) movieArray.get(z);

                                if (m.getMovieId() == movid) {
                                    System.out.println("Movie: " + m.getTitle());
                                }
                            }

                            int cinep = -1;
                            String filename3 = "MOBLIMA/databases/Cinema.txt";
                            ArrayList cinemaArray = retrieveCinema.readCinema(filename3);
                            for (int y = 0; y < cinemaArray.size(); y++) {
                                Cinema c = (Cinema) cinemaArray.get(y);
                                if (c.getCinema().equals(s.getCinema())) {
                                    cinep = c.getCineplex();
                                }
                            }

                            String cp = "";

                            if (cinep == 0) {
                                cp = "Vivocity";
                            } else if (cinep == 1) {
                                cp = "Bishan";
                            }

                            else if (cinep == 2) {
                                cp = "Ang Mo Kio";
                            }

                            else {
                                cp = "Ang Mo Kio";
                            }

                            System.out.println("Showing Date: " + s.getDate());
                            System.out.println("Showing Time: " + s.getTime());
                            System.out.println("Cinema: " + s.getCinema());

                            System.out.println("Cineplex: " + cp);

                            int SC = mt.getSeatClass();

                            String seatc = "";
                            if (SC == 0) {
                                seatc = "Normal Seat";
                            }

                            else if (SC == 1) {
                                seatc = "Elite Seat";
                            }

                            else if (SC == 2) {
                                seatc = "Ultima Seat";
                            }

                            else if (SC == 3) {
                                seatc = "Couple Seat";
                            }

                            String age1 = mt.getAgeCat();
                            int age = Integer.parseInt(age1);

                            String ans = "";

                            if (age == 0) {
                                ans = "Child";
                            }

                            else if (age == 1) {
                                ans = "Adult";
                            }

                            else if (age == 2) {
                                ans = "Senior Citizen";
                            }

                            else if (age == 3) {
                                ans = "Standard";
                            }

                            System.out.println("Ticket Type: " + ans);

                            System.out.println("Seating Row: " + mt.getSeatingRow());

                            System.out.println("Seating Column: " + mt.getSeatingColumn());

                            System.out.println("Ticket Price: " + mt.getPrice());

                            System.out.println("Seat Type: " + seatc);

                            System.out.println("__________________________________________________");

                            break;
                        }

                    }
                    break;
                }

            }
        }
    }

}
