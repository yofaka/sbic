/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import static sbic.Disposal.TABLE_NAME;

/**
 *
 * @author Yoftahe
 */
public class User {

    private int id;
    private String userName;
    private String password;
    private String role;
    private boolean Active;

    final static String TABLE_NAME = "users";
    private boolean isNew;

    User() {

        this.isNew = true;
    }

    User(String userName, String password, String role, boolean Active) {

        this.userName = userName;
        this.password = password;
        this.role = role;
        this.Active = Active;

        this.isNew = true;

    }

    User(int id, String userName, String password, String role, boolean Active) {

        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.Active = Active;

        this.isNew = false;

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
        return Active;
    }

    public String getActive() {

        if (Active) {
            return "Yes";
        } else {
            return "No";
        }
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

    public void setActive(boolean isActive) {
        this.Active = Active;
    }

    static int validCredentials(String userName, String password) throws SQLException {

        ResultSet matchingUsers = DBConnection.select("users", "count(id) as matchingUsersCount", "active = '1', name = '" + userName + "' AND password='" + password + "'");

        matchingUsers.next();

        if (matchingUsers.getInt("matchingUsersCount") > 0) {

            ResultSet matchedUser = DBConnection.select("users", "id", "name = '" + userName + "' AND password='" + password + "'");
            matchedUser.next();
            return Integer.valueOf(matchedUser.getString(1));

        } else {

            return 0;
        }

    }

    boolean save() throws SQLException {

        if (this.isNew) {
            ArrayList dataToInsert = new ArrayList();
            dataToInsert.add("null");
            dataToInsert.add(this.userName);
            dataToInsert.add(this.password);
            dataToInsert.add(this.role);
            if (this.Active) {
                dataToInsert.add(1);
            } else {
                dataToInsert.add(0);
            }

            if (DBConnection.insert(TABLE_NAME, dataToInsert) == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            ArrayList columnNames = new ArrayList();
            columnNames.add("name");
            columnNames.add("password");
            columnNames.add("role");
            columnNames.add("active");

            ArrayList columnValues = new ArrayList();
            columnValues.add(this.userName);
            columnValues.add(this.password);
            columnValues.add(this.role);
            columnValues.add(this.password);

            if (DBConnection.update(TABLE_NAME, columnNames, columnValues, "id = " + this.id + "") == 1) {
                return true;
            } else {
                return false;
            }
        }

    }

    boolean canDelete() throws SQLException {

        ResultSet resultsCounter = DBConnection.select(GRN.TABLE_NAME + ", " + Sale.TABLE_NAME + "," + Disposal.TABLE_NAME, "count(*) as rowCount", "grn.userId = " + this.id + " OR sales.userId = " + this.id + " OR disposal.userId = " + this.id);

        resultsCounter.next();
        int rowCount = resultsCounter.getInt("rowCount");

        if (rowCount > 0) {
            return false;
        } else {
            return true;
        }

    }

    boolean delete() throws SQLException {

        if (canDelete()) {

            if (DBConnection.delete(TABLE_NAME, "id = " + this.id) == 1) {

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

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

}
