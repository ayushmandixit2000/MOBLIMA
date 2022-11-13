package MOBLIMA.listing;

import java.io.IOException;
import java.util.Scanner;

/**
 * Helper class to list cineplexes available.
 */
public class CineplexListing implements Listing {
    /**
     * Name of cineplex indicated by the moviegoer.
     */
    private String cineplex;

    /**
     * List cineplexes available.
     */
    public void displayListing() throws IOException {
        System.out.println("The cineplex are shown below:\n"
                + "0 - VivoCity\n"
                + "1 - Bishan\n"
                + "2 - Ang Mo Kio\n");
    }

    public String getCineplex() {
        return cineplex;
    }

    /**
     * Obtains moviegoer's input of intended cineplex.
     */
    public void getUserInput() {
        Scanner sc = new Scanner(System.in);
        int cineplexchoice = -1;
        boolean flag = false;

        // to prevent users from keying in data that is not string
        do {
            try {
                System.out.println("Please enter the cineplex you'd like to edit");
                cineplexchoice = sc.nextInt();
                flag = false;
                if (cineplexchoice < 0 || cineplexchoice > 3) {
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

        switch (cineplexchoice) {
            case 0:
                cineplex = "Vivocity";
                break;
            case 1:
                cineplex = "Bishan";
                break;
            case 2:
                cineplex = "Ang Mo Kio";
                break;

        }
        System.out.println("The cineplex chosen is " + cineplex + "\n");
        return;
    }
}