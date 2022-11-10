import java.io.IOException;

import MOBLIMA.action.adminMovieAction;

public class oldEditShowtimeFacade {
    public void run() throws IOException {
        adminMovieAction ama = new adminMovieAction();
        ama.displayChoices();
        int action = ama.getChoice();
        switch (action) {
            case 1:
                System.out.println("Create Movie Showtimes");
                break;
            case 2:
                System.out.println("Update Movie Showtimes");
                break;
            case 3:
                System.out.println("Remove Movie Showtimes");
                break;
        }
    }

}