package Model;

public class userModel {
    public userModel(String userName) {
        this.userName = userName;
    }

    public userModel(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "userModel{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }

    public userModel(){
        super();
    }

    private String userId;
    private String userName;

}
