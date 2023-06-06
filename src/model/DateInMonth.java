/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jiang
 */
public class DateInMonth {
    private int dateInMonth;
    private int month;

    public int getDateInMonth() {
        return dateInMonth;
    }

    public void setDateInMonth(int dateInMonth) {
        this.dateInMonth = dateInMonth;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
    
    public boolean isLeap(int year)
    {
        boolean isLeap;
        if(year % 4 == 0) {
            if( year % 100 == 0) {
                isLeap = year % 400 == 0;
            }
            else
                isLeap = true;
        }
        else {
            isLeap = false;
        }
        return isLeap;
    }
    public int countDateInMonth(int month, int year){
        switch (month) {
            case 2 -> {
                if(isLeap(year)) return 29;
                else return 28;
            }
            case 1, 3, 5, 7, 8, 10, 12 -> {return 31;}
            case 4, 6, 9, 11 -> {return 30;}
            default -> {return 31;}
        }
    }
}