package MOBLIMA.useractions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import MOBLIMA.configurables.peakDates;
import MOBLIMA.dataStructure.MovieTicket;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrieveMovieTicket;
import MOBLIMA.save.saveMovieTicket;
import MOBLIMA.configurables.peakDates;

public class CustomerTicket {
    private Showtime s1;
    private int[][] seats;

    public void setshow(Showtime s) {
        this.s1 = s;
    }

    public void setseats(int[][] seatarray) {
        this.seats = seatarray;
    }

    public void display() throws IOException {

        Scanner scc = new Scanner(System.in);
        for (int i = 0; i < seats.length; i++) {
            int sk = i + 1;
            System.out.println("Ticket " + sk + " details: ");
            System.out.println("Row: " + Character.toString((char) (seats[i][0] + 65)));
            System.out.println("Column: " + seats[i][1]); // -1 when sending to database

            System.out.println("What age category ticket would you like?");
            System.out.println("1: Child");
            System.out.println("2: Adult");
            System.out.println("3: Senior Citizen");

            int ageopt = scc.nextInt();
            ageopt = ageopt - 1;
            String age = Integer.toString(ageopt);
            String filename = "MOBLIMA/databases/MovieTicket.txt";

            ArrayList movieTicketArray = retrieveMovieTicket.readMovieTicket(filename); // retrieve current array
            MovieTicket mt = new MovieTicket(age, seats[i][0], seats[i][1] - 1, s1.getShowtimeId());// add new showtime
            movieTicketArray.add(mt);
            saveMovieTicket.saveMovieTicketArray(filename, movieTicketArray);// save to same file

            
        }

        
    }

}
