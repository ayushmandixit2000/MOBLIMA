package MOBLIMA.listing;

import java.io.IOException;
import java.util.Scanner;

import MOBLIMA.listing.*;

public class CinemaListing implements Listing{

    public void displayListing() throws IOException {

        CineplexListing st = new CineplexListing();

        System.out.println("There are 3 cinemas in the chosen cineplex: \n"
        + "1- Cinema 1 \n" + "2- Cinema 2 \n" + "3- Cinema 3 \n");


    }

    public int getListing(){
        System.out.println("Enter the Cinema number you'd like to create: ");

        Scanner sc = new Scanner(System.in);
        int cinemaNumber = sc.nextInt();
        return cinemaNumber;

    }
    
    public static void main(String[] args) throws IOException{
         CinemaListing cl = new CinemaListing();
         cl.displayListing();
         cl.getListing();
    }
}
