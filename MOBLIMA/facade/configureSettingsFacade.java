package MOBLIMA.facade;

import java.io.IOException;
import MOBLIMA.configurables.ageGroupPricing;
import MOBLIMA.configurables.peakDates;
import MOBLIMA.configurables.peakPricing;
import MOBLIMA.configure.configurePeakDates;
import MOBLIMA.configure.configurePeakPricing;
import MOBLIMA.configure.configureRankStatus;
import MOBLIMA.configure.configureTicketPricing;
import MOBLIMA.listing.configureListing;

/**
 * Consolidated class to link all the required classes together to execute the
 * Configure Setting functionality.
 */
public class configureSettingsFacade {
    /**
     * Display the options users have and to instantantiate related classes and
     * execute their required functionalities.
     */
    public static void configureSettings() throws IOException {
        configureListing c = new configureListing();
        boolean loop = true;
        while (loop) {
            c.displayListing();
            c.getUserInput();
            int option = c.getOption();
            switch (option) {
                case 1:
                    new ageGroupPricing();
                    configureTicketPricing ctp = new configureTicketPricing();
                    ctp.displaySetting();
                    ctp.getNewSetting();
                    ctp.displaySetting();
                    break;
                case 2:
                    new peakPricing();
                    configurePeakPricing cpp = new configurePeakPricing();
                    cpp.displaySetting();
                    cpp.getNewSetting();
                    cpp.displaySetting();
                    break;
                case 3:
                    new peakDates();
                    configurePeakDates cpd = new configurePeakDates();
                    cpd.displaySetting();
                    cpd.getNewSetting();
                    cpd.displaySetting();
                    break;
                case 4:
                    configureRankStatus crs = new configureRankStatus();
                    crs.displaySetting();
                    crs.getNewSetting();
                    crs.displaySetting();
                    break;
                case 5:
                    loop = false;
                    break;
            }
        }
        System.out.println("Exited");
    }
}
