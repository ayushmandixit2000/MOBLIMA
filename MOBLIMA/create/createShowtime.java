package MOBLIMA.create;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import MOBLIMA.dataStructure.Showtime;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;





public class createShowtime {
    public static final String SEPARATOR = "|";

    public static ArrayList readShowtime(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String cineplex = star.nextToken().trim();
            int cinema = Integer.parseInt(star.nextToken().trim());
            String date = star.nextToken().trim();
            int timeSlot = Integer.parseInt(star.nextToken().trim());
            int movieId = Integer.parseInt(star.nextToken().trim());
            String seating = star.nextToken().trim();

            Showtime s = new Showtime(cineplex, cinema, date, timeSlot, movieId, seating);
            alr.add(s);
        }
        return alr;
    }

    public static String fileToString(String filePath) throws Exception{
        String input = null;
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer sb = new StringBuffer();
        while (sc.hasNextLine()) {
           input = sc.nextLine();
           sb.append(input);
        }
        return sb.toString();
     }

    /** Read the contents of the given file. */
    public static List read(String fileName) throws IOException {
        List data = new ArrayList();
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        try {
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
        } finally {
            scanner.close();
        }
        return data;
    }

    /** Write fixed content to the given file. Never changed */
    public static void write(String fileName, List data) throws IOException  {
        PrintWriter out = new PrintWriter(new FileWriter(fileName));

        try {
            for (int i =0; i < data.size() ; i++) {
                out.println((String)data.get(i));
            }
        }
        finally {
        out.close();
        }
    }

    
    // an example of saving
	public static void saveShowtime(String filename, List al) throws IOException {
		List alw = new ArrayList() ;// to store Cinema data
        

        for (int i = 0 ; i < al.size() ; i++) {
				Showtime shoetimeobj = (Showtime)al.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(shoetimeobj.getCineplex());
				st.append(SEPARATOR);
				st.append(shoetimeobj.getCinema());
				st.append(SEPARATOR);
				st.append(shoetimeobj.getDate().trim());
				st.append(SEPARATOR);
				st.append(shoetimeobj.getTimeSlot());
                st.append(SEPARATOR);
				st.append(shoetimeobj.getMovieId());
                st.append(SEPARATOR);
				st.append(shoetimeobj.getSeating().trim());
				alw.add(st.toString()) ;
			}
			write(filename,alw);
	}

    public static void updateShowtime(String filename, List al, int a) throws IOException {
		List alw = new ArrayList() ;// to store Cinema data

        System.out.println("length: "+al.size());

        for (int i = 0 ; i < al.size() ; i++) {
				Showtime shoetimeobj = (Showtime)al.get(i);
				StringBuilder st =  new StringBuilder();
				st.append(shoetimeobj.getCineplex());
				st.append(SEPARATOR);
				st.append(shoetimeobj.getCinema());
				st.append(SEPARATOR);
				st.append(shoetimeobj.getDate().trim());
				st.append(SEPARATOR);
				st.append(shoetimeobj.getTimeSlot());
                st.append(SEPARATOR);
				st.append(shoetimeobj.getMovieId());
                st.append(SEPARATOR);
				st.append(shoetimeobj.getSeating().trim());
				alw.add(st.toString()) ;
			}
			write(filename,alw);
	}


    public static void main(String[] aArgs) {
        String filename = "MOBLIMA/databases/showtime.txt";
        Scanner sc = new Scanner(System.in);
        // defining the integers etc
        System.out.println("What would you like to do with showtime?\n"
        + "1 - Read All showtime in Database\n"
        + "2 - Update Showtime\n"
        + "3 - Create new Showtime\n"
        );
        int choice = sc.nextInt();

        switch(choice){
        case 1:
        try {
            ArrayList al = createShowtime.readShowtime(filename);
            System.out.println("Cineplex | Cinema | Date | Time | MovieID | Seating\n");
            for (int i = 0; i < al.size(); i++) {
                Showtime m = (Showtime) al.get(i);
                System.out.print(m.getCineplex());
                System.out.print(" | " + m.getCinema());
                System.out.print(" | " + m.getDate());
                System.out.print(" | " + m.getTimeSlot());
                System.out.print(" | " + m.getMovieId());
                System.out.println(" | " + m.getSeating());
            }


            }catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
            }
        break;

        case 2:
        String cineplex2 = "null";
        int cinema2 = 0;
        String date2 = "null";
        int timeSlot2 = 0;
        int movieId2 = 0;
        String seating2 = "null";
            try {


                ArrayList al = createShowtime.readShowtime(filename);

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

                System.out.println("Old line: " + oldline);
                System.out.println("New line: " + newLine);

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



                // Write Stuff:
                Showtime c1 = new Showtime(cineplex2, cinema2, date2, timeSlot2, movieId2, seating2);
                // al is an array list containing Professor objs
                al.add(c1);
                //  write cinema record/s to file.
                createShowtime.saveShowtime(filename, al);
                System.out.println("The fields has been updated:");
                System.out.println(cineplex2 + "|" + cinema2 + "|" + date2 + "|" + timeSlot2 + "|" + movieId2 + "|" + seating2);





            }catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
            }
        break;
        


        case 3:
            try {
                // Read stuff
                ArrayList al = createShowtime.readShowtime(filename);
                String cineplex = "null";
                int cinema = 0;
                String date = "null";
                int timeSlot = 0;
                int movieId = 0;
                String seating = "null";


                System.out.println("Successfully opened showtime file, adding new showtime");
                int i = 0;
                System.out.println("Select an input to create new Showtime Database:\n"
                + "1 - Cineplex\n"
                + "2 - Cinema\n"
                + "3 - Date\n"
                + "4 - Time Slot\n"
                + "5 - Movie ID\n"
                + "6 - Seating\n"
                + "7 - check inputs\n"
                + "8 - Create Showtime\n");
                while (i!=8) {
                    System.out.println("Enter input number: ");
                    i = sc.nextInt();
                    switch (i){
                        case 1:
                        System.out.println("Enter the Cineplex id: ");
                        System.out.println("ID: Vivocity, Clementi, Orchard, Rochor");
                        cineplex = sc.next();
                        break;

                        case 2:
                        System.out.println("Enter the Cinema: ");
                        System.out.println("Cinema Number: 1, 2, 3, 4, 5");
                        cinema = sc.nextInt();
                        break;

                        case 3:
                        System.out.println("Enter the date: ");
                        System.out.println("DDMMYYYY: 12012022 ");
                        date = sc.next();
                        break;

                        case 4:
                        System.out.println("Enter the timeslot in 24 hour format: ");
                        System.out.println("2359");
                        timeSlot = sc.nextInt();
                        break;

                        case 5:
                        System.out.println("Enter the movie id: ");
                        System.out.println("eg: 1-avengers, 2-thor, 3-Hui Xiang Drinks alcohol");
                        movieId = sc.nextInt();
                        break;

                        case 6:
                        System.out.println("Enter the seating layout: ");
                        System.out.println("example: [0,0,0][0,0,0][0,0,0]");
                        seating = sc.next();
                        break;

                        case 7:
                        System.out.println("Checking inputs...");
                        System.out.println(cineplex + "|" + cinema + "|" + date + "|" + timeSlot + "|" + movieId + "|" + seating);
                        break;

                        case 8:
                        System.out.println("Writing show time!");
                        break;
                    };
                };

                // Write Stuff:
                Showtime c1 = new Showtime(cineplex, cinema, date, timeSlot, movieId, seating);
                // al is an array list containing Professor objs
                al.add(c1);
                // write cinema record/s to file.
                createShowtime.saveShowtime(filename, al);
                System.out.println("Added the following fields in the database:");
                System.out.println(cineplex + "|" + cinema + "|" + date + "|" + timeSlot + "|" + movieId + "|" + seating);

            } catch (IOException e) {
                System.out.println("IOException > " + e.getMessage());
            }
            break;
        }
    }
}
