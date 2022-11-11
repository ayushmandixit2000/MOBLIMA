package MOBLIMA.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import MOBLIMA.dataStructure.MovieTicket;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrieveMovieTicket;
import MOBLIMA.save.saveMovieTicket;

public class CustomerTicketHandler {
    private Showtime s1;
    private int[][] seats;

    private String user;

    public void setuser(String ui) {
        this.user = ui;
    }

    public void setshow(Showtime s) {
        this.s1 = s;
    }

    public void setseats(int[][] seatarray) {
        this.seats = seatarray;
    }

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

            if(st[seats[i][0]][seats[i][1] - 1] == 0){
                SC = 0;
            }

            else if(st[seats[i][0]][seats[i][1] - 1] == 3){
                SC = 1;
            }

            else if(st[seats[i][0]][seats[i][1] - 1] == 4){
                SC = 2;
            }

            s1.addSeating(seats[i][0], seats[i][1] - 1);

            System.out.println("What age category ticket would you like?");
            System.out.println("1: Child");
            System.out.println("2: Adult");
            System.out.println("3: Senior Citizen");

            int ageopt;

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


            ageopt = ageopt - 1;
            String age = Integer.toString(ageopt);
            String filename = "MOBLIMA/databases/MovieTicket.txt";

            ArrayList movieTicketArray = retrieveMovieTicket.readMovieTicket(filename); // retrieve current array
            MovieTicket mt = new MovieTicket(age, seats[i][0], seats[i][1] - 1, s1.getShowtimeId(), SC);// add new showtime
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
