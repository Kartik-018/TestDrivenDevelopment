package org.example;

public class LeapYear {
    public static boolean isLeapYear(int year){
        if(year%400==0)return true;
        else return false;
    }
}
