package MOBLIMA.listing;

import java.io.IOException;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.dataStructure.Movie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class top5RatingListing {

    private Movie m1;

    public void displayListing() throws IOException {
        Scanner scc = new Scanner(System.in);
        String filename1 = "MOBLIMA/databases/movie.txt";
        System.out.println("The top 5 movies are...");
        ArrayList movieObjects = retrieveMovie.readMovie(filename1); // this creates an array of movie objects
        int arraySize = movieObjects.size();
        // titleRatings[] ratingsTitle = new titleRatings[100];
        // create array for the objects with title and ratings number
        ArrayList<titleRatings> ratingsTitle = new ArrayList<titleRatings>();
        for (int i = 0; i < arraySize; i++) {
            Movie m = (Movie) movieObjects.get(i); // pulls one movie object from the arraylist
            String title = m.getTitle();
            double rating = m.getAvgRating();
            if (m.getNumReviews() >= 1 && m.getIsDeleted() == 0) {
                titleRatings newObject = new titleRatings(title, rating);
                ratingsTitle.add(newObject);
            }
        }

        String [] ids = new String[5];
        Collections.sort(ratingsTitle,
                Comparator.comparingDouble(titleRatings::getRating));

        int count = 0;
        if (ratingsTitle.size() < 5) {
            int num = 1;
            for (int j = ratingsTitle.size() -1 ; j > -1; j--) {
                System.out.println(
                    num + ":   Rated: [" + ratingsTitle.get(j).getRating() + "]     " + ratingsTitle.get(j).getTitle());
                    ids[num-1] = ratingsTitle.get(j).getTitle();
                    num++;
            }
            count = num;
        } else {
            int num = 1;
            for (int j = ratingsTitle.size()-1; j > ratingsTitle.size() - 6; j--) {
                System.out.println(
                    num + ":   Rated: [" + ratingsTitle.get(j).getRating() + "]     " + ratingsTitle.get(j).getTitle());
                    ids[num-1] = ratingsTitle.get(j).getTitle();
                    num++;
            }
            count = num;
        }

        System.out.println("Would you like to continue with a movie?");
        System.out.println("1: Yes");
        System.out.println("2: No");

        int additionalopt;

        while (true) {
            String input = scc.next();
            additionalopt = 0;
            try {
                additionalopt = Integer.parseInt(input);
                if (additionalopt > 2 || additionalopt < 1) {
                    System.out.println("Please key in a valid number!");
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ne) {
                System.out.println("Please key in a number only!");
            }
        }

        if(additionalopt == 1){
            System.out.println("Please select a movie you want to find out more about (enter the number beside the movie)");

            int additional;

            while (true) {
                String input = scc.next();
                additional = 0;
                try {
                    additional = Integer.parseInt(input);
                    if (additional > count || additional < 1) {
                        System.out.println("Please key in a valid number!");
                        continue;
                    } else {
                        break;
                    }
                } catch (NumberFormatException ne) {
                    System.out.println("Please key in a number only!");
                }
            }

            String titlechosen = ids[additional-1];


            String filename = "MOBLIMA/databases/movie.txt";
            ArrayList movieArray = retrieveMovie.readMovie(filename);
            for (int i = 0; i < movieArray.size(); i++) {
                Movie m = (Movie) movieArray.get(i);
                if(m.getTitle().equalsIgnoreCase(titlechosen)){
                    this.m1 = m;
                }
            }
        }

    }

    public Movie getmovie(){
        return this.m1;
    }

}

class titleRatings implements Comparable<titleRatings> {
    private String title;
    private double rating;

    public titleRatings(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public int compareTo(titleRatings o) {
        /*
         * if(this.rating != o.getRating())
         * {
         * return (Double)(this.rating - o.getRating());
         * }
         */
        return this.title.compareTo(o.getTitle());
    }
}
