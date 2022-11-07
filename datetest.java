import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class datetest {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        // String date = input.nextLine();
        // int year = Integer.valueOf(date.split("\\/")[0]);
        // int month = Integer.valueOf(date.split("\\/")[1]);
        // int day = Integer.valueOf(date.split("\\/")[2]);
        // LocalDate d = LocalDate.of(year, month, day);
        // System.out.println(d.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));//14/12/22

        // DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        // String formattedDate = d.format(myFormatObj);
        // System.out.println("After formatting: " + formattedDate);

        int time = input.nextInt();
        int hr = Integer.parseInt(Integer.toString(time).substring(0, 2));
        int min = Integer.parseInt(Integer.toString(time).substring(2, 4));
        LocalTime t = LocalTime.of(hr, min, 0, 0);
        System.out.println(t.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HHmm");
        String formattedDate = t.format(myFormatObj);
        System.out.println("After formatting: " + formattedDate);
        // // 11:45 PM

        // LocalDateTime dt = LocalDateTime.of(2022, 05, 2,12,3);
        // System.out.println(dt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));

        // // Current date
        // Date now = new Date();
        // System.out.println(now.toString());
        // // example formating - for more, refer to Java API for SimpleDateFormat class
        // SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
        // System.out.println(dateFormatter.format(now));

        // // Using Calendar class
        // Calendar cal = Calendar.getInstance();
        // // get Date from calendar
        // Date dateNow = cal.getTime();
        // System.out.println(dateFormatter.format(dateNow));
        // // extract individual fields from calendar
        // int year = cal.get(Calendar.YEAR);
        // int month = cal.get(Calendar.MONTH); // NOTE!!! : Month from 0 to 11
        // int day = cal.get(Calendar.DAY_OF_MONTH);
        // int hour = cal.get(Calendar.HOUR_OF_DAY);
        // int minute = cal.get(Calendar.MINUTE);
        // int second = cal.get(Calendar.SECOND);

        // System.out.printf("Now is %4d/%02d/%02d %02d:%02d:%02d\n", // Pad with zero
        // year, month + 1, day, hour, minute, second);
        // System.out.println("Now is " + year + "/" + (month + 1) + "/" + day);

        // // Manipulating Dates
        // Calendar aDate, calTemp;
        // aDate = new GregorianCalendar(2013, 3, 5, 13, 30);
        // // // NOTE!!! : Month from 0 to 11 => 3 is April
        // calTemp = (Calendar) aDate.clone();

        // // add time
        // calTemp.add(Calendar.MINUTE, 30);
        // System.out.println("30 minutes later, it will be: " + calTemp.getTime());

        // // compare calendar
        // if (calTemp.after(aDate)) {
        // System.out.println(calTemp.getTime() + " is after " + aDate.getTime());
        // }

        // }
    }
}
