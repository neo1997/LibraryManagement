    package DAO;

    import DataBaseConnection.ConnectionManagement;
    import Model.userModel;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;

    public class userDao {
        private static final Connection connection;
        static {
            try {
                connection = ConnectionManagement.createConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        public userDao() throws SQLException {
        }
        public static boolean insertToDb(userModel userModel){
            boolean flag = false;
            try {
                String query = "INSERT INTO user(userId, userName) values(?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, userModel.getUserId());
                preparedStatement.setString(2, userModel.getUserName());
                int preparedStatement1 = preparedStatement.executeUpdate();
                System.out.println(preparedStatement1);
                flag = true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return flag;
        }
        public static boolean modifyUser(userModel userModel) throws SQLException {
            boolean flag = false;
            try{
                String query = "UPDATE user SET userName=? where userId=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, userModel.getUserName());
                preparedStatement.setString(2, userModel.getUserId());
                preparedStatement.executeUpdate();
                flag = true;
            } catch (Exception e){
                throw new SQLException(e);
            }
            return flag;
        }
        public static boolean deleteUser(userModel userModel) throws SQLException {
            boolean flag = false;
            try{
                String query = "DELETE FROM user WHERE userId=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, userModel.getUserId());
                preparedStatement.executeUpdate();
                flag = true;
            } catch (Exception e){
                throw new SQLException(e);
            }
            return flag;
        }
    }