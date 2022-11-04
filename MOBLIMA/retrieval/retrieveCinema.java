package MOBLIMA.retrieval;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import MOBLIMA.dataStructure.Cinema;

public class retrieveCinema extends retrieve {
    public static ArrayList readCinema(String filename) throws IOException {
        ArrayList stringArray = (ArrayList) read(filename);
        ArrayList alr = new ArrayList();
        for (int i = 0; i < stringArray.size(); i++) {
            String st = (String) stringArray.get(i);
            StringTokenizer star = new StringTokenizer(st, SEPARATOR);

            String cinema = star.nextToken().trim();
            int cineplex = Integer.parseInt(star.nextToken().trim());
            int movieClass = Integer.parseInt(star.nextToken().trim());
            String layout = star.nextToken().trim();

            Cinema c = new Cinema(cinema, cineplex, movieClass, layout);
            alr.add(c);
        }
        return alr;
    }

    public static void main(String[] aArgs) {
        String filename = "MOBLIMA/databases/Cinema.txt";
        try {
            ArrayList al = retrieveCinema.readCinema(filename);
            for (int i = 0; i < al.size(); i++) {
                Cinema c = (Cinema) al.get(i);
                System.out.println("CinemaId " + c.getCinema());
            }
        } catch (IOException e) {
            System.out.println("IOException > " + e.getMessage());
        }
    }
}