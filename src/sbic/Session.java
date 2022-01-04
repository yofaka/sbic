/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import javax.swing.JPanel;

/**
 *
 * @author Mebrea
 */
public class Session {
    private int id ;
    private String userName;
    private String password;
    private String role;
    private boolean isactive;
    
    final static String TABLE_NAME = "users";
    private boolean isNew;
    
    Session(){
        
        this.isNew = true;
    }
    
    Session(String userName, String password,String role, boolean isactive ){
    
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.isactive = isactive;
        
        this .isNew = true;
        
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public boolean isNew() {
        return isNew;
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
        static Session find(int id) {
           
        return new Session();
        
    }
        static Session[] findAll() {

        Session[] Sessions = new Session[10];

        return Sessions;
    }

    boolean delete() {
        return false;

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

    

