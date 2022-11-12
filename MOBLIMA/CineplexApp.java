package MOBLIMA;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import MOBLIMA.panel.adminpanel;
import MOBLIMA.panel.customerpanel;

public class CineplexApp {
        public static Scanner scc = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
                boolean quit = false;
                String input = "0";
                int option = 0;
                while (!quit) {
                        printHRPSTitle();

                        while (true) {
                                if (scc.hasNext()) {
                                        input = scc.next();

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
                        }
                        scc = new Scanner(System.in);
                        switch (option) {
                                case 1:
                                        customerpanel customerui = new customerpanel();
                                        customerui.viewApp();
                                        option = 0;

                                        break;
                                // continue;

                                case 2:
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

                                        }
                                        break;

                                case 3:
                                        System.out.println("Program closing ...");
                                        System.out.println();
                                        printThankYouMsg();
                                        quit = true;
                                        break;
                                default:
                                        System.out.println("here");
                                        System.out.println(option);
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

        private static void printThankYouMsg(){
                System.out.println("████████╗██╗  ██╗ █████╗ ███╗   ██╗██╗  ██╗    ██╗   ██╗ ██████╗ ██╗   ██╗██╗");
                System.out.println("╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██║ ██╔╝    ╚██╗ ██╔╝██╔═══██╗██║   ██║██║");
                System.out.println("   ██║   ███████║███████║██╔██╗ ██║█████╔╝      ╚████╔╝ ██║   ██║██║   ██║██║");
                System.out.println("   ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗       ╚██╔╝  ██║   ██║██║   ██║╚═╝");
                System.out.println("   ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗       ╚██╔╝  ██║   ██║██║   ██║╚═╝");
                System.out.println("   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝       ╚═╝    ╚═════╝  ╚═════╝ ╚═╝");
                System.out.println();
        }
                                                                             



}
