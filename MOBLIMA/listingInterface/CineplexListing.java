package MOBLIMA.listingInterface;

import MOBLIMA.dataStructure.Movie;
import MOBLIMA.retrieval.retrieveMovie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class CineplexListing implements Listing{
    
    private static String cineplex;

    public void displayListing() throws IOException {
        System.out.println("The cineplex are shown below:\n" 
        +"0 - VivoCity\n"
        +"1 - Bishan\n"
        +"2 - Orchard\n"
        +"3 - Ang Mo Kio\n");
    }

    public static String getListing() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the cineplex you'd like to edit");
        int cineplexchoice = sc.nextInt();

        switch (cineplexchoice) {
            case 0:
            cineplex = "Vivocity";
            case 1:
            cineplex = "Bishan";
            case 2:
            cineplex = "Orchard";
            case 3:
            cineplex = "Ang Mo Kio";

        }
        System.out.println("The cineplex chosen is "+ cineplex);
        return cineplex;

        // switch (cinInput) {
        //     case 0:
        //     cineplex = "Vivocity";
        //     System.out.println("Select Cinema chosen in Cineplex VivoCity: ");
        //     System.out.println("Cinema: 1, 2, 3, 4");
        //     cinemaChoice = sc.nextInt();

        //     case 1:
        //     cineplex = "Bishan";
        //     System.out.println("Select Cinema chosen in Cineplex VivoCity: ");
        //     System.out.println("Cinema: 1, 2, 3, 4");
        //     cinemaChoice = sc.nextInt();

        //     case 2:
        //     cineplex = "Orchard";
        //     System.out.println("Select Cinema chosen in Cineplex VivoCity: ");
        //     System.out.println("Cinema: 1, 2, 3, 4");
        //     cinemaChoice = sc.nextInt();

        //     case 3:
        //     cineplex = "Ang Mo Kio";
        //     System.out.println("Select Cinema chosen in Cineplex VivoCity: ");
        //     System.out.println("Cinema: 1, 2, 3, 4");
        //     cinemaChoice = sc.nextInt();

        // }
    }

}
