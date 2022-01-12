/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JPanel;

/**
 *
 * @author Mebrea
 */
public class Session {

    private static boolean loggedIn;
    private static User loggedInUser;

    static void logUserOut() throws SQLException, IOException {

        loggedIn = false;
        loggedInUser = null;
        ProgramWindow.restartWindow();
    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        Session.loggedIn = loggedIn;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        Session.loggedInUser = loggedInUser;
    }

    static void logUserIn(User user) throws SQLException, IOException {

        loggedIn = true;
        loggedInUser = user;
        ProgramWindow.loginWindow.setVisible(false);
        ProgramWindow.loginWindow.dispose();
        ProgramWindow.loginWindow = null;

        ProgramWindow.startWindow();
    }

}
