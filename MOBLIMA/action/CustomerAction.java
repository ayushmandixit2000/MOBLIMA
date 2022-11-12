package MOBLIMA.action;

import java.io.IOException;
import java.util.Scanner;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.handler.CustomerBookingHandler;
import MOBLIMA.handler.CustomerreviewHandler;

public class CustomerAction implements action {
    private int action;
    private Movie mov;
    private String user;

    public void setuser(String ui) {
        this.user = ui;
    }

    public void setaction(int action) {
        this.action = action;
    }

    public void setmovie(Movie mov) {
        this.mov = mov;
    }

    public void displayChoices() {
        System.out.println("\nPlease select your next action");
        System.out.println("1: Book Movie");
        System.out.println("2: Review Movie");
    }

    public int getChoice() throws IOException {
        Scanner scc = new Scanner(System.in);
        if (this.action == 0) {
            displayChoices();
            int opt;
            int i=0;

            while (true) {
                String input = scc.next();
                opt = 0;
                try {
                    opt = Integer.parseInt(input);
                    if (opt > 2 || opt < 1) {
                        System.out.println("Please key in a valid number!");
                        continue;
                    } else {
                        break;
                    }
                } catch (NumberFormatException ne) {
                    if(i==0)
                        System.out.println("Please key in a number only!");
                        i++;
                }
            }

            this.action = opt;
        }

        if (this.action == 1) {
            System.out.println("\nLoading Booking Page...");
            CustomerBookingHandler cb = new CustomerBookingHandler();
            cb.setmovie(mov);
            cb.setuser(user);
            cb.display();
        }

        else if (this.action == 2) {
            System.out.println("\nLoading Review Page...");
            CustomerreviewHandler rev = new CustomerreviewHandler();
            rev.setmovie(mov);
            rev.review();
        }
        return action;
    }
}
