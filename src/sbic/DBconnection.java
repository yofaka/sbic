/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

/**
 *
 * @author LENOVO
 */
public class DBconnection {

    static private Object db = new Object(); //variable  & has  getter
    private static String databaseName;
    private static String serverName;
    private static String passwordName; // with setters and getters

    public void connect() {
        if (db == null) {
            //if code here
        } else {
            //else code here
        }
    }

    public static void setDb(Object db) {
        DBconnection.db = db;
    }

    public static void setDatabaseName(String databaseName) {
        DBconnection.databaseName = databaseName;
    }

    public static void setServerName(String serverName) {
        DBconnection.serverName = serverName;
    }

    public static void setPasswordName(String passwordName) {
        DBconnection.passwordName = passwordName;
    }

    public static String getDatabaseName() {
        return databaseName;
    }

    public static String getServerName() {
        return serverName;
    }

    public static String getPasswordName() {
        return passwordName;
    }
    
    

    int insertData() {
        return 0;  //to be modified 
    }

    int ResultSet() {
        return 0;  //to be modified  
    }

    int selectWhere() {
        return 0;  //to be modified  
    }

    int deleteData() {
        return 0;  //to be modified
    }

}
