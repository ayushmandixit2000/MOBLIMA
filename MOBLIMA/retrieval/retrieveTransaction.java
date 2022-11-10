package MOBLIMA.retrieval;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import MOBLIMA.dataStructure.Transaction;
import MOBLIMA.utils.dateTime;

public class retrieveTransaction {
    public static final String SEPARATOR = "|";

    public static ArrayList readTransaction(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String transactionId = star.nextToken().trim();
            String purchaseDate =star.nextToken().trim();
            String purchaseTime = star.nextToken().trim();
            String userId = star.nextToken().trim();
            String[] arrayofMovieTickets = star.nextToken().trim().split("\\,");

            Transaction t = new Transaction(purchaseDate, purchaseTime, userId, arrayofMovieTickets);
            alr.add(t);
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
        String filename = "MOBLIMA/databases/transactions.txt";
        try {
            ArrayList al = retrieveTransaction.readTransaction(filename);
            for (int i = 0; i < al.size(); i++) {
                Transaction t = (Transaction) al.get(i);
                System.out.println(Arrays.deepToString(t.getArrayofMovieTickets()));
            }
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
