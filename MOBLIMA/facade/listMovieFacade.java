package MOBLIMA.facade;

import java.io.IOException;

import MOBLIMA.Listings.MovieDetailsListing;
import MOBLIMA.action.CustomerAction;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.listing.movielisting;

public class listMovieFacade {
    private static int action = 0;

    public static void setAction(int a) {
        action = a;
    }

    public static void run(String userId) throws IOException {
        movielisting ml = new movielisting();
        ml.setuser(userId);
        ml.show();
        Movie chosenMovie = ml.getChosenMovie();

        MovieDetailsListing moviedetails = new MovieDetailsListing();
        moviedetails.setmovie(chosenMovie);
        moviedetails.displayListing();

        CustomerAction CA = new CustomerAction();
        CA.setaction(action);
        CA.setmovie(chosenMovie);
        CA.getChoice();
    }
}
