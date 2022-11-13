package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Helper class to retrieve various pricings from the ticketPricing database.
 */
public class retrieveTicketPricing {
    /**
     * Converts data read from the file into various pricings
     * 
     * @param filename The file path to the file of interest.
     * @return Different pricings obtained from the file of interest.
     */
    public static String readTicketPricing(String filename) throws IOException {
        List stringList = read(filename);
        return (String) stringList.get(0);

    }

    /**
     * Reads data from a specific file.
     * 
     * @param fileName The file path to the file of interest.
     * @return Data read from the specific file.
     */
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
}
