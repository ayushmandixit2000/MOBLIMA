package MOBLIMA.listingInterface;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

import MOBLIMA.listingInterface.*;
import MOBLIMA.utils.dateTime;

public class ShowtimeListing implements Listing{

    public void displayListing() throws IOException {
        System.out.println("Pick a showtime:\n"
        + "0 - 0700\n"
        + "1 - 1000\n"
        + "2 - 1300\n"
        + "3 - 1600\n"
        + "4 - 1900\n"
        + "5 - 2200\n"
        + "6 - 0100\n");
    }

    public LocalTime getListing() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        while (choice < 0 || choice > 6) {
            System.out.println("please input your choice");
            choice = sc.nextInt();
        }

        System.out.println("choice: " + choice);
        LocalTime localtime = dateTime.convertTime("0100");
        switch(choice) {
            case 0:
            localtime = dateTime.convertTime("0700"); 
            return localtime;

            case 1:
            //strTime = "1000";
            localtime = dateTime.convertTime("1000"); 
            return localtime;

            case 2:
            localtime = dateTime.convertTime("1300"); 
            return localtime;

            case 3:
            localtime = dateTime.convertTime("1600"); 
            return localtime;

            case 4:
            localtime = dateTime.convertTime("1900"); 
            return localtime;

            case 5:
            localtime = dateTime.convertTime("2200"); 
            return localtime;

            case 6:
            localtime = dateTime.convertTime("0100"); 
            return localtime;
        
            }

            return localtime;
    }

    public static void main(String[] args) throws IOException {
        ShowtimeListing listing = new ShowtimeListing();

        LocalTime lt = listing.getListing();

        System.out.println(lt);

    }

}