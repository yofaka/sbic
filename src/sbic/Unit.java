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
public class Unit {

    private int id;
    private String name;

    final static String TABLE_NAME = "units";
    private boolean isNew;

    Unit() {

        this.isNew = true;
    }

    Unit(String name) {

        this.name = name;

        this.isNew = true;

    }

    Unit(int id, String name) {

        this.id = id;
        this.name = name;

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

    public static Unit find(int id) {

        return new Unit();
    }

    public static Unit[] findAll() {

        Unit units[] = null;
        return units;
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
