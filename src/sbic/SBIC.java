/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Yoftahe
 */
public class SBIC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException, ParseException {
        // TODO code application logic here

        if (DBConnection.connect()) {
            ProgramWindow.startWindow();
            Session.logUserIn(User.find(1));
        } else {
            
            JFrame DBConfigWindow = new JFrame("Database Configuration Window");
            if (JOptionPane.showConfirmDialog(DBConfigWindow, "There seems to be a problem connecting to the database. Would you like to modify your database connection configuration?", "Database Connection Error", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

            s
                
                DBConnectionConfiguration dbcc = new DBConnectionConfiguration();

                DBConfigWindow.add(dbcc);
                DBConfigWindow.setSize(400, 400);
                DBConfigWindow.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(DBConfigWindow, "System is going to exit!!!", "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

}
