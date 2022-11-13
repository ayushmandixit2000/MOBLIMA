package MOBLIMA.handler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.listing.ShowtimeListing;
import MOBLIMA.listing.movieListing;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.save.saveShowtime;
import MOBLIMA.utils.compareDates;
import MOBLIMA.utils.dateTime;

/**
 * Helper class to update the showtime with attributes indicated by the admin.
 */
public class updateShowtimeHandler {
    /**
     * The file path to the showtime databse.
     */
    private static String filename = "MOBLIMA/databases/showtime.txt";
    /**
     * The showtimes stored in the showtime database.
     */
    private static ArrayList showTimeArray;

    /**
     * Replaces the showtime object with the updates showtime object.
     * Saves changes into the showtime database.
     * 
     * @param st Updated showtime object.
     * @param id Id of the showtime object to be replaced.
     */
    public static void update(Showtime st, String id) throws IOException {
        try {
            for (int i = 0; i < showTimeArray.size(); i++) {
                Showtime s = (Showtime) showTimeArray.get(i);
                if (s.getShowtimeId().equals(id)) {
                    showTimeArray.set(i, st);
                    break;
                }
            }
            saveShowtime.saveShowtimeArray(filename, showTimeArray);
            System.out.println("Updated successfully");
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

    /**
     * Displays the options and obtains inputs to update the showtime attributes.
     * 
     * @param cplx The showtime's cineplex.
     * @param cnm  The showtime's cinema's number.
     * @param cc   The showtime's cinema's code.
     */
    public static void run(String cplx, int cnm, String cc) throws IOException {
        Scanner sc = new Scanner(System.in);
        LocalTime time = dateTime.convertTime("0100");
        LocalDate date = dateTime.convertDate("2016/01/01");
        String oldShowtimeId = "NULL";
        int FirstCounter = 0;
        Movie chosenMovie = new Movie(2, "title", 2, "director", new String[] { "cast1", "cast2" }, "synopsis", 1, 1,
                0);
        String showtimeDetails = "";
        try {
            showTimeArray = retrieveShowtime.readShowtime(filename);
            ShowtimeListing stl = new ShowtimeListing();
            stl.populate(cplx, cnm, cc);
            stl.displayListing();
            int validShowtimes = stl.getValidShowtimes();
            if (validShowtimes == 0) {
                System.out.println("Please create a showtime.");
                return;
            }

            boolean flag;
            int userindex = -1;

            // to prevent users from keying in data that is not integer
            do {
                try {
                    System.out.println("Enter showtime number that you would like to Update: ");
                    userindex = sc.nextInt();
                    flag = false;
                    if (userindex < 0 || userindex >= validShowtimes) {
                        System.out.println("Invalid option. Please key in valid numbers.");
                        flag = true;
                    } else {
                        flag = false;
                    }
                } catch (Exception e) {
                    System.out.println("Inavlid input. Please enter intergers only.");
                    sc.nextLine();
                    flag = true;
                }
            } while (flag);
            sc.nextLine();

            Collections.sort(showTimeArray, new compareDates());
            for (int i = 0; i < showTimeArray.size(); i++) {
                Showtime s = (Showtime) showTimeArray.get(i);
                if ((s.getCinema()).equals(cc)) {
                    if (FirstCounter == userindex) {
                        String filename1 = "MOBLIMA/databases/movie.txt";
                        ArrayList movieArray = retrieveMovie.readMovie(filename1);
                        for (int j = 0; j < movieArray.size(); j++) {
                            Movie m1 = (Movie) movieArray.get(j);
                            if (m1.getMovieId() == s.getMovieId()) {
                                chosenMovie = m1;
                                oldShowtimeId = s.getShowtimeId();
                                date = s.getDate();
                                time = s.getTime();
                            }
                        }
                        showtimeDetails = cc + "|" + dateTime.convertDate(date) + "|"
                                + dateTime.convertTime(time) + "|"
                                + chosenMovie.getTitle();
                        break;
                    }
                    FirstCounter++;
                }
            }
            System.out.println(showtimeDetails);
            System.out.println("showtime size: " + FirstCounter);
            int editParameter = -1;
            while (editParameter != 100) {
                System.out.println("Select the parameter you would like to edit: \n"
                        + "0 - Date \n"
                        + "1 - Time \n"
                        + "2 - Movie \n"
                        + "3 - Exit");

                // to prevent users from keying in data that is not string
                do {
                    try {
                        editParameter = sc.nextInt();
                        flag = false;
                        if (editParameter < 0 || editParameter > 3) {
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

                switch (editParameter) {
                    case 0:
                        String inputDate = "date";
                        System.out.println("Editing Date: ");
                        DateTimeFormatter strictDateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                        // error handling for invalid input
                        do {
                            try {
                                System.out.println("Input date in YYYY/MM/DD format");
                                inputDate = sc.next();
                                LocalDate.parse(inputDate, strictDateFormatter);
                                flag = false;
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid input. Please try again.");
                                flag = true;
                            }
                        } while (flag);
                        date = dateTime.convertDate(inputDate);
                        break;

                    case 1:
                        String inputTime = "time";
                        System.out.println("Editing Time: ");
                        // error handling for invalid input
                        DateTimeFormatter strictTimeFormatter = DateTimeFormatter.ofPattern("HHmm")
                                .withResolverStyle(ResolverStyle.STRICT);
                        do {
                            try {
                                System.out.println("Input time in HHMM format");
                                inputTime = sc.next();
                                LocalTime.parse(inputTime, strictTimeFormatter);
                                flag = false;
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid input. Please try again.");
                                flag = true;

                            }
                        } while (flag);
                        time = dateTime.convertTime(inputTime);

                        break;
                    case 2:
                        System.out.println("Editing Movie: ");
                        movieListing ml = new movieListing(true);
                        ml.displayListing();
                        ml.show();
                        chosenMovie = ml.getChosenMovie();
                        break;
                    case 3:
                        editParameter = 100;
                        break;
                }
            }
            System.out.println("Updating...");
            int[][] seating = { { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 3, 3, 4, 4, 2, 4, 4, 3, 3, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 3, 3, 4, 4, 2, 4, 4, 3, 3, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 3, 3, 4, 4, 2, 4, 4, 3, 3, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 3, 3, 4, 4, 2, 2, 2, 3, 3, 0, 0, 0, 0, 2 } };
            Showtime newST = new Showtime(cc, date, time, chosenMovie.getMovieId(), seating);
            update(newST, oldShowtimeId);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}