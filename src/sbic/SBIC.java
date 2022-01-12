/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.sql.JDBCType.NULL;
import java.sql.SQLException;
import java.util.ArrayList;

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
        Session.logUserIn(new User());

        ProgramWindow.startWindow();
    }

}
