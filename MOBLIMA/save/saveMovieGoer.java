package MOBLIMA.save;

import java.io.IOException;
import java.util.List;

import MOBLIMA.dataStructure.MovieGoer;
import MOBLIMA.retrieval.retrieveMovieGoer;
import java.util.ArrayList;

/**
 * Helper class to save moviegoer objects into the moviegoer database.
 */
public class saveMovieGoer extends save {
    /**
     * Converts the fields of moviegoer objects into data.
     * 
     * @param filename The file path to the file to be written into.
     * @param al       The moviegoer objects to be converted into data.
     */
    public static void saveMovieGoerArray(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store data
        for (int i = 0; i < al.size(); i++) {
            MovieGoer mg = (MovieGoer) al.get(i); // moving through the object to get the necessary info
            StringBuilder st = new StringBuilder();

            st.append(mg.getUserId());
            st.append(SEPARATOR);
            st.append(mg.getName());
            st.append(SEPARATOR);
            st.append(mg.getMobileNumber());
            st.append(SEPARATOR);
            st.append(mg.getEmail());
            alw.add(st.toString());
        }
        write(filename, alw);
    }
}