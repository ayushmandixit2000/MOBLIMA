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
        boolean flag;

        // read data from database
        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename); // retrieve current array

        // intialitlizing valid movie and movie listings
        MovieListing showValidMovies = new MovieListing();
        ArrayList<Movie> validMovies = showValidMovies.getValidMovies();

        // if movie list is empty
        if(validMovies.size()==0){
            showValidMovies.displayListing();
            return true;
        }

        int removeMovieOption = -1;
        
        // to prevent users from keying in data that is not string 
        do{
            try{
                // display movies
                showValidMovies.displayListing();
                System.out.println("Select the movie you would like to remove: ");
                removeMovieOption = (sc.nextInt());
                flag = false;
                if (removeMovieOption <= 0 || removeMovieOption > validMovies.size()) {
                    System.out.println("Invalid option. Please try again");
                    flag = true;
                }
                else{
                    flag = false;
                }
            }
            catch(Exception e){
                System.out.println("Inavlid input. Please enter intergers only.");
                sc.nextLine();
                flag = true;
            }
        }
        while(flag);
        sc.nextLine();

        // setting movie as deleted
        Movie fromValidMovie = (Movie) validMovies.get(removeMovieOption - 1);
        Movie toDelete = (Movie) movieArray.get(fromValidMovie.getMovieId());

        int confirmDelete = -1;
         // to prevent users from keying in data that is not string 
         do{
            try{
                System.out.println("Movie to remove: " + toDelete.getTitle());
                System.out.println("Confirm delete: \n1: Yes \n2: No");
                confirmDelete = (sc.nextInt());
                flag = false;
                if (confirmDelete <= 0 || confirmDelete > 2) {
                    System.out.println("Invalid option. Please try again");
                    flag = true;
                }
                else{
                    flag = false;
                }
            }
            catch(Exception e){
                System.out.println("Inavlid input. Please enter intergers only.");
                sc.nextLine();
                flag = true;
            }
        }
        while(flag);
        sc.nextLine();

        switch(confirmDelete){
            case 1:
            System.out.println("Deleting "+toDelete.getTitle()+" .......");
            toDelete.setShowStatus(3); // setting show status to end of shows which deletes movies
            movieArray.set(toDelete.getMovieId(), toDelete);
            saveMovie.saveMovieArray(filename, movieArray);// overwrite file
            System.out.println(toDelete.getTitle() + " has been deleted");
            break;

            case 2:
            System.out.println("Discarding changes.");
            break;
        }

        return true;

    }

}
