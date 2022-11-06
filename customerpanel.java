import MOBLIMA.panelInterface.*;
import java.util.Scanner;

public class customerpanel implements Panel {


    public void viewApp(){
        System.out.println("Welcome to MOBLIMA");
        Scanner scc = new Scanner(System.in);
        loop: while(true){
            System.out.println("Please select your desired action (key in the coresponding number)");
            System.out.println("1: Search for a movie");
            System.out.println("2: List movies");
            System.out.println("3: Booking History");
            System.out.println("4: Book and purshcase ticket");
            System.out.println("5: View booking history");
            System.out.println("6: List the Top 5 ranking by ticket salers OR by overall reviewers' ratings");
            System.out.println("7: Quit");

            int option = scc.nextInt();

            switch(option){
                case 1:
                    System.out.println("Please select your desired action");
                    System.out.println("1: List movies currently showing");
                    System.out.println("2: Search a specific movie");
                    int option1 = scc.nextInt();
                    if(option1 == 1){
                        // movie.list();
                    }
                    else if(option == 2){
                        // movie.search();
                    }
                    break;

                // case 2:
                //     movie.viewdetails();

                // case 3:
                //     cineplex.seats();

                // case 4:
                //     user.booktickets();

                // case 5:
                //     user.bookinghistory();

                // case 6:
                //     movie.rank();
                case 7:
                    System.out.println("Exiting...");
                    break loop;
            }
        }
    }
}
