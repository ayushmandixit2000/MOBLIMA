package MOBLIMA.save;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import MOBLIMA.dataStructure.Movie;
import MOBLIMA.retrieval.retrieveMovie;

/**
 * Helper class to save movie objects into the movie database.
 */
public class saveMovie extends save {
    /**
     * Converts the fields of movie objects into data.
     * 
     * @param filename The file path to the file to be written into.
     * @param al       The movie objects to be converted into data.
     */
    public static void saveMovieArray(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store data
        for (int i = 0; i < al.size(); i++) {
            Movie m = (Movie) al.get(i); // moving through the object to get the necessary info
            StringBuilder st = new StringBuilder();

            st.append(i);
            st.append(SEPARATOR);
            st.append(m.getTitle());
            st.append(SEPARATOR);
            st.append(m.getShowStatus());
            st.append(SEPARATOR);
            st.append(m.getDirector());
            st.append(SEPARATOR);
            for (int j = 0; j < m.getCast().length; j++) {
                st.append(m.getCast()[j]);
                st.append(',');
            }
            st.setLength(st.length() - 1);
            st.append(SEPARATOR);
            st.append(m.getSynopsis());
            st.append(SEPARATOR);
            st.append(m.getMovieRating());
            st.append(SEPARATOR);
            st.append(m.getMovieType());
            st.append(SEPARATOR);
            st.append(m.getSales());
            st.append(SEPARATOR);
            st.append(m.getIsDeleted());
            st.append(SEPARATOR);
            m.setNumReviews();
            st.append(m.getNumReviews());
            st.append(SEPARATOR);
            m.setAvgRating();
            st.append(m.getAvgRating());
            alw.add(st.toString());
        }
        write(filename, alw);
    }
}