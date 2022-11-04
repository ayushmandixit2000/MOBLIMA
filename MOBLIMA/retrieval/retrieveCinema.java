package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import MOBLIMA.dataStructure.Cinema;

public class retrieveCinema {
    public static final String SEPARATOR = "|";

    public static ArrayList readShowtime(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String cineplex = star.nextToken().trim();
            int cinema = Integer.parseInt(star.nextToken().trim());
            int movieClass = Integer.parseInt(star.nextToken().trim());
            String layout = star.nextToken().trim();

            Cinema c = new Cinema(cineplex, cinema, movieClass, layout);
            alr.add(c);
        }
        return alr;
    }

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
        String filename = "MOBLIMA/databases/Cinema.txt";
        try {
            ArrayList al = retrieveCinema.readShowtime(filename);
            for (int i = 0; i < al.size(); i++) {
                Cinema c = (Cinema) al.get(i);
                System.out.println("CinemaId " + c.getCinema());
            }
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
