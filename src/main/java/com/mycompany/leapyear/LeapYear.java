/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.leapyear;

/**
 *
 * @author Matuma
 */
import java.util.Scanner;
public class LeapYear {

    public static void main(String[] args) {
       Scanner Tshego= new Scanner(System.in);
     System.out.print("enter the year");
     int year=Tshego.nextInt();
     
     if(LeapYearChecker(year)){ 
     System.out.print(year + " is a leap year ");
    }else{  
     System.out.print(year + " is not a leap year ");
     }
     
    }
    public static boolean LeapYearChecker(int year){
     if(year % 400==0){
     return true;
     }else if(year % 100==0){
     return false;
     }else if(year % 4 ==0){
     return true;
     }else{  
     return false;
     }
    }
}
 