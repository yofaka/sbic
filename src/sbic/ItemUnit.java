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
public class ItemUnit {

    private int id;
    private Item item;
    private Unit unit;
    private double conversion;
    private boolean main;

    final static String TABLE_NAME = "item_unit";
    private boolean isNew;

    ItemUnit() {

        this.isNew = true;
    }

    ItemUnit(Item item, Unit unit, double conversion, boolean main) {

        this.item = item;
        this.unit = unit;
        this.conversion = conversion;
        this.main = main;

        this.isNew = true;

    }

    ItemUnit(int id, String name) {

        this.id = id;
        this.item = item;
        this.unit = unit;
        this.conversion = conversion;
        this.main = main;

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

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public double getConversion() {
        return conversion;
    }

    public void setConversion(double conversion) {
        this.conversion = conversion;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

   
    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public static ItemUnit find(int id) {

        return new ItemUnit();
    }
    
    public static ItemUnit[] findUnitsForItem(Item item) {

            ItemUnit[] itemUnits = null;
        
        return itemUnits;
    }

    public static ItemUnit[] findAll() {

        ItemUnit itemUnits[] = null;
        return itemUnits;
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

}
