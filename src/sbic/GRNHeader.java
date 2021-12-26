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
 * @author LENOVO
 */
public class GRNHeader {
    private int id;
    private String grnNumber;
    private String supplierName;
    /*
    change the supplier attribute to supplierName
    */
    private String supplierTelephone;
    private String supplierTin;
    private User user;
    Date date;
    final static String TABLE_NAME = "grn_headers";
    private boolean isNew;
    
    GRNHeader(){
       this.isNew=true; 
    }
    
    GRNHeader(Date date,String grnNumber,String supplierName,String supplierTelephone,String supplierTin,User user){
        this.date=date;
        this.grnNumber=grnNumber;
        this.supplierName=supplierName;
        this.supplierTelephone=supplierTelephone;
        this.supplierTin=supplierTin;
        this.user=user;
        
        this.isNew=true;
    }

    public String getGRNNumber() {
        return grnNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierTelephone() {
        return supplierTelephone;
    }

    public String getSupplierTin() {
        return supplierTin;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public static String getTABLE_NAME() {
        return TABLE_NAME;
    }

    /*
    
    change isIsNew to isNew
    
    */
    
    public boolean isNew() {
        return isNew;
    }

    public void setGRNNumber(String grnNumber) {
        this.grnNumber = grnNumber;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setSupplierTelephone(String supplierTelephone) {
        this.supplierTelephone = supplierTelephone;
    }

    public void setSupplierTin(String supplierTin) {
        this.supplierTin = supplierTin;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate(Date date) {
        this.date = date;
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

    static GRNHeader find(int id) {

        GRNHeader foundGRNHeader = new GRNHeader();
        foundGRNHeader.isNew = false;

        return foundGRNHeader;
    }

    static GRNHeader[] findAll() {
        
        /*
        
        change the object name to plural like foundGRNHeaders
        
        */

        GRNHeader[] foundGRNHeaders = null;

        return foundGRNHeaders;
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
