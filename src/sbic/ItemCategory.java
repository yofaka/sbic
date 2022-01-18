/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Yoftahe
 */
public class ItemCategory {

    private int id;

    public static String getTABLE_NAME() {
        return TABLE_NAME;
    }
    private String name;
    private String description;

    final static String TABLE_NAME = "item_categories";
    private boolean isNew;

    ItemCategory() {

        this.isNew = true;

    }

    ItemCategory(String name, String description) {

        this.name = name;
        this.description = description;

        this.isNew = true;

    }

    ItemCategory(int id, String name, String description) {

        this.id = id;
        this.name = name;
        this.description = description;

        this.isNew = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    boolean save() throws SQLException {

        if (this.isNew) {
            ArrayList dataToInsert = new ArrayList();
            dataToInsert.add("null");
            dataToInsert.add(this.name);
            dataToInsert.add(this.description);

            if (DBConnection.insert(TABLE_NAME, dataToInsert) == 1) {
                return true;
            } else {
                return false;
            }

        } else {
            ArrayList columnNames = new ArrayList();
            columnNames.add("name");
            columnNames.add("description");

            ArrayList columnValues = new ArrayList();
            columnValues.add(this.name);
            columnValues.add(this.description);

            if (DBConnection.update(TABLE_NAME, columnNames, columnValues, "id = " + this.id + "") == 1) {
                return true;
            } else {
                return false;
            }
        }

    }

    boolean canDelete() throws SQLException {

        ResultSet resultsCounter = DBConnection.select(Item.TABLE_NAME, "count(id) as rowCount", "itemCategoryId = " + this.id);
        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");

        if (rowCount > 0) {
            return false;
        } else {
            return true;
        }
    }

    boolean delete() throws SQLException {

        if (DBConnection.delete(TABLE_NAME, "id = " + this.id) == 1) {
            return true;
        } else {
            return false;
        }

    }

    static ItemCategory find(int id) {

        ItemCategory foundItemCategory = new ItemCategory();
        foundItemCategory.isNew = false;

        return foundItemCategory;
    }

    static ItemCategory[] findAll() throws SQLException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "1=1 Order By id");

        ResultSet results = DBConnection.select(TABLE_NAME, "id, name, description", "1=1");

        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");

        ItemCategory[] foundItemCategories = new ItemCategory[rowCount];

        int rowCounter = 0;

        while (results.next()) {

            foundItemCategories[rowCounter] = new ItemCategory(Integer.valueOf(results.getString(1)), results.getString(2), results.getString(3));

            rowCounter++;
        }

        return foundItemCategories;
    }

    static boolean nameExists(String Name, String Except) throws SQLException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "name='" + Name + "'");
        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");
        if (rowCount > 0) {

            if (Except.equals(Name)) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }

    }

}
