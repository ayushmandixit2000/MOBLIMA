package MOBLIMA.facade;

import java.io.IOException;
import MOBLIMA.action.CustomerAction;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.listing.MovieDetailsListing;
import MOBLIMA.listing.searchListing;

/**
 * Consolidated class to link all the required classes together to execute the
 * Search Movie functionality.
 */
public class searchMovieFacade {
    public static void run(String userId) throws IOException {
        int action = 0;
        searchListing sl = new searchListing();
        sl.show();
        Movie chosenMovie = sl.getChosenMovie();

        if (chosenMovie == null) {
            return;
        }
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
