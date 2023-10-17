package Model;

import java.sql.Date;

public class issuedModel {
    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getIssuedToId() {
        return issuedToId;
    }

    public void setIssuedToId(String issuedToId) {
        this.issuedToId = issuedToId;
    }

    public String getIssuedToName() {
        return issuedToName;
    }

    public void setIssuedToName(String issuedToName) {
        this.issuedToName = issuedToName;
    }

    public String getIssuedBookId() {
        return issuedBookId;
    }

    public void setIssuedBookId(String issuedBookId) {
        this.issuedBookId = issuedBookId;
    }

    public String getIssuedBookName() {
        return issuedBookName;
    }

    public void setIssuedBookName(String issuedBookName) {
        this.issuedBookName = issuedBookName;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Override
    public String toString() {
        return "issuedModel{" +
                "issueId='" + issueId + '\'' +
                ", issuedToId='" + issuedToId + '\'' +
                ", issuedToName='" + issuedToName + '\'' +
                ", issuedBookId='" + issuedBookId + '\'' +
                ", issuedBookName='" + issuedBookName + '\'' +
                ", issuedDate=" + issuedDate +
                ", fineAmount=" + fineAmount +
                ", returnDate=" + returnDate +
                ", returnBy=" + returnBy +
                ", delayDays=" + delayDays +
                '}';
    }

    public issuedModel(){
        super();
    }
    public issuedModel(String issueId, String issuedToId, String issuedBookId, Date issuedDate) {
        this.issueId = issueId;
        this.issuedToId = issuedToId;
        this.issuedBookId = issuedBookId;
        this.issuedDate = issuedDate;
    }


    public issuedModel(String issueId, Date issuedDate, double fineAmount) {
        this.issueId = issueId;
        this.issuedDate = issuedDate;
        this.fineAmount = fineAmount;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getReturnBy() {
        return returnBy;
    }

    public void setReturnBy(Date returnBy) {
        this.returnBy = returnBy;
    }

    public long getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(long delayDays) {
        this.delayDays = delayDays;
    }

    private String issueId;
    private String issuedToId;
    private String issuedToName;
    private String issuedBookId;
    private String issuedBookName;
    private Date issuedDate;
    private double fineAmount;
    private Date returnDate;
    private Date returnBy;
    private long delayDays;
}
