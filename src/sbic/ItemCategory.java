/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import javax.swing.JPanel;

/**
 *
 * @author Yoftahe
 */
public class ItemCategory {

    private int id;
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

    static ItemCategory find(int id) {

        ItemCategory foundItemCategory = new ItemCategory();
        foundItemCategory.isNew = false;

        return foundItemCategory;
    }

    static ItemCategory[] findAll() {

        ItemCategory[] foundItemCategories = null;

        return foundItemCategories;
    }

    static JPanel addForm() {
        return null;
    }

    

    static JPanel editForm() {
        return null;

    }

}
