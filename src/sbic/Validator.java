/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Yoftahe
 */
public class Validator {

    static boolean isNumber(JTextField textField) {
        return true;

    }

    static boolean isNumberGreaterThan(JSpinner spinnerField, double Minimum) {

        if((double)spinnerField.getValue() > Minimum){
        return true;
        }else{
        return false;
        }
    }

    static boolean isNumberLessThan(JTextField textField, int Maximum) {
        return true;

    }

    static boolean isNumberLessThan(JTextField textField, double Maximum) {
        return true;

    }

    static boolean isNumberLessThan(JSpinner spinnerField, int Maximum) {
        return true;

    }

    static boolean isNumberLessThan(JSpinner spinnerField, double Maximum) {
        return true;

    }

    static boolean isNumberBetween(JTextField textField, int Minimum, int Maximum) {
        return true;

    }

    static boolean isNumberBetween(JTextField textField, double Minimum, double Maximum) {
        return true;

    }

    static boolean isNumberBetween(JSpinner spinnerField, int Minimum, int Maximum) {
        return true;

    }

    static boolean isNumberBetween(JSpinner spinnerField, double Minimum, double Maximum) {
        return true;

    }

    static boolean isProperTelephoneNumber(JTextField textField) {

        
        return true;
    }

    static boolean isProperTINNumber(JTextField textField) {

        if(textField.getText().toString().length() > 10)
        return false;
        else
        return true;
    }
    
    
    static boolean isProperPassword(JTextField textField){
    
    return true;
    }
    
  static boolean isUserName(JTextField textField){
    
    return true;
    }
    
 
}
