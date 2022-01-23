/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JPanel;

/**
 *
 * @author Yoftahe
 */
public class GRN {

    private int id;
    private String GRNNumber;
    private Date date;
    private String supplierName;
    private String supplierTelephone;
    private String supplierTIN;
    private User user;
    private Item item;
    private double receivedQuantity;
    private double unitCost;
    private double totalCost;

    final static String TABLE_NAME = "grn";
    private boolean isNew;

    GRN() {

        this.isNew = true;

    }

    GRN(String GRNNumber, Date date, String supplierName, String supplierTelephone, String supplierTIN, User user, Item item, double receivedQuantity, double unitCost, double totalCost) {

        this.GRNNumber = GRNNumber;
        this.date = date;
        this.supplierName = supplierName;
        this.supplierTelephone = supplierTelephone;
        this.supplierTIN = supplierTIN;
        this.user = user;
        this.item = item;
        this.receivedQuantity = receivedQuantity;
        this.unitCost = unitCost;
        this.totalCost = totalCost;

        this.isNew = true;

    }

    GRN(int id, String GRNNumber, Date date, String supplierName, String supplierTelephone, String supplierTIN, User user, Item item, double receivedQuantity, double unitCost, double totalCost) {

        this.id = id;
        this.GRNNumber = GRNNumber;
        this.date = date;
        this.supplierName = supplierName;
        this.supplierTelephone = supplierTelephone;
        this.supplierTIN = supplierTIN;
        this.user = user;
        this.item = item;
        this.receivedQuantity = receivedQuantity;
        this.unitCost = unitCost;
        this.totalCost = totalCost;

        this.isNew = false;

    }

    public int getId() {
        return id;
    }

    public String getGRNNumber() {
        return GRNNumber;
    }

