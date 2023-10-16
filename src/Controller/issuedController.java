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
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public void issueController() throws IOException, SQLException {
        String issueId = RandomStringUtils.randomAlphabetic(10);
        System.out.print("Enter User Id for issuing : ");
        String issueUserId = br.readLine();
        System.out.print("Enter Book Id to be issued : ");
        String issueBookId = br.readLine();
        Date date = Date.valueOf(LocalDate.now());
        var issuedModel = new issuedModel(issueId, issueUserId, issueBookId, date);
        var issueService = new issueService();
        issueService.issueBookToUser(issuedModel);
        System.out.println(issuedModel);
        issueService.updateToDb(issuedModel);
    }
}
