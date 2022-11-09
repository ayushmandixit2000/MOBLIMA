import java.io.IOException;
import java.util.Scanner;
import MOBLIMA.Listings.*;


public class top5Facade {
    public static void main(String[] args) throws IOException{
    System.out.println("Please enter how you would like your movies to be sorted:");
    System.out.println("(1) By Sales (2) By Ratings");
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();
    int i=0;

    do{
    if(choice == 1)
    {
        top5SalesListing sales = new top5SalesListing();
        sales.displayListing();
        i++;
    }

    else if(choice == 2)
    {
        top5RatingListing ratings = new top5RatingListing();
        ratings.displayListing();
        i++;
    }
    else{
        System.out.println("Input error. Please try again.");
    }
}while(i< 1);

    System.out.println("Would you like to find out more about a movie?"); 
    System.out.println("(1) Yes (2) No");
    Scanner sb = new Scanner(System.in);
    int option = sb.nextInt();
    i =0;
    do{
        if(option == 1)
        {
            MovieDetailsListing search = new MovieDetailsListing();
            search.displayListing(); 
            i++;
        }
    
        else if(option == 2) //link to another page
        {
            i++;
        }
        else{
            System.out.println("Input error. Please try again.");
        }
    }while(i< 1);
}
}


