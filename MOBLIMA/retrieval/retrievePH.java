package MOBLIMA.retrieval;

import java.io.IOException;
import java.time.LocalDate;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;
import MOBLIMA.utils.dateTime;
import java.util.List;
import java.util.ArrayList;

public class retrievePH {
    public static final String SEPARATOR = "|";

    public static ArrayList readPH(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data
        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);
            LocalDate d = dateTime.convertDate(star.nextToken().trim());
            alr.add(d);
        }
        return alr;

    }

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

    public static void main(String[] aArgs) {
        String filename = "MOBLIMA/databases/publicholidays.txt";
        try {
            ArrayList al = retrievePH.readPH(filename);
            for (int i = 0; i < al.size(); i++) {
                LocalDate d = (LocalDate) al.get(i);
                System.out.println(dateTime.convertDate(d));
            }
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
