package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import MOBLIMA.dataStructure.Review;

public class retrieveReview {
    public static final String SEPARATOR = "|";

    public static ArrayList readReview(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            int movieId = Integer.parseInt(star.nextToken().trim());
            int rating = Integer.parseInt(star.nextToken().trim());
            String review = star.nextToken().trim();
            Review r = new Review(movieId, rating, review);
            alr.add(r);
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
        String filename = "MOBLIMA/databases/review.txt";
        try {
            ArrayList al = retrieveReview.readReview(filename);
            for (int i = 0; i < al.size(); i++) {
                Review r = (Review) al.get(i);
                System.out.println("Review: " + r.getReview());
            }
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

}
