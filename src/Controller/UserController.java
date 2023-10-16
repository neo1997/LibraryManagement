package Controller;

import Model.userModel;
import Service.UserService;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;


public class UserController {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void userController() throws IOException, SQLException {
        System.out.println("1. Add User");
        System.out.println("2. Modify User");
        System.out.println("3. Delete User");
        int choice = Integer.parseInt(br.readLine());
        if (choice == 1)
            insertUser();
        else if (choice == 2)
            modifyUser();
        else if (choice == 3)
            deleteUser();
    }

    public void deleteUser() throws IOException, SQLException {
        System.out.print("Enter User ID - ");
        String userId = br.readLine();
        var userModel = new userModel(userId);

        var UserService = new UserService();
        UserService.ModifyUser(userModel);
    }

    public void modifyUser() throws IOException, SQLException {
        System.out.print("Enter User ID - ");
        String userId = br.readLine();
        System.out.print("Enter Modified User Name - ");
        String userName = br.readLine();
        var userModel = new userModel(userId, userName);

        var UserService = new UserService();
        UserService.ModifyUser(userModel);
        System.out.println(userModel);
    }

    public void insertUser() throws IOException {
        String userId = RandomStringUtils.randomNumeric(5);
        System.out.print("Enter User Name : ");
        String userName = br.readLine();
        var userModel = new userModel(userId, userName);
        var UserService = new UserService();
        UserService.InsertUser(userModel);
        System.out.println(userModel);
    }
}
