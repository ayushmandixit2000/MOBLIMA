package MOBLIMA.Listings;

import java.io.IOException;
import java.util.ArrayList;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.listing.Listing;
import MOBLIMA.retrieval.retrieveMovie;

public class MovieListing implements Listing {

    private ArrayList<Movie> validMovies;

    public MovieListing() throws IOException{
        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename); // retrieve current array
        this.validMovies = new ArrayList<Movie>(movieArray);
        this.validMovies.removeIf(Movie -> Movie.getIsDeleted() != 0); // create array with valid movies
    }

    public void displayListing() throws IOException {
        // retrieve movie list
        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename); // retrieve current array
        this.validMovies = new ArrayList<Movie>(movieArray);
        this.validMovies.removeIf(Movie -> Movie.getIsDeleted() != 0); // create array with valid movies

        // print movie list
        if(this.validMovies.size()==0){
            System.out.println("No movies available currently.");
        }
        else{
            System.out.println("Movies available: ");
            for(int i = 0; i<this.validMovies.size(); i++){
                Movie m = this.validMovies.get(i);
                System.out.println((i+1)+": "+m.getTitle());
            }
        }
    }

    // get valid movie array
    public ArrayList<Movie> getValidMovies() {
        return this.validMovies;
    }
    
}
