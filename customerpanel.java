import MOBLIMA.panelInterface.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import MOBLIMA.retrieval.retrieveMovieGoer;
import MOBLIMA.save.saveMovieGoer;
import MOBLIMA.dataStructure.MovieGoer;

public class customerpanel implements Panel {

    public void viewApp() {
        System.out.println("Welcome to MOBLIMA");
        try (Scanner scc = new Scanner(System.in)) {

            System.out.println("Please enter your name");
            String name1 = scc.next();
            String name = name1.toLowerCase();
            boolean newuser = true;
            String userid = "";

            String filename = "MOBLIMA/databases/movieGoer.txt";
            ArrayList movieGoerArray = retrieveMovieGoer.readMovieGoer(filename);

            for (int i = 0; i < movieGoerArray.size(); i++) {
                MovieGoer m = (MovieGoer) movieGoerArray.get(i);
                String m1 = m.getName().toLowerCase();
                if (m1.contains(name)) {
                    newuser = false;
                    userid = m.getUserId();
                    break;
                }
            }

            if (newuser == false) {
                System.out.println("Welcome Back " + name1);
                System.out.println("User ID: " + userid);
            }

            else {
                System.out.println("Please enter your email address");
                String email = scc.next();

                System.out.println("Please enter your phone number");
                int mobilenumber = scc.nextInt();

                userid = name1 + mobilenumber;

                System.out.println("Welcome " + name1);
                System.out.println("User ID: " + userid);

                MovieGoer mg = new MovieGoer(userid, name1, mobilenumber, email);// add new movieGoer
                movieGoerArray.add(mg);
                saveMovieGoer.saveMovieGoerArray(filename, movieGoerArray);// overwrite file
            }

           

            loop: while (true) {
                System.out.println("\nPlease select your desired action (key in the coresponding number)");
                System.out.println("1: Search for a movie");
                System.out.println("2: List movies");
                System.out.println("3: View movie detailes");
                System.out.println("4: Check seat availability");
                System.out.println("5: Book and purchase ticket");
                System.out.println("6: View booking history");
                System.out.println("7: List the Top 5 ranking movies");
                System.out.println("8: Rate Movies");
                System.out.println("8: Quit \n");

                int option = scc.nextInt();

                switch (option) {
                    case 1:
                        search searchmovie = new search();
                        searchmovie.findmovie();
                        break;

                    case 2:
                        list listmovies = new list();
                        listmovies.show();
                        break;

                    case 3:
                        moviedetailui md = new moviedetailui();
                        md.begin();
                        break;

                    // case 2:
                    // movie.viewdetails();

                    // case 3:
                    // cineplex.seats();

                    // case 4:
                    // user.booktickets();

                    // case 5:
                    // user.bookinghistory();

                    // case 6:
                    // movie.rank();
                    case 7:
                        System.out.println("Exiting...");
                        break loop;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}