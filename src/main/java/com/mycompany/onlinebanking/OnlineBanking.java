/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.onlinebanking;

/**
 *
 * @author Matuma
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class OnlineBanking {
  private static BankAccount account=new BankAccount();
private static JFrame frame;  
    
    public static void main(String[] args) {
       showLoginScreen();
    }
    
    private static void showLoginScreen(){
    
    frame=new JFrame("online banking login");  
    frame.setSize(300, 180);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
       JPanel panel=new JPanel();
       frame.add(panel);
       placeLoginComponents(panel);
       
       frame.setVisible(true);
    
}
   private static void placeLoginComponents(JPanel panel){
   panel.setLayout(null);
   JLabel userLabel =new JLabel("username");
   userLabel.setBounds(20, 20, 80 , 25 );
   panel.add(userLabel);
   
   JTextField userText= new JTextField(20);
   userText.setBounds(100 ,20 ,160, 25);
   panel.add(userText);
   
   JPasswordField passwordText =new JPasswordField(20);
   passwordText.setBounds(100, 50, 160, 25);
   panel.add(passwordText);
   
   JButton loginButton=new JButton("login");
   loginButton.setBounds(100, 90, 80, 25);
   panel.add(loginButton);
   loginButton.addActionListener(e->{
   String user=userText.getText();
   String pass= String.valueOf(passwordText.getPassword());
   if(user.equals("user")&& pass.equals("pass")){
   frame.dispose();
   showBankingDashboard();
   }else{  
   JOptionPane.showMessageDialog(frame,"invalid login" ,"Error" ,JOptionPane.ERROR_MESSAGE);
   
   }
   });  
           
   }
   private static void showBankingDashboard (){   
       frame= new JFrame("online Banking - dashboard");
       frame.setSize(500, 400);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLocationRelativeTo(null);
       JPanel panel=new JPanel();
       panel.setLayout(null);
       
       JLabel balanceLabel=new JLabel("Balance: $0.00");
       balanceLabel.setFont(new Font("Arial",Font.BOLD, 16));
       balanceLabel.setBounds(120,20,200,25);
       panel.add(balanceLabel);
       
       JButton depositButton=new JButton("Deposit");
       depositButton.setBounds(50, 70, 120, 30);
       panel.add(depositButton);
       
       JButton withdrawButton=new JButton("Withdraw");
       withdrawButton.setBounds(200, 70, 120, 30);
       panel.add(withdrawButton);
        
       JButton logoutButton=new JButton("Logout");
       logoutButton.setBounds(125, 120, 120, 30);
       panel.add(logoutButton);
       
       depositButton.addActionListener(e->{
       String input= JOptionPane.showInputDialog(frame, "Enter deposit money:");
       try{
       double amount=Double.parseDouble(input);
           account.deposit(amount);
           balanceLabel.setText("Balance:$" +String.format("%.2f", account.getBalance()));  
       }catch(Exception ex){
       JOptionPane.showMessageDialog(frame,"invalid input.");
       }   
       });
       withdrawButton.addActionListener(e->{
       String input=JOptionPane.showInputDialog(frame,"enter withdrawal amount:");
       try{
           double amount=Double.parseDouble(input);
           if(account.withdraw(amount)){
           balanceLabel.setText("Balance: $ " +String.format("%.2f", account.getBalance()));
           }else{
           JOptionPane.showMessageDialog(frame,"Insufficient funds.");
           }
       }catch(Exception ex){
           JOptionPane.showMessageDialog(frame,"Invalid input.");   
       }
       });
       logoutButton.addActionListener(e->{
       frame.dispose();
       showLoginScreen();
       });
  frame.add(panel);
  frame.setVisible(true);
   }}


class BankAccount{
private double balance =0; 

public void deposit(double amount){
 if(amount>0) balance+=amount; 
}
public boolean withdraw(double amount ){
if(amount>0 && balance>=amount ){   
balance-=amount;
return true;
}
return false;
}
public double getBalance(){
return balance;

}


}
