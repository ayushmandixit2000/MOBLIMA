package MOBLIMA.remove;

import MOBLIMA.retrieval.retrieveShowtime;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import MOBLIMA.dataStructure.Showtime;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class removeShowtime {

    public static void main(String[] args) {
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

                System.out.println("\nDelete fields!");
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

                System.out.println("Choose the line to Delete:");
                int field = sc.nextInt();
                int totalindex = al.size()-1;

                while(field > totalindex || field < 0){
                    System.out.println("Enter a value between 0 and " + totalindex);
                    field = sc.nextInt();
                }
                
                System.out.println("Are you sure you want to delete line " + field + "? (y/n)");
                String confirm = sc.next();
                while(confirm.equals("n")||confirm.equals("N") ){
                    System.out.println("Enter a value between 0 and " + totalindex);    
                    field = sc.nextInt();
                    System.out.println("Are you sure you want to delete line " + field + "? (y/n)");
                    confirm = sc.next();
                }

                // Print out what user is editing:
                for (int i = 0; i <= field; i++) {
                    if (i == field){
                        System.out.println("\nDeleting this line of DB:");
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


                File inputFile = new File("MOBLIMA/databases/showtime.txt");
                File tempFile = new File("MOBLIMA/databases/showtimetemp.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String lineToRemove = oldline;
                String currentLine;

                while((currentLine = reader.readLine()) != null) {
                    // trim newline when comparing with lineToRemove
                    String trimmedLine = currentLine.trim();
                    if(trimmedLine.equals(lineToRemove)) continue;
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
                writer.close(); 
                reader.close(); 
                
                inputFile.delete();
                tempFile.renameTo(inputFile);
                tempFile.delete();


            }catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
            }
    }
    
}
