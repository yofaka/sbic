/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.io.*;

public class DBConnection {

    final static String DB_CONFIG_FILE_NAME = "config/dbconfig";
    final static String DEFAULT_SERVER_NAME = "localhost";
    final static String DEFAULT_PORT_NUMBER = "3306";
    final static String DEFAULT_DATABASE_NAME = "sbic";
    final static String DEFAULT_USER_NAME = "root";
    final static String DEFAULT_PASSWORD = "";

    private static Connection connection;
    private static String serverName;
    private static String portNumber;
    private static String databaseName;
    private static String userName;
    private static String password;

    static void loadDBConfig() throws FileNotFoundException, IOException {

        File DBConfigFile = new File(DB_CONFIG_FILE_NAME);

        if (DBConfigFile.exists()) {

            FileReader DBConfigFileReader = new FileReader(DB_CONFIG_FILE_NAME);
            BufferedReader DBConfigFileBufferedReader = new BufferedReader(DBConfigFileReader);
            DBConnection.serverName = DBConfigFileBufferedReader.readLine();
            DBConnection.portNumber = DBConfigFileBufferedReader.readLine();
            DBConnection.databaseName = DBConfigFileBufferedReader.readLine();
            DBConnection.userName = DBConfigFileBufferedReader.readLine();
            DBConnection.password = DBConfigFileBufferedReader.readLine();

        } else {

            DBConfigFile.createNewFile();
            setDBConfig(DEFAULT_SERVER_NAME, DEFAULT_PORT_NUMBER, DEFAULT_DATABASE_NAME, DEFAULT_USER_NAME, DEFAULT_PASSWORD);

        }
    }

    static void setDBConfig(String serverName, String portNumber, String databaseName, String userName, String password) throws IOException {

        FileWriter DBConfigFileWriter = new FileWriter(DB_CONFIG_FILE_NAME);
        PrintWriter DBConfigFilePrintWriter = new PrintWriter(DBConfigFileWriter);
        DBConfigFilePrintWriter.println(serverName);
        DBConfigFilePrintWriter.println(portNumber);
        DBConfigFilePrintWriter.println(databaseName);
        DBConfigFilePrintWriter.println(userName);
        DBConfigFilePrintWriter.println(password);

        DBConfigFilePrintWriter.flush();
        DBConfigFilePrintWriter.close();
        DBConfigFileWriter.close();

        loadDBConfig();
    }

    public static boolean connect() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

        loadDBConfig();

        
        String url = "jdbc:mysql://" + DBConnection.serverName + ":" + DBConnection.portNumber + "/" + DBConnection.databaseName;
        Connection connection = DriverManager.getConnection(url, DBConnection.userName, DBConnection.password);

        if (connection == null) {
            return false;
        } else {

            DBConnection.connection = connection;

            return true;

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

    public static int insert(String tableName, ArrayList values) throws SQLException {

        String insertQuery = "insert into " + tableName + " values (";  // start the quesry string 

        ListIterator valuesIterator = values.listIterator(); // create an iterator for the 

        while (valuesIterator.hasNext()) {

            Object value = valuesIterator.next();
            if (value == "null") {
                insertQuery = insertQuery + " NULL "; // list the values on the list with ''
            } else {
                insertQuery = insertQuery + " '" + value + "' "; // list the values on the list with ''
            }
            if (valuesIterator.nextIndex() < (values.size())) {

                insertQuery = insertQuery + ", "; // add a comma only if there is at least one next element
            }

        }

        insertQuery = insertQuery + ") ";

        System.out.println(insertQuery);

        Statement statement = connection.createStatement();

        return statement.executeUpdate(insertQuery);

    }

    public static int update(String tableName, ArrayList columns, ArrayList values, String whereClause) throws SQLException {

        String updateQuery = "update " + tableName + " set ";

        ListIterator columnsIterator = columns.listIterator();

        int index = 0;

        while (columnsIterator.hasNext()) {

            updateQuery = updateQuery + " " + columnsIterator.next() + " = '" + values.get(index) + "' "; // add column = value to string from the 2 array lists

            if (columnsIterator.nextIndex() < (values.size())) {

                updateQuery = updateQuery + ", "; // add a comma only if there is at least one next element
            }
            index++;
        }

        updateQuery = updateQuery + " where " + whereClause;
        
        System.out.println(updateQuery);

        Statement statement = connection.createStatement();

        return statement.executeUpdate(updateQuery);
    }

    public static int delete(String tableName, String whereClause) throws SQLException {

        String deleteQuery = "delete from " + tableName + " where " + whereClause;

        Statement statement = connection.createStatement();

        return statement.executeUpdate(deleteQuery);
    }

    static ResultSet select(String tableName, String columns, String whereClause) throws SQLException {

        String selectQuery = "";
        if (whereClause == "") {
            selectQuery = "select " + columns + " from " + tableName + " ";
        } else {
            selectQuery = "select " + columns + " from " + tableName + " where " + whereClause;
        }

        System.out.println(selectQuery);
        Statement statement = connection.createStatement();

        return statement.executeQuery(selectQuery);
    }

    /*
    public int insertData() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sbic","root","root");
        String insertData="INSERT INTO Item values(?,?,?,?,?,?,?,?)";
        Statement stmt=conn.createStatement();
        stmt.executeUpdate(insertData);
        System.out.println("Insert Complete.");
        
        
        
        }catch(ClassNotFoundException | SQLException exc){
        }
        
        return 0;  //to be modified 
    }
     
    public int update() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sbic", "root", "root");
        Statement stmt = conn.createStatement();
        String update = " UPDATE Item set values(?,?,?)";
        stmt.executeUpdate(update);
        return 0;
    }
     */
    public int delete() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sbic", "root", "root");
        Statement stmt = conn.createStatement();
        String delete = "DELETE FROM Item where value(?=?)";
        stmt.executeUpdate(delete);
        return 0;
    }
    /*
    ResultSet select(String TableName, String Columns, String WhereClause) {
        
        return new Object();
    
    } 


    boolean deleteData(String TableName, String PrimaryKeyColumn, int id) {
        return 0;  //to be modified
    }
     */
}
