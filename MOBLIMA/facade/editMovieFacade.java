package MOBLIMA.facade;

import java.io.IOException;

import MOBLIMA.action.adminShowtimeAction;
import MOBLIMA.handler.createMovieHandler;
import MOBLIMA.handler.removeMovieHandler;
import MOBLIMA.handler.updateMovieHandler;

public class editMovieFacade {
    public void run() throws IOException {
        adminShowtimeAction asa = new adminShowtimeAction();
        asa.displayChoices();
        int action = asa.getChoice();
        switch (action){
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
