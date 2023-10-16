package DAO;

import DataBaseConnection.ConnectionManagement;
import Model.bookModel;
import Model.issuedModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class issuedDao {
    private static final Connection connection;
    static {
        try {
            connection = ConnectionManagement.createConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getUserName(issuedModel issuedModel){
        try {
            String query = " select * from user where userId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, issuedModel.getIssuedToId());
            ResultSet resultSet = preparedStatement.executeQuery();
            String userName = null;
            while (resultSet.next()) {
                userName = resultSet.getString("userName");
            }
            return userName;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static bookModel getBookItem(issuedModel issuedModel){
        bookModel bookModel = new bookModel();
        try {
            String query = " select * from books where bookId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, issuedModel.getIssuedBookId());
            ResultSet resultSet = preparedStatement.executeQuery();
            String bookName = null;
            int bookQuantity = 0;
            while (resultSet.next()) {
                bookName = resultSet.getString("bookName");
                bookQuantity = resultSet.getInt("bookQuantity");
            }
            bookModel.setBookName(bookName);
            bookModel.setQuantity(bookQuantity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookModel;
    }
    public static void updateToDb(issuedModel issuedModel) throws SQLException {
        String query = "INSERT INTO issued(issueId, issuedToId, issuedToName, issuedBook, issuedBookName, issuedDate, fineAmount) values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, issuedModel.getIssueId());
        preparedStatement.setString(2, issuedModel.getIssuedToId());
        preparedStatement.setString(3, issuedModel.getIssuedToName());
        preparedStatement.setString(4, issuedModel.getIssuedBookId());
        preparedStatement.setString(5, issuedModel.getIssuedBookName());
        preparedStatement.setDate(6, issuedModel.getIssuedDate());
        preparedStatement.setDouble(7, issuedModel.getFineAmount());

        preparedStatement.executeUpdate();
    }
}

    /*try {

            // SQL command data stored in String datatype
            String sql = "select * from cuslogin";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            // Printing ID, name, email of customers
            // of the SQL command above
            System.out.println("id\t\tname\t\temail");

            // Condition check
            while (rs.next()) {

            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            System.out.println(id + "\t\t" + name
            + "\t\t" + email);
            }
            }*/
