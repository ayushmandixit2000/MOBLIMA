package MOBLIMA.action;

import java.io.IOException;
import java.util.Scanner;

public class adminMovieAction implements action {
    public void displayChoices() {
        System.out.println("Please select your desired action (key in the coresponding number)");
        System.out.println("1: Create cinema showtimes");
        System.out.println("2: Update cinema showtimes");
        System.out.println("3: Remove cinema showtimes");
        System.out.println("4: Quit");
    }

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
