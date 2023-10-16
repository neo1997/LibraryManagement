package DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagement {

    static Connection connection;
    public static Connection createConnection()throws SQLException{
        try{
            //Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Create COnnection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement", "root", "Sai.1919");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
