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
    public static void save(Showtime st, String id) throws IOException {
        String filename = "MOBLIMA/databases/showtime.txt";
        ArrayList showTimeArray = retrieveShowtime.readShowtime(filename);
        for (int i = 0; i < showTimeArray.size(); i++) {
            Showtime s = (Showtime) showTimeArray.get(i);
            if (s.getShowtimeId().equals(id)) {
                showTimeArray.set(i, st);
                break;
            }
        }
        saveShowtime.saveShowtimeArray(filename, showTimeArray);
    }

    public static void update(String cplx, int cnm, String cc) throws IOException {
        String filename = "MOBLIMA/databases/showtime.txt";
        Scanner sc = new Scanner(System.in);
        LocalTime time = dateTime.convertTime("0100");
        LocalDate date = dateTime.convertDate("2016/01/01");
        String oldShowtimeId = "NULL";
        int FirstCounter = 0;
        Movie chosenMovie = new Movie(2, "title", 2, "director", new String[] { "cast1", "cast2" }, "synopsis", 1, 1,
                0);
        String showtimeDetails = "";
        try {
            ArrayList al = retrieveShowtime.readShowtime(filename);
            ShowtimeListing stl = new ShowtimeListing();
            stl.populate(cplx, cnm, cc);
            stl.displayListing();
            System.out.println("Enter showtime number that you would like to Update: ");
            int userindex = sc.nextInt();
            Collections.sort(al, new compareDates());
            for (int i = 0; i < al.size(); i++) {
                Showtime s = (Showtime) al.get(i);
                if ((s.getCinema()).equals(cc)) {
                    if (FirstCounter == userindex) {
                        filename = "MOBLIMA/databases/movie.txt";
                        ArrayList movieArray = retrieveMovie.readMovie(filename);
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
                        System.out.println("Saving...");
                        editParameter = 100;
                        break;
                }
            }
            int[][] seating = { { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 2 } };
            Showtime newST = new Showtime(cc, date, time, chosenMovie.getMovieId(), seating);
            save(newST, oldShowtimeId);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}