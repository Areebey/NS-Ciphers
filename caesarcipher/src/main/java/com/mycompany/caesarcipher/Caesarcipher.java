/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.caesarcipher;

/**
 *
 * @author Areeb Rafiq
 */
import java.util.Scanner;   
public class Caesarcipher {
    
    public static final String alpha = "abcdefghijklmnopqrstuvwxyz";   
      
    public static String encryptData(String inputStr, int shiftKey)   
    {    
        inputStr = inputStr.toLowerCase();   
         
        String encryptStr = "";   
          
        // Here we use for loop for traversing each character of the input string   
        for (int i = 0; i < inputStr.length(); i++)   
        {     
            int position = alpha.indexOf(inputStr.charAt(i));   
           
            int encryptPos = (shiftKey + position) % 26;   
            char encryptChar = alpha.charAt(encryptPos);   
             
            encryptStr += encryptChar;   
        }
        // return encrypted string   
        return encryptStr;   
    } 
    public static String decryptData(String inputStr, int shiftKey)   
    {   
        inputStr = inputStr.toLowerCase();   
          
        String decryptStr = "";   
          
        for (int i = 0; i < inputStr.length(); i++)   
        {   
            int position = alpha.indexOf(inputStr.charAt(i));   
              
            int decryptPos = (position - shiftKey) % 26;   
              
            if (decryptPos < 0){   
                decryptPos = alpha.length() + decryptPos;   
            }   


            char decryptChar = alpha.charAt(decryptPos);
            decryptStr += decryptChar;   
        }   


        // return decrypted string   
        return decryptStr;   
    }   


    // main() method 
    public static void main(String[] args)   
    {   
        Scanner sc = new Scanner(System.in);   
          
        // take input from the user   
        System.out.println("Enter a string for encryption using Caesar Cipher: ");   
        String inputStr = sc.nextLine();   
          
        System.out.println("Enter the value of plaintext message then it will gets shifted: ");   
        int shiftKey = Integer.valueOf(sc.nextLine());   
          
        System.out.println("Encrypted Data => "+encryptData(inputStr, shiftKey));   
        System.out.println("Decrypted Data => "+decryptData(encryptData(inputStr, shiftKey), shiftKey));   
          
    }   
}   


