package MOBLIMA.handler;

import java.io.IOException;
import java.util.Scanner;
import MOBLIMA.dataStructure.Showtime;

/**
 * Helper class to display the cinema's seat availability and validate the seat
 * indicated by moviegoer
 */
public class choosingseatsHandler {
    /**
     * The showtime of the movie being screened.
     */
    private Showtime s1;

    /**
     * The id of the moviegoer.
     */
    private String user;

    /**
     * Changes the id of the moviegoer.
     * 
     * @param ui The moviegoer's new id.
     */
    public void setuser(String ui) {
        this.user = ui;
    }

    /**
     * Changes the showtime of the chosen seat.
     * 
     * @param s The new showtime of the chose seat.
     */
    public void setshow(Showtime s) {
        this.s1 = s;
    }

    /**
     * Prints and prompts the moviegoer ticket booking requirements such as quantity
     * and ticket's seat's row and column
     * 
     */
    public void display() throws IOException {
        Scanner scc = new Scanner(System.in);
        System.out.println("How many tickets will you like to purchase?");

        int num;

        while (true) {
            String input = scc.next();
            num = 0;
            try {
                num = Integer.parseInt(input);
                if (num > 30 || num < 1) {
                    System.out.println("Please key in a valid number!");
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ne) {
                System.out.println("Please key in a number only!");
            }
        }

        System.out
                .println("Please key in seat. Note: Choose unoccupied seats (0) and enter the row followed by column");

        int[][] chosenseat = new int[num][2];

        for (int a = 0; a < num; a++) {

            int taken = 1;

            while (taken == 1) {

                int b = a + 1;
                System.out.println("\nTicket " + b + " : ");

                int r = 0;
                while (r < 65 || r > 73) {
                    System.out.println("Please key in row of seat. E.g C: ");
                    String c1 = scc.next();
                    String c = c1.toUpperCase();
                    char row1 = c.charAt(0);
                    r = (int) row1;
                }

                System.out.println("Select column: ");

                int column;

                while (true) {
                    String input = scc.next();
                    column = 0;
                    try {
                        column = Integer.parseInt(input);
                        if (column > 18 || column < 1) {
                            System.out.println("Please key in a valid number!");
                            continue;
                        } else {
                            break;
                        }
                    } catch (NumberFormatException ne) {
                        System.out.println("Please key in a number only!");
                    }
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

                if (st[r - 65][column - 1] == 5) {
                    if (a + 1 == num) {
                        System.out.println(
                                "You can't buy a couple seat because you will have to buy both seat. Please update your number of tickets and try again");
                        return;
                    }

                    System.out.println("You have selected a couple seat, the seat next to it will be auto selected");

                    if (st[r - 65][column - 2] == 5) {
                        chosenseat[a + 1][0] = r - 65;
                        chosenseat[a + 1][1] = column - 1;
                        a++;
                    } else if (st[r - 65][column] == 5) {
                        chosenseat[a + 1][0] = r - 65;
                        chosenseat[a + 1][1] = column + 1;
                        a++;
                    }
                }

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

        System.out.println("    _  _  _  _  _  _  _  _  _ __ __ __ __ __ __ __ __ __");
        System.out.println("    1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18");
        System.out.println("    _  _  _  _  _  _  _  _  _ __ __ __ __ __ __ __ __ __");
        System.out.println();
        System.out.println("_________________________SCREEN___________________________");
        System.out.println();
        int k = 65;
        for (int i = 0; i < st.length; i++) {
            String s = Character.toString((char) k);
            System.out.print("|" + s + "| ");
            k++;
            for (int j = 0; j < st[i].length; j++) {
                if (inarray(i, j + 1, chosenseat)) {
                    System.out.print("X");
                }

                else if (st[i][j] == 2) {
                    System.out.print(" ");
                }

                else if (st[i][j] == 3) {
                    System.out.print("E");
                }

                else if (st[i][j] == 4) {
                    System.out.print("U");
                }

                else if (st[i][j] == 5) {
                    System.out.print("C");
                }

                else {
                    System.out.print(st[i][j]);
                }
                System.out.print("  ");
            }
            System.out.println();
            System.out.println();
        }

        System.out.println("__________Exit 1________________________Exit 2____________");
        System.out.println();
        System.out.println("Legend - X Seat: Selected");
        System.out.println("Legend - 0: Unoccupied");
        System.out.println("Legend - 1: Occupied");
        System.out.println("Legend - E: Elite seats (Unoccupied) - Extra charges with apply");
        System.out.println("Legend - U: Ultima seats (Unoccupied) - Extra charges with apply");
        System.out.println("Legend - C: Couple Seat - Seat next to it will be auto selected");
        System.out.println("Legend - space : Alleys and Stairs");
        System.out.println();
        System.out.println("_____________________________________________________");

        System.out.println("Would you like to buy the tickets?");
        System.out.println("1: Yes");
        System.out.println("2: No");

        int conopt;

        while (true) {
            String input = scc.next();
            conopt = 0;
            try {
                conopt = Integer.parseInt(input);
                if (conopt > 2 || conopt < 1) {
                    System.out.println("Please key in a valid number!");
                    continue;
                } else {
                    break;
                }
            } catch (NumberFormatException ne) {
                System.out.println("Please key in a number only!");
            }
        }

        if (conopt != 1) {
            System.out.println("Exiting...");
            return;
        }

        CustomerTicketHandler ct = new CustomerTicketHandler();
        ct.setshow(s1);
        ct.setseats(chosenseat);
        ct.setuser(user);
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
