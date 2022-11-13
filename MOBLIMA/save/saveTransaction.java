package MOBLIMA.save;

import java.io.IOException;
import java.util.List;
import MOBLIMA.dataStructure.Transaction;
import MOBLIMA.retrieval.retrieveTransaction;
import MOBLIMA.utils.dateTime;
import java.util.ArrayList;

/**
 * Helper class to save transaction objects into the transactions database.
 */
public class saveTransaction extends save {
    /**
     * Converts the fields of transaction objects into data.
     * 
     * @param filename The file path to the file to be written into.
     * @param al       The transaction objects to be converted into data.
     */
    public static void saveTransactionArray(String filename, List al) throws IOException {
        List alw = new ArrayList();
        for (int i = 0; i < al.size(); i++) {
            Transaction t = (Transaction) al.get(i);
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
}