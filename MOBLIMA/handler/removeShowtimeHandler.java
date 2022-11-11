package MOBLIMA.handler;

import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.save.saveShowtime;
import MOBLIMA.utils.compareDates;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.listing.ShowtimeListing;
import java.io.IOException;

public class removeShowtimeHandler {
    private static String filename = "MOBLIMA/databases/showtime.txt";
    private static ArrayList showTimeArray;

    public static void remove(String id) throws IOException {
        for (int i = 0; i < showTimeArray.size(); i++) {
            Showtime s = (Showtime) showTimeArray.get(i);
            if (s.getShowtimeId().equals(id)) {
                showTimeArray.remove(s);
                break;
            }
        }
        saveShowtime.saveShowtimeArray(filename, showTimeArray);
        System.out.println("Removed successfully");
    }

    public static void run(String cplx, int cnm, String cc) {
        Scanner sc = new Scanner(System.in);
        try {
            showTimeArray = retrieveShowtime.readShowtime(filename);
            ShowtimeListing stl = new ShowtimeListing();

            stl.populate(cplx, cnm, cc);
            stl.displayListing();
            System.out.println("Hint : Select the showtime you want to remove");
            System.out.println("Enter what you'd like to remove: ");
            int userindex = sc.nextInt();
            String selectedShowtimeId = "";
            int FirstCounter = 0;
            Collections.sort(showTimeArray, new compareDates());
            for (int i = 0; i < showTimeArray.size(); i++) {
                Showtime s = (Showtime) showTimeArray.get(i);
                if ((s.getCinema()).equals(cc)) {
                    if (FirstCounter == userindex) {
                        selectedShowtimeId = s.getShowtimeId();
                    }
                    FirstCounter++;
                }
            }
            System.out.println("Removing...");
            remove(selectedShowtimeId);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
