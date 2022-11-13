package MOBLIMA.facade;

import java.io.IOException;
import MOBLIMA.action.CustomerAction;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.listing.MovieDetailsListing;
import MOBLIMA.listing.movieListing;

/**
 * Consolidated class to link all the required classes together to execute the
 * List Movie functionality.
 */
public class listMovieFacade {
    /**
     * The index of the user's actions (0: No Indication, 1: Review Movie, 2: Book
     * Movie).
     */
    private static int action = 0;

    /**
     * Change the user's action index.
     * 
     * @param a The user's new action index.
     */
    public static void setAction(int a) {
        action = a;
    }

    /**
     * Display the options users have and to instantantiate related classes and
     * execute their required functionalities.
     */
    public static void run(String userId) throws IOException {
        movieListing ml = new movieListing(false);
        ml.setuser(userId);
        ml.show();
        Movie chosenMovie = ml.getChosenMovie();

        MovieDetailsListing moviedetails = new MovieDetailsListing();
        moviedetails.setmovie(chosenMovie);
        moviedetails.displayListing();

        CustomerAction CA = new CustomerAction();
        CA.setaction(action);
        CA.setuser(userId);
        CA.setmovie(chosenMovie);
        CA.getChoice();
    }
}
