/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.onetimepad;
// Java program Implementing One Time Pad Algorithm
 
import java.util.Scanner;
/**
 *
 * @author Areeb Rafiq
 */
public class OneTimePad {
    
    // For Encryption
    public static String stringEncryption(String text,String key)
    {
        String cipherText = "";
 
        int cipher[] = new int[key.length()];
 
        for (int i = 0; i < key.length(); i++) {
            cipher[i] = text.charAt(i) - 'A'
                        + key.charAt(i) - 'A';
        }
        
        for (int i = 0; i < key.length(); i++) {
            if (cipher[i] > 25) {
                cipher[i] = cipher[i] - 26;
            }
        }
 
        for (int i = 0; i < key.length(); i++) {
            int x = cipher[i] + 'A';
            cipherText += (char)x;
        }
 
        // Returning the cipherText
        return cipherText;
    }
 
    // For Decryption
    public static String stringDecryption(String s,String key)
    {
        String plainText = "";
 
        int plain[] = new int[key.length()];
 
        for (int i = 0; i < key.length(); i++) {
            plain[i]
                = s.charAt(i) - 'A'
                  - (key.charAt(i) - 'A');
        }

        for (int i = 0; i < key.length(); i++) {
            if (plain[i] < 0) {
                plain[i] = plain[i] + 26;
            }
        }
 
        for (int i = 0; i < key.length(); i++) {
            int x = plain[i] + 'A';
            plainText += (char)x;
        }
 
        // Returning the plainText
        return plainText;
    }
 
    // Main Func
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        
        // Input PlainText 
        System.out.println("Enter the Plain text");
        String plainText = sc.nextLine();
 
        // Input message key with the same length
        System.out.println("Enter the Key ");
        String key = sc.nextLine();
 
        //Convert PlainText into Ciphertext
        String encryptedText = stringEncryption(plainText.toUpperCase(), 
                key.toUpperCase());
        
        //Convert Encrypted Text into PlainText (Decryption)
        String decryptedText=stringDecryption(encryptedText,
                               key.toUpperCase());
        
        System.out.println(" ");
        
        System.out.println("Encrypted CipherText -: " + encryptedText);
 
        System.out.println("Decrypted Message -: "+ decryptedText);
    }
}
