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

public class createShowtimeHandler {
    public static final String SEPARATOR = "|";
    private static LocalTime showtime;
    private static String inputDate;
    private static int movieId;
    private static String inputTime;

    public static void create(String cnplx, int cnm, String cc) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("We are now creating showtime at \n Cineplex: " + cnplx + " Cinema: " + cnm
                    + " Cinema Code: " + cc);
            System.out.println("Enter Showtime Time in the format HHMM");
            inputTime = sc.next();
            while (inputTime.length() != 4) {
                System.out.println("Invalid Time format, please try again");
                inputTime = sc.next();
            }
            System.out.println("Enter Date in the format YYYY/MM/DD");
            inputDate = sc.next();
            while (inputDate.length() != 10) {
                System.out.println("Invalid Date format, please try again");
                inputDate = sc.next();
            }

            System.out.println("Enter Movie ID");
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
                    System.out.println("Please input a number to edit the fields");
                    i = sc.nextInt();
                    switch (i) {
                        case 1:
                            System.out.println("Your previous input is: " + inputDate);
                            System.out.println("Enter the new Date YYYY//MM/DD:");
                            inputDate = sc.next();
                            break;

                        case 2:
                            System.out.println("Your previous input is: " + showtime);
                            System.out.println("Enter Showtime Time in the format HHMM");
                            inputTime = sc.next();
                            while (inputTime.length() != 4) {
                                System.out.println("Invalid Time format, please try again");
                                inputTime = sc.next();
                            }
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
            Showtime s = new Showtime(cc, dateTime.convertDate(inputDate), dateTime.convertTime(inputTime),
                    chosenMovie.getMovieId(), seating); // add new showtime //\get movie id
            showtimeArray.add(s);

            saveShowtime.saveShowtimeArray(filename, showtimeArray);// overwrite file

            System.out.println("Successfully added.");
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

    public static void main(String[] aArgs) {
        create("Ang Mo Kio", 2, "Ao2");
    }
}
