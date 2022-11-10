package MOBLIMA.configure;

import java.io.IOException;
import java.util.Scanner;

import MOBLIMA.configurables.rankStatus;

public class configureRankStatus implements configure {

    public void displaySetting() throws IOException {
        System.out.println("Current Setting:");
        int status = rankStatus.getStatus();
        switch (status) {
            case 0:
                System.out.println("No ranking is allowed");
                break;
            case 1:
                System.out.println("Only rank by sales");
                break;
            case 2:
                System.out.println("Only rank by rating");
                break;
            case 3:
                System.out.println("Rank by sales or rating");
                break;
        }
    }

    public void getNewSetting() throws IOException {
        Scanner sc = new Scanner(System.in);
        int selection = -1;
        while (selection < 0 || selection > 3) {
            System.out
                    .println("Please input 0 for no ranking, 1 for rank by sales, 2 for rank by rating and 3 by both:");
            while (!sc.hasNextInt()) {
                System.out.println("Please input a double:");
                sc.next();
            }
            selection = sc.nextInt();
        }
        rankStatus.setStatus(selection);
    }
}