package MOBLIMA.listingInterface;

import java.io.IOException;
import java.util.Scanner;

public class adminShowtimeAction {
    
    public void displayListing() throws IOException {
        System.out.println("What would you like to do with showtime?\n"
        + "0 - Create Showtime\n"
        + "1 - Update Showtime\n"
        + "2 - Remove Showtime\n");
    }
}
