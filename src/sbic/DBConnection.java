/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class DBConnection {

    private static Connection connection; //variable  & has  getter
    private static String databaseName;
    private static String serverName;
    private static String portNumber;
    private static String userName;
    private static String password; // with setters and getters

    static void loadConfig() {

        DBConnection.serverName = "";
        DBConnection.userName = "";
        DBConnection.password = "";
        DBConnection.databaseName = "";

    }

    public static void connect() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + DBConnection.serverName + ":" + DBConnection.portNumber + "/" + DBConnection.databaseName;
        Connection connection = DriverManager.getConnection(url, DBConnection.userName, DBConnection.password);

        if (connection == null) {
            System.out.println("NOT Connected!!!");
        } else {

            System.out.println("Connected!!!");

            DBConnection.connection = connection;
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        DBConnection.connection = connection;
    }

    public static String getDatabaseName() {
        return databaseName;
    }

    public static void setDatabaseName(String databaseName) {
        DBConnection.databaseName = databaseName;
    }

    public static String getServerName() {
        return serverName;
    }

    public static void setServerName(String serverName) {
        DBConnection.serverName = serverName;
    }

    public static String getPortNumber() {
        return portNumber;
    }

    public static void setPortNumber(String portNumber) {
        DBConnection.portNumber = portNumber;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        DBConnection.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DBConnection.password = password;
    }

    int insertData() {
        return 0;  //to be modified 
    }

    ResultSet select(String TableName, String Columns, String WhereClause) {

        return null;

    }

    boolean deleteData(String TableName, String PrimaryKeyColumn, int id) {
        return false;  //to be modified
    }

}
