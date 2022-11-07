package MOBLIMA.update;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrieveShowtime;

import java.io.BufferedReader;

public class updateShowtime {
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

                System.out.println("aft processing:" + oldContent);
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


public static void main(String[] aArgs){
    String filename = "MOBLIMA/databases/showtime.txt";
    Scanner sc = new Scanner(System.in);

    String cineplex2 = "null";
    int cinema2 = 0;
    String date2 = "null";
    int timeSlot2 = 0;
    int movieId2 = 0;
    String seating2 = "null";
        try {


            ArrayList al = retrieveShowtime.readShowtime(filename);

            System.out.println("\nUpdate fields!");
            System.out.println("Cineplex | Cinema | Date | Time | MovieID | Seating");
            for (int i = 0; i < al.size(); i++) {
                Showtime m = (Showtime) al.get(i);
                System.out.print(i + "- " + m.getCineplex());
                System.out.print(" | " + m.getCinema());
                System.out.print(" | " + m.getDate());
                System.out.print(" | " + m.getTimeSlot());
                System.out.print(" | " + m.getMovieId());
                System.out.println(" | " + m.getSeating());
            }

            System.out.println("Choose the line to edit:");
            int field = sc.nextInt();
            System.out.println(al.size());

            int totalindex = al.size()-1;

            while(field>=al.size() || field<=0) {
                System.out.println("ensure that field is between 0 and " + totalindex);
                field = sc.nextInt();
            }
            
            // Print out what user is editing:
            for (int i = 0; i <= field; i++) {
                if (i == field){
                    System.out.println("\nEditing this line of DB:");
                    Showtime m = (Showtime) al.get(i);

                    cineplex2 = m.getCineplex();
                    cinema2 = m.getCinema();
                    date2 = m.getDate();
                    timeSlot2 = m.getTimeSlot();
                    movieId2 = m.getMovieId();
                    seating2 = m.getSeating();



                    System.out.print(i + "- " + m.getCineplex());
                    System.out.print(" | " + m.getCinema());
                    System.out.print(" | " + m.getDate());
                    System.out.print(" | " + m.getTimeSlot());
                    System.out.print(" | " + m.getMovieId());
                    System.out.println(" | " + m.getSeating() + "\n");
                }
            }

            String oldline = cineplex2 + "|" + cinema2 + "|" + date2 + "|" + timeSlot2 + "|" + movieId2 + "|" + seating2;

            

            System.out.println("Select an input to update new Showtime Database:\n"
            + "1 - Cineplex "
            + "2 - Cinema "
            + "3 - Date "
            + "4 - Time Slot "
            + "5 - Movie ID "
            + "6 - Seating "
            + "7 - check inputs "
            + "8 - upate Showtime "
            + "9 - back to main menu ");


            int j = 0;

            while (j !=9) {
                System.out.println("Chose field to update, to exit, input \'9\'");
                j = sc.nextInt();
                switch (j){
                    case 1:
                    System.out.println("Enter the Cineplex id: ");
                    System.out.println("Previous field :" + cineplex2);
                    cineplex2 = sc.next();
                    break;

                    case 2:
                    System.out.println("Enter the Cinema: ");
                    System.out.println("Previous field :" + cinema2);
                    cinema2 = sc.nextInt();
                    break;

                    case 3:
                    System.out.println("Enter the date: ");
                    System.out.println("Previous field :" + date2);
                    date2 = sc.next();
                    break;

                    case 4:
                    System.out.println("Enter the timeslot in 24 hour format: ");
                    System.out.println("Previous field :" + timeSlot2);
                    timeSlot2 = sc.nextInt();
                    break;

                    case 5:
                    System.out.println("Enter the movie id: ");
                    System.out.println("Previous field :" + movieId2);
                    movieId2 = sc.nextInt();
                    break;

                    case 6:
                    System.out.println("Enter the seating layout: ");
                    System.out.println("Previous field :" + seating2);
                    seating2 = sc.next();
                    break;

                    case 7:
                    System.out.println("Checking inputs...");
                    System.out.println(cineplex2 + "|" + cinema2 + "|" + date2 + "|" + timeSlot2 + "|" + movieId2 + "|" + seating2);
                    break;

                    case 8:
                    System.out.println("Writing show time!");
                    break;

                };
            };

            String newLine = cineplex2 + "|" + cinema2 + "|" + date2 + "|" + timeSlot2 + "|" + movieId2 + "|" + seating2;
            System.out.println("newline: "+ newLine);
            System.out.println("oldline: " + oldline);

            updateContent(filename, oldline, newLine);
            System.out.println("DONE!!!!");

        }
        catch (IOException e) {
        System.out.println("IOException > " + e.getMessage());
        }
    }
}