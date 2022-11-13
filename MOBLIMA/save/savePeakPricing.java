package MOBLIMA.save;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Helper class to save peakPricing String into the peakPricing database.
 */
public class savePeakPricing extends save {
    /**
     * Converts the String of peakPricings into data.
     * 
     * @param filename The file path to the file to be written into.
     * @param prices   The peakPricings to be written.
     */
    public static void savePeakPricingString(String filename, String prices) throws IOException {
        List alw = new ArrayList();
        alw.add(prices);
        write(filename, alw);
    }
}