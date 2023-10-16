package Model;

import java.sql.Date;
import java.time.LocalDate;

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

    private String issueId;
    private String issuedToId;
    private String issuedToName;
    private String issuedBookId;
    private String issuedBookName;
    private Date issuedDate;
    private double fineAmount;
}
