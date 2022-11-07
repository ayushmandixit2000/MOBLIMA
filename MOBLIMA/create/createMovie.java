package MOBLIMA.create;

import MOBLIMA.dataStructure.*;
import java.util.Scanner;

public class createMovie {

    public createMovie() {
    }

    public boolean movieCreate() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Movie Title: ");
        String movieTitle = sc.next();
        int showStatus;
        boolean loop = true;
        while (loop) {
            System.out.println("Movie Status: \n1: Comming Soon \n2: Preview \n3: Now Showing \n4: End of Show");
            showStatus = (sc.nextInt()) - 1;
            switch (showStatus) {
                case 0:
                case 1:
                case 2:
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        return true;
    }

}
