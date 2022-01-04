/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.util.Date;
import javax.swing.JPanel;

/**
 *
 * @author Yoftahe
 */
public class GRN {

    private int id;
    private String GRNNumber;
    private Date date;
    private String supplierName;
    private String supplierTelephone;
    private String supplierTIN;
    private User user;
    private Item item;
    private double receivedQuantity;
    private double unitCost;
    private double totalCost;

    final static String TABLE_NAME = "grn";
    private boolean isNew;

    GRN() {

        this.isNew = true;

    }

    GRN(String GRNNumber, Date date, String supplierName, String supplierTelephone, String supplierTIN, User user, Item item, double receivedQuantity, double unitCost, double totalCost) {

        this.GRNNumber = GRNNumber;
        this.date = date;
        this.supplierName = supplierName;
        this.supplierTelephone = supplierTelephone;
        this.supplierTIN = supplierTIN;
        this.user = user;
        this.item = item;
        this.receivedQuantity = receivedQuantity;
        this.unitCost = unitCost;
        this.totalCost = totalCost;

        this.isNew = true;

    }

    public int getId() {
        return id;
    }

    public String getGRNNumber() {
        return GRNNumber;
    }

    public void setGRNNumber(String GRNNumber) {
        this.GRNNumber = GRNNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierTelephone() {
        return supplierTelephone;
    }

    public void setSupplierTelephone(String supplierTelephone) {
        this.supplierTelephone = supplierTelephone;
    }

    public String getSupplierTIN() {
        return supplierTIN;
    }

    public void setSupplierTIN(String supplierTIN) {
        this.supplierTIN = supplierTIN;
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

    public double getReceivedQuantity() {
        return receivedQuantity;
    }

    public void setReceivedQuantity(double receivedQuantity) {
        this.receivedQuantity = receivedQuantity;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }
    
    
    boolean save(){
    
    
        if(this.isNew){
        //insert
        }else{
        
            // update
        }
    
        return false;
    }
    
    
    GRN find(int id){
    
        return new GRN();
    }

    GRN[]  findAll(){
    
        GRN GRNs[] = new GRN[10];
        return  GRNs;
    }
    
    boolean delete(){
    
        return false;
    }
    
    
    JPanel listView(){
    
    return null;}
    
    JPanel addForm(){return null;}
    
    JPanel editForm(){return null;}
    
    
    
}
