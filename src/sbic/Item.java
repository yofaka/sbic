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
    
    Item(){
        
        this.isNew = true;
    }
    
    
    Item(String code,String name,ItemCategory itemCategory,String  uom,double unitPrice,double quantityAtHand,double minStockLevel,String description){
    
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
    
    public Item find(int itemId){
    
    
        Item item = new Item();
        item.isNew = false;
        
        return item;
    }
    
    public boolean save(){
    
        if(this.isNew){
            //insert code
        }
        else{
         //update code
            }
        
            return false;
    }
    
    public boolean delete(){
    
    return false;
    }
    
    
}
