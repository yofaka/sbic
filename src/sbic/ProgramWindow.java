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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    static JLabel userInfo;
    static JButton logoutButton;

    static JPanel grnsPanel;
    static JPanel itemsPanel;
    static JPanel itemCategoriesPanel;
    static JPanel themeSetting;
    static JPanel databaseSetting;

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
    static JButton aboutButton;

    static void startWindow() throws SQLException, IOException, ParseException {

        ProgramWindow.loadThemeConfig();

        if (Session.isLoggedIn()) {
            loadMainWindow();
        } else {
            loadLoginWindow();
        }
    }

    static void destroyWindow() {

        mainWindow.setVisible(false);
        mainWindow.dispose();
        mainWindow = null;

    }

    static void restartWindow() throws SQLException, IOException, ParseException {

        destroyWindow();
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

    static void loadMainWindow() throws SQLException, IOException, ParseException {

        userInfo = new JLabel(Session.getLoggedInUser().getUserName() + " (" + Session.getLoggedInUser().getRole() + ")");
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Session.logUserOut();
                } catch (SQLException ex) {
                    Logger.getLogger(ProgramWindow.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ProgramWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        headerPanel.add(userInfo);
        headerPanel.add(logoutButton);

        themeSetting = new ThemeSetting();

        databaseSetting = new DBConnectionConfiguration();

        itemCategoriesPanel = new ItemCategories();

        itemsPanel = new Items();

        grnsPanel = new GRNs();
        
        mainTab = new JTabbedPane();
        mainTab.setBackground(primaryColor);
        mainTab.setForeground(secondaryColor);
        mainTab.addTab("Home", new JPanel());
        mainTab.addTab("Item Categories", itemCategoriesPanel);
        mainTab.addTab("Items", itemsPanel);
        mainTab.addTab("GRN", grnsPanel);
        mainTab.addTab("Sales", new JPanel());
        mainTab.addTab("Disposal", new JPanel());
        mainTab.addTab("Master Table", new JPanel());
        mainTab.addTab("Users", new JPanel());
        mainTab.addTab("Theme Settings", themeSetting);
        mainTab.addTab("Database Settings", databaseSetting);

        centerPanel = new JPanel();
        //centerPanel.add(mainTab);

        aboutButton = new JButton("About The Project & Developers");
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutDevelopers aboutDevelopers = new AboutDevelopers();
                aboutDevelopers.setVisible(true);
            }
        });
        footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        footerPanel.add(aboutButton);

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
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (loginUserNameField.getText().equals("")) {

                    JOptionPane.showMessageDialog(loginWindow, "Enter User Name", "Login", JOptionPane.ERROR_MESSAGE);

                } else if (loginPasswordField.getText().equals("")) {

                    JOptionPane.showMessageDialog(loginWindow, "Enter Password", "Login", JOptionPane.ERROR_MESSAGE);

                } else {

                    try {

                        int loginResult = User.validCredentials(loginUserNameField.getText(), loginPasswordField.getText());

                        if (loginResult > 0) {

                            Session.logUserIn(User.find(loginResult));

                        } else {

                            JOptionPane.showMessageDialog(loginWindow, "Wrong User Name or Password!", "Login", JOptionPane.ERROR_MESSAGE);

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ProgramWindow.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ProgramWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        });

        loginForm = new JPanel();
        loginForm.setLayout(null);

        loginForm.add(loginUserNameLabel);

        loginForm.add(loginUserNameField);
        loginForm.add(loginPasswordLabel);
        loginForm.add(loginPasswordField);
        loginForm.add(loginButton);

        aboutButton = new JButton("About The Project & Developers");
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutDevelopers aboutDevelopers = new AboutDevelopers();
                aboutDevelopers.setVisible(true);
            }
        });

        loginFooter = new JPanel();
        loginFooter.add(aboutButton);

        loginWindow = new JFrame("Login - Small Business Management Software");
        loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginWindow.setResizable(false);
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
        } else if (color == Color.GREEN) {
            return "Green";
        } else if (color == Color.RED) {
            return "Red";
        } else if (color == Color.YELLOW) {
            return "Yellow";
        } else if (color == Color.BLUE) {
            return "Blue";
        } else if (color == Color.ORANGE) {
            return "Orange";
        } else if (color == Color.PINK) {
            return "Pink";
        } else if (color == Color.GRAY) {
            return "Gray";
        } else {
            return "White";
        }

    }

}
