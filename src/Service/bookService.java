package Service;

import Controller.BookController;
import DAO.bookDao;
import Model.bookModel;

import java.io.IOException;

public class bookService {
    public void addBook(bookModel bookModel) throws IOException {
        boolean flag = bookDao.addBook(bookModel);
        if (flag){
            System.out.println("Book Added Successfully");
        } else {
            System.out.println("Book inserting failed, Try Again");
            var bookController = new BookController();
            bookController.bookController();
        }
    }
}
