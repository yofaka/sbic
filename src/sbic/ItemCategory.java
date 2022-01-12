/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            
            DBConnection.insert(TABLE_NAME, dataToInsert);
        } else {
            //update code
        }

        return true;
    }

    boolean delete() {
        return false;

    }

    static ItemCategory find(int id) {

        ItemCategory foundItemCategory = new ItemCategory();
        foundItemCategory.isNew = false;

        return foundItemCategory;
    }

    static Object[][] findAll() throws SQLException {
        
      
       ResultSet resultsCounter  = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "1=1");
      
       ResultSet results = DBConnection.select(TABLE_NAME, "id, name, description", "1=1");
      
       resultsCounter.next();
       int rowCount = resultsCounter.getInt("rowCount");
       
       
       Object[][] foundItemCategories = new Object[rowCount][results.getMetaData().getColumnCount()];

       int rowCounter = 0;
       
      while(results.next()){
      
          for(int i = 0; i < 3; i++){
         
              foundItemCategories[rowCounter][i] = results.getString(i+1);
          }
          rowCounter++;
      }
       
        
        return foundItemCategories;
    }
    

    static boolean nameExists(String Name) throws SQLException{
    
        ResultSet resultsCounter  = DBConnection.select(TABLE_NAME, "count(id) as rowCount", "Name='"+Name+"'");
        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");
        if(rowCount>0)
            return true;
        else
            return false;
    
    }
    
    
    static JPanel addForm() {
        return null;
    }

    

    static JPanel editForm() {
        return null;

    }

}
