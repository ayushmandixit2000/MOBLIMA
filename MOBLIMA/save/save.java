package MOBLIMA.save;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Interface for relevant classes to implement.
 */
public class save {
    /**
     * Separator used to denote different data boundaries in the database.
     */
    public static final String SEPARATOR = "|";

    /**
     * Writes data from a specific file.
     * 
     * @param fileName The file path to the file to write into.
     */
    public static void write(String fileName, List data) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(fileName));
        try {
            for (int i = 0; i < data.size(); i++) {
                out.println((String) data.get(i));
            }
        } finally {
            out.close();
        }
    }

}