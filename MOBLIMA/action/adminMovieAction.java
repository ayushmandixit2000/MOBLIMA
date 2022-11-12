package MOBLIMA.action;

import java.io.IOException;
import java.util.Scanner;

/**
 * A helper class to display the actions that an admin can perform to edit the
 * movies and obtains the selection.
 */
public class adminMovieAction implements action {
    /**
     * Prints on the console the actions of Create, Update and Remove the admin can
     * perform on the movies with the option to quit.
     */
    public void displayChoices() {
        System.out.println("Please select your desired action (key in the coresponding number)");
        System.out.println("1: Create cinema showtimes");
        System.out.println("2: Update cinema showtimes");
        System.out.println("3: Remove cinema showtimes");
        System.out.println("4: Quit");
    }

    /**
     * Validates and obtains the user console input.
     */
    public int getChoice() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int choice = 0;
        while (loop) {
            choice = sc.nextInt();
            if (choice <= 5 && choice > 0) {
                loop = false;
            }
        }
        return choice;
    }
}
