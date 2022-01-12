/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    static int validCredentials(String userName, String password) throws SQLException {

        ResultSet matchingUsers = DBConnection.select("users", "count(id) as matchingUsersCount", "name = '" + userName + "' AND password='" + password + "'");

        matchingUsers.next();

        if (matchingUsers.getInt("matchingUsersCount") > 0) {

            ResultSet matchedUser = DBConnection.select("users", "id", "name = '" + userName + "' AND password='" + password + "'");
            matchedUser.next();
            return Integer.valueOf(matchedUser.getString(1));

        } else {

            return 0;
        }

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

    static User find(int id) throws SQLException {

        ResultSet foundUserRow = DBConnection.select("users", "id,name,password,role,active", "id=" + id);
        if (foundUserRow.next()) {

            boolean isActive;

            if (Integer.valueOf(foundUserRow.getString(5)) == 0) {
                isActive = false;
            } else {
                isActive = true;
            }

            User foundUser = new User(foundUserRow.getString(2), foundUserRow.getString(3), foundUserRow.getString(4), isActive);
            foundUser.id = Integer.valueOf(foundUserRow.getString(1));
            foundUser.isNew = false;

            return foundUser;
        } else {

            return null;
        }
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
