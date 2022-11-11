package MOBLIMA.listing;

import java.io.IOException;
import MOBLIMA.retrieval.retrieveMovie;
import MOBLIMA.retrieval.retrieveMovieTicket;
import MOBLIMA.dataStructure.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class top5SalesListing {

    private Movie m1;
    
    public void displayListing() throws IOException {

        Scanner scc = new Scanner(System.in);
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

        String [] ids = new String[5];
        // Arrays.sort(salesTitle);
        Collections.sort(salesTitle,
                Comparator.comparingDouble(titleSales::getTotalSales));
        
            int count = 0;
            if (salesTitle.size() < 5) {
            int num = 1;
            for (int j = salesTitle.size() -1 ; j > -1; j--) {
                System.out.println(
                    num + ":   Sales: [$" + salesTitle.get(j).getTotalSales() + ".00]\t" + salesTitle.get(j).getTitle());
                    ids[num-1] = salesTitle.get(j).getTitle();
                    num++;
            }
            count = num;
        } else {
            int num = 1;
            for (int j = salesTitle.size()-1; j > salesTitle.size() - 6; j--) {
                System.out.println(
                    num + ":   Rated: [" + salesTitle.get(j).getTotalSales() + ".00]\t" + salesTitle.get(j).getTitle());
                    ids[num-1] = salesTitle.get(j).getTitle();
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