/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

/**
 *
 * @author Yoftahe
 */
public class SBIC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        User x = new User();
        
        x.setUserName("haile");
        x.setPassword("lkjaVKJBSFKVBFBVBF");
        x.setRole("Store");
        
        x.save();

        
        User y = User.find(1);
        
        y.setPassword("kkkkkkk");
        
        y.save();
        
       
        
    }
    
}