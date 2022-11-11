package MOBLIMA.facade;

import java.io.IOException;
import java.util.Scanner;

import MOBLIMA.Listings.*;
import MOBLIMA.configurables.rankStatus;
import MOBLIMA.listing.top5RatingListing;
import MOBLIMA.listing.top5SalesListing;

public class top5Facade {
    public static void show(String userid) throws IOException {
        
        int config = rankStatus.getStatus();

        int choicerank = 0;
        
        if(config == 0){
            System.out.println("The cinema has disabled this function for now, please check back later!");
            return;
        }

        else if(config == 1){
            System.out.println("Currently we are only showing ranking by sales!");
            choicerank = 1;
        }

        else if(config == 2){
            System.out.println("Currently we are only showing ranking by ratings!");
            choicerank = 2;
        }

        if(choicerank == 0){
            System.out.println("Please enter how you would like your movies to be sorted:");
            System.out.println("(1) By Sales (2) By Ratings");
            Scanner scc = new Scanner(System.in);

            while (true) {
                String input = scc.next();
                choicerank = 0;
                try {
                    choicerank = Integer.parseInt(input);
                    if (choicerank > 2 || choicerank < 1) {
                        System.out.println("Please key in a valid number!");
                        continue;
                    } else {
                        break;
                    }
                } catch (NumberFormatException ne) {
                    System.out.println("Please key in a number only!");
                }
            }
        }

        if(choicerank == 1){
            top5SalesListing sales = new top5SalesListing();
            sales.displayListing(); 
        }

        if(choicerank == 2){
            top5RatingListing ratings = new top5RatingListing();
            ratings.displayListing(); 
        }
        
        // System.out.println("Would you like to find out more about a movie?");
        // System.out.println("(1) Yes (2) No");
        // Scanner sb = new Scanner(System.in);
        // int option = sb.nextInt();
        // i = 0;
        // do {
        //     if (option == 1) {
        //         MovieDetailsListing search = new MovieDetailsListing();
        //         search.displayListing();
        //         i++;
        //     }

        //     else if (option == 2) // link to another page
        //     {
        //         i++;
        //     } else {
        //         System.out.println("Input error. Please try again.");
        //     }
        // } while (i < 1);
    }
}
