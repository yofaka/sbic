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
public class Supplier {
    
    private int id;
    private String name;
    private String description;
    private String TIN;
    private String telephone;
    

    final static String TABLE_NAME = "suppliers";
    private boolean isNew;

    Supplier() {

        this.isNew = true;
    }

    Supplier(String name, String description, String TIN, String telephone) {

        this.name = name;
        this.description = description;
        this.TIN = TIN;
        this.telephone = telephone;

        this.isNew = true;

    }

    Supplier(int id, String name, String description, String TIN, String telephone) {

        this.id = id;
        
        this.name = name;
        this.description = description;
        this.TIN = TIN;
        this.telephone = telephone;

      
        this.isNew = false;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public static Supplier find(int id) {

        return new Supplier();
    }

    public static Supplier[] findAll() {

        Supplier units[] = null;
        return units;
    }

     

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTIN() {
        return TIN;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public static boolean nameExists(String name, String except) {
        return false;
    }


    public static boolean tinExists(String TIN, String except) {
        return false;
    }    
}
