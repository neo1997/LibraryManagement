import Service.*;
import org.apache.commons.lang3.RandomStringUtils;
import Model.*;


import java.io.IOException;

public class DummyDataGenerator {
    public static void insertRandomUsers() throws IOException {
        for(int i=0;i<=500;i++){
            String userId = RandomStringUtils.randomNumeric(5);
            String userName = RandomStringUtils.randomAlphabetic(10,20);
            var userModel = new userModel(userId, userName);
            var userService = new UserService();
            userService.InsertUser(userModel);
        }
    }

    public static void insertRandomBookData() throws IOException {
        for(int i=0;i<=1000;i++){
            String bookId = RandomStringUtils.randomAlphanumeric(8);
            String bookName = RandomStringUtils.randomAlphabetic(15,50);
            String quantity = RandomStringUtils.randomNumeric(1,2);
            int bookQuantity = Integer.parseInt(quantity);
            var bookModel = new bookModel(bookId, bookName,bookQuantity);
            var bookService = new bookService();
            bookService.addBook(bookModel);
        }
    }
}
