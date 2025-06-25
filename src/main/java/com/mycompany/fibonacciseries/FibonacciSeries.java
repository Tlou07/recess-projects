/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fibonacciseries;

/**
 *
 * @author Matuma
 */
import java.util.Scanner;
public class FibonacciSeries {

    public static void main(String[] args) {
    Scanner Easy =new Scanner(System.in);
    System.out.print("enter the number of terms in the series");
    int terms=Easy.nextInt();
  int T=terms;
  int firstTerm=0;
  int secondTerm=1;
  for(int i=0; i<T; i++){
    System.out.print(firstTerm+ " , ");    
  int nextTerm=firstTerm + secondTerm;
  firstTerm=secondTerm;
  secondTerm=nextTerm;
  
  }
           } 
   
   
   }
    

