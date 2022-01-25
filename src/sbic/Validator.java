/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import javax.swing.JSpinner;
import javax.swing.JTextField;


public class Validator {

    static boolean isNumber(JTextField textField) {
        return true;

    }

    static boolean isNumberGreaterThan(JSpinner spinnerField, double Minimum) {

        System.out.println(spinnerField.getValue() + " Vs " + Minimum);

        if (Double.valueOf(spinnerField.getValue().toString()) > Minimum) {

            return true;
        } else {
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

        if (textField.getText().length() == 13 && textField.getText().charAt(0) == '+') {
            return true;
        } else {
            return false;
        }

    }

    static boolean isProperTINNumber(JTextField textField) {

        if (textField.getText().toString().length() == 10 && textField.getText().toString().matches("[0-9]*{10}")) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isProperName(JTextField textField) {

        if (textField.getText().toString().length() <= 30) {

            return true;
        } else {

            return false;
        }
    }
    
    static boolean isProperUserName(JTextField textField) {

        if (textField.getText().toString().length() <= 25) {

            return true;
        } else {

            return false;
        }
    }

    static boolean properDocumentNumber(JTextField textField) {

        if (textField.getText().toString().length() <= 10) {

            return true;
        } else {

            return false;
        }
    }

    static boolean isProperPassword(JTextField textField) {

        return true;
    }

    static boolean isUserName(JTextField textField) {

        return true;
    }

}
