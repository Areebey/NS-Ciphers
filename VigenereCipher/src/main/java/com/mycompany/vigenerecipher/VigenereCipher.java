/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vigenerecipher;

/**
 *
 * @author Areeb Rafiq
 */
import java.util.Scanner;

public class VigenereCipher {
	public static void main(String[] args) {

	         System.out.println("Vigenere Cipher Encryptor \n");
		Scanner in = new Scanner(System.in);
		//Allow the user to choose 1 for encrypt or 2 for  decrypt a message
		System.out.println("- Press 1 to encrypt a message / Press 2 to decrypt a message - ");
		int input = in.nextInt();
		if (input == 1) {
			System.out.print("Enter the key in UPPER Case: ");
			String key = in.next();
			System.out.print("Enter the message that would like to be encrypted          by Vigenere cipher: ");
			String EMessage = in.next();

			String encryptMessage = encrypt(EMessage, key);
			System.out.println("The encrypted message is: " + encryptMessage);
		}
		else if (input == 2) {
			System.out.print("Enter the key in UPPER Case: ");
			String key = in.next();
			System.out.print("Enter the message that would like to be decrypted by Vigenere cipher: ");
			String DMessage = in.next();
			String decryptMessage = decrypt(DMessage, key);
			System.out.println("The decrypted message is: " + decryptMessage);
		}
		else {
			System.out.println("Wrong Input!");
		}
		in.close();
	}
           // For Encryption
	public static String encrypt(String Message, String Key) {
		String EMessage = "";
		Message = Message.toUpperCase();
		for (int i = 0, j = 0; i < Message.length(); i++) {
			char letter = Message.charAt(i);
			EMessage += (char)(((letter - 65) + (Key.charAt(j)-65)) % 26 + 65);
			j = ++j % Key.length();
		}
		return EMessage;
	}
           // For Decryption
	public static String decrypt(String Message, String Key) {
		String DMessage = "";
		Message = Message.toUpperCase();
		for (int i = 0, j = 0; i < Message.length(); i++) {
			char letter = Message.charAt(i);
			DMessage += (char)((letter - Key.charAt(j) + 26) % 26 + 65);
			j = ++j % Key.length();
		}
		return DMessage;
	}
}
