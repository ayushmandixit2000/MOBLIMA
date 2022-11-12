package MOBLIMA.panel;

import java.io.IOException;
import java.util.Scanner;

import MOBLIMA.facade.editShowtimeFacade;
import MOBLIMA.facade.configureSettingsFacade;
import MOBLIMA.facade.editMovieFacade;

public class adminpanel implements Panel {
    private String password = "ilovesc2002";

    public String getPassword() {
        return this.password;
    }

    public void displayChoices() {
        System.out.println("Please select your desired action (key in the coresponding number)");
        System.out.println("__________________________________________________________________");
        System.out.println("1: Create/Update/Remove Movie Listing");
        System.out.println("2: Create/Update/Remove cinema showtimes");
        System.out.println("3: Configure system settings");
        System.out.println("4: Quit");
        System.out.println("__________________________________________________________________");
    }

    public void viewApp() throws IOException {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        printWelcomeMsg();
        System.out.println();
        
        while (!exit) {
            displayChoices();
            
            int option;

            while (true) {
                    
                    String input = sc.next();
                    option = 0;
                    try {
                        option = Integer.parseInt(input);
                        if (option > 4 || option < 1) {
                            System.out.println("Please key in a valid number!");
                            continue;
                        } else {
                            break;
                        }
                    } catch (NumberFormatException ne) {
                        System.out.println("Please key in a number only!");
                    }
            }

            switch (option) {
                case 1:
                    System.out.println("Edit Movie Listings");
                    editMovieFacade emf = new editMovieFacade();
                    emf.run();
                    break;
                case 2:
                    System.out.println("Edit Cinema Showtimes");
                    editShowtimeFacade esf = new editShowtimeFacade();
                    esf.run();
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Configure System Settings");
                    configureSettingsFacade.configureSettings();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
            }
        }
    }

    private static void printWelcomeMsg(){
        System.out.println("██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗         █████╗ ██████╗ ███╗   ███╗██╗███╗   ██╗██╗");
        System.out.println("██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝        ██╔══██╗██╔══██╗████╗ ████║██║████╗  ██║██║");
        System.out.println("██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗          ███████║██║  ██║██╔████╔██║██║██╔██╗ ██║██║");
        System.out.println("██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝          ██╔══██║██║  ██║██║╚██╔╝██║██║██║╚██╗██║╚═╝");
        System.out.println("╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗        ██║  ██║██████╔╝██║ ╚═╝ ██║██║██║ ╚████║██╗");
        System.out.println(" ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝        ╚═╝  ╚═╝╚═════╝ ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝╚═╝");
    }
}                                                                                                                                                        
                                                                                                                                                 
