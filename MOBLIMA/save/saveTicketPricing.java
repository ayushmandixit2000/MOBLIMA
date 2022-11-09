package MOBLIMA.save;

import java.io.IOException;
import java.util.List;
import MOBLIMA.retrieval.retrieveTicketPricing;
import java.util.ArrayList;

public class saveTicketPricing extends save {
    public static void saveTicketPricingString(String filename, String prices) throws IOException {
        List alw = new ArrayList();
        alw.add(prices);
        write(filename, alw);
    }

    public static void main(String[] aArgs) throws IOException {
        String filename = "MOBLIMA/databases/ticketPricing.txt";
        String ticketPricing = retrieveTicketPricing.readTicketPricing(filename);

        ticketPricing = "6,11,8";

        // save to same file
        saveTicketPricing.saveTicketPricingString(filename, ticketPricing);
    }

}