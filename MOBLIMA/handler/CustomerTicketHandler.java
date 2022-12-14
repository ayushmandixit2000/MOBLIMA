package MOBLIMA.handler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import MOBLIMA.configurables.peakDates;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.MovieTicket;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.retrieval.retrieveMovieTicket;
import MOBLIMA.save.saveMovieTicket;

/**
 * 
 * Helper class to identify the showtime the moviegoer is interested in
 * booking.
 */

public class CustomerTicketHandler {
    /**
     * The showtime selected by the movie-goer.
     */
    private Showtime s1;
    /**
     * The seat availability of the selected showtime.
     */
    private int[][] seats;

    /**
     * The id of the moviegoer.
     */
    private String user;

    /**
     * Changes the id of the moviegoer.
     * 
     * @param ui The new id of the moviegoer.
     */
    public void setuser(String ui) {
        this.user = ui;
    }

    /**
     * Changes the selected showtime by the moviegoer.
     * 
     * @param s The new selected showtime of the moviegoer.
     */
    public void setshow(Showtime s) {
        this.s1 = s;
    }

    /**
     * Changes the seat availability of the selected showtime of the moviegoer.
     * 
     * @param seatarray
     */
    public void setseats(int[][] seatarray) {
        this.seats = seatarray;
    }

    /**
     * Displays the relevant options and obtains the moviegoer's input for the
     * required information to book.
     */
    public void display() throws IOException {

        MovieTicket[] ticketsarray = new MovieTicket[seats.length];
        Scanner scc = new Scanner(System.in);
        for (int i = 0; i < seats.length; i++) {
            int sk = i + 1;
            System.out.println("Ticket " + sk + " details: ");
            System.out.println("Row: " + Character.toString((char) (seats[i][0] + 65)));
            System.out.println("Column: " + seats[i][1]); // -1 when sending to database

            int[][] st = s1.getSeating();

            int SC = 0;

            if (st[seats[i][0]][seats[i][1] - 1] == 0) {
                SC = 0;
            }

            else if (st[seats[i][0]][seats[i][1] - 1] == 3) {
                SC = 1;
            }

            else if (st[seats[i][0]][seats[i][1] - 1] == 4) {
                SC = 2;
            }

            else if (st[seats[i][0]][seats[i][1] - 1] == 5) {
                SC = 3;
            }

            s1.addSeating(seats[i][0], seats[i][1] - 1);

            LocalDate showdate = s1.getDate();
            LocalTime showtime = s1.getTime();

            new peakDates();
            int peakcat = 0;

            if (!peakDates.isDicountApplicable(s1.getDate(), s1.getTime())) {
                peakcat = 1;
            }

            int movietype = s1.getMovieId();

            Movie mov = null;

            String filename0 = "MOBLIMA/databases/movie.txt";
            ArrayList movieArray = retrieveMovie.readMovie(filename0);
            for (int o = 0; o < movieArray.size(); o++) {
                Movie m = (Movie) movieArray.get(o);
                if (m.getMovieId() == movietype) {
                    mov = m;
                    break;
                }
            }

            int mt11 = mov.getMovieRating();

            int ageopt;

            if (peakcat == 1) {
                System.out.println("Age group pricing is not applicable for this movie.");
                System.out.println("Age group pricing is only allowed on Mon-Fri before 6pm.");
                ageopt = 4;
            }

            else if (mt11 == 3 || mt11 == 4 || mt11 == 5) {
                System.out.println("Age group pricing is not applicable to movies rated NC16 and above");
                ageopt = 4;
            }

            else {
                System.out.println("Age group pricing is applicable for this movie.");
                System.out.println();

                System.out.println("What age category ticket would you like?");
                System.out.println("1: Child");
                System.out.println("2: Adult");
                System.out.println("3: Senior Citizen");

                while (true) {
                    String input = scc.next();
                    ageopt = 0;
                    try {
                        ageopt = Integer.parseInt(input);
                        if (ageopt > 3 || ageopt < 1) {
                            System.out.println("Please key in a valid number!");
                            continue;
                        } else {
                            break;
                        }
                    } catch (NumberFormatException ne) {
                        System.out.println("Please key in a number only!");
                    }
                }
            }

            ageopt = ageopt - 1;
            String age = Integer.toString(ageopt);
            String filename = "MOBLIMA/databases/MovieTicket.txt";

            ArrayList movieTicketArray = retrieveMovieTicket.readMovieTicket(filename); // retrieve current array
            MovieTicket mt = new MovieTicket(age, seats[i][0], seats[i][1] - 1, s1.getShowtimeId(), SC);// add new
                                                                                                        // showtime
            movieTicketArray.add(mt);
            saveMovieTicket.saveMovieTicketArray(filename, movieTicketArray);// save to same file

            // getting movieticket id
            String filename1 = "MOBLIMA/databases/movieTicket.txt";
            ArrayList al = retrieveMovieTicket.readMovieTicket(filename1);
            for (int l = 0; l < al.size(); l++) {
                MovieTicket mt1 = (MovieTicket) al.get(l);
                if (mt1.getShowtimeId().equalsIgnoreCase(s1.getShowtimeId())) {
                    if (mt1.getSeatingRow() == seats[i][0] && mt1.getSeatingColumn() == seats[i][1] - 1) {
                        ticketsarray[i] = mt1;
                    }
                }
            }
        }

        FinalPurchaseHandler fp = new FinalPurchaseHandler();
        fp.settickets(ticketsarray);
        fp.setshow(s1);
        fp.setuser(user);
        fp.display();
    }
}
