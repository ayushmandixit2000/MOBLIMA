package MOBLIMA.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import MOBLIMA.dataStructure.MovieGoer;
import MOBLIMA.retrieval.retrieveMovieGoer;
import MOBLIMA.save.saveMovieGoer;

public class customerVerifcationHandler {

    private static String filename = "MOBLIMA/databases/movieGoer.txt";
    private static ArrayList movieGoerArray;

    public static String userIdCheck(String name) throws IOException {
        movieGoerArray = retrieveMovieGoer.readMovieGoer(filename);
        for (int i = 0; i < movieGoerArray.size(); i++) {
            MovieGoer m = (MovieGoer) movieGoerArray.get(i);
            String m1 = m.getName().toLowerCase();
            if (m1.equalsIgnoreCase(name)) {
                return m.getUserId();
            }
        }
        return "";
    }

    public static void displayNewUser(String name1) throws IOException {
        Scanner scc = new Scanner(System.in);
        System.out.println("Please enter your email address");
        String email = scc.next();
        System.out.println("Please enter your phone number");
        int mobilenumber;

        while (true) {
            String input = scc.next();
            mobilenumber = 0;
            try {
                mobilenumber = Integer.parseInt(input);
                if (mobilenumber < 60000000) {
                    System.out.println("Please key in a valid number!");
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ne) {
                System.out.println("Please key in a number only!");
            }
        }
        String userid = name1 + mobilenumber;
        System.out.println("Welcome " + name1);
        System.out.println("User ID: " + userid);
        MovieGoer mg = new MovieGoer(userid, name1, mobilenumber, email);// add new movieGoer
        movieGoerArray.add(mg);
        saveMovieGoer.saveMovieGoerArray(filename, movieGoerArray);// overwrite file
    }

    public static void displayOldUser(String name1, String userid) {
        System.out.println("Welcome Back " + name1);
        System.out.println("User ID: " + userid);
    }
}
