/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;


public class DateFieldHelper {


    static Date strToDate(String dateStr, String dateFormatPattern) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatPattern);
        Date date = simpleDateFormat.parse(dateStr);
        return date;
    }

}
