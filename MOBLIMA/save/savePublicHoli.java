package MOBLIMA.save;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import MOBLIMA.retrieval.retrievePH;
import MOBLIMA.utils.dateTime;
import java.util.ArrayList;

public class savePublicHoli extends save {

    public static void savePHArray(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store data
        for (int i = 0; i < al.size(); i++) {
            LocalDate date = (LocalDate) al.get(i);
            alw.add(dateTime.convertDate(date));
        }
        write(filename, alw);
    }

    public static void main(String[] aArgs) throws IOException {
        String filename = "MOBLIMA/databases/publicholidays.txt";
        ArrayList phArray = retrievePH.readPH(filename); // retrieve current array
        LocalDate date = dateTime.convertDate("2023/04/07");
        phArray.add(date);
        // save to same file
        savePublicHoli.savePHArray(filename, phArray);
    }
}