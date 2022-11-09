package MOBLIMA.useractions;

import java.util.Scanner;

import MOBLIMA.dataStructure.Showtime;

public class SeatAvailability {
    private Showtime s;

    public void setshow(Showtime s1) {
        this.s = s1;
    }

    public void display() {
        Scanner scc = new Scanner(System.in);
        int[][] st = s.getSeating();

        System.out.println("_____________________________________________________");
        System.out.println();
        System.out.println(
                "Cinema :" + s.getCinema() + " ||" + "Date: " + s.getDate() + " ||" + "Time: " + s.getTime() + " ||");
        System.out.println();

        System.out.println("    _  _  _  _  _  _  _  _  _ __ __ __ __ __ __ __ __");
        System.out.println("    1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17");
        System.out.println("    _  _  _  _  _  _  _  _  _ __ __ __ __ __ __ __ __");
        System.out.println();
        int k = 65;
        for (int i = 0; i < st.length; i++) {
            String s = Character.toString((char) k);
            System.out.print("|" + s + "| ");
            k++;
            for (int j = 0; j < st[i].length; j++) {
                System.out.print(st[i][j]);
                System.out.print("  ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Legend - 0: Unoccupied");
        System.out.println("Legend - 8: Occupied");
        System.out.println("Legend - 1: Alleys and Stairs");
        System.out.println();
        System.out.println("_____________________________________________________");

        System.out.println("Would you like to select seats? ");
        System.out.println("1: Yes");
        System.out.println("2: No");

        int opt = scc.nextInt();

        if(opt != 1){
            return;
        }

        choosingseats cs = new choosingseats();
        cs.setshow(s);
        cs.display();
    }
}