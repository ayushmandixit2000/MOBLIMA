package MOBLIMA.save;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import MOBLIMA.dataStructure.Cinema;
import MOBLIMA.retrieval.retrieveCinema;

public class saveCinema extends save {
    public static final int ROWS = 9;
    public static final int COLUMNS = 17;

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
            st.append(SEPARATOR);
            for (int j = 0; j < ROWS; j++) {
                for (int k = 0; k < COLUMNS; k++) {
                    st.append(c.getLayout()[j][k]);
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
        String filename = "MOBLIMA/databases/cinema.txt";
        ArrayList cinemaArray = retrieveCinema.readCinema(filename); // retrieve current array
        // add new cinema
        int[][] layout = { { 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 } };
        Cinema c = new Cinema("cinema", 1, 1, layout);
        cinemaArray.add(c);
        // save to same file
        saveCinema.saveCinemaArray(filename, cinemaArray);
    }
}
