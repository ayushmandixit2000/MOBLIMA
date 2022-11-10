package MOBLIMA.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import MOBLIMA.Listings.MovieListing;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.save.saveMovie;

public class removeMovieHandler {
    public boolean movieRemove() throws IOException {

        Scanner sc = new Scanner(System.in);

        // read data from database
        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename); // retrieve current array

        // intialitlizing valid movie and movie listings
        MovieListing showValidMovies = new MovieListing();
        ArrayList<Movie> validMovies = showValidMovies.getValidMovies();

        // display movies
        showValidMovies.displayListing();
        System.out.println("Select the movie you would like to remove: ");
        int removeMovieOption = sc.nextInt();
        if (removeMovieOption <= 0 || removeMovieOption > validMovies.size()) {
            System.out.println("Invalid option. Please try again");
            return false;
        }

        // setting movie as deleted
        Movie fromValidMovie = (Movie) validMovies.get(removeMovieOption - 1);
        Movie toDelete = (Movie) movieArray.get(fromValidMovie.getMovieId());
        System.out.println("Movie to remove: " + toDelete.getTitle());
        toDelete.setShowStatus(3); // setting show status to end of shows which deletes movies
        movieArray.set(toDelete.getMovieId(), toDelete);
        saveMovie.saveMovieArray(filename, movieArray);// overwrite file
        System.out.println(toDelete.getTitle() + " has been deleted");
        return true;

    }

}
