/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.traveloffice.model;

/**
 *
 * @author altkom
 */
public class Date {
    
    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public Date(java.util.Date date) {
        day = date.getDate();
        month = date.getMonth() + 1;
        year = date.getYear() + 1900;
    }
    
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public static void main(String[] args) {
        Date d  = new Date(1, 2, 3);
        System.out.println(d);
    }

    @Override
    public String toString() {
        return "Date{" + "day=" + day + ", month=" + month + ", year=" + year + '}';
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
    
    
    
}
