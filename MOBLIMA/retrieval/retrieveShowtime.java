package MOBLIMA.retrieval;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.utils.compareDates;
import MOBLIMA.utils.dateTime;

public class retrieveShowtime {
    public static final int ROWS = 9;
    public static final int COLUMNS = 19;
    public static final String SEPARATOR = "|";

    public static ArrayList readShowtime(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String cinema = star.nextToken().trim();
            LocalDate date = dateTime.convertDate(star.nextToken().trim());
            LocalTime timeSlot = dateTime.convertTime(Integer.parseInt(star.nextToken().trim()));
            int movieId = Integer.parseInt(star.nextToken().trim());

            String[] seatinArray = star.nextToken().trim().split("\\.");
            int[][] seating = new int[ROWS][COLUMNS];
            for (int j = 0; j < ROWS; j++) {
                String[] row = seatinArray[j].split("\\,");
                for (int k = 0; k < COLUMNS; k++) {
                    seating[j][k] = Integer.valueOf(row[k]);
                }
            }
            String showTimeId = star.nextToken().trim(); // not used

            Showtime s = new Showtime(cinema, date, timeSlot, movieId, seating);
            alr.add(s);
        }
        return alr;
    }

    /** Read the contents of the given file. */
    public static List read(String fileName) throws IOException {
        List data = new ArrayList();
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        try {
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
        } finally {
            scanner.close();
        }
        return data;
    }

    public static void main(String[] aArgs) {
        String filename = "MOBLIMA/databases/showtime.txt";
        try {
            ArrayList al = retrieveShowtime.readShowtime(filename);
            for (int i = 0; i < al.size(); i++) {
                Showtime s = (Showtime) al.get(i);
                System.out.println("MovieId " + s.getMovieId());
                int[][] array = s.getSeating();
                // for (int k = 0; k < array.length; k++) {
                // for (int j = 0; j < array[k].length; j++) {
                // System.out.print(array[k][j] + " ");
                // }
                // System.out.println();
                // }
                System.out.println(dateTime.convertDate(s.getDate()));
                System.out.println(dateTime.convertTime(s.getTime()));
                System.out.println(s.getShowtimeId());
            }
            System.out.println("after sorting");
            Collections.sort(al, new compareDates());// HELLO AYUSHMAN!
            for (int i = 0; i < al.size(); i++) {
                Showtime s = (Showtime) al.get(i);
                System.out.println("MovieId " + s.getMovieId());
                int[][] array = s.getSeating();
                // for (int k = 0; k < array.length; k++) {
                // for (int j = 0; j < array[k].length; j++) {
                // System.out.print(array[k][j] + " ");
                // }
                // System.out.println();
                // }
                System.out.println(dateTime.convertDate(s.getDate()));
                System.out.println(dateTime.convertTime(s.getTime()));
                System.out.println(s.getShowtimeId());
            }

        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
