package MOBLIMA.handler;

import MOBLIMA.dataStructure.*;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.save.saveMovie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import MOBLIMA.Listings.MovieListing;

public class updateMovieHandler {
    public boolean movieUpdate() throws IOException {
        Scanner sc = new Scanner(System.in);

        // retrieve movie list
        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename); // retrieve current array

        // intialitlizing valid movie and movie listings
        MovieListing showValidMovies = new MovieListing();
        ArrayList<Movie> validMovies = showValidMovies.getValidMovies();
        int numbOfMovies= validMovies.size();

        boolean loop = true;
        boolean flag;

        // generating menu to select movie to update
        int movieOption = -1;
        while (loop) {
            // to prevent users from keying in data that is not string 
            do{
                try{
                    showValidMovies.displayListing();
                    System.out.println("Select movie to edit: ");
                    movieOption = sc.nextInt();
                    flag = false;
                }
                catch(Exception e){
                    System.out.println("Inavlid input. Please enter intergers only... "+e);
                    sc.nextLine();
                    flag = true;
                }
            }
            while(flag);
            sc.nextLine();

            if (movieOption > 0 && movieOption <= numbOfMovies) {
                loop = false;
            }
            // error handling if input is invalid
            System.out.println("Invalid Option. Please try again");
        }

        Movie editMovie = (Movie) validMovies.get(movieOption - 1);
        System.out.println();
        System.out.println("You have selected: " + editMovie.getTitle());

