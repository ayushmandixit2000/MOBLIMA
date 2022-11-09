package MOBLIMA.useractions;

import java.util.Scanner;

import MOBLIMA.dataStructure.Showtime;

public class choosingseats {
    private Showtime s1;

    public void setshow(Showtime s) {
        this.s1 = s;
    }

    public void display() {
        Scanner scc = new Scanner(System.in);
        System.out.println("How many tickets will you like to purchase?");
        int num = scc.nextInt();

        System.out.println("Please key in seat. Note: Choose unoccupied seats (0) and enter the row followed by column");
        for(int a = 0 ; a < num; a++){
            int b = a+1;
            System.out.println("Ticket " + b + " : ");
            System.out.println("Please key in row of seat. E.g C: ");
            
        }

    }
}

