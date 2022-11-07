package MOBLIMA.save;

import java.io.IOException;
import java.util.List;
import MOBLIMA.dataStructure.Transaction;
import MOBLIMA.retrieval.retrieveTransaction;

import java.util.ArrayList;

public class saveTransaction extends save {
    public static void saveTransactionArray(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store data
        for (int i = 0; i < al.size(); i++) {

            // todo
            Transaction t = (Transaction) al.get(i); // moving through the object to get the necessary info
            StringBuilder st = new StringBuilder();
            st.append(t.getTransactionId());
            st.append(SEPARATOR);
            st.append(t.getPurchaseDate());
            st.append(SEPARATOR);
            st.append(t.getPurchaseTime());
            st.append(SEPARATOR);
            st.append(t.getUserId());
            st.append(SEPARATOR);
            st.append(t.getMovieId());
            st.append(SEPARATOR);
            st.append(t.getDate());
            st.append(SEPARATOR);
            st.append(t.getTime());
            st.append(SEPARATOR);
            st.append(t.getCinema());
            st.append(SEPARATOR);
            st.append(t.getTotalCost());
            st.append(SEPARATOR);
            st.append(t.getTicketCount());
            st.append(SEPARATOR);

            for (int j = 0; j < t.getTicketCount(); j++) {
                st.append(t.getArrayOfTicketCatgeory()[j]);
                st.append(',');
            }

            st.setLength(st.length() - 1);

            st.append(SEPARATOR);

            for (int j = 0; j < t.getTicketCount(); j++) {
                for (int k = 0; k < 2; k++) {
                    st.append(t.getArrayOfSeatAllocation()[j][k]);
                    st.append(',');
                }
                st.setLength(st.length() - 1);
                st.append('.');
            }
            st.setLength(st.length() - 1);

            alw.add(st.toString());
        }
        write(filename, alw);
    }

    public static void main(String[] aArgs) throws IOException {
        String filename = "MOBLIMA/databases/transactions.txt";
        ArrayList transactionArray = retrieveTransaction.readTransaction(filename); // retrieve current array

        // add new transaction
        int[][] seatings = { { 1, 2 }, { 4, 5 } };
        Transaction t = new Transaction("tid", "purchaseDate", 2000, "userid", 2, "date", 2100, "cinema", 10, 2,
                new String[] { "0", "1" }, seatings);
        transactionArray.add(t);

        // save to same file
        saveTransaction.saveTransactionArray(filename, transactionArray);
    }
}