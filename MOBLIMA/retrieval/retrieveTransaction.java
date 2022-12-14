package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import MOBLIMA.dataStructure.Transaction;

/**
 * Helper class to retrieve transaction objects from the transaction database.
 */
public class retrieveTransaction {
    /**
     * Separator used to denote different data boundaries in the transaction
     * database.
     */
    public static final String SEPARATOR = "|";

    /**
     * Converts data read from the file into fields of the transaction object.
     * 
     * @param filename The file path to the file of interest.
     * @return Transaction objects obtained from the file of interest.
     */
    public static ArrayList readTransaction(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String transactionId = star.nextToken().trim();
            String purchaseDate = star.nextToken().trim();
            String purchaseTime = star.nextToken().trim();
            String userId = star.nextToken().trim();
            String[] arrayofMovieTickets = star.nextToken().trim().split("\\,");

            Transaction t = new Transaction(purchaseDate, purchaseTime, userId, arrayofMovieTickets);
            alr.add(t);
        }
        return alr;
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