    public void setGRNNumber(String GRNNumber) {
        this.GRNNumber = GRNNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierTelephone() {
        return supplierTelephone;
    }

    public void setSupplierTelephone(String supplierTelephone) {
        this.supplierTelephone = supplierTelephone;
    }

    public String getSupplierTIN() {
        return supplierTIN;
    }

    public void setSupplierTIN(String supplierTIN) {
        this.supplierTIN = supplierTIN;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getReceivedQuantity() {
        return receivedQuantity;
    }

    public void setReceivedQuantity(double receivedQuantity) {
        this.receivedQuantity = receivedQuantity;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    boolean save() throws SQLException {

        String dateFormatPattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatPattern);

        if (this.isNew) {
            ArrayList dataToInsert = new ArrayList();
            dataToInsert.add("null");
            dataToInsert.add(this.GRNNumber);
            dataToInsert.add(simpleDateFormat.format(this.date));
            dataToInsert.add(this.getSupplierName());
            dataToInsert.add(this.getSupplierTelephone());
            dataToInsert.add(this.getSupplierTIN());
            dataToInsert.add(Session.getLoggedInUser().getId());
            dataToInsert.add(this.getItem().getId());
            dataToInsert.add(this.getReceivedQuantity());
            dataToInsert.add(this.getUnitCost());
            dataToInsert.add(this.getTotalCost());

            this.getItem().setQuantityAtHand((this.getItem().getQuantityAtHand() + this.receivedQuantity)); // update quantity and save wih new GRN

            if (DBConnection.insert(TABLE_NAME, dataToInsert) == 1 && this.getItem().save()) {
                return true;
            } else {
                return false;
            }

        } else {
            ArrayList columnNames = new ArrayList();
            //columnNames.add("GRNNumber");
            //columnNames.add("date");
            columnNames.add("supplierName");
            columnNames.add("supplierTelephone");
            columnNames.add("supplierTIN");
            //columnNames.add("userId");
            //columnNames.add("itemId");
            //columnNames.add("receivedQuantity");
            columnNames.add("unitCost");
            columnNames.add("totalCost");
          
          
            ArrayList columnValues = new ArrayList();
            //columnValues.add(this.GRNNumber);
            //columnValues.add(simpleDateFormat.format(this.date));
            columnValues.add(this.getSupplierName());
            columnValues.add(this.getSupplierTelephone());
            columnValues.add(this.getSupplierTIN());
            //columnValues.add(this.getUser().getId());
            //columnValues.add(this.getItem().getId());
            //columnValues.add(this.getReceivedQuantity());
            columnValues.add(this.getUnitCost());
            columnValues.add(this.getTotalCost());

            double oldRecievedQuantity = (GRN.find(this.id).getReceivedQuantity()); // fetch unmodified object of GRN to fetch the old received
            double newItemQuantity = (this.getItem().getQuantityAtHand() - oldRecievedQuantity) + this.receivedQuantity; // determined new quantity
            this.getItem().setQuantityAtHand(newItemQuantity); // update quantity and save wih updated GRN

            if (DBConnection.update(TABLE_NAME, columnNames, columnValues, "id = " + this.id + "") == 1) {
                return true;
            } else {
                return false;
            }
        }

    }

    static GRN find(int id) throws SQLException {

        ResultSet results = DBConnection.select(TABLE_NAME, "id, GRNNumber, date, supplierName, supplierTelephone, supplierTIN, userId, itemId, receivedQuantity, unitCost, totalCost", "id = " + id);

        results.next();

        GRN foundGRN = new GRN(Integer.valueOf(results.getString(1)), results.getString(2), new Date(), results.getString(4), results.getString(5), results.getString(6), User.find(Integer.valueOf(results.getString(7))), Item.find(Integer.valueOf(results.getString(8))), Double.parseDouble(results.getString(9)), Double.parseDouble(results.getString(10)), Double.parseDouble(results.getString(11)));

        return foundGRN;

    }

    static GRN[] findAll() throws SQLException, ParseException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "1=1");

        ResultSet results = DBConnection.select(TABLE_NAME, "id, GRNNumber, date, supplierName, supplierTelephone, supplierTIN, userId, itemId, receivedQuantity, unitCost, totalCost", "1=1  Order By id");

        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");

        GRN[] foundGRNs = new GRN[rowCount];

        int rowCounter = 0;

        while (results.next()) {

            foundGRNs[rowCounter] = new GRN(Integer.valueOf(results.getString(1)), results.getString(2), DateFieldHelper.strToDate(results.getString(3), "yyyy-mm-dd"), results.getString(4), results.getString(5), results.getString(6), User.find(Integer.valueOf(results.getString(7))), Item.find(Integer.valueOf(results.getString(8))), Double.parseDouble(results.getString(9)), Double.parseDouble(results.getString(10)), Double.parseDouble(results.getString(11)));

            rowCounter++;
        }

        return foundGRNs;
    }

    boolean canDelete() {

        if (this.getItem().getQuantityAtHand() >= this.receivedQuantity) {
            return true;
        } else {
            return false;
        }
    }

    boolean delete() throws SQLException {

        if (this.canDelete()) {

            double newQuantity = this.getItem().getQuantityAtHand() - this.receivedQuantity;
            System.out.println((this.getItem().getQuantityAtHand() - this.receivedQuantity)+"<-"+this.getItem().getQuantityAtHand()+" - "+this.receivedQuantity);
            System.out.println("Old QAH -> "+this.getItem().getQuantityAtHand());
            this.getItem().setQuantityAtHand(newQuantity);
            System.out.println("New QAH -> "+this.getItem().getQuantityAtHand());

            if (DBConnection.delete(TABLE_NAME, "id = " + this.id) == 1 && this.getItem().save()) {
                return true;
            } else {
                return false;
            }
        } else {

            return false;
        }
    }

    static boolean GRNNumberExists(String GRNNumber, String Except) throws SQLException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "GRNNumber ='" + GRNNumber + "'");
        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");
        if (rowCount > 0) {

            if (Except.equals(GRNNumber)) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }

    }

}
