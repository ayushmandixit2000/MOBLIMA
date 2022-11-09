package MOBLIMA.useractions;

import java.io.IOException;
import java.util.Scanner;

import MOBLIMA.dataStructure.Showtime;

public class choosingseats {
    private Showtime s1;

    public void setshow(Showtime s) {
        this.s1 = s;
    }

    public void display() throws IOException {
        Scanner scc = new Scanner(System.in);
        System.out.println("How many tickets will you like to purchase?");
        int num = scc.nextInt();

        System.out
                .println("Please key in seat. Note: Choose unoccupied seats (0) and enter the row followed by column");

        int[][] chosenseat = new int[num][2];

        for (int a = 0; a < num; a++) {

            int taken = 1;

            while (taken == 1) {

                int b = a + 1;
                System.out.println("\nTicket " + b + " : ");

                int r = 0;
                while (r < 65 || r > 74) {
                    System.out.println("Please key in row of seat. E.g C: ");
                    String c1 = scc.next();
                    String c = c1.toUpperCase();
                    char row1 = c.charAt(0);
                    r = (int) row1;
                }

                int column = -1;

                while (column < 0 || column > 18 || column == 10) {
                    System.out.println("Please key in Column  E.g 2:");
                    column = scc.nextInt();
                }

                String s8 = Character.toString((char) r);
                System.out.println("Row Selected: " + s8);
                System.out.println("Column Selected: " + column);

                int[][] st = s1.getSeating();

                if (st[r - 65][column - 1] == 1) {
                    System.out.println("This seat is already taken, please choose another seat");
                    continue;
                }

                else if (st[r - 65][column - 1] == 2) {
                    System.out.println("This is not a seat, please choose a seat");
                    continue;
                }

                else if (inarray(r - 65, column, chosenseat)) {
                    System.out.println("You have already selected this seat");
                    continue;
                }

                else {
                    taken = 0;
                }

                System.out.println("You have selected row: " + s8 + " and column " + column);

                chosenseat[a][0] = r - 65;
                chosenseat[a][1] = column;

            }

        }

        int[][] st = s1.getSeating();

        System.out.println("Printing selected seats...");
        System.out.println("_____________________________________________________");
        System.out.println();
        System.out.println(
                "Cinema :" + s1.getCinema() + " ||" + "Date: " + s1.getDate() + " ||" + "Time: " + s1.getTime()
                        + " ||");
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
                if (inarray(i, j + 1, chosenseat)) {
                    System.out.print("X");
                } else {
                    System.out.print(st[i][j]);
                }
                System.out.print("  ");
            }
            System.out.println();
            System.out.println();
        }

        System.out.println("Legend - X Seat: Selected");
        System.out.println("Legend - 0: Unoccupied");
        System.out.println("Legend - 1: Occupied");
        System.out.println("Legend - 2: Alleys and Stairs");
        System.out.println();
        System.out.println("_____________________________________________________");

        System.out.println("Would you like to buy the tickets?");
        System.out.println("1: Yes");
        System.out.println("2: No");

        int conopt = scc.nextInt();

        if (conopt != 1) {
            System.out.println("Exiting...");
        }

        CustomerTicket ct = new CustomerTicket();
        ct.setshow(s1);
        ct.setseats(chosenseat);
        ct.display();
    }

    public boolean inarray(int row, int column, int[][] curarray) {
        for (int i = 0; i < curarray.length; i++) {
            if (curarray[i][0] == row && curarray[i][1] == column) {
                return true;
            }
        }
        return false;
    }
}
