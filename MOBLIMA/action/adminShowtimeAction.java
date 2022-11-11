package MOBLIMA.action;

import java.io.IOException;
import java.util.Scanner;

public class adminShowtimeAction implements action {
    public void displayChoices() {
        System.out.println("Please select your desired action (key in the coresponding number)");
        System.out.println("1: Create Movie Showtime");
        System.out.println("2: Update Movie Showtime");
        System.out.println("3: Remove Movie Showtime");
        System.out.println("4: Quit");
    }

    public int getChoice() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        int choice = 0;
        boolean flag;
         // to prevent users from keying in data that is not string 
         do{
            try{
                choice = sc.nextInt();
                flag = false;
                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid option. Please key in valid numbers");
                    flag = true;
                }
                else{
                    flag = false;
                }
            }
            catch(Exception e){
                System.out.println("Inavlid input. Please enter intergers only... "+e);
                sc.nextLine();
                flag = true;
            }
        }
        while(flag);
        sc.nextLine();
        
        return choice;

    }

}
