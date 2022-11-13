package MOBLIMA.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import MOBLIMA.dataStructure.MovieGoer;
import MOBLIMA.retrieval.retrieveMovieGoer;
import MOBLIMA.save.saveMovieGoer;

/**
 * Helper class to verify the movie-goer's identity.
 */
public class customerVerifcationHandler {
    /**
     * The file path to the moviegoer database.
     */
    private static String filename = "MOBLIMA/databases/movieGoer.txt";
    /**
     * The moviegoers registered onto the app.
     */
    private static ArrayList movieGoerArray;

    /**
     * Gets the details of the moviegoer if he has registered with the app.
     * 
     * @param name The name of the moviegoer.
     * @return The id of the moviegoer if he has previously registered.
     */
    public static String userIdCheck(String name) throws IOException {
        movieGoerArray = retrieveMovieGoer.readMovieGoer(filename);
        for (int i = 0; i < movieGoerArray.size(); i++) {
            MovieGoer m = (MovieGoer) movieGoerArray.get(i);
            String m1 = m.getEmail().toLowerCase();
            if (m1.equalsIgnoreCase(name)) {
                return m.getUserId();
            }
        }
        return "";
    }

    /**
     * Displays the relevant options and obtains the information required to
     * register a new moviegoer.
     * 
     * @param name1 The name of the new moviegoer.
     */
    public static void displayNewUser(String name1) throws IOException {
        Scanner scc = new Scanner(System.in);
        System.out.println("Please enter your name");
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
        String userid = email + mobilenumber;
        System.out.println("Welcome " + email);
        System.out.println("User ID: " + userid);
        MovieGoer mg = new MovieGoer(userid, email, mobilenumber, name1);// add new movieGoer
        movieGoerArray.add(mg);
        saveMovieGoer.saveMovieGoerArray(filename, movieGoerArray);// overwrite file
    }

    /**
     * Displays the welcome page to registered moviegoers.
     * 
     * @param name1  The name of the moviegoer.
     * @param userid The id of the moviegoer.
     */
    public static void displayOldUser(String name1, String userid) throws IOException {

        movieGoerArray = retrieveMovieGoer.readMovieGoer(filename);
        for (int i = 0; i < movieGoerArray.size(); i++) {
            MovieGoer m = (MovieGoer) movieGoerArray.get(i);
            String m1 = m.getEmail().toLowerCase();
            if (m1.equalsIgnoreCase(name1)) {
                name1 = m.getName();
            }
        }

        System.out.println("Welcome Back " + name1);
        System.out.println("User ID: " + userid);
    }
}
