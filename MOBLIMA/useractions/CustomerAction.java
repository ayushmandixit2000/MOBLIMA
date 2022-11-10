package MOBLIMA.useractions;
import java.io.IOException;
import java.util.Scanner;

import MOBLIMA.dataStructure.Movie;

public class CustomerAction {
    private int action;
    private Movie mov;

    private String user;

    public void setuser(String ui){
        this.user = ui;
    }

    public void setaction(int action) {
        this.action = action;
    }

    public void setmovie(Movie mov) {
        this.mov = mov;
    }

    public void displayaction() throws IOException {
        Scanner scc = new Scanner(System.in);
        if (this.action == 0) {
            System.out.println("\nPlease select your next action");
            System.out.println("1: Book Movie");
            System.out.println("2: Review Movie");
            int opt = scc.nextInt();
            this.action = opt;
        }

        if (this.action == 1) {
            System.out.println("\nLoading Booking Page...");
            CustomerBooking cb = new CustomerBooking();
            cb.setmovie(mov);
            cb.setuser(user);
            cb.display();
        }

        else if (this.action == 2) {
            System.out.println("\nLoading Review Page...");
            Customerreview rev = new Customerreview();
            rev.setmovie(mov);
            rev.review();
        }

    }
}
