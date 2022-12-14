package MOBLIMA.facade;

import java.io.IOException;

import MOBLIMA.action.adminMovieAction;
import MOBLIMA.handler.createMovieHandler;
import MOBLIMA.handler.removeMovieHandler;
import MOBLIMA.handler.updateMovieHandler;

/**
 * Consolidated class to link all the required classes together to execute the
 * Edit Movie functionality.
 */
public class editMovieFacade {
    /**
     * Display the options users have and to instantantiate related classes and
     * execute their required functionalities.
     */
    public void run() throws IOException {
        adminMovieAction asa = new adminMovieAction();
        asa.displayChoices();
        int action = asa.getChoice();
        switch (action) {
            case 1:
                System.out.println("Create Movie Listing");
                createMovieHandler newMovie = new createMovieHandler();
                newMovie.movieCreate();
                break;
            case 2:
                System.out.println("Update Movie Listing");
                updateMovieHandler editMovie = new updateMovieHandler();
                editMovie.movieUpdate();
                break;
            case 3:
                System.out.println("Remove Movie Listing");
                removeMovieHandler deleteMovie = new removeMovieHandler();
                deleteMovie.movieRemove();
                break;
        }
    }

}
