package MOBLIMA.listing;

import java.io.IOException;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.retrieval.retrieveMovieTicket;
import MOBLIMA.dataStructure.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class top5SalesListing {

    public void displayListing() throws IOException {

        String filename1 = "MOBLIMA/databases/movie.txt";
        String filename2 = "MOBLIMA/databases/movieTicket.txt";
        System.out.println("The top 5 movies are...");
        ArrayList movieObjects = retrieveMovie.readMovie(filename1); // this creates an array of movie objects
        //ArrayList movieTickets = retrieveMovieTicket.readMovieTicket(filename2); // array of movie tickets
        int arraySize = movieObjects.size();
        
        ArrayList<titleSales> salesTitle = new ArrayList<titleSales>(); // create array for the objects with title and                                                               // sales number
        for (int i = 0; i < arraySize; i++) {
            Movie m = (Movie) movieObjects.get(i); // pulls one movie object from the arraylist
            int salesNo = m.getSales();
            String title = m.getTitle();
            //MovieTicket t = (MovieTicket) movieTickets.get(i);
            // int totalSales = (int)totalsales;
            if(m.getIsDeleted() == 0){
                titleSales newObject = new titleSales(title, salesNo);
                // salesTitle[i] = newObject;
                salesTitle.add(newObject);
            }
        }
        // Arrays.sort(salesTitle);
        Collections.sort(salesTitle,
                Comparator.comparingDouble(titleSales::getTotalSales));
        
            if (salesTitle.size() < 5) {
            int num = 1;
            for (int j = salesTitle.size() -1 ; j > -1; j--) {
                System.out.println(
                    num + ":   Sales: [$" + salesTitle.get(j).getTotalSales() + ".00]\t" + salesTitle.get(j).getTitle());
                    num++;
            }
        } else {
            int num1 = 1;
            for (int j = salesTitle.size()-1; j > salesTitle.size() - 6; j--) {
                System.out.println(
                    num1 + ":   Rated: [" + salesTitle.get(j).getTotalSales() + ".00]\t" + salesTitle.get(j).getTitle());
                    num1++;
            }
        }
    
    }
}

class titleSales implements Comparable<titleSales> {
    private String title;
    private int totalSales;

    public titleSales(String title, int totalSales) {
        this.title = title;
        this.totalSales = totalSales;
    }

    public String getTitle() {
        return title;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public int compareTo(titleSales o) {
        /*
         * if(this.totalSales != o.getTotalSales())
         * {
         * return this.totalSales - o.getTotalSales();
         * }
         */
        return this.title.compareTo(o.getTitle());
    }
}