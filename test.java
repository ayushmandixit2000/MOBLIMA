import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import MOBLIMA.configurables.ageGroupPricing;
import MOBLIMA.configurables.peakDates;
import MOBLIMA.configurables.peakPricing;
import MOBLIMA.dataStructure.Showtime;
import MOBLIMA.retrieval.retrievePH;
import MOBLIMA.utils.TicketPrice;
import MOBLIMA.utils.dateTime;

public class test {
    public static void main(String[] args) throws IOException {
        String m = "movieId";
        LocalDate d = dateTime.convertDate("2022/12/11");
        LocalTime t = dateTime.convertTime("1900");
        int r = 1;
        int c = 2;
        String mt = m + dateTime.convertDate(d) + dateTime.convertTime(t) + String.valueOf(r) + String.valueOf(c);
        System.out.println(mt);
        String s = "Cat2022/12/141630";
        System.out.println(s.substring(3, 13));
        System.out.println("test".split("\\.")[0]);
        System.out.println("ABC2022/12/12190014".substring(0, 3));
        new peakPricing();
        System.out.println(peakPricing.getPeakMultiplier());
        peakPricing.setPeakMultiplier(2);
        peakPricing.saveMultipliers();

        new peakDates();
        String filename = "MOBLIMA/databases/publicholidays.txt";
        ArrayList al = retrievePH.readPH(filename);
        for (int i = 0; i < al.size(); i++) {
            LocalDate date = (LocalDate) al.get(i);
            System.out.println(dateTime.convertDate(date));
        }
        System.out.println(peakDates.isPeak(dateTime.convertDate("2022/12/26")));

        new ageGroupPricing();
        System.out.println(ageGroupPricing.getPriceOfChild());
        ageGroupPricing.setPriceOfChild(5);
        ageGroupPricing.savePricing();

        System.out.println(dateTime.convertDate(LocalDate.now()));
        System.out.println(dateTime.convertTime(LocalTime.now()));
        // test

        int[][] seating = { { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                { 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
                { 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 2 } };
        LocalDate date = dateTime.convertDate("2022/12/21");
        LocalTime time = dateTime.convertTime("1900");
        Showtime st = new Showtime("cin", date, time, 1, seating);
        System.out.println(st.getShowtimeId());
        st.addSeating(2, 3);
    }

}