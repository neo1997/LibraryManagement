package Controller;

import org.apache.commons.lang3.RandomStringUtils;
import Model.bookModel;
import Service.bookService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookController {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void bookController() throws IOException {
        System.out.println("Add Book");
        addBook();
    }
    private void addBook() throws IOException {
        String bookId = RandomStringUtils.randomAlphanumeric(8);
        System.out.print("Enter Book Name");
        String bookName = br.readLine();
        System.out.println("Enter Book Quantity");
        int quantity = Integer.parseInt(br.readLine());
        var bookModel = new bookModel(bookId, bookName, quantity);
        var bookService = new bookService();
        bookService.addBook(bookModel);
        System.out.println(bookModel);
    }
}