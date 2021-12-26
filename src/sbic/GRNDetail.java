/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class GRNDetail {
    private int id;
    private GRNHeader grnHeaderId;
    private Item itemId;
    private double receivedQuantity;
    private double unitCost;
    private double totalCost;
    
    final static String TABLE_NAME = "grn_headers";
    private boolean isNew;
    GRNDetail(){
        this.isNew=true;
   }
    
   GRNDetail(GRNHeader grnHeaderId,Item itemId,double receivedQuantity,double unitCost,double totalCost){
      
       this.grnHeaderId=grnHeaderId;
       this.itemId=itemId;
       this.receivedQuantity=receivedQuantity;
       this.unitCost=unitCost;
       this.totalCost=totalCost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGRNHeaderId(GRNHeader grnHeaderId) {
        this.grnHeaderId = grnHeaderId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    public void setReceivedQuantity(double receivedQuantity) {
        this.receivedQuantity = receivedQuantity;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

   
   
   
    public int getId() {
        return id;
    }

    public GRNHeader getGRNHeaderId() {
        return grnHeaderId;
    }

    public Item getItemId() {
        return itemId;
    }

    public double getReceivedQuantity() {
        return receivedQuantity;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public static String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public boolean isIsNew() {
        return isNew;
    }
   
   public boolean isNew() {
        return isNew;
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

    static GRNDetail find(int id) {

        GRNDetail foundGRNDetail = new GRNDetail();
        foundGRNDetail.isNew = false;

        return foundGRNDetail;
    }

    static GRNDetail[] findAll() {
        
        /*
        
        change the object name to plural like foundGRNHeaders
        
        */

        GRNDetail[] foundGRNDetail = null;

        return foundGRNDetail;
    }

    static JPanel addForm() {
        return null;
    }

    static JPanel editForm() {
        return null;

    }

    static JPanel listView() {
        return null;
    }
    
   
}
