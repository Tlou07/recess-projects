/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.heart;

/**
 *
 * @author Matuma
 */
public class Heart {

    public static void main(String[] args) {
        int size =7;
        for (int i = size / 2 ;i< size;i += 2 ){ 
       for (int j = 1; j < size - i; j += 2){ 
       System.out.print(" ");
       }
       for (int j = 1; j< i + 1 ;j++){
       System.out.print("*");
       }
       for (int j = 1; j < size - i + 1; j+=2){
       System.out.print(" ");
       }
       for (int j = 1; j < i + 1;j++){
       System.out.print("*");
       }
       System.out.println();
        }
        for (int i = size; i > 0; i--){
        for (int j = 0; j < size - i; j++){
        System.out.print(" ");
        }
        for (int j = 0; j < 2 * i - 1;j++){
        System.out.print("*"); 
        }
        System.out.println();
        }
    }

}
    
               
     
       

