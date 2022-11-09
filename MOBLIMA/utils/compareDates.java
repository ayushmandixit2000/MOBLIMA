package MOBLIMA.utils;

import java.util.Comparator;

import MOBLIMA.dataStructure.Showtime;

public class compareDates implements Comparator<Showtime> {
    public int compare(Showtime s1, Showtime s2) {
        int comp1 = s1.getDate().compareTo(s2.getDate());
        if (comp1 != 0) {
            return comp1;
        }
        return s1.getTime().compareTo(s2.getTime());
    }

}
