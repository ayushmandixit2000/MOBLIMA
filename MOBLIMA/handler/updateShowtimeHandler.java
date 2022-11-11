package MOBLIMA.handler;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.listing.ShowtimeListing;
import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.utils.compareDates;
import MOBLIMA.utils.dateTime;

import java.io.BufferedReader;

public class updateShowtimeHandler {
    public static final String SEPARATOR = "|";

    static void updateContent(String filePath, String oldString, String newString)
	{
		File fileToBeModified = new File(filePath);
		
		String oldContent = "";
		
		BufferedReader reader = null;
		
		FileWriter writer = null;
		
		try 
		{
			reader = new BufferedReader(new FileReader(fileToBeModified));
			
			//Reading all the lines of input text file into oldContent
			
			String line = reader.readLine();
			
			while (line != null) 
			{
				oldContent = oldContent + line + System.lineSeparator();
				
				line = reader.readLine();

                //System.out.println("aft processing:" + oldContent);
			}
			
			//Replacing oldString with newString in the oldContent
			
			String newContent = oldContent.replace(oldString, newString);

            System.out.println("new Content: \n" + newContent);
			
			//Rewriting the input text file with newContent
			
			writer = new FileWriter(fileToBeModified);
			
			writer.write(newContent);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				//Closing the resources
				
				reader.close();
				
				writer.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

    public static void update(String cplx, int cnm, String cc) {
        String filename = "MOBLIMA/databases/showtime.txt";
        Scanner sc = new Scanner(System.in);

        //Initialisation
        LocalTime localtime = dateTime.convertTime("0100");
        LocalDate localdate = dateTime.convertDate("2016/01/01");

        String cinema;
        int movieId = 0;
        int seating[][];
        String showtimeID = "NULL";
        String seatingstr = "NULL";
        

        try {

            ArrayList al = retrieveShowtime.readShowtime(filename);
    
            // Print the showtime for user to see:
            ShowtimeListing stl = new ShowtimeListing();
            stl.populate(cplx, cnm, cc);
            stl.displayListing();

            System.out.println("Hint : Select the showtime you want to Edit");
            
            System.out.println("Enter what you'd like to Update: ");
            int userindex = sc.nextInt();

            int FirstCounter = 0;
            StringBuilder st = new StringBuilder();

            Collections.sort(al, new compareDates());
            for (int i = 0; i < al.size(); i++) {
                Showtime s = (Showtime) al.get(i);
                //System.out.println("Printing s: "+ s);
                if ((s.getCinema()).equals(cc)) {
                    if (FirstCounter == userindex) {
                        localtime = s.getTime();
                        localdate = s.getDate();
                        movieId = s.getMovieId();
                        seating = s.getSeating();
                        showtimeID = s.getShowtimeId();
                        System.out.println("showtimeID" + showtimeID);
                        seatingstr = st.toString();

                        // System.out.println(seating.toString());
                        break;
                    }
                    FirstCounter++;
                }
            }

            String oldString = cc + "|" + localdate.toString().replace("-", "/") + "|" +  localtime.toString().replace(":", "") + "|" 
                            + movieId + "|"  + showtimeID;

            System.out.println(oldString);



            System.out.println("Select the parameter you would like to edit: \n"
            + "0 - Date \n"
            + "1 - Time \n"
            + "2 - MovieID \n"
            + "3 - Exit");

            int editParameter = 199;
            while(editParameter != 100) {
                System.out.print("Please Choose the parameter to edit: \n");
                editParameter = sc.nextInt();
                switch(editParameter) {
                    case 0:
                        System.out.println("Editing Date: ");
                        System.out.println("input date in YYYY/MM/DD format");
                        localdate = dateTime.convertDate(sc.next());
                        break;
                    case 1:
                        System.out.println("Editing Time: ");
                        System.out.println("input time in HHMM format");
                        localtime = dateTime.convertTime(sc.next());
                        break;
                    case 2:
                        System.out.println("Editing MovieID: ");
                        System.out.println("input MovieID");
                        movieId = sc.nextInt();
                        break;
                    case 3:
                        System.out.println("Exiting");
                        editParameter = 100;
                        break;

                }
            }

            String newString = cc + "|" + localdate.toString().replace("-", "/") + "|" +  localtime.toString().replace(":", "") + "|" 
                            + movieId + "|"  + seatingstr + "|" + showtimeID;
            System.out.println(newString);
            
            updateContent(filename, oldString, newString);
                     



        }
        catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
            }

    }


public static void main(String[] aArgs){
    update("Ang Mo Kio", 2, "Ao2");
    
}



    // String filename = "MOBLIMA/databases/showtime.txt";
    // Scanner sc = new Scanner(System.in);

    // String cinema = "Ao2";
    // LocalTime localtime "";
    // LocalDate localdate;
    // int movieId;
    // String seating;
    // String showtimeID;

    // String localtimestr;
    // String localdatestr;

    //     try {


    //         ArrayList al = retrieveShowtime.readShowtime(filename);

    //         System.out.println("\nUpdate fields!");
    //         System.out.println(" Cinema | Date | Time | MovieID | Seating");
    //         for (int i = 0; i < al.size(); i++) {
    //             Showtime m = (Showtime) al.get(i);
    //             System.out.print(" | " + m.getCinema());
    //             System.out.print(" | " + m.getDate());
    //             System.out.print(" | " + m.getTime());
    //             System.out.print(" | " + m.getMovieId());
    //             System.out.println(" | " + m.getSeating());
    //             System.out.println(" | " + m.getShowtimeId());
    //         }

    //         System.out.println("Choose the line to edit:");
    //         int field = sc.nextInt();
    //         System.out.println(al.size());

    //         int totalindex = al.size()-1;

    //         while(field>=al.size() || field<=0) {
    //             System.out.println("ensure that field is between 0 and " + totalindex);
    //             field = sc.nextInt();
    //         }
            
    //         // Print out what user is editing:
    //         for (int i = 0; i <= field; i++) {
    //             if (i == field){
    //                 System.out.println("\nEditing this line of DB:");
    //                 Showtime m = (Showtime) al.get(i);

    //                 cinema = m.getCinema();
    //                 localdate = m.getDate();
    //                 localtime = m.getTime();
    //                 movieId = m.getMovieId();
    //                 showtimeID = m.getShowtimeId();



    //                 System.out.print(" | " + m.getCinema());
    //                 System.out.print(" | " + m.getDate());
    //                 System.out.print(" | " + m.getTime());
    //                 System.out.print(" | " + m.getMovieId());
    //                 System.out.println(" | " + m.getSeating());
    //                 System.out.println(" | " + m.getShowtimeId() + "\n");
    //             }
    //         }

    //         String oldline = cinema + "|" + localdate + "|" + localtime + "|" + movieId + "|" + seating + "|" + showtimeID;

            

    //         System.out.println("Select an input to update new Showtime Database:\n"
    //         + "1 - Cineplex "
    //         + "2 - Cinema "
    //         + "3 - Date "
    //         + "4 - Time Slot "
    //         + "5 - Movie ID "
    //         + "6 - Seating "
    //         + "7 - check inputs "
    //         + "8 - upate Showtime "
    //         + "9 - back to main menu ");


    //         int j = 0;

    //         while (j !=9) {
    //             System.out.println("Chose field to update, to exit, input \'9\'");
    //             j = sc.nextInt();
    //             switch (j){
    //                 case 1:
    //                 System.out.println("Enter the Cinema: ");
    //                 System.out.println("Previous field :" + cinema);
    //                 cinema = sc.next();
    //                 break;

    //                 case 2:
    //                 System.out.println("Enter the date: ");
    //                 System.out.println("Previous field :" + localdate);
    //                 localdatestr = sc.next();
    //                 break;

    //                 case 3:
    //                 System.out.println("Enter the timeslot in 24 hour format: ");
    //                 System.out.println("Previous field :" + localtime);
    //                 localtimestr = sc.next();
    //                 break;

    //                 case 4:
    //                 System.out.println("Enter the movie id: ");
    //                 System.out.println("Previous field :" + movieId);
    //                 movieId = sc.nextInt();
    //                 break;

    //                 case 5:
    //                 System.out.println("Checking inputs...");
    //                 System.out.println(cinema + "|" + localdatestr + "|" + localtimestr + "|" + movieId + "|" + seating + "|" + showtimeID);
    //                 break;

    //                 case 6:
    //                 System.out.println("Writing show time!");
    //                 break;

    //             };
    //         };

    //         String newLine = cinema + "|" + localdatestr + "|" + localtimestr + "|" + movieId + "|" + seating + "|" + showtimeID;
    //         System.out.println("newline: "+ newLine);
    //         System.out.println("oldline: " + oldline);

    //         updateContent(filename, oldline, newLine);
    //         System.out.println("DONE!!!!");

    //     }
    //     catch (IOException e) {
    //     System.out.println("IOException > " + e.getMessage());
    //     }
    // }
}