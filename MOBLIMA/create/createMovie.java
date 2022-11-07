package MOBLIMA.create;

import MOBLIMA.dataStructure.*;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.save.saveMovie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class createMovie {

    public createMovie() {
    }

    public boolean movieCreate() throws IOException {
            
        Scanner sc = new Scanner(System.in);

        // getting movie title
        System.out.print("Enter Movie Title: ");
        String movieTitle = sc.nextLine();

        // getting show status
        int showStatus = -1;
        boolean loop = true;
        while (loop) {
            System.out.println("Select Movie Status: \n1: Comming Soon \n2: Preview \n3: Now Showing \n4: End of Show");
            showStatus = (sc.nextInt());
            switch (showStatus) {
                case 1:
                case 2:
                case 3:
                case 4:
                    loop = false;
                    showStatus--;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        //getting director
        System.out.print("Enter Director: ");
        String director = sc.nextLine();
        sc.nextLine();
        
        // getting cast
        ArrayList<String> cast = new ArrayList<String>();
        String userInputCast;
        System.out.println("Enter each cast on a new line. Key in stop to complete the list of cast.");
        while (true){
            System.out.print("Cast: ");
            userInputCast = sc.nextLine();
            if(userInputCast.equals("stop")){
                break;
            }
            cast.add(userInputCast);
        }
        // converting arrayList to string
        String castString [] = cast.toArray(new String[cast.size()]);

        // getting synopsis
        System.out.print("Enter Synopsis: ");
        String synopsis = sc.nextLine();

        // getting movie rating
        int movieRating = -1;
        loop = true;
        while (loop) {
            System.out.println("Select Movie Rating: \n1: G \n2: PG \n3: M \n4: R16");
            movieRating = (sc.nextInt());
            switch (movieRating) {
                case 1:
                case 2:
                case 3:
                case 4:
                    loop = false;
                    movieRating--;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        // getting movie type
        int movieType = -1;
        loop = true;
        while (loop) {
            System.out.println("Select Movie Type: \n1: 3D \n2: Blockbuster ");
            movieType = (sc.nextInt());
            switch (movieType) {
                case 1:
                case 2:
                    loop = false;
                    movieType--;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }


        // creating movie class. MovieID, MovieRating, sales set to 0 for time being
        Movie movieAdmin = new Movie(5, movieTitle, showStatus, director, castString, synopsis, movieRating,movieType, 0);

        // pushing movie into database
        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename); // retrieve current array
        movieArray.add(movieAdmin);
        saveMovie.saveMovieArray(filename, movieArray);// overwrite file
        return true;
    }

}
