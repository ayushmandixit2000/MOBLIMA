package MOBLIMA.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import MOBLIMA.dataStructure.Transaction;
import MOBLIMA.listing.TransactionDetailsListing;
import MOBLIMA.retrieval.retrieveTransaction;
import MOBLIMA.utils.dateTime;

public class pastTransactionsFacade {
    private static String userid;

    public static void run(String userId) throws IOException {
        userid = userId;
        display();
    }

    public static void display() throws IOException {
        Scanner scc = new Scanner(System.in);
        String filename = "MOBLIMA/databases/transactions.txt";
        ArrayList transactionArray = retrieveTransaction.readTransaction(filename);
        List<Transaction> optionlist = new ArrayList<Transaction>();

        for (int i = 0; i < transactionArray.size(); i++) {
            Transaction t = (Transaction) transactionArray.get(i);

            if (t.getUserId().contains(userid)) {
                optionlist.add(t);
            }
        }

        if (optionlist.size() == 0) {
            System.out.println("\nNo past history on Moblima for user " + userid);
        }

        else {
            System.out.println("\nPlease select the transaction you will like to eqnuire more about: ");

            for (int l = 0; l < optionlist.size(); l++) {
                Transaction t2 = optionlist.get(l);
                System.out.println(
                        l + 1 + " : Transaction ID - " + t2.getTransactionId() + " Purchased on "
                                + t2.getPurchaseDate());
            }

            int opt;

            while (true) {
                String input = scc.next();
                opt = 0;
                try {
                    opt = Integer.parseInt(input);
                    if (opt < 1 || opt > optionlist.size()) {
                        System.out.println("Please key in a number from the list above only!");
                        continue;
                    } else {
                        break;
                    }
                } catch (NumberFormatException ne) {
                    System.out.println("Please key in a number only!");
                }
            }

            for (int l = 0; l < optionlist.size(); l++) {
                if (opt == l + 1) {
                    Transaction t3 = optionlist.get(l);
                    System.out.println("\nTransaction Selected: " + " Transaction ID - " + t3.getTransactionId()
                            + " Purchased on " + dateTime.convertDate(t3.getPurchaseDate()));
                    TransactionDetailsListing tdl = new TransactionDetailsListing();
                    tdl.settransaction(t3);
                    tdl.displayListing();

                }
            }
        }

    }
}
