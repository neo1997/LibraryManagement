    package Service;

    import Model.*;
    import DAO.issuedDao;
    import java.sql.Date;
    import java.sql.SQLException;
    import java.util.concurrent.TimeUnit;

    public class issueService {
        public void issueBookToUser(issuedModel issuedModel) throws SQLException {
            String userName = issuedDao.getUserName(issuedModel);
            System.out.println("userName : " + userName);
            bookModel bookItem = issuedDao.getBookItem(issuedModel);
            bookItem.setBookId(issuedModel.getIssuedBookId());
            System.out.println("Previous Quantity in inventory : " + bookItem.getQuantity());
            //var bookModel = new bookModel(bookItem.getQuantity(), bookItem.getBookId());
            long days = 7;
            if (bookQuantityAfterIssuing(bookItem)) {
                System.out.println("New Quantity in inventory : " + bookItem.getQuantity());
                //System.out.println("BookName : "+bookItem.getBookName()+"\n BookQuantity : "+bookItem.getQuantity());
                issuedModel.setReturnBy(Date.valueOf(Date.valueOf(issuedModel.getIssuedDate().toLocalDate().plusDays(days)).toLocalDate()));
                issuedModel.setIssuedToName(userName);
                issuedModel.setIssuedBookName(bookItem.getBookName());
                updateToDb(issuedModel);
            } else {
                System.out.println("Please check another book, bookName "+bookItem.getBookName()+" having bookId "+bookItem.getBookId()+" is not available");
            }
        }
        public boolean bookQuantityAfterIssuing(bookModel bookItem){
            if (bookItem.getQuantity() >= 1){
                bookItem.setQuantity(bookItem.getQuantity() - 1);
                issuedDao.bookQuantityAfterIssuing(bookItem);
                System.out.println("New Quantity : "+bookItem.getQuantity());
                return true;
            } else{
                System.out.println("Book Not Available");
                return false;
            }
        }
        public void updateToDb(issuedModel issuedModel) throws SQLException {
            issuedDao.updateToDb(issuedModel);
        }

        public void returnBook(issuedModel issueItem) {
            issuedDao.getIssueDetails(issueItem);
            Date date = issueItem.getIssuedDate();
            System.out.println("Issued date " + date);
            System.out.println("Return Date " + issueItem.getReturnDate());
            long difference = issueItem.getReturnDate().getTime() - date.getTime();
            long diffInDays = TimeUnit.MILLISECONDS.toDays(difference);
            System.out.println("Book kept for : " + diffInDays);
            long delayedDate = issueItem.getReturnDate().getTime() - date.getTime();
            long delayDay = TimeUnit.MILLISECONDS.toDays(delayedDate) - 7;
            System.out.println("Book kept for extra : " + delayDay);
            issueItem.setDelayDays(delayDay);
            System.out.println(issueItem.getDelayDays());
            if (delayDay > 7)
                issueItem.setFineAmount(fineCalc(delayDay));
            else
                issueItem.setFineAmount(20);

            issuedDao.updateFineAmount(issueItem);
        }
        public double fineCalc(double delayDay){
            double amount = 0.0;
            double finePerDay = 1.5;
            for(int i =1; i <= delayDay; i++){
                amount = amount + finePerDay;
            }
            System.out.println(amount);
            return amount;
        }
    }
