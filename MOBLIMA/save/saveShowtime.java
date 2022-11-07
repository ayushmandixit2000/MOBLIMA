package MOBLIMA.save;

import java.io.IOException;
import java.util.List;

import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrieveShowtime;

import java.util.ArrayList;

public class saveShowtime extends save {
    public static void saveShowtimeArray(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store data
        for (int i = 0; i < al.size(); i++) {
            Showtime s = (Showtime) al.get(i); // moving through the object to get the necessary info
            StringBuilder st = new StringBuilder();

            st.append(s.getCineplex());
            st.append(SEPARATOR);
            st.append(s.getCinema());
            st.append(SEPARATOR);
            st.append(s.getDate());
            st.append(SEPARATOR);
            st.append(s.getTimeSlot());
            st.append(SEPARATOR);
            st.append(s.getMovieId());
            st.append(SEPARATOR);

            for (int j = 0; j < s.getSeating().length; j++) {
                for (int k = 0; k < s.getSeating().length; k++) {
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
        int[][] seating = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Showtime s = new Showtime("cp", 1, "date", 2000, 1, seating);
        showtimeArray.add(s);

        // save to same file
        saveShowtime.saveShowtimeArray(filename, showtimeArray);
    }
}