package MOBLIMA.save;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Helper class to save ticketPricing String into the ticketPricing database.
 */
public class saveTicketPricing extends save {
    /**
     * Converts the String of ticketPricing into data.
     * 
     * @param filename The file path to the file to be written into.
     * @param prices   The ticketPricing to be written.
     */
    public static void saveTicketPricingString(String filename, String prices) throws IOException {
        List alw = new ArrayList();
        alw.add(prices);
        write(filename, alw);
    }
}