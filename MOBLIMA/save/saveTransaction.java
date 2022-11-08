package MOBLIMA.save;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import MOBLIMA.dataStructure.Transaction;
import MOBLIMA.retrieval.retrieveTransaction;
import MOBLIMA.utils.dateTime;

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
            st.append(dateTime.convertDate(t.getPurchaseDate()));
            st.append(SEPARATOR);
            st.append(dateTime.convertTime(t.getPurchaseTime()));
            st.append(SEPARATOR);
            st.append(t.getUserId());
            st.append(SEPARATOR);

            for (int j = 0; j < t.getArrayofMovieTickets().length; j++) {
                st.append(t.getArrayofMovieTickets()[j]);
                st.append(',');
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
        LocalDate date = dateTime.convertDate("2022/12/20");
        LocalTime time = dateTime.convertTime(1900);
        Transaction t = new Transaction(date, time, "userid", new String[] {"ABC2022/12/12190014"});
        transactionArray.add(t);

        // save to same file
        saveTransaction.saveTransactionArray(filename, transactionArray);
    }
}