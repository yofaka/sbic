package sbic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Sale {

    private int id;
    private String invoiceNumber;
    private Date date;
    private String customerTIN;
    private User user;
    private Item item;
    private double soldQuantity;
    private double unitPrice;
    private double totalPrice;

    final static String TABLE_NAME = "sales";
    private boolean isNew;

    Sale() {
        this.isNew = true;
    }

    public Sale(String invoiceNumber, Date date, String customerTIN, User user, Item item, double soldQuantity, double unitPrice, double totalPrice) {

        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.customerTIN = customerTIN;
        this.user = user;
        this.item = item;
        this.soldQuantity = soldQuantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;

        this.isNew = true;
    }

    public Sale(int id, String invoiceNumber, Date date, String customerTIN, User user, Item item, double soldQuantity, double unitPrice, double totalPrice) {

        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.customerTIN = customerTIN;
        this.user = user;
        this.item = item;
        this.soldQuantity = soldQuantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;

        this.isNew = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerTIN() {
        return customerTIN;
    }

    public void setCustomerTIN(String customerTIN) {
        this.customerTIN = customerTIN;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(double soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    boolean canSell() throws SQLException {

        if (Item.find(this.item.getId()).getQuantityAtHand() <= soldQuantity) {
            return true;
        } else {
            return false;
        }

    }

    boolean save() throws SQLException {

        String dateFormatPattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatPattern);

        if (this.isNew) {
            ArrayList dataToInsert = new ArrayList();
            dataToInsert.add("null");
            dataToInsert.add(this.invoiceNumber);
            dataToInsert.add(simpleDateFormat.format(this.date));
            dataToInsert.add(this.getCustomerTIN());
            dataToInsert.add(Session.getLoggedInUser().getId());
            dataToInsert.add(this.getItem().getId());
            dataToInsert.add(this.getSoldQuantity());
            dataToInsert.add(this.getUnitPrice());
            dataToInsert.add(this.getTotalPrice());

            this.getItem().setQuantityAtHand((this.getItem().getQuantityAtHand() - this.soldQuantity)); // update quantity and save wih new Sale

            if (canSell()) {
                if (DBConnection.insert(TABLE_NAME, dataToInsert) == 1 && this.getItem().save()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } else {
            ArrayList columnNames = new ArrayList();
            //columnNames.add("InvoiceNumber");
            //columnNames.add("date");
            columnNames.add("customerTIN");
            //columnNames.add("userId");
            //columnNames.add("itemId");
            //columnNames.add("soldQuantity");
            columnNames.add("unitPrice");
            columnNames.add("totalPrice");

            ArrayList columnValues = new ArrayList();
            //columnValues.add(simpleDateFormat.format(this.date));
            columnValues.add(this.getCustomerTIN());
            //columnValues.add(Session.getLoggedInUser().getId());
            //columnValues.add(this.getItem().getId());
            //columnValues.add(this.getSoldQuantity());
            columnValues.add(this.getUnitPrice());
            columnValues.add(this.getTotalPrice());

            if (DBConnection.update(TABLE_NAME, columnNames, columnValues, "id = " + this.id + "") == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    static Sale find(int SalesHederId) throws SQLException, ParseException {

        ResultSet results = DBConnection.select(TABLE_NAME, "id, invoiceNumber, date, customerTIN, userId, itemId, soldQuantity, unitPrice, totalPrice", "1=1  Order By id");
        results.next();

        Sale foundSale = new Sale(Integer.valueOf(results.getString(1)), results.getString(2), DateFieldHelper.strToDate(results.getString(3), "yyyy-mm-dd"), results.getString(4), User.find(Integer.valueOf(results.getString(5))), Item.find(Integer.valueOf(results.getString(6))), Double.parseDouble(results.getString(7)), Double.parseDouble(results.getString(8)), Double.parseDouble(results.getString(9)));
        return foundSale;
    }

    static Sale[] findAll() throws SQLException, ParseException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "1=1");

        ResultSet results = DBConnection.select(TABLE_NAME, "id, invoiceNumber, date, customerTIN, userId, itemId, soldQuantity, unitPrice, totalPrice", "1=1  Order By id");

        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");

        Sale[] foundSales = new Sale[rowCount];

        int rowCounter = 0;

        while (results.next()) {

            foundSales[rowCounter] = new Sale(Integer.valueOf(results.getString(1)), results.getString(2), DateFieldHelper.strToDate(results.getString(3), "yyyy-mm-dd"), results.getString(4), User.find(Integer.valueOf(results.getString(5))), Item.find(Integer.valueOf(results.getString(6))), Double.parseDouble(results.getString(7)), Double.parseDouble(results.getString(8)), Double.parseDouble(results.getString(9)));

            rowCounter++;
        }

        return foundSales;
    }

    boolean canDelete() {

        return true;

    }

    boolean delete() throws SQLException {

        if (canDelete()) {

            double newQuantity = this.getItem().getQuantityAtHand() + this.soldQuantity;
            this.getItem().setQuantityAtHand(newQuantity);

            if (DBConnection.delete(TABLE_NAME, "id = " + this.id) == 1 && this.getItem().save()) {

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    static boolean invoiceNumberExists(String invoiceNumber, String Except) throws SQLException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "invoiceNumber ='" + invoiceNumber + "'");
        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");
        if (rowCount > 0) {

            if (Except.equals(invoiceNumber)) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }

    }
}
