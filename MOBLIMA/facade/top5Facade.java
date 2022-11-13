package MOBLIMA.facade;

import java.io.IOException;
import java.util.Scanner;
import MOBLIMA.action.CustomerAction;
import MOBLIMA.configurables.rankStatus;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.listing.MovieDetailsListing;
import MOBLIMA.listing.top5RatingListing;
import MOBLIMA.listing.top5SalesListing;

/**
 * Consolidated class to link all the required classes together to execute the
 * Configure Setting functionality.
 */
public class top5Facade {
    /**
     * Display the options users have and to instantantiate related classes and
     * execute their required functionalities.
     */
    public static void show(String userid) throws IOException {
        int config = rankStatus.getStatus();
        int action = 0;
        int choicerank = 0;

        if (config == 0) {
            System.out.println("The cinema has disabled this function for now, please check back later!");
            return;
        }

        else if (config == 1) {
            System.out.println("Currently we are only showing ranking by sales!");
            choicerank = 1;
        }

        else if (config == 2) {
            System.out.println("Currently we are only showing ranking by ratings!");
            choicerank = 2;
        }

        if (choicerank == 0) {
            System.out.println("Please enter how you would like your movies to be sorted:");
            System.out.println("(1) By Sales (2) By Ratings");
            Scanner scc = new Scanner(System.in);
            while (true) {
                String input = scc.next();
                choicerank = 0;
                try {
                    choicerank = Integer.parseInt(input);
                    if (choicerank > 2 || choicerank < 1) {
                        System.out.println("Please key in a valid number!");
                        continue;
                    } else {
                        break;
                    }
                } catch (NumberFormatException ne) {
                    System.out.println("Please key in a number only!");
                }
            }
        }

        if (choicerank == 1) {
            top5SalesListing sales = new top5SalesListing();
            sales.displayListing();
            Movie m = sales.getmovie();
            if (m != null) {
                MovieDetailsListing moviedetails = new MovieDetailsListing();
                moviedetails.setmovie(m);
                moviedetails.displayListing();
                CustomerAction CA = new CustomerAction();
                CA.setaction(action);
                CA.setuser(userid);
                CA.setmovie(m);
                CA.getChoice();
            }
        }
        if (choicerank == 2) {
            top5RatingListing ratings = new top5RatingListing();
            ratings.displayListing();
            Movie m = ratings.getmovie();
            if (m != null) {
                MovieDetailsListing moviedetails = new MovieDetailsListing();
                moviedetails.setmovie(m);
                moviedetails.displayListing();
                CustomerAction CA = new CustomerAction();
                CA.setaction(action);
                CA.setuser(userid);
                CA.setmovie(m);
                CA.getChoice();
            }
        }
    }
}
