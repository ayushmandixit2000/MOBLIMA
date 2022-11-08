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
        String s = "Cat2022/12/141630";
        System.out.println(s.substring(3, 13));
        System.out.println("test".split("\\.")[0]);
        System.out.println("ABC2022/12/12190014".substring(0, 3));
    }

}