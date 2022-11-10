package MOBLIMA.utils;

import java.time.LocalDate;
import java.util.Comparator;

public class comparePH implements Comparator<LocalDate> {
    public int compare(LocalDate s1, LocalDate s2) {
        return s1.compareTo(s2);

    }
}