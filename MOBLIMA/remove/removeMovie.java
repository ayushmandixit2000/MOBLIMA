package MOBLIMA.remove;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.save.saveMovie;


public class removeMovie {

    public removeMovie(){};

    public boolean movieRemove() throws IOException{
        
        Scanner sc = new Scanner(System.in);

        // read data from database
        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename); // retrieve current array
        ArrayList<Movie> validMovies = new ArrayList<Movie>(movieArray);
        validMovies.removeIf(Movie->Movie.getIsDeleted()!=0);

        // display movies
        System.out.println("Select the movie you would like to remove: ");
        for(int i = 0; i<validMovies.size(); i++){
            Movie m = (Movie)validMovies.get(i);
            System.out.println((i+1+": "+m.getTitle()));
        }
        int removeMovieOption = sc.nextInt();
        if(removeMovieOption<=0 || removeMovieOption>validMovies.size()){
            System.out.println("Invalid option. Please try again");
            return false;
        }

        // setting movie as deleted
        Movie fromValidMovie = (Movie)validMovies.get(removeMovieOption-1);
        Movie toDelete = (Movie)movieArray.get(fromValidMovie.getMovieId());
        System.out.println("Movie to remove: "+toDelete.getTitle());
        toDelete.setShowStatus(3); //setting show status to end of shows which deletes movies
        movieArray.set(toDelete.getMovieId(), toDelete);
        saveMovie.saveMovieArray(filename, movieArray);// overwrite file
        System.out.println(toDelete.getTitle()+" has been deleted");
        return true;

    }
    
    
}
