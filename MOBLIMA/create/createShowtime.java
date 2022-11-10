package MOBLIMA.create;

import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.listingInterface.*;
import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.save.saveShowtime;
import MOBLIMA.utils.dateTime;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;



public class createShowtime {
    public static final String SEPARATOR = "|";

    /** Write fixed content to the given file. Never changed */

    private static LocalTime showtime;
    private static String inputDate;
    private static int movieId;
    private static String inputTime;

    public static void create(String cnplx, int cnm, String cc){

        Scanner sc = new Scanner(System.in);
        // defining the integers etc
        try {
            

            System.out.println("We are now creating showtime at \n Cineplex: " + cnplx + " Cinema: " + cnm + " Cinema Code: " + cc);



            
            // Time, require user to manual input:
            System.out.println("Enter Showtime Time in the format HHMM");
            inputTime = sc.next();
            while (inputTime.length() !=4){
                System.out.println("Invalid Time format, please try again");
                inputTime = sc.next();
            }
            


            // Date, require user to manual input:
            System.out.println("Enter Date in the format YYYY/MM/DD");
            inputDate = sc.next();
            while (inputDate.length()!=10){
                System.out.println("Invalid Date format, please try again");
                inputDate = sc.next();
            }

            // Movie ID waiting for summit
            System.out.println("Enter Movie ID");

            while (true){
                try{
                    movieId = sc.nextInt();
                    break;
                }
                catch (InputMismatchException e) {
                    System.out.println("There was error reading the value, please input integer");
                    movieId = sc.nextInt();
                }
            }



            
    
            // What the user have selected
            System.out.println("You have selected: "
            + "Cineplex: " + cnplx +"\n"
            + "Cinema: " + cnm +"\n"
            + "Showtime: " + inputTime +"\n"
            + "date: " + inputDate +"\n"
            + "movieID: " + movieId +"\n"
            );




            // Checks if user wants to redo anything.

            System.out.println("Confirm that you want to write the following to database");
            // System.out.println("Cinema | Date | Time | MovieID:");
            // System.out.println(cinema + "|" + inputDate + "|" + inputTime + "|" + movieId);

            System.out.println("Enter Y to confirm, N to try again");
            String confirm = sc.next();
            int i=0;
            if(confirm.equals("Y") || confirm.equals("y")){

            }
            else{
                System.out.println("Select an input to edit the fields:\n"
                + "1 - Date\n"
                + "2 - Time\n"
                + "3 - Movie ID\n"
                + "4 - Check inputs\n"
                + "5 - Confirm inputs\n");
                while (i!= 100){
                    System.out.println("Please input a number to edit the fields");
                    i = sc.nextInt();

                    switch (i){
                        case 1:
                        System.out.println("Your previous input is: " + inputDate);
                        System.out.println("Enter the new Date YYYY//MM/DD:");
                        inputDate = sc.next();
                        break;

                        case 2:
                        System.out.println("Your previous input is: " + showtime);

                            System.out.println("Enter Showtime Time in the format HHMM");
                            inputTime = sc.next();
                            while (inputTime.length() !=4){
                                System.out.println("Invalid Time format, please try again");
                                inputTime = sc.next();
                            }
                        break;

                        case 3:
                        System.out.println("Your previous input is: " + movieId);
                        System.out.println("Enter the new movieID ie 1,2,3,4,5");
                        movieId = sc.nextInt();
                        break;

                        case 4:
                        System.out.println("Your current inputs:\nCinema | Date | Time | MovieID:");
                        System.out.println(inputDate + "|" + inputTime + "|" + movieId);
                        break;

                        case 5:
                        System.out.println("Confirm that you want to write the following:");
                        System.out.println(cnm + "|" + inputDate + "|" + inputTime + "|" + movieId);
                        System.out.println("Enter Y to confirm, N to try again");
                        String confirm2 = sc.next();
                        if(confirm2.equals("Y") || confirm2.equals("y")){
                            i = 100;
                        }
                        break;
                    }
                }
            }
            // Write Stuff:
            // al is an array list containing Professor objs
            // write cinema record/s to file.
            String filename = "MOBLIMA/databases/Showtime.txt";
            ArrayList showtimeArray = retrieveShowtime.readShowtime(filename); // retrieve current array
            int[][] seating = { { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
            { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 2 } };
            LocalDate d = dateTime.convertDate(inputDate);
            LocalTime t = dateTime.convertTime(inputTime);
            Showtime s = new Showtime(cc, d, t, 1, seating); // add new showtime //\get movie id
            showtimeArray.add(s);
            
            saveShowtime.saveShowtimeArray(filename, showtimeArray);// overwrite file

            System.out.println("Added the following fields in the database:");
            
            System.out.println( cc + "|" + d + "|" + t + "|" + movieId + "|" + "Seating" + "|" + s.getShowtimeId() );

        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }

    }



    public static void main(String[] aArgs) {
        create("Ang Mo Kio", 2, "Ao2");
    }
}
