package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import MOBLIMA.dataStructure.Transaction;

public class retrieveTransaction {
    public static final String SEPARATOR = "|";

    public static ArrayList readTransaction(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();// to store data

        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String transactionId = star.nextToken().trim();
            String purchaseDate = star.nextToken().trim();
            int purchaseTime = Integer.parseInt(star.nextToken().trim());
            String userId = star.nextToken().trim();
            int movieId = Integer.parseInt(star.nextToken().trim());
            String date = star.nextToken().trim();
            int time = Integer.parseInt(star.nextToken().trim());
            String cinema = star.nextToken().trim();
            int totalCost = Integer.parseInt(star.nextToken().trim());
            int ticketCount = Integer.parseInt(star.nextToken().trim());
            String[] arrayOfTicketCatgeory = star.nextToken().trim().split("\\,");
            String[] arrayOfSeatAllocationArray = star.nextToken().trim().split("\\.");
            int[][] arrayOfSeatAllocation = new int[ticketCount][2];
            for (int j = 0; j < ticketCount; j++) {
                String[] row = arrayOfSeatAllocationArray[j].split("\\,");
                for (int k = 0; k < 2; k++) {
                    arrayOfSeatAllocation[j][k] = Integer.valueOf(row[k]);
                }
            }

            Transaction t = new Transaction(transactionId, purchaseDate, purchaseTime, userId, movieId, date, time,
                    cinema, totalCost,
                    ticketCount, arrayOfTicketCatgeory, arrayOfSeatAllocation);
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
                System.out.println("Transaction " + t.getTransactionId());
                System.out.println(Arrays.toString(t.getArrayOfTicketCatgeory()));
                System.out.println(Arrays.deepToString(t.getArrayOfSeatAllocation()));
            }
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
