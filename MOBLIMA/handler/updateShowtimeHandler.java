package MOBLIMA.handler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.listing.ShowtimeListing;
import MOBLIMA.listing.movielisting;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.save.saveShowtime;
import MOBLIMA.utils.compareDates;
import MOBLIMA.utils.dateTime;

public class updateShowtimeHandler {
    private static String filename = "MOBLIMA/databases/showtime.txt";
    private static ArrayList showTimeArray;

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
            System.out.println("Enter showtime number that you would like to Update: ");
            int userindex = sc.nextInt();
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
            int editParameter = -1;
            while (editParameter != 100) {
                System.out.println("Select the parameter you would like to edit: \n"
                        + "0 - Date \n"
                        + "1 - Time \n"
                        + "2 - Movie \n"
                        + "3 - Exit");
                editParameter = sc.nextInt();
                switch (editParameter) {
                    case 0:
                        System.out.println("Editing Date: ");
                        System.out.println("input date in YYYY/MM/DD format");
                        date = dateTime.convertDate(sc.next());
                        break;
                    case 1:
                        System.out.println("Editing Time: ");
                        System.out.println("input time in HHMM format");
                        time = dateTime.convertTime(sc.next());
                        break;
                    case 2:
                        System.out.println("Editing Movie: ");
                        movielisting ml = new movielisting();
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