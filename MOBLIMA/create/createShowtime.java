package MOBLIMA.create;

import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrieveShowtime;

import java.io.FileWriter;
import java.io.PrintWriter;



public class createShowtime {
    public static final String SEPARATOR = "|";

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
        try {
            // Read stuff
            ArrayList al = retrieveShowtime.readShowtime(filename);
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
            while (i!=100) {
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
                    System.out.println("Confirm that you want to write the following:");
                    System.out.println(cineplex + "|" + cinema + "|" + date + "|" + timeSlot + "|" + movieId + "|" + seating);
                    System.out.println("Enter Y to confirm, N to try again");
                    String confirm = sc.next();
                    if(confirm.equals("Y") || confirm.equals("y")){
                        i = 100;
                        continue;
                    }
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
    }
}
