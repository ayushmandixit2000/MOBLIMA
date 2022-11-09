
import java.io.IOException;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.retrieval.retrieveMovieTicket;
import MOBLIMA.dataStructure.*;

import java.util.ArrayList;
import java.util.*;

public class top5SalesListing {
    
    public void displayListing() throws IOException 
    {
        String filename1 = "MOBLIMA/databases/movie.txt";
        String filename2 = "MOBLIMA/databases/movieTicket.txt";
        System.out.println("The top 5 movies are...");
        ArrayList movieObjects = retrieveMovie.readMovie(filename1); //this creates an array of movie objects
        ArrayList movieTickets = retrieveMovieTicket.readMovieTicket(filename2); //array of movie tickets
        int arraySize = movieObjects.size();
        titleSales[] salesTitle = new titleSales[100];
        //ArrayList<titleSales> salesTitle = new ArrayList<titleSales>(); //create array for the objects with title and sales number
        for(int i=0; i<arraySize; i++)
        {
            Movie m = (Movie) movieObjects.get(i); //pulls one movie object from the arraylist
            int salesNo = m.getSales();
            String title = m.getTitle();
            MovieTicket t = (MovieTicket) movieTickets.get(i);
            double price = t.getPrice();
            double totalsales = salesNo*price;
            int totalSales = (int)totalsales;
            titleSales newObject = new titleSales(title, totalSales);
            salesTitle[i] = newObject;
    }
    Arrays.sort(salesTitle);
    for(int j=0; j<5; j++)
    {
        System.out.println("Movie:" + salesTitle[j].getTitle() + " Total sales:" + salesTitle[j].getTotalSales());
    }
}
}

class titleSales implements Comparable<titleSales>
{
    private String title;
    private int totalSales;

    public titleSales(String title, int totalSales)
    {
        this.title = title;
        this.totalSales = totalSales;
    }

    public String getTitle()
    {
        return title;
    }

    public int getTotalSales()
    {
        return totalSales;
    }

    public int compareTo(titleSales o)
    {
        if(this.totalSales != o.getTotalSales())
        {
            return this.totalSales - o.getTotalSales();
        }
        return this.title.compareTo(o.getTitle());
    }
}