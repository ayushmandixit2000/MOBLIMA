package MOBLIMA.retrieval;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import MOBLIMA.dataStructure.Transaction;

public class retrieveTransaction extends retrieve {
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
            String arrayOfTicketCatgeory = star.nextToken().trim();
            String arrayOfSeatAllocation = star.nextToken().trim();
            Transaction t = new Transaction(transactionId, purchaseDate, purchaseTime, userId, movieId, date, time,
                    cinema,
                    totalCost, ticketCount, arrayOfTicketCatgeory, arrayOfSeatAllocation);
            alr.add(t);
        }
        return alr;
    }

    public static void main(String[] aArgs) {
        String filename = "MOBLIMA/databases/transactions.txt";
        try {
            ArrayList al = retrieveTransaction.readTransaction(filename);
            for (int i = 0; i < al.size(); i++) {
                Transaction t = (Transaction) al.get(i);
                System.out.println("Transaction " + t.getTransactionId());
            }
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}
