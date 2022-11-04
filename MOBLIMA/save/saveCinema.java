package MOBLIMA.save;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import MOBLIMA.dataStructure.Cinema;
import MOBLIMA.retrieval.retrieveCinema;

public class saveCinema extends save {
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
            st.append(c.getLayout());
            alw.add(st.toString());
        }
        write(filename, alw);
    }

    public static void main(String[] aArgs) throws IOException {
        String filename = "MOBLIMA/databases/cinema.txt";
        ArrayList cinemaArray = retrieveCinema.readCinema(filename); // retrieve current array
        // add new cinema
        Cinema c = new Cinema("cinema", 1, 1, "layout");
        cinemaArray.add(c);
        // save to same file
        saveCinema.saveCinemaArray(filename, cinemaArray);
    }
}
