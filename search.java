
import java.util.Scanner;
import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;

import MOBLIMA.dataStructure.Movie;
import MOBLIMA.retrieval.retrieveMovie;

public class search {

    public void findmovie() throws IOException {
        Scanner scc = new Scanner(System.in);
        System.out.println("\nPlease key in the movie you would like to inquire about: ");
        String movie1 = scc.next();
        String movie = movie1.toLowerCase();
        boolean found = false;
        String movieid = "";

        

        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename);
        List<Movie> optionlist=new ArrayList<Movie>();

        for (int i = 0; i < movieArray.size(); i++) {
            Movie m1 = (Movie) movieArray.get(i);
            String m = m1.getTitle().toLowerCase();
            found = m.contains(movie);
            if(found == true){
                optionlist.add(m1);
                found = false;
            }
        }

        if (optionlist.size() == 0) {
            System.out.println("No Movie Found...");
            return;
        }

        else{
            System.out.println("\nPlease Select the movie based on the options found (enter number): ");
            for(int j = 0; j < optionlist.size(); j++){
                Movie m2 = (Movie) optionlist.get(j);
                System.out.println(j+1 + " : " + m2.getTitle());
            }

            

            int movie_chosen = scc.nextInt();
            for(int j = 0; j < optionlist.size(); j++){
                if(movie_chosen == j+1){
                    Movie m3 = (Movie) optionlist.get(j);
                    System.out.println("\nYou have Selected: " + m3.getTitle());

                    
                    MovieDetailsListing moviedetails = new MovieDetailsListing();
                    moviedetails.setmovie(m3);
                    moviedetails.displayListing();
                    
                }
            }

        }
        
        // view movie details option from here

        Integer chosenmovie = 1; // add user input id here

        detailmovie mov = new detailmovie();
        mov.specify(chosenmovie);
    }
}
