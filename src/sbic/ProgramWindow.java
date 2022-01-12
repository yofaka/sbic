/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Yoftahe
 */
public class ProgramWindow {

    final static String THEME_CONFIG_FILE_NAME = "config/themeconfig";
    final static String DEFAULT_PRIMARY_COLOR = "White";
    final static String DEFAULT_SECONDARY_COLOR = "White";

    static Color primaryColor;
    static Color secondaryColor;

    static JPanel itemsPanel;
    static JPanel itemCategoriesPanel;
    static JPanel themeSetting;

    static boolean mainWindowStarted;
    static JFrame mainWindow;

    static JPanel headerPanel;
    static JPanel centerPanel;
    static JPanel footerPanel;

    static JTabbedPane mainTab;

    static JFrame loginWindow;

    static JPanel loginHeader;
    static JPanel loginForm;
    static JPanel loginFooter;

    static JLabel loginHeaderLabel;
    static JLabel loginUserNameLabel;
    static JLabel loginPasswordLabel;
    static JTextField loginUserNameField;
    static JTextField loginPasswordField;
    static JButton loginButton;
    static JButton aboutDevelopersButton;

    static void startWindow() throws SQLException, IOException {

        ProgramWindow.loadThemeConfig();

        if (Session.isLoggedIn()) {
            loadMainWindow();
        } else {
            loadLoginWindow();
        }
    }

    static void restartWindow() throws SQLException, IOException {

        mainWindow.setVisible(false);
        startWindow();
    }

    static void loadThemeConfig() throws FileNotFoundException, IOException {

        File themeConfigFile = new File(THEME_CONFIG_FILE_NAME);

        if (themeConfigFile.exists()) {

            FileReader themeConfigFileReader = new FileReader(THEME_CONFIG_FILE_NAME);
            BufferedReader themeConfigFileBufferedReader = new BufferedReader(themeConfigFileReader);

            primaryColor = stringToColor(themeConfigFileBufferedReader.readLine());
            secondaryColor = stringToColor(themeConfigFileBufferedReader.readLine());

        } else {

            themeConfigFile.createNewFile();
            setThemeConfig(DEFAULT_PRIMARY_COLOR, DEFAULT_SECONDARY_COLOR);

        }

    }

    static void setThemeConfig(String primaryColor, String secondaryColor) throws IOException {

        FileWriter themeConfigFileWriter = new FileWriter(THEME_CONFIG_FILE_NAME);
        PrintWriter themeConfigFilePrintWriter = new PrintWriter(themeConfigFileWriter);

        themeConfigFilePrintWriter.println(primaryColor);
        themeConfigFilePrintWriter.println(secondaryColor);

        themeConfigFilePrintWriter.flush();
        themeConfigFilePrintWriter.close();
        themeConfigFileWriter.close();

    }

    static void loadMainWindow() throws SQLException, IOException {

        headerPanel = new JPanel();

        themeSetting = new ThemeSetting();

        itemCategoriesPanel = new ItemCategories();

        mainTab = new JTabbedPane();
        mainTab.setBackground(primaryColor);
        mainTab.setForeground(secondaryColor);
        mainTab.addTab("Home", new JPanel());
        mainTab.addTab("Item Categories", itemCategoriesPanel);
        mainTab.addTab("Items", new JPanel());
        mainTab.addTab("GRN", new JPanel());
        mainTab.addTab("Sales", new JPanel());
        mainTab.addTab("Disposal", new JPanel());
        mainTab.addTab("Master Table", new JPanel());
        mainTab.addTab("Users", new JPanel());
        mainTab.addTab("Settings", themeSetting);

        centerPanel = new JPanel();
        //centerPanel.add(mainTab);

        footerPanel = new JPanel();

        mainWindow = new JFrame("Small Business Management Software");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1000, 1000);
        mainWindow.setLayout(new BorderLayout());
        mainWindow.add(headerPanel, BorderLayout.NORTH);
        mainWindow.add(mainTab, BorderLayout.CENTER);
        mainWindow.add(footerPanel, BorderLayout.SOUTH);
        mainWindow.setVisible(true);

    }

    static void loadLoginWindow() {

        loginHeaderLabel = new JLabel("Login To Access The System");

        loginHeader = new JPanel();
        loginHeader.add(loginHeaderLabel);

        loginUserNameLabel = new JLabel("User Name");
        loginUserNameLabel.setBounds(125, 20, 250, 20);

        loginUserNameField = new JTextField();
        loginUserNameField.setColumns(10);
        loginUserNameField.setBounds(125, 40, 250, 30);

        loginPasswordLabel = new JLabel("Password");
        loginPasswordLabel.setBounds(125, 80, 250, 20);

        loginPasswordField = new JTextField();
        loginPasswordField.setColumns(10);
        loginPasswordField.setBounds(125, 100, 250, 30);

        loginButton = new JButton("Login");
        loginButton.setBounds(200, 150, 100, 30);

        loginForm = new JPanel();
        loginForm.setLayout(null);

        loginForm.add(loginUserNameLabel);

        loginForm.add(loginUserNameField);
        loginForm.add(loginPasswordLabel);
        loginForm.add(loginPasswordField);
        loginForm.add(loginButton);

        aboutDevelopersButton = new JButton("About Developers");

        loginFooter = new JPanel();
        loginFooter.add(aboutDevelopersButton);

        loginWindow = new JFrame("Login - Small Business Management Software");
        loginWindow.setSize(500, 500);
        loginWindow.setLayout(new BorderLayout());
        loginWindow.add(loginHeader, BorderLayout.NORTH);
        loginWindow.add(loginForm, BorderLayout.CENTER);
        loginWindow.add(loginFooter, BorderLayout.SOUTH);

        loginWindow.setVisible(true);

//        main.add()
    }

    static Color stringToColor(String colorName) {

        switch (colorName) {

            case "White":
                return Color.WHITE;
            case "Black":
                return Color.BLACK;
            case "Green":
                return Color.GREEN;
            case "Red":
                return Color.RED;
            case "Yellow":
                return Color.YELLOW;
            case "Blue":
                return Color.BLUE;
            case "Orange":
                return Color.ORANGE;
            case "Pink":
                return Color.PINK;
            case "Gray":
                return Color.GRAY;
            default:
                return Color.WHITE;

        }

    }

    static String colorToString(Color color) {

        if (color == Color.WHITE) {
            return "White";
        } else if (color == Color.BLACK) {
            return "Black";
        }else if (color == Color.GREEN) {
            return "Green";
        }else if (color == Color.RED) {
            return "Red";
        }else if (color == Color.YELLOW) {
            return "Yellow";
        }else if (color == Color.BLUE) {
            return "Blue";
        }else if (color == Color.ORANGE) {
            return "Orange";
        }else if (color == Color.PINK) {
            return "Pink";
        }else if (color == Color.GRAY) {
            return "Gray";
        }else{
        return "White";
        }

    }

}