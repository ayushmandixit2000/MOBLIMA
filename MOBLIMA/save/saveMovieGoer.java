package MOBLIMA.save;

import java.io.IOException;
import java.util.List;

import MOBLIMA.dataStructure.MovieGoer;
import MOBLIMA.retrieval.retrieveMovieGoer;

import java.util.ArrayList;

public class saveMovieGoer extends save {
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

    public static void main(String[] aArgs) throws IOException {
        String filename = "MOBLIMA/databases/movieGoer.txt";
        ArrayList movieGoerArray = retrieveMovieGoer.readMovieGoer(filename); // retrieve current array

        // add new movieGoer
        MovieGoer mg = new MovieGoer("userid", "name", 91223132, "email");
        movieGoerArray.add(mg);

        // save to same file
        saveMovieGoer.saveMovieGoerArray(filename, movieGoerArray);
    }

}