package Controller;

import org.apache.commons.lang3.RandomStringUtils;
import Model.*;
import Service.issueService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class issuedController {
    public void issuedController() throws IOException, SQLException {
        System.out.println("1. Issue a new Book");
        System.out.println("2. Return of issued Book");
        int choice = Integer.parseInt(br.readLine());
        if (choice == 1)
            issueController();
        else if (choice == 2) {
            returnIssuedBook();
        }
    }
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void issueController() throws IOException, SQLException {
        String issueId = RandomStringUtils.randomAlphabetic(10);
        System.out.print("Enter User Id for issuing : ");
        String issueUserId = br.readLine();
        System.out.print("Enter Book Id to be issued : ");
        String issueBookId = br.readLine();
        Date date = Date.valueOf(LocalDate.of(2023, 10, 1));
        var issuedModel = new issuedModel(issueId, issueUserId, issueBookId, date);
        var issueService = new issueService();
        issueService.issueBookToUser(issuedModel);
        System.out.println(issuedModel);
    }

    public void returnIssuedBook() throws IOException {
        System.out.print("Enter Issue Id : ");
        String issueId = br.readLine();
        Date date = Date.valueOf(LocalDate.now());
        var issueItem = new issuedModel();
        issueItem.setIssueId(issueId);
        issueItem.setReturnDate(date);
        var issueService = new issueService();
        issueService.returnBook(issueItem);
    }
}
