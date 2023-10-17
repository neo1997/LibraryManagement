package Model;

public class bookModel {
    public bookModel(){
        super();
    }
    public bookModel(String bookId, String bookName, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.quantity = quantity;
    }

    public bookModel(int quantity, String bookId){
        this.quantity = quantity;
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "bookModel{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    private String bookId;
    private String bookName;
    private int quantity;
}
