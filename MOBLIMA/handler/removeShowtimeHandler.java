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

/**
 * Helper class to remove the showtime indicated by the admin.
 */
public class removeShowtimeHandler {
    /**
     * The file path to the showtime database.
     */
    private static String filename = "MOBLIMA/databases/showtime.txt";
    /**
     * The stored showtime obtained from the showtime database.
     */
    private static ArrayList showTimeArray;

    /**
     * Removes the specified showtime id.
     * Saves the changes into the showtime database.
     * 
     * @param id The id of the showtime to remove.
     */
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

    /**
     * Displays the options and obtains inputs to identify the intended showtime for
     * removal.
     * 
     * @param cplx The showtime's cineplex.
     * @param cnm  The showtime's cinema's number.
     * @param cc   The showtime's cinema's code
     */
    public static void run(String cplx, int cnm, String cc) {
        Scanner sc = new Scanner(System.in);
        try {
            showTimeArray = retrieveShowtime.readShowtime(filename);
            ShowtimeListing stl = new ShowtimeListing();

            stl.populate(cplx, cnm, cc);
            stl.displayListing();
            int validShowtimes = stl.getValidShowtimes();
            if (validShowtimes == 0) {
                System.out.println("Please create showtimes.");
                return;
            }

            boolean flag;
            int userindex = -1;
            do {
                try {
                    System.out.println("Enter what you'd like to remove: ");
                    userindex = sc.nextInt();
                    flag = false;
                    if (userindex < 0 || userindex >= validShowtimes) {
                        System.out.println("Invalid option. Please key in valid numbers");
                        flag = true;
                    } else {
                        flag = false;
                    }
                } catch (Exception e) {
                    System.out.println("Inavlid input. Please enter intergers only");
                    sc.nextLine();
                    flag = true;
                }
            } while (flag);
            sc.nextLine();

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
