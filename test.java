import java.time.LocalDate;
import java.time.LocalTime;

import MOBLIMA.utils.dateTime;

public class test {
    public static void main(String[] args) {
        String m = "movieId";
        LocalDate d = dateTime.convertDate("2022/12/11");
        LocalTime t = dateTime.convertTime(1900);
        int r = 1;
        int c = 2;
        String mt = m + dateTime.convertDate(d) + dateTime.convertTime(t) + String.valueOf(r) + String.valueOf(c);
        System.out.println(mt);
    }
}