        // generating menu to edit
        loop = true;
        int editOption = -1;
        String newTitle;
        while (loop) {

            // to prevent users from keying in data that is not string 
            do{
                try{
                    System.out.println("Select field to edit: ");
                    System.out.println("1: Movie Title \n2: Show Status \n3: Director \n4: Cast \n5: Synopsis \n6: Movie Rating \n7: Movie Type \n8: Confirm Changes");
                    editOption = sc.nextInt();
                    flag = false;
                }
                catch(Exception e){
                    System.out.println("Inavlid input. Please enter intergers only... "+e);
                    sc.nextLine();
                    flag = true;
                }
            }
            while(flag);
            sc.nextLine();

            switch (editOption) {
                case 1:
                    System.out.println("Edit movie title selected. \nCurrent movie title: " + editMovie.getTitle());
                    System.out.println("New Title: ");
                    newTitle = sc.nextLine();

                    // error handling if title is empty
                    while(newTitle.isBlank() || newTitle.isEmpty()){
                        System.out.println("Input cannot be empty. Please try again");
                        System.out.println("New Title: ");
                        newTitle = sc.nextLine();
                    }

                    editMovie.setTitle(newTitle);
                    break;

                case 2:
                    System.out.println("Edit show status selected.");
                    int curShowStatus = editMovie.getShowStatus();
                    switch (curShowStatus) {
                        case 0:
                            System.out.println("Current show status: Coming Soon");
                            break;
                        case 1:
                            System.out.println("Current show status: Preview");
                            break;
                        case 2:
                            System.out.println("Current show status: Now Showing");
                            break;
                        case 3:
                            System.out.println("Current show status: End of Show");
                            break;
                    }

                    boolean statusLoop = true;
                    int newShowStatus = -1;
                    while (statusLoop) {
                        // to prevent users from keying in data that is not string 
                        do{
                            try{
                                System.out.println("Select new movie Status: \n1: Comming Soon \n2: Preview \n3: Now Showing");
                                newShowStatus = (sc.nextInt());
                                flag = false;
                            }
                            catch(Exception e){
                                System.out.println("Inavlid input. Please enter intergers only... "+e);
                                sc.nextLine();
                                flag = true;
                            }
                        }
                        while(flag);
                        sc.nextLine();

                        switch (newShowStatus) {
                            case 1:case 2:case 3:
                                newShowStatus--;
                                statusLoop = false;
                                editMovie.setShowStatus(newShowStatus);
                                break;

                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }
                    break;

                case 3:
                    String newDirector;
                    System.out.println("Edit director selected. \nCurrent director: " + editMovie.getDirector());
                    System.out.println("Enter new director: ");
                    newDirector = sc.nextLine();

                    // to prevent empty string
                    while(newDirector.isBlank() || newDirector.isEmpty()){
                        System.out.println("Input cannot be empty. Please try again");
                        System.out.println("Enter new director: ");
                        newDirector = sc.nextLine();
                    }
                    
                    editMovie.setDirector(newDirector);
                    break;

                case 4:
                    boolean castLoop = true;
                    int editCastOption = -1;
                    List<String> cast = new ArrayList<String>(Arrays.asList(editMovie.getCast()));
                    while (castLoop) {
                        // to prevent users from keying in data that is not string 
                        do{
                            try{
                                System.out.println("Edit cast selected. Select option:\n1: Edit cast \n2: Add cast \n3: Remove cast \n4: Confirm Changes");
                                editCastOption = sc.nextInt();
                                flag = false;
                            }
                            catch(Exception e){
                                System.out.println("Inavlid input. Please enter intergers only... "+e);
                                sc.nextLine();
                                flag = true;
                            }
                        }
                        while(flag);
                        sc.nextLine();

                        switch (editCastOption) {
                            case 1:
                                int optionSelectCast = 1;

                                // erorr handling if cast list is empty
                                if (cast.size() == 0) {
                                    System.out.println("Invalid option. Cast list is empty.");
                                    break;
                                }
                                
                                // error handling if input is not integer
                                do{
                                    try{
                                        System.out.println("Current cast:");
                                        for (int i = 0; i < cast.size(); i++) {
                                            System.out.println((i + 1) + ": " + cast.get(i));
                                        }
                                        System.out.println("Cast to edit: ");
                                        optionSelectCast = sc.nextInt();
                                        flag = false;
                                    }
                                    catch(Exception e){
                                        System.out.println("Inavlid input. Please enter intergers only... "+e);
                                        sc.nextLine();
                                        flag = true;
                                    }
                                }
                                while(flag);
                                sc.nextLine();

                                if (optionSelectCast > 0 && optionSelectCast <= cast.size()) {
                                    System.out.println("Selected cast: " + cast.get(optionSelectCast - 1));
                                    System.out.println("Enter new cast: ");
                                    String newCast = sc.nextLine();

                                    // error handling for empty input
                                    while(newCast.isBlank() || newCast.isEmpty()){
                                        System.out.println("Input cannot be empty. Please try again.");
                                        System.out.println("Enter new cast: ");
                                        newCast = sc.nextLine();
                                    }
                                    // error handling for added cast
                                    if(cast.contains(newCast)){
                                        System.out.println("Cast is already on the list.");
                                    }
                                    else{
                                    cast.set(optionSelectCast - 1, newCast);
                                    }
                                } 
                                // error handling for incorrect cast
                                else {
                                    System.out.println("Incorrect option. Please try again.");
                                }
                                break;

                            case 2:
                                // print current cast list only if cast list is not empty
                                if(cast.size()!=0){
                                    System.out.println("Current cast:");
                                    for (int i = 0; i < cast.size(); i++) {
                                        System.out.println((i + 1) + ": " + cast.get(i));
                                    }
                                }
                                else{
                                    System.out.println("Current cast list is empty.");
                                }

                                System.out.println("Enter new cast: ");
                                String newCast = sc.nextLine();

                                // error handling for empty input
                                while(newCast.isBlank() || newCast.isEmpty()){
                                    System.out.println("Input cannot be empty. Please try again.");
                                    System.out.println("Enter new cast: ");
                                    newCast = sc.nextLine();
                                }
                                // error handling for added cast
                                if(cast.contains(newCast)){
                                    System.out.println("Cast is already on the list.");
                                }
                                else{
                                    cast.add(newCast);
                                }
                                break;

                            case 3:
                                // error handling for empty cast list
                                if (cast.size() == 0) {
                                    System.out.println("Invalid option. Cast list is empty.");
                                    break;
                                }

                                int removeOptionCast = -1;
                                // to prevent users from keying in data that is not string 
                                do{
                                    try{
                                        System.out.println("Current cast:");
                                        for (int i = 0; i < cast.size(); i++) {
                                            System.out.println((i + 1) + ": " + cast.get(i));
                                        }
                                        System.out.println("Cast to remove: ");
                                        removeOptionCast = sc.nextInt();
                                        flag = false;
                                    }
                                    catch(Exception e){
                                        System.out.println("Inavlid input. Please enter intergers only... "+e);
                                        sc.nextLine();
                                        flag = true;
                                    }
                                }
                                while(flag);
                                sc.nextLine();

                                if (removeOptionCast > 0 && removeOptionCast <= cast.size()) {
                                    cast.remove(removeOptionCast - 1);
                                } 
                                // error handling for option that exceeds range
                                else {
                                    System.out.println("Invalid option. Please try again.");
                                }
                                break;

                            case 4:
                            boolean loop1 = true;
                            while(loop1){
                                if(cast.size()!=0){
                                    System.out.println("Upated cast list: ");
                                    for(int i = 0; i<cast.size(); i++){
                                        System.out.println((i+1)+"): " + cast.get(i));
                                    }
                                }
                                else{
                                    System.out.println("Cast list is empty.");
                                    System.out.println("Please enter a cast: ");
                                    String oneCast = sc.nextLine();

                                    // to prevent empty cast
                                    while(oneCast.isEmpty() || oneCast.isBlank()){
                                        System.out.println("Invalid input. Input cannot be empty");
                                        System.out.println("Cast: ");
                                        oneCast = sc.nextLine();
                                    }
                                    cast.add(oneCast);
                                    System.out.println("Upated cast list: ");
                                    for(int i = 0; i<cast.size(); i++){
                                        System.out.println((i+1)+"): " + cast.get(i));
                                    }

                                }

                                int optionConfirm = -1;
                                // to prevent users from keying in data that is not string 
                                do{
                                    try{
                                        System.out.println("Select your option to confirm changes. \n1: Yes \n2: No");
                                        optionConfirm = sc.nextInt();
                                        flag = false;
                                    }
                                    catch(Exception e){
                                        System.out.println("Inavlid input. Please enter intergers only... "+e);
                                        sc.nextLine();
                                        flag = true;
                                    }
                                }
                                while(flag);
                                sc.nextLine();

                                switch(optionConfirm){
                                    case 1:
                                    System.out.println("Upading cast......");
                                    editMovie.setCast(cast.toArray(new String[0]));
                                    System.out.println("Cast updated.");
                                    loop1 = false;
                                    castLoop = false;
                                    break;
                                    case 2:
                                    loop1 = false;
                                    castLoop = false;
                                    System.out.println("No chnages were made.");
                                    break;

                                    default:
                                    System.out.println("Incorrect option. Please try again.");
                                }
                            }
                            break;
                            default:
                            System.out.println("Invalid option. Please try again.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Edit synopsis selected. Current synopsis: " + editMovie.getSynopsis());
                    System.out.println("Enter new synopsis: ");
                    editMovie.setSynopsis(sc.nextLine());
                    break;

                case 6:
                    System.out.println("Edit movie rating.");
                    int curMovieRating = editMovie.getMovieRating();
                    switch (curMovieRating) {
                        case 0:
                            System.out.println("Current movie rating: G");
                            break;
                        case 1:
                            System.out.println("Current movie rating: PG");
                            break;
                        case 2:
                            System.out.println("Current movie rating: M");
                            break;
                        case 3:
                            System.out.println("Current movie rating: R16");
                    }
                    int newMovieRating = -1;
                    boolean movieRatingLoop = true;
                    while (movieRatingLoop) {
                        System.out.println("Select Movie Rating: \n1: G \n2: PG \n3: M \n4: R16");
                        newMovieRating = (sc.nextInt());
                        switch (newMovieRating) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                newMovieRating--;
                                movieRatingLoop = false;
                                break;

                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }
                    editMovie.setMovieRating(newMovieRating);
                    break;

                case 7:
                    System.out.println("Edit movie type.");
                    int curMovieType = editMovie.getMovieType();
                    switch (curMovieType) {
                        case 0:
                            System.out.println("Current movie status: 3D");
                            break;
                        case 1:
                            System.out.println("Current movie status: Blockbuster");
                            break;
                    }
                    int newMovieType = -1;
                    boolean movieTypeLoop = true;
                    while (movieTypeLoop) {
                        System.out.println("Select new movie type: \n1: 3D \n2: Blockbuster");
                        newMovieType = sc.nextInt();
                        switch (newMovieType) {
                            case 1:
                            case 2:
                                newMovieType--;
                                movieTypeLoop = false;
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }
                    editMovie.setMovieType(newMovieType);
                    break;

                case 8:
                    loop = false;
                    movieArray.set(editMovie.getMovieId(), editMovie);
            }

        }

        // push to database
        saveMovie.saveMovieArray(filename, movieArray);// overwrite file
        return true;
    }

}
