/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Yoftahe
 */
public class Item {

    private int id;
    private String code;
    private String name;
    private ItemCategory itemCategory;
    private String uom;
    private double unitPrice;
    private double quantityAtHand;
    private double minStockLevel;
    private String description;

    final static String TABLE_NAME = "items";
    private boolean isNew;

    Item() {

        this.isNew = true;
    }

    Item(String code, String name, ItemCategory itemCategory, String uom, double unitPrice, double quantityAtHand, double minStockLevel, String description) {

        this.code = code;
        this.name = name;
        this.itemCategory = itemCategory;
        this.uom = uom;
        this.unitPrice = unitPrice;
        this.quantityAtHand = quantityAtHand;
        this.minStockLevel = minStockLevel;
        this.description = description;

        this.isNew = true;
    }

    Item(int id, String code, String name, ItemCategory itemCategory, String uom, double unitPrice, double quantityAtHand, double minStockLevel, String description) {

        this.id = id;
        this.code = code;
        this.name = name;
        this.itemCategory = itemCategory;
        this.uom = uom;
        this.unitPrice = unitPrice;
        this.quantityAtHand = quantityAtHand;
        this.minStockLevel = minStockLevel;
        this.description = description;

        this.isNew = false;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public String getUom() {
        return uom;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getQuantityAtHand() {
        return quantityAtHand;
    }

    public double getMinStockLevel() {
        return minStockLevel;
    }

    public String getDescription() {
        return description;
    }

    public static String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantityAtHand(double quantityAtHand) {
        this.quantityAtHand = quantityAtHand;
    }

    public void setMinStockLevel(double minStockLevel) {
        this.minStockLevel = minStockLevel;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Item[] findAll() throws SQLException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "1=1");

        ResultSet results = DBConnection.select(TABLE_NAME, "id, code, name, itemCategoryId, uom, unitPrice, quantityAtHand, minStockLevel, description", "1=1  Order By id");

        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");

        Item[] foundItems = new Item[rowCount];

        int rowCounter = 0;

        while (results.next()) {

            foundItems[rowCounter] = new Item(Integer.valueOf(results.getString(1)), results.getString(2), results.getString(3), ItemCategory.find(Integer.valueOf(results.getString(4))), results.getString(5), Double.parseDouble(results.getString(6)), Double.parseDouble(results.getString(7)), Double.parseDouble(results.getString(8)), results.getString(9));

            rowCounter++;
        }

        return foundItems;

    }

    public static Item find(int id) throws SQLException {

        ResultSet results = DBConnection.select(TABLE_NAME, "id, code, name, itemCategoryId, uom, unitPrice, quantityAtHand, minStockLevel, description", "id = " + id);

        results.next();

        Item foundItem = new Item(Integer.valueOf(results.getString(1)), results.getString(2), results.getString(3), ItemCategory.find(Integer.valueOf(results.getString(4))), results.getString(5), Double.parseDouble(results.getString(6)), Double.parseDouble(results.getString(7)), Double.parseDouble(results.getString(8)), results.getString(9));

        return foundItem;
    }

    public boolean save() throws SQLException {

        if (this.isNew) {
            ArrayList dataToInsert = new ArrayList();
            dataToInsert.add("null");
            dataToInsert.add(this.code);
            dataToInsert.add(this.name);
            dataToInsert.add(this.itemCategory.getId());
            dataToInsert.add(this.uom);
            dataToInsert.add(this.unitPrice);
            dataToInsert.add(this.quantityAtHand);
            dataToInsert.add(this.minStockLevel);
            dataToInsert.add(this.description);

            if (DBConnection.insert(TABLE_NAME, dataToInsert) == 1) {
                return true;
            } else {
                return false;
            }

        } else {
            ArrayList columnNames = new ArrayList();
            columnNames.add("code");
            columnNames.add("name");
            columnNames.add("itemCategoryId");
            columnNames.add("uom");
            columnNames.add("unitPrice");
            columnNames.add("quantityAtHand");
            columnNames.add("minStockLevel");
            columnNames.add("description");

            ArrayList columnValues = new ArrayList();
            columnValues.add(this.code);
            columnValues.add(this.name);
            columnValues.add(this.itemCategory.getId());
            columnValues.add(this.uom);
            columnValues.add(this.unitPrice);
            columnValues.add(this.quantityAtHand);
            columnValues.add(this.minStockLevel);
            columnValues.add(this.description);

            if (DBConnection.update(TABLE_NAME, columnNames, columnValues, "id = " + this.id + "") == 1) {
                return true;
            } else {
                return false;
            }
        }

    }

    boolean canDelete() throws SQLException {

        ResultSet resultsCounter = DBConnection.select(GRN.TABLE_NAME + ", " + Sale.TABLE_NAME + "," + Disposal.TABLE_NAME, "count(*) as rowCount", "grn.itemId = " + this.id + " OR sales.itemId = " + this.id + " OR disposal.itemId = " + this.id);

        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");

        if (rowCount > 0) {
            return false;
        } else {
            return true;
        }
    }

    boolean delete() throws SQLException {

        if (this.canDelete()) {
            if (DBConnection.delete(TABLE_NAME, "id = " + this.id) == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
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

    static boolean codeExists(String Code, String Except) throws SQLException {

        ResultSet resultsCounter = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "code='" + Code + "'");
        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");
        if (rowCount > 0) {

            if (Except.equals(Code)) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }

    }

}
