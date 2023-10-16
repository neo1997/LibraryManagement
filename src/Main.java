import Controller.MainController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello world!");
        System.out.println("press Enter to continue");
        /*System.out.println("1. Enter Dummy User Data");
        System.out.println("2. Enter Dummy Book Data");*/
        String enter = sc.nextLine();
        if (enter.isEmpty()) {
            var MainController = new MainController();
            MainController.mainMenu();
       /* } else if (enter.equals("1")){
            DummyDataGenerator.insertRandomUsers();
        } else if (enter.equals("2")){
            DummyDataGenerator.insertRandomBookData();
        }*/
        }
    }
}