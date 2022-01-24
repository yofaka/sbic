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
public class Disposal {

    private int id;
    private String disposalNumber;
    private Date date;
    private String description;
    private User user;
    private Item item;
    private double disposedQuantity;
    
    final static String TABLE_NAME = "disposal";
    private boolean isNew;

    Disposal() {

        this.isNew = true;
    }

    Disposal(String disposalNumber, Date date, String description, User user, Item item, double disposedQuantity){
    
        this.disposalNumber = disposalNumber;
        this.date = date;
        this.description = description;
        this.user = user;
        this.item = item;
        this.disposedQuantity = disposedQuantity;
    
        this.isNew = true;
    }
    
        Disposal(int id, String disposalNumber, Date date, String description, User user, Item item, double disposedQuantity){
    
        this.id = id;
        
        this.disposalNumber = disposalNumber;
        this.date = date;
        this.description = description;
        this.user = user;
        this.item = item;
        this.disposedQuantity = disposedQuantity;
    
        this.isNew = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisposalNumber() {
        return disposalNumber;
    }

    public void setDisposalNumber(String disposalNumber) {
        this.disposalNumber = disposalNumber;
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
        return disposedQuantity;
    }

    public void setDisposedQuantity(double disposedQuantity) {
        this.disposedQuantity = disposedQuantity;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }
        
    

    boolean canDispose() throws SQLException {

        if (Item.find(this.item.getId()).getQuantityAtHand() >= disposedQuantity) {
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
            dataToInsert.add(this.disposalNumber);
            dataToInsert.add(simpleDateFormat.format(this.date));
            dataToInsert.add(this.getDescription());
            dataToInsert.add(Session.getLoggedInUser().getId());
            dataToInsert.add(this.getItem().getId());
            dataToInsert.add(this.getDisposedQuantity());

            this.getItem().setQuantityAtHand((this.getItem().getQuantityAtHand() - this.disposedQuantity)); // update quantity and save wih new Disposal

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
            //columnNames.add("DisposalNumber");
            //columnNames.add("date");
            columnNames.add("description");
            //columnNames.add("userId");
            //columnNames.add("itemId");
            //columnNames.add("disposedQuantity");
         

            ArrayList columnValues = new ArrayList();
            //coulumnValues.add(this.disposalNumber);
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

    static Disposal find(int id) throws SQLException, ParseException {

        ResultSet results = DBConnection.select(TABLE_NAME, "id, disposalNumber, date, description, userId, itemId, disposedQuantity", "id = "+id+"  Order By id");
        results.next();

        Disposal foundDisposal = new Disposal(Integer.valueOf(results.getString(1)), results.getString(2), DateFieldHelper.strToDate(results.getString(3), "yyyy-mm-dd"), results.getString(4), User.find(Integer.valueOf(results.getString(5))), Item.find(Integer.valueOf(results.getString(6))), Double.parseDouble(results.getString(7)));
        return foundDisposal;
    }

    static Disposal[] findAll() throws SQLException, ParseException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "1=1");

        ResultSet results = DBConnection.select(TABLE_NAME, "id, disposalNumber, date, description, userId, itemId, disposedQuantity", "1=1  Order By id");

        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");

        Disposal[] foundDisposals = new Disposal[rowCount];

        int rowCounter = 0;

        while (results.next()) {

            foundDisposals[rowCounter] = new Disposal(Integer.valueOf(results.getString(1)), results.getString(2), DateFieldHelper.strToDate(results.getString(3), "yyyy-mm-dd"), results.getString(4), User.find(Integer.valueOf(results.getString(5))), Item.find(Integer.valueOf(results.getString(6))), Double.parseDouble(results.getString(7)));

            rowCounter++;
        }

        return foundDisposals;
    }

    
        static Disposal[] findAllToday() throws SQLException, ParseException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "date = CURDATE()");

        ResultSet results = DBConnection.select(TABLE_NAME, "id, disposalNumber, date, description, userId, itemId, disposedQuantity", "date = CURDATE()  Order By id");

        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");

        Disposal[] foundDisposals = new Disposal[rowCount];

        int rowCounter = 0;

        while (results.next()) {

            foundDisposals[rowCounter] = new Disposal(Integer.valueOf(results.getString(1)), results.getString(2), DateFieldHelper.strToDate(results.getString(3), "yyyy-mm-dd"), results.getString(4), User.find(Integer.valueOf(results.getString(5))), Item.find(Integer.valueOf(results.getString(6))), Double.parseDouble(results.getString(7)));

            rowCounter++;
        }

        return foundDisposals;
    }

    boolean canDelete() {

        return true;

    }

    boolean delete() throws SQLException {

        if (canDelete()) {

            double newQuantity = this.getItem().getQuantityAtHand() + this.disposedQuantity;
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

    static boolean disposalNumberExists(String disposalNumber, String Except) throws SQLException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "disposalNumber ='" + disposalNumber + "'");
        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");
        if (rowCount > 0) {

            if (Except.equals(disposalNumber)) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }

    }    
        
}
