package MOBLIMA.handler;

import java.io.IOException;
import java.util.ArrayList;
import MOBLIMA.dataStructure.Cinema;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.MovieTicket;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrieveCinema;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.save.saveMovie;

public class FinalPurchaseHandler {
    private MovieTicket[] customertickers;
    private Showtime s;

    private String user;

    public void setuser(String ui) {
        this.user = ui;
    }

    public void settickets(MovieTicket[] ct) {
        this.customertickers = ct;
    }

    public void setshow(Showtime s) {
        this.s = s;
    }

    public void display() throws IOException {

        String title = "";
        int movietype = -1;

        Movie m1 = new Movie(2, "title", 2, "director", new String[] { "cast1", "cast2" }, "synopsis", 1, 1, 0);

        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename);
        for (int i = 0; i < movieArray.size(); i++) {
            Movie m = (Movie) movieArray.get(i);
            if (m.getMovieId() == s.getMovieId()) {
                title = m.getTitle();
                movietype = m.getMovieType();
                m1 = m;
            }
        }

        m1.getAvgRating();

        int cinematype = 0;
        int cinep = -1;
        String filename1 = "MOBLIMA/databases/Cinema.txt";
        ArrayList cinemaArray = retrieveCinema.readCinema(filename1);
        for (int i = 0; i < cinemaArray.size(); i++) {
            Cinema c = (Cinema) cinemaArray.get(i);
            if (c.getCinema().equals(s.getCinema())) {
                cinep = c.getCineplex();
                cinematype = c.getMovieClass();
            }
        }


        String ct = "Standard Class";

        if(cinematype == 1){
            ct = "Premium Movie Class";
        }

        String cp = "";

        if (cinep == 1) {
            cp = "Vivocity";
        } else if (cinep == 2) {
            cp = "Bishan";
        }

        else if (cinep == 3) {
            cp = "Orchard";
        }

        else {
            cp = "Ang Mo Kio";
        }

        String movietypeS = "";

        if (movietype == 0) {
            movietypeS = "3D";
        }

        else {
            movietypeS = "Blockbuster";
        }

        double totalprice = 0;

        for (int z = 0; z < customertickers.length; z++) {
            int tiknum = z + 1;
            System.out.println();
            System.out.println();
            System.out.println("Printing Ticket " + tiknum + "...");

            String agecat = customertickers[z].getAgeCat();
            int age = Integer.parseInt(agecat);

            String agec = "";

            totalprice = totalprice + customertickers[z].getPrice();

            if (age == 0) {
                agec = "Child";
            }

            else if (age == 1) {
                agec = "Adult";
            }

            else {
                agec = "Senior Citizen";
            }

            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("_____________________________________________________________________");
            System.out.println("Movie : " + title + "     Type: " + movietypeS);
            System.out.println("_____________________________________________________________________");
            System.out.println("Cinema : " + s.getCinema() + "      Cineplex: " + cp + "     Class: " + ct);
            System.out.println("_____________________________________________________________________");
            System.out.println("Ticket Price : $" + customertickers[z].getPrice());
            System.out.println("_____________________________________________________________________");
            System.out.println("Seating  - Row: " + Character.toString((char) (customertickers[z].getSeatingRow() + 65))
                    + "   Column: " + ((customertickers[z].getSeatingColumn()) + 1));
            System.out.println("_____________________________________________________________________");
            System.out.println("Showtime - Date: " + s.getDate() + "        Time: " + s.getTime());
            System.out.println("_____________________________________________________________________");
            System.out.println("Ticket ID:  " + customertickers[z].getMovieTicketId() + "   Ticket Category: " + agec);
            System.out.println("_____________________________________________________________________");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        }

        System.out.println();
        System.out.println("Total cost: $" + totalprice);

        int sales1 = m1.getSales();
        int roundVal= (int) Math.round(totalprice);
        sales1 = sales1 + roundVal;
        
        ArrayList movieArray1 = retrieveMovie.readMovie(filename);
        for (int i = 0; i < movieArray1.size(); i++) {
            Movie m = (Movie) movieArray1.get(i);
            if (m.getMovieId() == m1.getMovieId()) {
                m.setSales(sales1);
                movieArray1.set(m1.getMovieId(), m);
                saveMovie.saveMovieArray(filename, movieArray1);
            }   
        }
        TransactionProccessingHandler tp = new TransactionProccessingHandler();
        tp.settickets(customertickers);
        tp.setuser(user);
        tp.display();
    }
}
