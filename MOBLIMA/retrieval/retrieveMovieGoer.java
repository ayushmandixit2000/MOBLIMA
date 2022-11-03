package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import MOBLIMA.dataStructure.MovieGoer;

public class retrieveMovieGoer {
    public static final String SEPARATOR = "|";

    public static ArrayList readMovieGoer(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String userId = star.nextToken().trim();
            String name = star.nextToken().trim();
            int mobileNumber = Integer.parseInt(star.nextToken().trim());
            String email = star.nextToken().trim();

            MovieGoer m = new MovieGoer(userId, name, mobileNumber, email);
            alr.add(m);
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
        String filename = "MOBLIMA/databases/movieGoer.txt";
        try {
            ArrayList al = retrieveMovieGoer.readMovieGoer(filename);
            for (int i = 0; i < al.size(); i++) {
                MovieGoer m = (MovieGoer) al.get(i);
                System.out.println("Name: " + m.getName());
            }
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
