package MOBLIMA.save;

import java.io.IOException;
import java.util.List;
import MOBLIMA.retrieval.retrievePeakPricing;

import java.util.ArrayList;

public class savePeakPricing extends save {
    public static void savePeakPricingString(String filename, String prices) throws IOException {
        List alw = new ArrayList();
        alw.add(prices);
        write(filename, alw);
    }

    public static void main(String[] aArgs) throws IOException {
        String filename = "MOBLIMA/databases/peakPricing.txt";
        String peakPricing = retrievePeakPricing.readPeakPricing(filename);

        peakPricing = "1.2,1.7";

        // save to same file
        savePeakPricing.savePeakPricingString(filename, peakPricing);
    }

}