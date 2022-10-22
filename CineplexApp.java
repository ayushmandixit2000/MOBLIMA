
import java.util.Scanner;


public class CineplexApp {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while(true){
                printHRPSTitle();
                String option = sc.next();
                if(option == "A"){
                    adminpanel a = new adminpanel;
                    System.out.println("Please key in the password");
                    String password = sc.next();
                    if(password != a.getpassword){
                        break;
                    }
                }

                if(option  == "C"){

                }

                if(option == "Q"){
                    break;
                }
            }
            System.out.println("Program closing ... Thank you for using MOBLIMA!");
    }

    private static void printHRPSTitle() {
        System.out.println();
        System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                                                     ║");
        System.out.println("║                                                                                                     ║");
        System.out.println("║         ▐▐         ▐▐  ▐▐▐▐▐▐▐▐▐▐▐  ▐▐▐▐▐▐▐▐▐▐▐  ▐▐           ▐▐  ▐▐         ▐▐      ▐▐▐▐           ║");
        System.out.println("║         ▐▐▐▐     ▐▐▐▐  ▐▐       ▐▐  ▐▐       ▐▐  ▐▐           ▐▐  ▐▐▐▐     ▐▐▐▐    ▐▐    ▐▐         ║");
        System.out.println("║         ▐▐  ▐▐ ▐▐  ▐▐  ▐▐       ▐▐  ▐▐       ▐▐  ▐▐           ▐▐  ▐▐  ▐▐ ▐▐  ▐▐  ▐▐        ▐▐       ║");
        System.out.println("║         ▐▐         ▐▐  ▐▐       ▐▐  ▐▐▐▐▐▐▐▐▐▐▐  ▐▐           ▐▐  ▐▐         ▐▐  ▐▐▐▐▐▐▐▐▐▐▐▐       ║");
        System.out.println("║         ▐▐         ▐▐  ▐▐       ▐▐  ▐▐       ▐▐  ▐▐           ▐▐  ▐▐         ▐▐  ▐▐        ▐▐       ║");
        System.out.println("║         ▐▐         ▐▐  ▐▐       ▐▐  ▐▐       ▐▐  ▐▐           ▐▐  ▐▐         ▐▐  ▐▐        ▐▐       ║");
        System.out.println("║         ▐▐         ▐▐  ▐▐▐▐▐▐▐▐▐▐▐  ▐▐▐▐▐▐▐▐▐▐▐  ▐▐▐▐▐▐▐▐▐▐▐  ▐▐  ▐▐         ▐▐  ▐▐        ▐▐       ║");
        System.out.println("║                                                                                                     ║");
        System.out.println("║                      Welcome to Movie Booking and Listing Management Application!                   ║");
        System.out.println("║                                                                                                     ║");
        System.out.println("║                      Key in C to contiue                                                            ║");
        System.out.println("║                      Key in A to access Admin Panel                                                 ║");
        System.out.println("║                      Key in Q to quit the apllication                                               ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════╝");
    }
}