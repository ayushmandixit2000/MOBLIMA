package MOBLIMA.action;

import java.io.IOException;
import java.util.Scanner;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.handler.CustomerBookingHandler;
import MOBLIMA.handler.CustomerreviewHandler;

/**
 * A helper class to display the actions that a customer can perform on the app
 * and obtains the selection.
 */
public class CustomerAction implements action {
    /**
     * The selected customer action index (1: Book Movie, 2: Review Movie)
     */
    private int action;

    /**
     * The specified movie to perform actions on.
     */
    private Movie mov;

    /**
     * The id of the user making the selection.
     */
    private String user;

    /**
     * Changes the id of the user making the selection.
     * 
     * @param ui The selection's new user's id.
     */
    public void setuser(String ui) {
        this.user = ui;
    }

    /**
     * Changes the index of the action selected.
     * 
     * @param action The selected action's new index.
     */
    public void setaction(int action) {
        this.action = action;
    }

    /**
     * Changes the movie to perform the action on.
     * 
     * @param mov The actions' new movie to perform actions on.
     */
    public void setmovie(Movie mov) {
        this.mov = mov;
    }

    /**
     * Prints on the console the actions of Book and Review customers can perform on
     * the movies.
     */
    public void displayChoices() {
        System.out.println("\nPlease select your next action");
        System.out.println("1: Book Movie");
        System.out.println("2: Review Movie");
    }

    /**
     * Validates and obtains the user console input and calls the relevant handlers.
     */
    public int getChoice() throws IOException {
        Scanner scc = new Scanner(System.in);
        if (this.action == 0) {
            displayChoices();
            int opt;

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
                    System.out.println("Please key in a number only!");
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
