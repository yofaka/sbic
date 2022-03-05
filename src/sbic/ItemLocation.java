/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

/**
 *
 * @author Yoftahe
 */
public class ItemLocation {
 
    private int id;
    private Item item;
    private Location location;
    private double quantity;

    final static String TABLE_NAME = "locations";
    private boolean isNew;

    ItemLocation() {

        this.isNew = true;
    }

    ItemLocation(Item item, Location location, double quantity) {

        this.item = item;
        this.location = location;
        this.quantity = quantity;
        
        this.isNew = true;

    }

    ItemLocation(int id, Item item, Location location, double quantity) {

        this.id = id;
        this.item = item;
        this.location = location;
        this.quantity = quantity;
        

    
      
        this.isNew = false;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }
    
      public static ItemLocation find(int id) {

        return new ItemLocation();
    }

    public static ItemLocation[] findAll() {

        ItemLocation itemLocation[] = null;
        return itemLocation;
    }

      
    
    public boolean save() {
        return false;
    }

    public boolean canDelete() {
        return false;
    }

    public boolean delete() {
        return false;
    }

    public boolean nameExists(String name, String except) {
        return false;
    }    

}
