package MOBLIMA.handler;

import MOBLIMA.dataStructure.*;
import MOBLIMA.listing.movieListing;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.save.saveMovie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;
import java.util.Hashtable;

/**
 * Helper class to create a movie with the admin's input
 */
public class createMovieHandler {
    /**
     * Display the options users have and to instantantiate related classes and
     * execute their required functionalities.
     */
    /**
     * Displays the current movies and gets user's option to edit each attribute of
     * the movie, confirms the detail and saves it into the movie database.
     * Validates the admin inputs.
     * 
     * @return The status of the movie creation process.
     */
    public boolean movieCreate() throws IOException {

        Scanner sc = new Scanner(System.in);
        boolean flag;

        // showing current movies
        movieListing showValidMovies = new movieListing(true);
        showValidMovies.displayListing();

        // getting list of all movies
        movieListing allMovies = new movieListing(false);
        ArrayList<Movie> moviesAll = allMovies.getValidMovies();

        // getting movie title
        boolean isRepeat;
        System.out.print("Enter new movie title: ");
        String movieTitle = sc.nextLine();

        while (movieTitle.isBlank() || movieTitle.isEmpty()) {
            System.out.println("Input cannot be empty. Please key in a valid input.");
            System.out.print("Enter new movie title: ");
            movieTitle = sc.nextLine();
        }

        // checking for duplicate movie
        for(int i = 0; i<moviesAll.size(); i++){
            if(moviesAll.get(i).getTitle().equalsIgnoreCase(movieTitle)){
                System.out.println("Movie already exists.");
                System.out.println("Returning to main menu....");
                System.out.println();
                return false;
            }
        }


        // getting show status
        Dictionary status = new Hashtable();
        status.put(0, "Coming Soon");
        status.put(1, "Preview");
        status.put(2, "Now Showing");
        int showStatus = -1;
        boolean loop = true;
        while (loop) {
            // to prevent users from keying in data that is not string
            do {
                try {
                    System.out.println("Select Movie Status: \n1: Comming Soon \n2: Preview \n3: Now Showing");
                    showStatus = (sc.nextInt());
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Inavlid input. Please enter intergers only.");
                    sc.nextLine();
                    flag = true;
                }
            } while (flag);
            sc.nextLine();
            switch (showStatus) {
                case 1:
                case 2:
                case 3:
                    loop = false;
                    showStatus--;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        // getting director
        System.out.print("Enter Director: ");
        String director = sc.nextLine();
        while (director.isBlank() || director.isEmpty()) {
            System.out.println("Input cannot be empty. Please key in a valid input.");
            System.out.print("Enter Director: ");
            director = sc.nextLine();
        }

        // getting cast
        ArrayList<String> cast = new ArrayList<String>();
        String userInputCast;
        System.out.println("Enter each cast on a new line. Key in 'stop' to complete the list of cast.");
        while (true) {
            System.out.print("Cast: ");
            userInputCast = sc.nextLine();

            // error handling for empty inputs
            while (userInputCast.isBlank() || userInputCast.isEmpty()) {
                System.out.println("Input cannot be empty. Please key in a valid input.");
                System.out.print("Cast: ");
                userInputCast = sc.nextLine();
            }

            // breaking out of loop when user keys in stop
            if (userInputCast.toLowerCase().equals("stop")) {
                if (cast.size() == 0) {
                    System.out.println("Cast list cannot be empty. Please insert casts.");
                } else {
                    break;
                }
            }

            // add cast only if it's a unique value
            if (cast.contains(userInputCast)) {
                System.out.println("Cast has already been entered.");
            } else {
                cast.add(userInputCast);
            }
        }
        // converting arrayList to string
        String castString[] = cast.toArray(new String[cast.size()]);

        // getting synopsis
        System.out.print("Enter synopsis: ");
        String synopsis = sc.nextLine();
        while (synopsis.isBlank() || synopsis.isEmpty()) {
            System.out.println("Input cannot be empty. Please key in a valid input.");
            System.out.print("Enter synopsis: ");
            synopsis = sc.nextLine();
        }

        // getting movie rating
        Dictionary rating = new Hashtable();
        rating.put(0, "G");
        rating.put(1, "PG");
        rating.put(2, "PG13");
        rating.put(3, "NC16");
        rating.put(4, "M18");
        rating.put(5, "R21");
        int movieRating = -1;
        loop = true;
        while (loop) {

            // only allows users to key integer values
            do {
                try {
                    System.out.println("Select Movie Rating: \n1: G \n2: PG \n3: PG13 \n4: NC16 \n5: M18 \n6: R21");
                    movieRating = (sc.nextInt());
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Inavlid input. Please enter intergers only.");
                    sc.nextLine();
                    flag = true;
                }
            } while (flag);
            sc.nextLine();

            switch (movieRating) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    loop = false;
                    movieRating--;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        // getting movie type
        Dictionary type = new Hashtable();
        type.put(0, "3D");
        type.put(1, "Blockbuster");
        type.put(2, "2D");
        int movieType = -1;
        loop = true;
        while (loop) {
            // only allows users to key integer values
            do {
                try {
                    System.out.println("Select Movie Type: \n1: 3D \n2: Blockbuster \n3: 2D ");
                    movieType = (sc.nextInt());
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Inavlid input. Please enter intergers only.");
                    sc.nextLine();
                    flag = true;
                }
            } while (flag);
            sc.nextLine();

            switch (movieType) {
                case 1:
                case 2:
                case 3:
                    loop = false;
                    movieType--;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        // creating movie class. MovieID, MovieRating, sales set to 0 for time being
        Movie movieAdmin = new Movie(5, movieTitle, showStatus, director, castString, synopsis, movieRating, movieType,
                0);

        // confirmation of movie
        System.out.println("Movie details:");
        System.out.println("Movie title: " + movieAdmin.getTitle());
        System.out.println("Show Status: " + status.get(movieAdmin.getShowStatus()));
        System.out.println("Director: " + movieAdmin.getDirector());
        for (int i = 0; i < movieAdmin.getCast().length; i++) {
            System.out.println((i + 1 + ") Cast: " + movieAdmin.getCast()[i]));
        }
        System.out.println("Synopsis: " + synopsis);
        System.out.println("Movie rating: " + rating.get(movieAdmin.getMovieRating()));
        System.out.println("Movie type: " + type.get(movieAdmin.getMovieType()));

        loop = true;
        int optionConfirm = -1;
        while (loop) {
            // only allows users to key integer values
            do {
                try {
                    System.out.println("Please confirm if you would like to create the movie. \n1: Yes \n2: No");
                    optionConfirm = (sc.nextInt());
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Inavlid input. Please enter intergers only.");
                    sc.nextLine();
                    flag = true;
                }
            } while (flag);
            sc.nextLine();

            switch (optionConfirm) {
                case 1:
                    loop = false;
                    System.out.println("Creating " + movieAdmin.getTitle() + ".....");
                    System.out.println();
                    break;
                case 2:
                    return false;

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }

        // pushing movie into database
        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename); // retrieve current array
        movieArray.add(movieAdmin);
        saveMovie.saveMovieArray(filename, movieArray);// overwrite file
        System.out.println(movieAdmin.getTitle() + " has been created.");
        System.out.println();
        return true;
    }

}
