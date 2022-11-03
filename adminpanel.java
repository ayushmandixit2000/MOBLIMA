import java.util.Scanner;


public class adminpanel {
    private String password = "inshallah";

    public adminpanel(){
    }

    public String getPassword(){
        return this.password;
    }

    public void viewapp(){
        Scanner sc = new Scanner(System.in);
        // System.out.println("Welcome to MOBLIMA\nPlease key in your password: ");
        // String userPassword = sc.next();
        // if (userPassword != this.getPassword()){
        //     System.out.println("Incorrect Password.\nExiting...");
        //     sc.close();
        //     return;
        // }
        boolean exit = false;
        int option;
        while(!exit){
            System.out.println("Please select your desired action (key in the coresponding number)");
            System.out.println("1: Create/Update/Remove Movie Listing");
            System.out.println("2: Create/Update/Remove cinema showtimes and the movies to be shown");
            System.out.println("3: Configure system settings");
            System.out.println("4: Quit");
            option = sc.nextInt();

            switch(option){
                case 1:
                System.out.println("Please select your desired action");
                System.out.println("1: Create Movie Listing\n2: Update Movie Listing\n3: Remove Movie Listing");
                int optionListing = sc.nextInt();
                switch(optionListing){
                    case 1:
                    System.out.println("Create Movie Listing");
                    break;
                    case 2:
                    System.out.println("Update Movie Listing");
                    break;
                    case 3:
                    System.out.println("Remove Movie Listing");
                    break;
                    default:
                    System.out.println("Please try again.");
                }
                break;
                case 2:
                System.out.println("Please select your desired action");
                System.out.println("1: Create Movie Showtimes\n2: Update Movie Showtimes\n3: Remove Movie Showtimes");
                int optionShowtimes = sc.nextInt();
                switch(optionShowtimes){
                    case 1:
                    System.out.println("Create Movie Showtimes");
                    break;
                    case 2:
                    System.out.println("Update Movie Showtimes");
                    break;
                    case 3:
                    System.out.println("Remove Movie Showtimes");
                    break;
                    default:
                    System.out.println("Please try again.");
                }
                break;
                case 3:
                System.out.println("Configure system settings");
                case 4:
                System.out.println("Exiting...");
                exit = true;
                sc.close();
                return;
            }
        }
    }


}
