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
public class Location {

    private int id;
    private String name;
    private String description;
    private String type;
    

    final static String TABLE_NAME = "locations";
    private boolean isNew;

    Location() {

        this.isNew = true;
    }

    Location(String name, String description, String type) {

        this.name = name;
        this.description = description;
        this.type = type;

        this.isNew = true;

    }

    Location(int id, String name, String description, String type) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;

      
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

    public static Location find(int id) {

        return new Location();
    }

    public static Location[] findAll() {

        Location units[] = null;
        return units;
    }

      public static Location[] findAllByType(String type) {

        Location locations[] = null;
        return locations;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
