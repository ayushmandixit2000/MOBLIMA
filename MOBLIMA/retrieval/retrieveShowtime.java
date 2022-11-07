package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import MOBLIMA.dataStructure.Showtime;

public class retrieveShowtime {
    public static final String SEPARATOR = "|";

    public static ArrayList readShowtime(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String cineplex = star.nextToken().trim();
            int cinema = Integer.parseInt(star.nextToken().trim());
            String date = star.nextToken().trim();
            int timeSlot = Integer.parseInt(star.nextToken().trim());
            int movieId = Integer.parseInt(star.nextToken().trim());

            String[] seatinArray = star.nextToken().trim().split("\\.");
            int[][] seating = new int[seatinArray.length][seatinArray.length];
            for (int j = 0; j < seatinArray.length; j++) {
                String[] row = seatinArray[j].split("\\,");
                for (int k = 0; k < seatinArray.length; k++) {
                    seating[j][k] = Integer.valueOf(row[k]);
                }
            }

            Showtime s = new Showtime(cineplex, cinema, date, timeSlot, movieId, seating);
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
                System.out.println(Arrays.deepToString(s.getSeating()));
            }
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
