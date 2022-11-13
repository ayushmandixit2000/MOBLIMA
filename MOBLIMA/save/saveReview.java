package MOBLIMA.save;

import java.io.IOException;
import java.util.List;
import MOBLIMA.dataStructure.Review;
import MOBLIMA.retrieval.retrieveReview;
import java.util.ArrayList;

/**
 * Helper class to save review objects into the reviews database.
 */
public class saveReview extends save {
    /**
     * Converts the fields of review objects into data.
     * 
     * @param filename The file path to the file to be written into.
     * @param al       The review objects to be converted into data.
     */
    public static void saveReviewArray(String filename, List al) throws IOException {
        List alw = new ArrayList();// to store data
        for (int i = 0; i < al.size(); i++) {
            Review r = (Review) al.get(i); // moving through the object to get the necessary info
            StringBuilder st = new StringBuilder();

            st.append(r.getMovieId());
            st.append(SEPARATOR);
            st.append(r.getRating());
            st.append(SEPARATOR);
            st.append(r.getReview());
            alw.add(st.toString());
        }
        write(filename, alw);
    }

    public static void main(String[] aArgs) throws IOException {
        String filename = "MOBLIMA/databases/review.txt";
        ArrayList reviewArray = retrieveReview.readReview(filename); // retrieve current array

        // add new review
        Review r = new Review(2, 3, "review");
        reviewArray.add(r);

        // save to same file
        saveReview.saveReviewArray(filename, reviewArray);
    }
}