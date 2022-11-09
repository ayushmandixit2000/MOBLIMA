package MOBLIMA.update;


import MOBLIMA.dataStructure.*;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.save.saveMovie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class updateMovie{

    public updateMovie(){   
    }

    public boolean movieUpdate() throws IOException{
        Scanner sc = new Scanner(System.in);
        int movieOption = -1;
        int numbOfMovies;
        boolean loop = true;

        // retrieve movie list
        String filename = "MOBLIMA/databases/movie.txt";
        ArrayList movieArray = retrieveMovie.readMovie(filename); // retrieve current array
        ArrayList<Movie> validMovies = new ArrayList<Movie>(movieArray);
        validMovies.removeIf(Movie->Movie.getIsDeleted()!=0);
        numbOfMovies = validMovies.size();

        // generating menu to select movie to update
        while(true){
            System.out.println("Select movie to edit: ");
            for(int i = 0; i < numbOfMovies; i++){
                Movie m = (Movie)validMovies.get(i);
                System.out.println((i+1) + ": " + m.getTitle());
            }
            movieOption = sc.nextInt();
            if(movieOption>0 && movieOption <= numbOfMovies){
                break;
            }
            System.out.println("Invalid Option. Please try again");
        }

        Movie editMovie = (Movie)validMovies.get(movieOption-1);
        System.out.println("You have selected: " + editMovie.getTitle());

        // generating menu to edit
        while(loop){
            System.out.println("Select field to edit: ");
            System.out.println("1: Movie Title \n2: Show Status \n3: Director \n4: Cast \n5: Synopsis \n6: Movie Rating \n7: Movie Type \n8: Quit");
            int editOption = sc.nextInt();
            sc.nextLine();
            switch(editOption){
                case 1:
                System.out.println("Edit movie title selected. \nCurrent movie title: " + editMovie.getTitle());
                System.out.println("New Title: ");
                editMovie.setTitle(sc.nextLine());
                break;

                case 2:
                System.out.println("Edit show status selected.");
                int curShowStatus = editMovie.getShowStatus();
                switch(curShowStatus){
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
                while (statusLoop) {
                System.out.println("Select new movie Status: \n1: Comming Soon \n2: Preview \n3: Now Showing \n4: End of Show");
                int newShowStatus = (sc.nextInt());
                switch (newShowStatus) {
                    case 1: case 2: case 3: case 4:
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
                System.out.println("Edit director selected. Current director: " + editMovie.getDirector());
                System.out.println("Enter new director: ");
                editMovie.setDirector(sc.nextLine());
                break;

                case 4:
                boolean castLoop = true;
                List<String> cast =  new ArrayList<String>(Arrays.asList(editMovie.getCast()));
                while(castLoop){
                    System.out.println("Edit cast selected. Select option:\n1: Edit cast \n2: Add cast \n3: Remove cast \n4: Quit");
                    int editCastOption = sc.nextInt();
                    sc.nextLine();
                    switch(editCastOption){
                        case 1:
                        if(cast.size()==0){
                            System.out.println("Invalid option. Cast list is empty.");
                            break;
                        }
                        for(int i = 0; i<cast.size(); i++){
                            System.out.println((i+1)+": "+ cast.get(i));
                        }
                        System.out.println("Cast to edit: ");
                        int optionSelectCast = sc.nextInt();
                        sc.nextLine();
                        if(optionSelectCast>0 && optionSelectCast<=cast.size()){
                            System.out.println("Selected cast: " + cast.get(optionSelectCast-1));
                            System.out.println("Enter new cast: ");
                            cast.set(optionSelectCast-1, sc.nextLine());
                        }
                        else{
                            System.out.println("Incorrect option. Please try again.");
                        }
                        break;

                        case 2:
                        System.out.println("Enter new cast: ");
                        String newCast = sc.nextLine();
                        cast.add(newCast);
                        break;

                        case 3:
                        if(cast.size()==0){
                            System.out.println("Invalid option. Cast list is empty.");
                            break;
                        }
                        for(int i = 0; i<cast.size(); i++){
                            System.out.println((i+1)+": "+ cast.get(i));
                        }
                        System.out.println("Cast to remove: ");
                        int removeOptionCast = sc.nextInt();
                        if(removeOptionCast>0 && removeOptionCast<=cast.size()){
                            cast.remove(removeOptionCast-1);
                        }
                        else{
                            System.out.println("Invalid option. Please try again.");
                        }
                        break;

                        case 4:
                        editMovie.setCast(cast.toArray(new String[0]));
                        castLoop = false;
                        break;

                        default:
                        System.out.println("Invalid option. Please try again.");
                    } 
                }
                break;

                case 5:
                System.out.println("Edit synopsis selected. Current synopsis: "+ editMovie.getSynopsis());
                System.out.println("Enter new synopsis: ");
                editMovie.setSynopsis(sc.nextLine());
                break;

                case 6:
                System.out.println("Edit movie rating.");
                int curMovieRating = editMovie.getMovieRating();
                switch(curMovieRating){
                    case 0: System.out.println("Current movie rating: G");
                    break;
                    case 1: System.out.println("Current movie rating: PG");
                    break;
                    case 2: System.out.println("Current movie rating: M");
                    break;
                    case 3: System.out.println("Current movie rating: R16");
                }
                int newMovieRating = -1;
                boolean movieRatingLoop = true;
                while(movieRatingLoop){
                    System.out.println("Select Movie Rating: \n1: G \n2: PG \n3: M \n4: R16");
                    newMovieRating = (sc.nextInt());
                    switch(newMovieRating){
                        case 1: case 2: case 3: case 4:
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
                switch(curMovieType){
                    case 0:
                    System.out.println("Current movie status: 3D");
                    break;
                    case 1:
                    System.out.println("Current movie status: Blockbuster");
                    break;
                }
                int newMovieType = -1;
                boolean movieTypeLoop = true;
                while(movieTypeLoop){
                    System.out.println("Select new movie type: \n1: 3D \n2: Blockbuster");
                    newMovieType = sc.nextInt();
                    switch(newMovieType){
                    case 1: case 2:
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

