
import java.io.IOException;
import java.util.Scanner;

import MOBLIMA.panel.adminpanel;

public class CineplexApp {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            printHRPSTitle();
            int option = sc.nextInt();
            if (option == 2) {
                adminpanel admin = new adminpanel();
                System.out.println("Please key in the password");
                String password = sc.next();
                Boolean passwordMatches = password.equals(admin.getPassword());
                if (!passwordMatches) {
                    System.out.println("Incorrect Password");
                }

                else {
                    admin.viewApp();
                }
            }

            if (option == 1) {
                customerpanel customerui = new customerpanel();
                customerui.viewApp();
            }

            if (option == 3) {
                System.out.println("Program closing ... Thank you for using MOBLIMA!");
                quit = true;
            }
        }
        
    }

    private static void printHRPSTitle() {
        System.out.println();
        System.out.println(
                "╔═════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(
                "║                                                                                                     ║");
        System.out.println(
                "║                                                                                                     ║");
        System.out.println(
                "║         ▐▐         ▐▐  ▐▐▐▐▐▐▐▐▐▐▐  ▐▐▐▐▐▐▐▐▐▐▐  ▐▐           ▐▐  ▐▐         ▐▐      ▐▐▐▐           ║");
        System.out.println(
                "║         ▐▐▐▐     ▐▐▐▐  ▐▐       ▐▐  ▐▐       ▐▐  ▐▐           ▐▐  ▐▐▐▐     ▐▐▐▐    ▐▐    ▐▐         ║");
        System.out.println(
                "║         ▐▐  ▐▐ ▐▐  ▐▐  ▐▐       ▐▐  ▐▐       ▐▐  ▐▐           ▐▐  ▐▐  ▐▐ ▐▐  ▐▐  ▐▐        ▐▐       ║");
        System.out.println(
                "║         ▐▐         ▐▐  ▐▐       ▐▐  ▐▐▐▐▐▐▐▐▐▐▐  ▐▐           ▐▐  ▐▐         ▐▐  ▐▐▐▐▐▐▐▐▐▐▐▐       ║");
        System.out.println(
                "║         ▐▐         ▐▐  ▐▐       ▐▐  ▐▐       ▐▐  ▐▐           ▐▐  ▐▐         ▐▐  ▐▐        ▐▐       ║");
        System.out.println(
                "║         ▐▐         ▐▐  ▐▐       ▐▐  ▐▐       ▐▐  ▐▐           ▐▐  ▐▐         ▐▐  ▐▐        ▐▐       ║");
        System.out.println(
                "║         ▐▐         ▐▐  ▐▐▐▐▐▐▐▐▐▐▐  ▐▐▐▐▐▐▐▐▐▐▐  ▐▐▐▐▐▐▐▐▐▐▐  ▐▐  ▐▐         ▐▐  ▐▐        ▐▐       ║");
        System.out.println(
                "║                                                                                                     ║");
        System.out.println(
                "║                      Welcome to Movie Booking and Listing Management Application!                   ║");
        System.out.println(
                "║                                                                                                     ║");
        System.out.println(
                "║                      1: Contiue on MOBLIMA                                                          ║");
        System.out.println(
                "║                      2: Access Admin Panel                                                          ║");
        System.out.println(
                "║                      3: Quit the apllication                                                        ║");
        System.out.println(
                "╚═════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }
}
