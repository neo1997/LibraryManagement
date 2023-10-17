package DAO;

import DataBaseConnection.ConnectionManagement;
import Model.bookModel;
import Model.issuedModel;

import java.sql.*;

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
        String query = "INSERT INTO issued(issueId, issuedToId, issuedToName, issuedBook, issuedBookName, issuedDate, fineAmount, returnBy) values(?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, issuedModel.getIssueId());
        preparedStatement.setString(2, issuedModel.getIssuedToId());
        preparedStatement.setString(3, issuedModel.getIssuedToName());
        preparedStatement.setString(4, issuedModel.getIssuedBookId());
        preparedStatement.setString(5, issuedModel.getIssuedBookName());
        preparedStatement.setDate(6, issuedModel.getIssuedDate());
        preparedStatement.setDouble(7, issuedModel.getFineAmount());
        preparedStatement.setDate(8, issuedModel.getReturnBy());

        preparedStatement.executeUpdate();
    }
    public static void bookQuantityAfterIssuing(bookModel bookItem) {
        int newQuantity = 0;
        try {
            String query = "UPDATE books SET bookQuantity=? where bookId=?";
           // System.out.println(bookItem.getQuantity());
            System.out.println(bookItem.getBookId());
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bookItem.getQuantity());
            preparedStatement.setString(2, bookItem.getBookId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getIssueDetails(issuedModel issueItem) {
        try {
            String query = "Select * from issued where issueId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, issueItem.getIssueId());
            ResultSet resultSet = preparedStatement.executeQuery();
            /*Date date = null;
            String issuedName = null;*/
            Date date = null;
            /*String issuedToName = null;
            String issuedToId = null;
            String issuedBook = null;*/
            while (resultSet.next()) {
                date = resultSet.getDate("issuedDate");
               /*issuedToName = resultSet.getString("issuedToName");
                issuedToId = resultSet.getString("issuedToId");
                issuedBook = resultSet.getString("issuedBook");*/

            }
            issueItem.setIssuedDate(date);
            /*issueItem.setIssuedToName(issuedToName);
            issueItem.setIssuedToId(issuedToId);
            issueItem.setIssuedBookId(issuedBook);*/
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateFineAmount(issuedModel issuedModel){
        try {
            String query = "UPDATE issued set fineAmount=?, returnedOn=?, delayDays=? where issueId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, issuedModel.getFineAmount());
            preparedStatement.setDate(2, issuedModel.getReturnDate());
            preparedStatement.setLong(3, issuedModel.getDelayDays());
            preparedStatement.setString(4, issuedModel.getIssueId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}