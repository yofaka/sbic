/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Yoftahe
 */
public class ProgramWindow {

    static JFrame main;

    void startWindow() {

    }

    static void loadMainWindow() {

        main = new JFrame("Small Business Management Software");
        main.setSize(1000, 1000);
        main.setVisible(true);

    }

    
     static void loadLoginWindow() {

         
         
         
         
        main = new JFrame("Login - Small Business Management Software");
        main.setSize(600, 600);
        main.setVisible(true);
        
        main.setLayout(new BorderLayout());
        
//        main.add()

    }
}
