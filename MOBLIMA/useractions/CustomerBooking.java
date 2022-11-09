package MOBLIMA.useractions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrieveShowtime;

public class CustomerBooking {
    private Movie m;

    public void setmovie(Movie m1) {
        this.m = m1;
    }

    public void display() throws IOException {

        if (m.getShowStatus() == 0) {
            System.out.println("This movie is coming soon, please check back in a few days");
            return;
        }

        if (m.getShowStatus() == 3) {
            System.out.println("This movie is no longer showing. Please choose another movie");
            return;
        }

        if (m.getShowStatus() == 1) {
            System.out.println("Movie Status - Preview");
        }

        if (m.getShowStatus() == 2) {
            System.out.println("Movie Status - Now Showing");
        }

        String filename = "MOBLIMA/databases/showtime.txt";
        ArrayList showTimeArray = retrieveShowtime.readShowtime(filename);
        List<Showtime> optionlist = new ArrayList<Showtime>();

        for (int i = 0; i < showTimeArray.size(); i++) {
            Showtime s = (Showtime) showTimeArray.get(i);
            if (s.getMovieId() == m.getMovieId()) {
                optionlist.add(s);
            }
        }

        System.out.println("Please select a show for " + m.getTitle());
        Scanner scc = new Scanner(System.in);

        for (int j = 0; j < optionlist.size(); j++) {
            Showtime s1 = optionlist.get(j);
            System.out.println(j+1 + ": Cinema :" + s1.getCinema() + " ||" + "Date: " + s1.getDate() + " ||" + "Time: "+ s1.getTime() + " ||");
        }

        int option = scc.nextInt();

        for (int l = 0; l < optionlist.size(); l++) {
            if(option == l+1){
                Showtime s2 = optionlist.get(l);
                
                SeatAvailability sa = new SeatAvailability();
                sa.setshow(s2);
                sa.display();
            }
        }

    }
}