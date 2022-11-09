import java.io.IOException;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.dataStructure.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class top5RatingListing {
    public void displayListing() throws IOException 
    {
        String filename1 = "MOBLIMA/databases/movie.txt";
        System.out.println("The top 5 movies are...");
        ArrayList movieObjects = retrieveMovie.readMovie(filename1); //this creates an array of movie objects
        int arraySize = movieObjects.size();
        //titleRatings[] ratingsTitle = new titleRatings[100];
       //create array for the objects with title and ratings number
       ArrayList<titleRatings> ratingsTitle = new ArrayList<titleRatings>();
        for(int i=0; i<arraySize; i++)
        {
            Movie m = (Movie) movieObjects.get(i); //pulls one movie object from the arraylist
            String title = m.getTitle();
            double rating = m.getAvgRating();
            if(m.getNumReviews() >= 1)
            {
                titleRatings newObject = new titleRatings(title, rating); 
                ratingsTitle.add(newObject);
            }
    }
    Collections.sort(ratingsTitle,
                         Comparator.comparingDouble(titleRatings::getRating));

    for(int j=0; j<5; j++)
    {
        System.out.println("Movie:" + ratingsTitle.get(j).getTitle() + " Total sales:" + ratingsTitle.get(j).getRating());
    }
}

}

class titleRatings implements Comparable<titleRatings>
{
    private String title;
    private double rating;

    public titleRatings(String title, double rating)
    {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle()
    {
        return title;
    }

    public double getRating()
    {
        return rating;
    }

    public int compareTo(titleRatings o)
    {
        /*if(this.rating != o.getRating())
        {
            return (Double)(this.rating - o.getRating());
        }*/
        return this.title.compareTo(o.getTitle());
    }
}

