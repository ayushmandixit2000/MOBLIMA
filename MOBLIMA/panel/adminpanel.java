package MOBLIMA.panel;

import java.io.IOException;
import java.util.Scanner;
import MOBLIMA.facade.editShowtimeFacade;
import MOBLIMA.facade.configureSettingsFacade;
import MOBLIMA.facade.editMovieFacade;

/**
 * Displays the options available to the admin and calls the relevant facade
 * classes to handle operations of.
 */
public class adminpanel implements Panel {
    /**
     * Password used to verify admin.
     */
    private String password = "ilovesc2002";

    /**
     * Gets the verification password.
     * 
     * @return The verification password.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Displays the choices admin can choose to do.
     */
    public void displayChoices() {
        System.out.println("Please select your desired action (key in the coresponding number)");
        System.out.println("__________________________________________________________________");
        System.out.println("1: Create/Update/Remove Movie Listing");
        System.out.println("2: Create/Update/Remove cinema showtimes");
        System.out.println("3: Configure system settings");
        System.out.println("4: Quit");
        System.out.println("__________________________________________________________________");
    }

    /**
     * Obtains the intended action of the admin and executes the relevant facade
     * classes.
     * Validates inputs.
     */
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

    /**
     * Displays welcome message.
     */
    private static void printWelcomeMsg() {
        System.out.println(
                "██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗         █████╗ ██████╗ ███╗   ███╗██╗███╗   ██╗██╗");
        System.out.println(
                "██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝        ██╔══██╗██╔══██╗████╗ ████║██║████╗  ██║██║");
        System.out.println(
                "██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗          ███████║██║  ██║██╔████╔██║██║██╔██╗ ██║██║");
        System.out.println(
                "██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝          ██╔══██║██║  ██║██║╚██╔╝██║██║██║╚██╗██║╚═╝");
        System.out.println(
                "╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗        ██║  ██║██████╔╝██║ ╚═╝ ██║██║██║ ╚████║██╗");
        System.out.println(
                " ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝        ╚═╝  ╚═╝╚═════╝ ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝╚═╝");
    }
}
