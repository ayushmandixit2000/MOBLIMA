package MOBLIMA.save;

import java.io.IOException;
import java.util.List;

import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrieveShowtime;

import java.util.ArrayList;

public class saveShowtime extends save {
    public static final int ROWS = 9;
    public static final int COLUMNS = 17;

    public static void saveShowtimeArray(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store data
        for (int i = 0; i < al.size(); i++) {
            Showtime s = (Showtime) al.get(i); // moving through the object to get the necessary info
            StringBuilder st = new StringBuilder();

            st.append(s.getCinema());
            st.append(SEPARATOR);
            st.append(s.getDate());
            st.append(SEPARATOR);
            st.append(s.getTimeSlot());
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

            alw.add(st.toString());
        }
        write(filename, alw);
    }

    public static void main(String[] aArgs) throws IOException {
        String filename = "MOBLIMA/databases/Showtime.txt";
        ArrayList showtimeArray = retrieveShowtime.readShowtime(filename); // retrieve current array

        // add new showtime
        int[][] seating = { { 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1 } };
        Showtime s = new Showtime("cinema", "date", 2000, 1, seating);
        showtimeArray.add(s);

        // save to same file
        saveShowtime.saveShowtimeArray(filename, showtimeArray);
    }
}