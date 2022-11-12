package MOBLIMA.action;

import java.io.IOException;
import java.util.Scanner;

/**
 * A helper class to display the actions that an admin can perform to edit the
 * showtimes and obtains the selection.
 */
public class adminShowtimeAction implements action {
    /**
     * Prints on the console the actions of Create, Update and Remove the admin can
     * perform on the showtimes with the option to quit.
     */
    public void displayChoices() {
        System.out.println("Please select your desired action (key in the coresponding number)");
        System.out.println("1: Create Movie Showtime");
        System.out.println("2: Update Movie Showtime");
        System.out.println("3: Remove Movie Showtime");
        System.out.println("4: Quit");
    }

    /**
     * Validates and obtains the user console input.
     */
    public int getChoice() throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean flag;
        do {
            try {
                choice = sc.nextInt();
                flag = false;
                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid option. Please key in valid numbers");
                    flag = true;
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Inavlid input. Please enter intergers only.");
                sc.nextLine();
                flag = true;
            }
        } while (flag);
        sc.nextLine();
        return choice;
    }
}
