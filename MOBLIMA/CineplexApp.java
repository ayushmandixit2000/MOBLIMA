package MOBLIMA;

import java.io.IOException;
import java.util.Scanner;

import MOBLIMA.panel.adminpanel;
import MOBLIMA.panel.customerpanel;

public class CineplexApp {
        public static void main(String[] args) throws IOException {
                Scanner scc = new Scanner(System.in);
                boolean quit = false;
                while (!quit) {
                        printHRPSTitle();
                        int option;

                        while (true) {
                                
                                String input = scc.next();
                                option = 0;
                                try {
                                    option = Integer.parseInt(input);
                                    if (option > 3 || option < 1) {
                                        System.out.println("Please key in a valid number!");
                                        continue;
                                    } else {
                                        break;
                                    }
                                } catch (NumberFormatException ne) {
                                    System.out.println("Please key in a number only!");
                                }
                        }

                        if (option == 2) {
                                adminpanel admin = new adminpanel();
                                System.out.println("____________________________");
                                System.out.println("Please key in the password:");
                                System.out.println("____________________________");
                                String password = scc.next();
                                Boolean passwordMatches = password.equals(admin.getPassword());
                                if (!passwordMatches) {
                                        System.out.println("Incorrect Password! Returning...");
                                }

                                else {
                                        admin.viewApp();
                                        break;
                                        
                                }
                        }

                        if (option == 1) {
                                customerpanel customerui = new customerpanel();
                                customerui.viewApp();
                                break;
                                
                        }

                        if (option == 3) {
                                System.out.println("Program closing ... Thank you for using MOBLIMA!");
                                quit = true;
                                break;
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
