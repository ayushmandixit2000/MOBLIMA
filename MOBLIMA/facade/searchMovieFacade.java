package MOBLIMA.facade;

import java.io.IOException;

import MOBLIMA.Listings.MovieDetailsListing;
import MOBLIMA.action.CustomerAction;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.listing.searchListing;

public class searchMovieFacade {
    public static void run(String userId) throws IOException {
        int action = 0;
        searchListing sl = new searchListing();
        sl.show();
        Movie chosenMovie = sl.getChosenMovie();

        MovieDetailsListing moviedetails = new MovieDetailsListing();
        moviedetails.setmovie(chosenMovie);
        moviedetails.displayListing();

        CustomerAction CA = new CustomerAction();
        CA.setaction(action);
        CA.setuser(userId);
        CA.setmovie(chosenMovie);
        CA.displayChoices();
        CA.getChoice();
    }
}
