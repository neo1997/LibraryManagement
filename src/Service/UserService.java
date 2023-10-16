package Service;

import Controller.UserController;
import Model.userModel;
import DAO.userDao;
import java.io.IOException;
import java.sql.SQLException;

public class UserService {
    public void InsertUser(userModel userModel) throws IOException {
        boolean flag = userDao.insertToDb(userModel);
        if (flag) {
            System.out.println("Successfully Updated");
        } else {
            System.out.println("User not Updated, Try Again");
            System.out.println("---------------------------");
            var UserController = new UserController();
            UserController.insertUser();
        }
    }

    public void ModifyUser(userModel userModel) throws SQLException, IOException {
        boolean flag = userDao.modifyUser(userModel);
        if (flag) {
            System.out.println("Successfully Modified");
        } else {
            System.out.println("Not Modified, Try Again");
            System.out.println("-----------------------");
            var UserController = new UserController();
            UserController.modifyUser();
        }
    }

    public void DeleteUser(userModel userModel) throws SQLException, IOException {
        boolean flag = userDao.deleteUser(userModel);
        if (flag) {
            System.out.println("Successfully Deleted");
        } else {
            System.out.println("Not Deleted, Try Again");
            System.out.println("-----------------------");
            var UserController = new UserController();
            UserController.deleteUser();
        }
    }
}
