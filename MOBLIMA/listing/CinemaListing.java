package MOBLIMA.listing;

import java.io.IOException;
import java.util.Scanner;

/**
 * Helper class to list cinemas available.
 */
public class CinemaListing implements Listing {

    private int cinema;

    /**
     * List cinemas available.
     */
    public void displayListing() throws IOException {

        CineplexListing st = new CineplexListing();

        System.out.println("Choose the Cinema in the given complex: \n"
                + "1- Cinema 1 \n" + "2- Cinema 2 \n" + "3- Cinema 3 \n");

    }

    public int getCinema() {
        return cinema;
    }

    public void getUserInput() {
        Scanner sc = new Scanner(System.in);
        int cinemaNumber = -1;
        boolean flag = false;
        do {
            try {
                System.out.println("Enter the Cinema number you'd like to view: ");
                cinemaNumber = sc.nextInt();
                flag = false;
                if (cinemaNumber < 1 || cinemaNumber > 3) {
                    System.out.println("Invalid option. Please key in valid numbers");
                    flag = true;
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Inavlid input. Please enter intergers only... " + e);
                sc.nextLine();
                flag = true;
            }
        } while (flag);
        sc.nextLine();

        System.out.println("");
        return;
    }
}
