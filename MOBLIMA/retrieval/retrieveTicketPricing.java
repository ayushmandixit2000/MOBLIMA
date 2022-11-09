package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class retrieveTicketPricing {
    public static String readTicketPricing(String filename) throws IOException {
        List stringList = read(filename);
        return (String) stringList.get(0);

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
        String filename = "MOBLIMA/databases/ticketPricing.txt";
        try {
            System.out.println(retrieveTicketPricing.readTicketPricing(filename));
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
