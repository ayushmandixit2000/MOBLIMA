package MOBLIMA.save;

import java.io.IOException;
import java.util.List;
import MOBLIMA.dataStructure.MovieTicket;
import MOBLIMA.retrieval.retrieveMovieTicket;
import java.util.ArrayList;

/**
 * Helper class to save movieTicket objects into the movieTicket database.
 */
public class saveMovieTicket extends save {
    /**
     * Converts the fields of movieTicket objects into data.
     * 
     * @param filename The file path to the file to be written into.
     * @param al       The movieTicket objects to be converted into data.
     */
    public static void saveMovieTicketArray(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store data
        for (int i = 0; i < al.size(); i++) {
            MovieTicket mt = (MovieTicket) al.get(i); // moving through the object to get the necessary info
            StringBuilder st = new StringBuilder();

            st.append(mt.getMovieTicketId());
            st.append(SEPARATOR);
            st.append(mt.getAgeCat());
            st.append(SEPARATOR);
            st.append(mt.getSeatingRow());
            st.append(SEPARATOR);
            st.append(mt.getSeatingColumn());
            st.append(SEPARATOR);
            st.append(mt.getPrice());
            st.append(SEPARATOR);
            st.append(mt.getShowtimeId());
            st.append(SEPARATOR);
            st.append(mt.getSeatClass());

            alw.add(st.toString());
        }
        write(filename, alw);
    }
}