package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class MainController {
    public void mainMenu() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("1. User Controller");
            System.out.println("2. Book Controller");
            System.out.println("3. Book Issue Controller");
            System.out.print("Enter Choice - ");
            int choice = Integer.parseInt(br.readLine());

            if (choice == 1){
                UserController userController = new UserController();
                userController.userController();
            } else if (choice == 2){
                BookController bookController = new BookController();
                bookController.bookController();
            } else if (choice == 3){
                var issuedController = new issuedController();
                issuedController.issueController();
            }
        }
    }
}
