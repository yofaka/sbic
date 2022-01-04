package sbic;

import java.util.Date;
import javax.swing.JPanel;

public class SalesHeader {

    private int SalesHederId;
    private String InvoiceNumber;
    private Date Date;
    private int CoustomerTIN;
    private User user;
    final static String TABLE_NAME = "sales_header";
    private boolean isNew;

    SalesHeader() {
        this.isNew = true;
    }

    public SalesHeader(String InvoiceNumber, Date Date, int CoustomerTIN, User user) {

        this.InvoiceNumber = InvoiceNumber;
        this.Date = Date;
        this.CoustomerTIN = CoustomerTIN;
        this.user = user;
    }

    public int getSalesHederId() {
        return SalesHederId;
    }

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public Date getDate() {
        return Date;
    }

    public int getCoustomerTIN() {
        return CoustomerTIN;
    }

    public User getUser() {
        return user;
    }

    public void setInvoiceNumber(String InvoiceNumber) {
        this.InvoiceNumber = InvoiceNumber;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public void setCoustomerTIN(int CoustomerTIN) {
        this.CoustomerTIN = CoustomerTIN;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    boolean save() {

        if (this.isNew) {
            // insert code
        } else {
            //update code
        }

        return true;
    }

    boolean delete() {
        return false;

    }

    static SalesHeader find(int SalesHederId) {

        SalesHeader found = new SalesHeader();
        found.isNew = false;

        return found;
    }

    static SalesHeader[] findAll() {

        SalesHeader[] SalesHeaderIId = null;

        return SalesHeaderIId;
    }

    static JPanel addForm() {
        return null;
    }

    public boolean isIsNew() {
        return isNew;
    }

    static JPanel editForm() {
        return null;

    }

    static JPanel listView() {
        return null;
    }

}
