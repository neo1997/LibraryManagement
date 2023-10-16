package DAO;

import DataBaseConnection.ConnectionManagement;
import Model.bookModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class bookDao {
    private static final Connection connection;
    static {
        try {
            connection = ConnectionManagement.createConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public bookDao() throws SQLException {
    }
    public static boolean addBook(bookModel bookModel){
        boolean flag = false;
        try {
            String query = "INSERT INTO books(bookId, bookName, bookQuantity) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bookModel.getBookId());
            preparedStatement.setString(2, bookModel.getBookName());
            preparedStatement.setInt(3, bookModel.getQuantity());
            int preparedStatement1 = preparedStatement.executeUpdate();
            System.out.println(preparedStatement1);
            flag = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
}
