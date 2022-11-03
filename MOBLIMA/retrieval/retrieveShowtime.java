package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
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

            int cineplex = Integer.parseInt(star.nextToken().trim());
            String cinema = star.nextToken().trim();
            String date = star.nextToken().trim();
            int timeSlot = Integer.parseInt(star.nextToken().trim());
            int movieId = Integer.parseInt(star.nextToken().trim());
            String seating = star.nextToken().trim();

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
        retrieveMovie txtDB = new retrieveMovie();
        String filename = "MOBLIMA/databases/showtime.txt";
        try {
            ArrayList al = retrieveShowtime.readShowtime(filename);
            for (int i = 0; i < al.size(); i++) {
                Showtime s = (Showtime) al.get(i);
                System.out.println("MovieId " + s.getMovieId());
            }
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
