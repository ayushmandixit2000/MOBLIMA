package MOBLIMA.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class dateTime {
    public static LocalDate getDate() {
        Scanner input = new Scanner(System.in);
        String date = input.nextLine();
        System.out.println("Pls input date in the format of YYYY/MM/DD");
        int year = Integer.valueOf(date.split("\\/")[0]);
        int month = Integer.valueOf(date.split("\\/")[1]);
        int day = Integer.valueOf(date.split("\\/")[2]);
        LocalDate d = LocalDate.of(year, month, day);
        input.close();
        return d;
    }

    public static LocalTime getTime() {
        Scanner input = new Scanner(System.in);
        System.out.println("Pls input time in the format of HHMM");
        int time = input.nextInt();
        int hr = Integer.parseInt(Integer.toString(time).substring(0, 2));
        int min = Integer.parseInt(Integer.toString(time).substring(2, 4));
        LocalTime t = LocalTime.of(hr, min, 0, 0);
        input.close();
        return t;
    }

    public static LocalDate convertDate(String date) {
        int year = Integer.valueOf(date.split("\\/")[0]);
        int month = Integer.valueOf(date.split("\\/")[1]);
        int day = Integer.valueOf(date.split("\\/")[2]);
        LocalDate d = LocalDate.of(year, month, day);
        return d;
    }

    public static LocalTime convertTime(String time) {
        int hr = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(2, 4));
        LocalTime t = LocalTime.of(hr, min, 0, 0);
        return t;
    }

    public static String convertDate(LocalDate date) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return date.format(myFormatObj);
    }

    public static String convertTime(LocalTime time) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HHmm");
        return time.format(myFormatObj);
    }
}
