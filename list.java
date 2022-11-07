import java.util.Scanner;
import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;

import MOBLIMA.dataStructure.Movie;
import MOBLIMA.retrieval.retrieveMovie;

public class list {

    public void show() throws IOException {
        Scanner scc = new Scanner(System.in); 
        System.out.println("Here are all the movies: ");

        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename);
        for (int i = 0; i < movieArray.size(); i++) {
            Movie m1 = (Movie) movieArray.get(i);
            System.out.println(i + 1 + ": " + m1.getTitle());
        }

        System.out.println("Please select a movie to find out more!, press 0 to exit");
        int opt = scc.nextInt();

        if(opt == 0){
            return;
        }

        for (int i = 0; i < movieArray.size(); i++) {
            if(i+1 == opt){
                Movie m2 = (Movie) movieArray.get(i);
                System.out.println("Movie Selected: " + m2.getTitle());
                MovieDetailsListing moviedetails = new MovieDetailsListing();
                moviedetails.setmovie(m2);
                moviedetails.displayListing();
            }

        }

        
    }

}
