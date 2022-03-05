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

/**
 *
 * @author Yoftahe
 */
public class Transfer {

    private int id;
    private String transferNumber;
    private Date date;
    private Location fromLocation;
    private Location toLocation;
    private String description;
    private User user;
    private Item item;
    private double transferedQuantity;

    final static String TABLE_NAME = "transfers";
    private boolean isNew;

    Transfer() {

        this.isNew = true;
    }

    Transfer(String transferNumber, Date date, Location fromLocation, Location toLocation, String description, User user, Item item, double transferedQuantity) {

        this.transferNumber = transferNumber;
        this.date = date;
        this.description = description;
        this.user = user;
        this.item = item;
        this.transferedQuantity = transferedQuantity;

        this.isNew = true;
    }

    Transfer(int id, String transferNumber, Date date, Location fromLocation, Location toLocation, String description, User user, Item item, double transferedQuantity) {

        this.id = id;

        this.transferNumber = transferNumber;
        this.date = date;
        this.description = description;
        this.user = user;
        this.item = item;
        this.transferedQuantity = transferedQuantity;

        this.isNew = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(String transferNumber) {
        this.transferNumber = transferNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public double getDisposedQuantity() {
        return transferedQuantity;
    }

    public void setDisposedQuantity(double transferedQuantity) {
        this.transferedQuantity = transferedQuantity;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    boolean canDispose() throws SQLException {

        if (Item.find(this.item.getId()).getQuantityAtHand() >= transferedQuantity) {
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
            dataToInsert.add(this.transferNumber);
            dataToInsert.add(simpleDateFormat.format(this.date));
            dataToInsert.add(this.getDescription());
            dataToInsert.add(Session.getLoggedInUser().getId());
            dataToInsert.add(this.getItem().getId());
            dataToInsert.add(this.getDisposedQuantity());

            this.getItem().setQuantityAtHand((this.getItem().getQuantityAtHand() - this.transferedQuantity)); // update quantity and save wih new Transfer

            if (canDispose()) {
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
            //columnNames.add("TransferNumber");
            //columnNames.add("date");
            columnNames.add("description");
            //columnNames.add("userId");
            //columnNames.add("itemId");
            //columnNames.add("transferedQuantity");

            ArrayList columnValues = new ArrayList();
            //coulumnValues.add(this.transferNumber);
            //columnValues.add(simpleDateFormat.format(this.date));
            columnValues.add(this.getDescription());
            //columnValues.add(Session.getLoggedInUser().getId());
            //columnValues.add(this.getItem().getId());
            //columnValues.add(this.getDisposedQuantity());

            if (DBConnection.update(TABLE_NAME, columnNames, columnValues, "id = " + this.id + "") == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    static Transfer find(int id) throws SQLException, ParseException {

        ResultSet results = DBConnection.select(TABLE_NAME, "id, transferNumber, date, description, userId, itemId, transferedQuantity", "id = " + id + "  Order By id");
        results.next();

        Transfer foundTransfer = new Transfer();//Integer.valueOf(results.getString(1)), results.getString(2), DateFieldHelper.strToDate(results.getString(3), "yyyy-mm-dd"), Location.find(Integer.valueOf(results.getString(4)), Location.find(Integer.valueOf(results.getString(4)), results.getString(4), User.find(Integer.valueOf(results.getString(5))), Item.find(Integer.valueOf(results.getString(6))), Double.parseDouble(results.getString(7)));
        return foundTransfer;
    }

    static Transfer[] findAll() throws SQLException, ParseException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "1=1");

        ResultSet results = DBConnection.select(TABLE_NAME, "id, transferNumber, date, description, userId, itemId, transferedQuantity", "1=1  Order By id");

        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");

        Transfer[] foundTransfers = new Transfer[rowCount];

        int rowCounter = 0;

        while (results.next()) {

            foundTransfers[rowCounter] = new Transfer();//Integer.valueOf(results.getString(1)), results.getString(2), DateFieldHelper.strToDate(results.getString(3), "yyyy-mm-dd"), results.getString(4), User.find(Integer.valueOf(results.getString(5))), Item.find(Integer.valueOf(results.getString(6))), Double.parseDouble(results.getString(7)));

            rowCounter++;
        }

        return foundTransfers;
    }

    static Transfer[] findAllToday() throws SQLException, ParseException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "date = CURDATE()");

        ResultSet results = DBConnection.select(TABLE_NAME, "id, transferNumber, date, description, userId, itemId, transferedQuantity", "date = CURDATE()  Order By id");

        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");

        Transfer[] foundTransfers = new Transfer[rowCount];

        int rowCounter = 0;

        while (results.next()) {

            foundTransfers[rowCounter] = new Transfer();//Integer.valueOf(results.getString(1)), results.getString(2), DateFieldHelper.strToDate(results.getString(3), "yyyy-mm-dd"), results.getString(4), User.find(Integer.valueOf(results.getString(5))), Item.find(Integer.valueOf(results.getString(6))), Double.parseDouble(results.getString(7)));

            rowCounter++;
        }

        return foundTransfers;
    }

    boolean canDelete() {

        return true;

    }

    boolean delete() throws SQLException {

        if (canDelete()) {

            double newQuantity = this.getItem().getQuantityAtHand() + this.transferedQuantity;
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

    static boolean transferNumberExists(String transferNumber, String Except) throws SQLException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "transferNumber ='" + transferNumber + "'");
        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");
        if (rowCount > 0) {

            if (Except.equals(transferNumber)) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }

    }

}
