package Service;

import Model.*;
import DAO.issuedDao;

import java.sql.SQLException;

public class issueService {
    public void issueBookToUser(issuedModel issuedModel) {
        String userName = issuedDao.getUserName(issuedModel);
        System.out.println("userName : "+userName);
        bookModel bookItem = issuedDao.getBookItem(issuedModel);
        //System.out.println("BookName : "+bookItem.getBookName()+"\n BookQuantity : "+bookItem.getQuantity());
        issuedModel.setIssuedToName(userName);
        issuedModel.setIssuedBookName(bookItem.getBookName());
    }
    public void updateToDb(issuedModel issuedModel) throws SQLException {
        issuedDao.updateToDb(issuedModel);
    }
}
