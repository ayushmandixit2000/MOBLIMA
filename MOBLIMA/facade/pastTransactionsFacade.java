package MOBLIMA.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import MOBLIMA.Listings.TransactionDetailsListing;
import MOBLIMA.dataStructure.Transaction;
import MOBLIMA.retrieval.retrieveTransaction;
import MOBLIMA.utils.dateTime;

public class pastTransactionsFacade {

    private String userid;

    public void setuserid(String userid) {
        this.userid = userid;
    }

    public void display() throws IOException {
        Scanner scc = new Scanner(System.in);
        String filename = "MOBLIMA/databases/transactions.txt";
        ArrayList transactionArray = retrieveTransaction.readTransaction(filename);
        List<Transaction> optionlist = new ArrayList<Transaction>();

        for (int i = 0; i < transactionArray.size(); i++) {
            Transaction t = (Transaction) transactionArray.get(i);

            if (t.getUserId().contains(this.userid)) {
                optionlist.add(t);
            }
        }

        if (optionlist.size() == 0) {
            System.out.println("\nNo past history on Moblima for user" + userid);
        }

        else {
            System.out.println("\nPlease select the transaction you will like to eqnuire more about: ");

            for (int l = 0; l < optionlist.size(); l++) {
                Transaction t2 = optionlist.get(l);
                System.out.println(
                        l + 1 + " : Transaction ID - " + t2.getTransactionId() + " Purchased on " + t2.getPurchaseDate());
            }

            int option = scc.nextInt();

            for (int l = 0; l < optionlist.size(); l++) {
                if(option == l + 1){
                    Transaction t3 = optionlist.get(l);
                    System.out.println("\nTransaction Selected: " + " Transaction ID - " + t3.getTransactionId() + " Purchased on " + dateTime.convertDate(t3.getPurchaseDate()));
                    TransactionDetailsListing tdl = new TransactionDetailsListing();
                    tdl.settransaction(t3);
                    tdl.displayListing();
                    
                }
            }
        }

    }
}
