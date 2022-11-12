package MOBLIMA.handler;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.listing.movielisting;
import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.save.saveShowtime;
import MOBLIMA.utils.dateTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class createShowtimeHandler {
    private static LocalTime showtime;
    private static String inputDate;
    private static int movieId;
    private static String inputTime;
    private static String filename = "MOBLIMA/databases/Showtime.txt";
    private static ArrayList showTimeArray;

    public static void save(Showtime s) throws IOException {
        showTimeArray = retrieveShowtime.readShowtime(filename); // retrieve current array
        showTimeArray.add(s);
        saveShowtime.saveShowtimeArray(filename, showTimeArray);
        System.out.println("Created successfully");
    }

    public static void run(String cnplx, int cnm, String cc) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("We are now creating showtime at \n Cineplex: " + cnplx + " Cinema: " + cnm
                    + " Cinema Code: " + cc);


            boolean flag;
            // error handling for invalid input
            DateTimeFormatter strictTimeFormatter = DateTimeFormatter.ofPattern("HHmm").withResolverStyle(ResolverStyle.STRICT);
            do{
                try{
                    System.out.println("Enter Showtime Time in the format HHMM");
                    inputTime = sc.next();
                    LocalTime.parse(inputTime, strictTimeFormatter);
                    flag = false;
                }
                catch(DateTimeParseException e){
                    System.out.println("Invalid input. Please try again.");
                    flag = true;
                    
                }
            }
            while(flag);

            // date
            DateTimeFormatter strictDateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            // error handling for invalid input
            do{
                try{
                    System.out.println("Enter Date in the format YYYY/MM/DD");
                    inputDate = sc.next();
                    LocalDate.parse(inputDate, strictDateFormatter);
                    flag = false;
                }
                catch(DateTimeParseException e){
                    System.out.println("Invalid input. Please try again.");
                    flag = true;
                    
                }
            }
            while(flag);

            System.out.println("Enter Movie");
            movielisting ml = new movielisting();
            ml.show();
            Movie chosenMovie = ml.getChosenMovie();
            System.out.println("You have selected: "
                    + "Cineplex: " + cnplx + "\n"
                    + "Cinema: " + cnm + "\n"
                    + "Showtime: " + inputTime + "\n"
                    + "date: " + inputDate + "\n"
                    + "movie: " + chosenMovie.getTitle() + "\n");

            System.out.println("Confirm that you want to write the following to database");
            System.out.println("Cinema | Date | Time | Movie:");
            System.out.println(cnm + "|" + inputDate + "|" + inputTime + "|" +
                    chosenMovie.getTitle());
            System.out.println("Enter Y to confirm, N to try again");
            String confirm = sc.next();
            int i = 0;
            if (confirm.equals("Y") || confirm.equals("y")) {
            } else {
                while (i != 100) {
                    System.out.println("Select an input to edit the fields:\n"
                            + "1 - Date\n"
                            + "2 - Time\n"
                            + "3 - Movie\n"
                            + "4 - Check inputs\n"
                            + "5 - Confirm inputs\n");

                    i = -1;
                     // to prevent users from keying in data that is not string 
                    do{
                        try{
                            System.out.println("Please input a number to edit the fields");
                            i = sc.nextInt();
                            flag = false;
                            if (i < 1 || i > 5) {
                                System.out.println("Invalid option. Please key in valid numbers");
                                flag = true;
                            }
                            else{
                                flag = false;
                            }
                        }
                        catch(Exception e){
                            System.out.println("Inavlid input. Please enter intergers only");
                            sc.nextLine();
                            flag = true;
                        }
                    }
                    while(flag);
                    sc.nextLine();

                    switch (i) {
                        case 1:
                            System.out.println("Your previous input is: " + inputDate);

                             // error handling for invalid input
                            do{
                                try{
                                    System.out.println("Enter the new Date YYYY/MM/DD:");
                                    inputDate = sc.next();
                                    LocalDate.parse(inputDate, strictDateFormatter);
                                    flag = false;
                                }
                                catch(DateTimeParseException e){
                                    System.out.println("Invalid input. Please try again.");
                                    flag = true;    
                                }
                            }
                            while(flag);
                            break;

                        case 2:
                            System.out.println("Your previous input is: " + showtime);

                            // error handling for invalid input
                            do{
                                try{
                                    System.out.println("Enter Showtime Time in the format HHMM");
                                    inputTime = sc.next();
                                    LocalTime.parse(inputTime, strictTimeFormatter);
                                    flag = false;
                                }
                                catch(DateTimeParseException e){
                                    System.out.println("Invalid input. Please try again.");
                                    flag = true;
                                    
                                }
                            }
                            while(flag);
                            
                            break;
                        case 3:
                            System.out.println("Your previous input is: " + chosenMovie.getTitle());
                            ml.show();
                            chosenMovie = ml.getChosenMovie();
                            break;
                        case 4:
                            System.out.println("Your current inputs:\nCinema | Date | Time | Movie:");
                            System.out.println(inputDate + "|" + inputTime + "|" + chosenMovie.getTitle());
                            break;
                        case 5:
                            System.out.println("Confirm that you want to write the following:");
                            System.out.println(cnm + "|" + inputDate + "|" + inputTime + "|" + movieId);
                            System.out.println("Enter Y to confirm, N to try again");
                            String confirm2 = sc.next();
                            if (confirm2.equals("Y") || confirm2.equals("y")) {
                                i = 100;
                            }
                            break;
                    }
                }
            }
            System.out.println("Adding...");
            int[][] seating = { { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                    { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 2 } };

            Showtime s = new Showtime(cc, dateTime.convertDate(inputDate), dateTime.convertTime(inputTime),
                    chosenMovie.getMovieId(), seating);
            save(s);
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
