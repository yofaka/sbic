/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import javax.swing.JPanel;

/**
 *
 * @author Mebrea
 */
public class Session {
   
    private static boolean loggedIn;
    private static User loggedInUser;
    
    
    static void logUserOut(){
    
        loggedIn = false;
        loggedInUser = null;
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
    
    static void logUserIn(User user){
    
        loggedIn = true;
        loggedInUser = user;
    }

}

    

