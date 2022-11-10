package MOBLIMA.panel;

import java.io.IOException;
import java.util.Scanner;

import MOBLIMA.facade.editShowtimeFacade;
import MOBLIMA.facade.configureSettingsFacade;
import MOBLIMA.facade.editMovieFacade;

public class adminpanel implements Panel {
    private String password = "inshallah";

    public String getPassword() {
        return this.password;
    }

    public void displayChoices() {
        System.out.println("Please select your desired action (key in the coresponding number)");
        System.out.println("1: Create/Update/Remove Movie Listing");
        System.out.println("2: Create/Update/Remove cinema showtimes");
        System.out.println("3: Configure system settings");
        System.out.println("4: Quit");

    }

    public void viewApp() throws IOException {
        System.out.println("here");
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int option;
        while (!exit) {
            displayChoices();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Edit Movie Listing");
                    editMovieFacade emf = new editMovieFacade();
                    emf.run();
                case 2:
                    System.out.println("Edit Cinema Showtime");
                    editShowtimeFacade esf = new editShowtimeFacade();
                    esf.run();
                case 3:
                    System.out.println("Configure System Settings");
                    configureSettingsFacade.configureSettings();
                case 4:
                    System.out.println("Exiting...");
                    exit = true;
            }
        }
    }
}
