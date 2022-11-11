package MOBLIMA.retrieval;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import MOBLIMA.dataStructure.MovieTicket;

public class retrieveMovieTicket {
    public static final String SEPARATOR = "|";

    public static ArrayList readMovieTicket(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String movieTicketId = star.nextToken().trim();
            String ageCat = star.nextToken().trim();
            int row = Integer.parseInt(star.nextToken().trim());
            int column = Integer.parseInt(star.nextToken().trim());
            double price = Double.parseDouble(star.nextToken().trim());
            String showtimeId = star.nextToken().trim();
            int seatClass = Integer.parseInt(star.nextToken().trim());


            MovieTicket mt = new MovieTicket(ageCat, row, column, showtimeId,seatClass); // price is calculated
            alr.add(mt);
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
        String filename = "MOBLIMA/databases/movieTicket.txt";
        try {
            ArrayList al = retrieveMovieTicket.readMovieTicket(filename);
            for (int i = 0; i < al.size(); i++) {
                MovieTicket mt = (MovieTicket) al.get(i);
                System.out.println(mt.getMovieTicketId());

            }
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
