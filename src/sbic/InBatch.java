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
public class InBatch {
    
    private int id;
    private String origin;
    private GRN grn;
    private Transfer transfer;
    private Location location;
    private Item item;
    private double quantityreceived;
    private double quantityUsed;
    

    final static String TABLE_NAME = "in_batches";
    private boolean isNew;

    InBatch() {

        this.isNew = true;
    }

    InBatch(GRN grn, Location location, Item item, double quantityReceived, double quantityUsed) {

        this.origin = "grn";
        this.grn = grn;
        this.location = location;
        this.item = item;
        this.quantityreceived = quantityReceived;
        this.quantityUsed = quantityUsed;

        this.isNew = true;

    }    
        
    InBatch(Transfer transfer, Location location, Item item, double quantityReceived, double quantityUsed) {

        this.origin = "transfer";
        this.transfer = transfer;
        this.location = location;
        this.item = item;
        this.quantityreceived = quantityReceived;
        this.quantityUsed = quantityUsed;

        this.isNew = true;

    }

    InBatch(int id, String origin, GRN grn, Location location, Item item, double quantityReceived, double quantityUsed) {

        this.id = id;
        this.origin = origin;
        this.grn = grn;        
        this.location = location;
        this.item = item;
        this.quantityreceived = quantityReceived;
        this.quantityUsed = quantityUsed;
      
        this.isNew = false;

    }

    
    InBatch(int id, String origin, Transfer transfer, Location location, Item item, double quantityReceived, double quantityUsed) {

        this.id = id;
        this.origin = origin;
        this.transfer = transfer;
        this.location = location;
        this.item = item;
        this.quantityreceived = quantityReceived;
        this.quantityUsed = quantityUsed;
      
        this.isNew = false;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public GRN getGrn() {
        return grn;
    }

    public void setGrn(GRN grn) {
        this.grn = grn;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getQuantityreceived() {
        return quantityreceived;
    }

    public void setQuantityreceived(double quantityreceived) {
        this.quantityreceived = quantityreceived;
    }

    public double getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(double quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

   

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }
    
    

    public static InBatch find(int id) {

        return new InBatch();
    }

    public static InBatch[] findAll() {

        InBatch units[] = null;
        return units;
    }

      public static InBatch[] findAllByType(String type) {

        InBatch inBatches[] = null;
        return inBatches;
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
