package MOBLIMA.panel;

import java.io.IOException;
import MOBLIMA.CineplexApp;
import MOBLIMA.facade.listMovieFacade;
import MOBLIMA.facade.pastTransactionsFacade;
import MOBLIMA.facade.searchMovieFacade;
import MOBLIMA.facade.top5Facade;
import MOBLIMA.handler.customerVerifcationHandler;



public class customerpanel implements Panel {
    public void displayChoices() {
        System.out.println();
        System.out.println("_______________________________________________________________________");
        System.out.println("| Please select your desired action (key in the coresponding number)   |");
        System.out.println("| 1: Search for a movie                                                |");
        System.out.println("| 2: List movies                                                       |");
        System.out.println("| 3: View movie details                                                |");
        System.out.println("| 4: Check seat availability                                           |");
        System.out.println("| 5: Book and purchase ticket                                          |");
        System.out.println("| 6: View booking history                                              |");
        System.out.println("| 7: List the Top 5 ranking movies                                     |");
        System.out.println("| 8: Rate Movies                                                       |");
        System.out.println("| 9: Quit                                                              |");
        System.out.println("_______________________________________________________________________");
        System.out.println();
    }

    public void viewApp() {
        printWelcomeMsg();
        try {

            String name1 = "";

            while(!isValidEmailAddress(name1)){
                System.out.println();
                System.out.println(
                    "Please enter your EMAIL in CORRECT FORMAT to log in/sign up, ENTER 'guest' to enter ANONOMOUSLY.\nNote: You will not be able to purchase if you enter ananoumously and will be asked to sign out and sign in to purchase");
                    name1 = CineplexApp.scc.next();
            }
            String name = name1.toLowerCase();



            String userid = "";

            userid = customerVerifcationHandler.userIdCheck(name);
            if (userid.length() > 0) {
                customerVerifcationHandler.displayOldUser(name1, userid);
            } else {
                customerVerifcationHandler.displayNewUser(name1);
                userid = customerVerifcationHandler.userIdCheck(name);
            }

            loop: while (true) {
                displayChoices();
                int option;
                while (true) {
                    String input = CineplexApp.scc.next();
                    option = 0;
                    try {
                        option = Integer.parseInt(input);
                        break;
                    } catch (NumberFormatException ne) {
                        System.out.println("Please key in a number only!");
                    }
                }
                switch (option) {
                    case 1:
                        searchMovieFacade.run(userid);
                        break;
                    case 2:
                    case 3:
                        listMovieFacade.run(userid);
                        break;
                    case 4:
                    case 5:
                        listMovieFacade.setAction(1);
                        listMovieFacade.run(userid);
                        break;
                    case 6:
                        pastTransactionsFacade.run(userid);
                        break;
                    case 7:
                        top5Facade.show(userid);
                        break;
                    case 8:
                        listMovieFacade.setAction(2);
                        listMovieFacade.run(userid);
                        break;
                    case 9:
                        return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printWelcomeMsg() {
        // System.out.println("██╗ ██╗███████╗██╗ ██████╗ ██████╗ ███╗ ███╗███████╗");
        // System.out.println("██║ ██║██╔════╝██║ ██╔════╝██╔═══██╗████╗
        // ████║██╔════╝");
        // System.out.println("██║ █╗ ██║█████╗ ██║ ██║ ██║ ██║██╔████╔██║█████╗ ");
        // System.out.println("██║███╗██║██╔══╝ ██║ ██║ ██║ ██║██║╚██╔╝██║██╔══╝ ");
        // System.out.println("╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝
        // ██║███████╗");
        // System.out.println(" ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝
        // ╚═╝╚══════╝");
        // System.out.println();

        System.out.println("██╗  ██╗███████╗██╗     ██╗      ██████╗     ████████╗██╗  ██╗███████╗██████╗ ███████╗██╗");
        System.out.println("██║  ██║██╔════╝██║     ██║     ██╔═══██╗    ╚══██╔══╝██║  ██║██╔════╝██╔══██╗██╔════╝██║");
        System.out.println("███████║█████╗  ██║     ██║     ██║   ██║       ██║   ███████║█████╗  ██████╔╝█████╗  ██║");
        System.out.println("██╔══██║██╔══╝  ██║     ██║     ██║   ██║       ██║   ██╔══██║██╔══╝  ██╔══██╗██╔══╝  ╚═╝");
        System.out.println("██║  ██║███████╗███████╗███████╗╚██████╔╝       ██║   ██║  ██║███████╗██║  ██║███████╗██╗");
        System.out.println("╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝ ╚═════╝        ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝╚══════╝╚═╝");
        System.out.println();
    }

    public boolean isValidEmailAddress(String email) {


        if(email.equalsIgnoreCase("guest")){
            return true;
        }

        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}
