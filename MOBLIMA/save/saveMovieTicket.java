package MOBLIMA.save;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import MOBLIMA.dataStructure.MovieTicket;
import MOBLIMA.retrieval.retrieveMovieTicket;
import MOBLIMA.retrieval.retrieveShowtime;

import java.util.ArrayList;

public class saveMovieTicket extends save {

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

            alw.add(st.toString());
        }
        write(filename, alw);
    }

    public static void main(String[] aArgs) throws IOException {
        String filename = "MOBLIMA/databases/MovieTicket.txt";
        ArrayList movieTicketArray = retrieveMovieTicket.readMovieTicket(filename); // retrieve current array

        // add new showtime
        MovieTicket mt = new MovieTicket("0", 1, 5, "Dog2022/12/141630");
        movieTicketArray.add(mt);
        // save to same file
        saveMovieTicket.saveMovieTicketArray(filename, movieTicketArray);
    }
}