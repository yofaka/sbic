/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Yoftahe
 */
public class ProgramWindow {

    static JFrame mainWindow;

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

    void startWindow() {

    }

    static void loadMainWindow() {

        mainWindow = new JFrame("Small Business Management Software");
        mainWindow.setSize(1000, 1000);
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

        
        loginPasswordLabel= new JLabel("Password");
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

        loginFooter = new JPanel();

        loginWindow = new JFrame("Login - Small Business Management Software");
        loginWindow.setSize(600, 600);
        loginWindow.setLayout(new BorderLayout());
        loginWindow.add(loginHeader, BorderLayout.NORTH);
        loginWindow.add(loginForm, BorderLayout.CENTER);
        loginWindow.add(loginFooter, BorderLayout.SOUTH);
        
        loginWindow.setVisible(true);

//        main.add()
    }
}
