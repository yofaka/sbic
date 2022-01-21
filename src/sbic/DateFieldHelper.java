/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbic;

import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author Yoftahe
 */
public class DateFieldHelper {

    String dd, mm, yyyy;
    int day, month, year;
    JComboBox dayField, monthField, yearField;

    DateFieldHelper(JComboBox dayField, JComboBox monthField, JComboBox yearField) {

        this.dayField = dayField;
        this.monthField = monthField;
        this.yearField = yearField;

    }

    void setDate(String dd, String mm, String yyyy) {

        this.dd = dd;
        this.day = Integer.valueOf(dd);

        this.mm = mm;
        this.month = Integer.valueOf(mm);

        this.yyyy = yyyy;
        this.year = Integer.valueOf(yyyy);

        this.dayField.setSelectedItem(dd);
        this.dayField.setSelectedItem(mm);
        this.dayField.setSelectedItem(yyyy);

    }

    void setDate(int day, int month, int year) {

        this.day = day;

        if (day <= 9) {
            dd = "0" + day;
        } else {
            dd = String.valueOf(day);
        }

        this.month = month;

        if (month <= 9) {
            mm = "0" + month;
        } else {
            mm = String.valueOf(month);
        }

        this.year = year;

        yyyy = String.valueOf(year);

        this.dayField.setSelectedItem(dd);
        this.dayField.setSelectedItem(mm);
        this.dayField.setSelectedItem(yyyy);

    }

    void setDate(Date date) {

        this.day = date.getDay();

        if (day <= 9) {
            dd = "0" + day;
        } else {
            dd = String.valueOf(day);
        }

        this.month = date.getMonth();

        if (month <= 9) {
            mm = "0" + month;
        } else {
            mm = String.valueOf(month);
        }

        this.year = date.getYear();

        yyyy = String.valueOf(year);

        this.dayField.setSelectedItem(dd);
        this.dayField.setSelectedItem(mm);
        this.dayField.setSelectedItem(yyyy);

    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public String getYyyy() {
        return yyyy;
    }

    public void setYyyy(String yyyy) {
        this.yyyy = yyyy;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    Date getDateObj() {
        return new Date(day, month, year);

    }

}
