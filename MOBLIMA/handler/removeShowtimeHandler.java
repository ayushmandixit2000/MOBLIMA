package MOBLIMA.handler;

import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.utils.compareDates;
import MOBLIMA.utils.dateTime;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.listing.ShowtimeListing;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;

public class removeShowtimeHandler {

    public static void remove(String cplx, int cnm, String cc) {
        String filename = "MOBLIMA/databases/showtime.txt";
        Scanner sc = new Scanner(System.in);

        String cinema;
        String inputDate;
        int inputTime;
        int movieId;
        String showtimeId;
        String oldline = "NULL";
        int field = 100;

        LocalTime showtime;

        try {
            ArrayList al = retrieveShowtime.readShowtime(filename);
            ShowtimeListing stl = new ShowtimeListing();

            stl.populate(cplx, cnm, cc);
            stl.displayListing();
            System.out.println("Hint : Select the showtime you want to remove");
            LocalTime time = dateTime.convertTime("0100");
            LocalDate date = dateTime.convertDate("2016/01/01");
            System.out.println("Enter what you'd like to remove: ");
            int userindex = sc.nextInt();

            int FirstCounter = 0;

            Collections.sort(al, new compareDates());
            for (int i = 0; i < al.size(); i++) {
                Showtime s = (Showtime) al.get(i);
                if ((s.getCinema()).equals(cc)) {
                    if (FirstCounter == userindex) {
                        time = s.getTime();
                        date = s.getDate();
                    }
                    FirstCounter++;
                }
            }

            // Process localtime
            String strshowtime = time.toString();
            String convertedShowTime = strshowtime.replace(":", "");
            System.out.println(convertedShowTime);

            // Process localdate
            String strlocaldate = date.toString();
            String convertedLocalDate = strlocaldate.replace("-", "/");
            System.out.println(convertedLocalDate);

            Scanner fileReaderScanner = new Scanner(new File(filename));
            int linecounter = 0;

            try (var reader = Files.newBufferedReader(Paths.get(filename))) {
                var scanner = new Scanner(reader);
                while (scanner.hasNextLine()) {
                    var line = scanner.nextLine();
                    if (line.contains(cc) && line.contains(convertedShowTime) && line.contains(convertedLocalDate)) {
                        System.out.println(line);
                        oldline = line;
                        field = linecounter;
                        break;
                    }
                    linecounter++;
                }
            }

            System.out.println("Removing the following line: \n" + oldline);

            File inputFile = new File("MOBLIMA/databases/showtime.txt");
            File tempFile = new File("MOBLIMA/databases/showtimetemp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = oldline;
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                // System.out.println(trimmedLine);
                if (trimmedLine.equals(lineToRemove)) {
                    // System.out.println("Found the line to remove!");
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            fileReaderScanner.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);
            tempFile.delete();

        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        removeShowtimeHandler rst = new removeShowtimeHandler();
        rst.remove("Ang Mo Kio", 2, "Ao2");
    }

}
