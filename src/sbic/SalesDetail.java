package sbic;

import javax.swing.JPanel;

public class SalesDetail {

    private int SalesDetailId;
    private SalesHeader salesHeder;
    private int ItemId;
    private double SoldQuantity;
    private double UnitPrice;
    private double TotalPrice;
    final static String TABLE_NAME = "sales_detail";
    private boolean isNew;

    SalesDetail() {
        this.isNew = true;
    }

    public SalesDetail(int SalesDetailId, SalesHeader salesHeder, int ItemId, double SoldQuantity, double UnitPrice, double TotalPrice) {
        this.SalesDetailId = SalesDetailId;
        this.salesHeder = salesHeder;
        this.ItemId = ItemId;
        this.SoldQuantity = SoldQuantity;
        this.UnitPrice = UnitPrice;
        this.TotalPrice = TotalPrice;
    }

    public int getSalesDetailId() {
        return SalesDetailId;
    }

    public SalesHeader getSalesHeder() {
        return salesHeder;
    }

    public int getItemId() {
        return ItemId;
    }

    public double getSoldQuantity() {
        return SoldQuantity;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setSalesDetailId(int SalesDetailId) {
        this.SalesDetailId = SalesDetailId;
    }

    public void setSalesHeder(SalesHeader salesHeder) {
        this.salesHeder = salesHeder;
    }

    public void setItemId(int ItemId) {
        this.ItemId = ItemId;
    }

    public void setSoldQuantity(double SoldQuantity) {
        this.SoldQuantity = SoldQuantity;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public void setTotalPrice(double TotalPrice) {
        this.TotalPrice = TotalPrice;
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

    static SalesDetail find(int ItemId) {

        SalesDetail found = new SalesDetail();
        found.isNew = false;

        return found;
    }

    static SalesDetail[] findAll() {

        SalesDetail[] foundItem = null;

        return foundItem;
    }

    static JPanel addForm() {
        return null;
    }

    public boolean isNew() {
        return isNew;
    }

    static JPanel editForm() {
        return null;

    }

    static JPanel listView() {
        return null;
    }
}
