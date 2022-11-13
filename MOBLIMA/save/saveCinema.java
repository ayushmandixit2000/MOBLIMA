package MOBLIMA.save;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import MOBLIMA.dataStructure.Cinema;

/**
 * Helper class to save cinema objects into the cinema database.
 */
public class saveCinema extends save {
    /**
     * Converts the fields of cinema objects into data.
     * 
     * @param filename The file path to the file to be written into.
     * @param al       The cinema objects to be converted into data.
     */
    public static void saveCinemaArray(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store data
        for (int i = 0; i < al.size(); i++) {
            Cinema c = (Cinema) al.get(i); // moving through the object to get the necessary info
            StringBuilder st = new StringBuilder();

            st.append(c.getCinema());
            st.append(SEPARATOR);
            st.append(c.getCineplex());
            st.append(SEPARATOR);
            st.append(c.getMovieClass());
            alw.add(st.toString());
        }
        write(filename, alw);
    }
}
