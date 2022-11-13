package MOBLIMA.save;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrieveShowtime;
import MOBLIMA.utils.dateTime;
import java.util.ArrayList;

/**
 * Helper class to save showtime objects into the showtime database.
 */
public class saveShowtime extends save {
    /**
     * The number of rows in the seating availability of a showtime object.
     */
    public static final int ROWS = 9;
    /**
     * The number of columns in the seating availability of a showtime object.
     */
    public static final int COLUMNS = 19;

    /**
     * Converts the fields of showtime objects into data.
     * 
     * @param filename The file path to the file to be written into.
     * @param al       The showtime objects to be converted into data.
     */
    public static void saveShowtimeArray(String filename, List al) throws IOException {
        List alw = new ArrayList();
        for (int i = 0; i < al.size(); i++) {
            Showtime s = (Showtime) al.get(i);
            StringBuilder st = new StringBuilder();
            st.append(s.getCinema());
            st.append(SEPARATOR);
            st.append(dateTime.convertDate(s.getDate()));
            st.append(SEPARATOR);
            st.append(dateTime.convertTime(s.getTime()));
            st.append(SEPARATOR);
            st.append(s.getMovieId());
            st.append(SEPARATOR);

            for (int j = 0; j < ROWS; j++) {
                for (int k = 0; k < COLUMNS; k++) {
                    st.append(s.getSeating()[j][k]);
                    st.append(',');
                }
                st.setLength(st.length() - 1);
                st.append('.');
            }
            st.setLength(st.length() - 1);
            st.append(SEPARATOR);
            st.append(s.getShowtimeId());
            alw.add(st.toString());
        }
        write(filename, alw);
    }
}