/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Yoftahe
 */
public class SBIC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        // TODO code application logic here

        DBConnection.connect();
        ProgramWindow.startWindow();
        Session.logUserIn(new User("Admin", "", "Admin", true));

    }

}
