package MOBLIMA.configure;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import MOBLIMA.configurables.peakDates;
import MOBLIMA.utils.comparePH;
import MOBLIMA.utils.dateTime;

/**
 * Represents a configure class to display the current settings and obtains the
 * user's input.
 */
public class configurePeakDates {
    /**
     * Prints on the console the current saved list of peak dates.
     * 
     */
    public void displaySetting() throws IOException {
        System.out.println("Current peak dates (Other than Fridays after 6pm and Weekends):");
        ArrayList datesArray = peakDates.getPublicHoli();
        Collections.sort(datesArray, new comparePH());
        for (int i = 0; i < datesArray.size(); i++) {
            LocalDate d = (LocalDate) datesArray.get(i);
            System.out.print(dateTime.convertDate(d));
            System.out.print(" | ");
        }
        System.out.println("_____________________________________________________________");
    }

    /**
     * Obtains the user console input for a new date to be considered peak.
     */
    public void getNewSetting() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please indicate new peak dates in format of YYYY/MM/DD");
        while (!sc.hasNext()) {
            System.out.println("Please input a date in format of YYYY/MM/DD:");
            sc.next();
        }
        LocalDate d = dateTime.convertDate(sc.next());
        peakDates.addPeakDate(d);
    }
}