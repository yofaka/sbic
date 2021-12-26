/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import javax.swing.JPanel;

/**
 *
 * @author Yoftahe
 */
public class User {

    private int id;
    private String userName;
    private String password;
    private String role;
    private boolean isActive;

    final static String TABLE_NAME = "users";
    private boolean isNew;

    User() {

        this.isNew = true;
    }

    User(String userName, String password, String role, boolean isActive) {

        this.userName = userName;
        this.password = password;
        this.role = role;
        this.isActive = isActive;

        this.isNew = true;

    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean isActive() {
        return isActive;
    }

    
    public boolean isNew() {
        return isNew;
    }

    /*
    public void setId(int id) {
        this.id = id;
    }
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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

    static User find(int id) {

        User foundUser = new User();
        foundUser.isNew = false;

        return foundUser;
    }

    static User[] findAll() {

        User[] foundUsers = null;

        return foundUsers;
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
