package com.marketlogic.sample.encoding;

import java.util.Scanner;

/**
 * This class is encoding and printing the test as per provided offset value
 * 
 * @author Sachin Garg
 *
 */
public class Encoding {

	/**
	 * Main Method to call encode method for validation of input key and apply logic
	 * on provided text value
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int offset; // The "key" for the encoding, a number from 1 to 25.
		String plainText; // The original string that is to be encoded.
		String cipherText; // The coded version of the string.
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.print("Enter the key, a number from 1 to 25(negative number allowed in this range) ");
		offset = sc.nextInt();
		if (offset > 25) {
			System.out.println("Enter the key range in between 1 to 25(negative number allowed in this range) ");
		} else {
			System.out.println();
			System.out.println("Enter your plaintext: ");
			System.out.print("? ");
			plainText = sc.next();
			plainText = plainText.toLowerCase(); // convert to lower case

			cipherText = encode(offset, plainText);
			System.out.println();
			System.out.println("Text in lower case: " + plainText);
			System.out.println("Encoded text:       " + cipherText);
			plainText = ""; // to be reconstructed from cipher Text
		}
	}

	/**
	 * Encodes String with another letters by applying an offset to move the
	 * letter forward and backward in the alphabet. 
	 * 
	 * If the new position is past the end of the
	 * alphabet, it wraps around to the beginning.
	 * 
	 * if offset is negative then subtract from highest value and 
	 * move backward in alphabets
	 * 
	 * @param original
	 *            Original String that is to be encoded. This must be a lower case
	 *        
	 * @param offset
	 *            an integer in the range 0 to 25 (inclusive). each character of original String is "moved"
	 *            forward this many spaces in the alphabet.
	 * @return the encoded String
	 */
	public static String encode(int offset, String original) {
		int i;
		String cipherText = "";
		for (i = 0; i < original.length(); i++) {
			char plainChar, encodedChar;
			int chCode;
			plainChar = original.charAt(i);
			if (plainChar < 'a' || plainChar > 'z')
				cipherText += plainChar; // it's not a letter; don't encode it.
			else {
				chCode = (int) plainChar - (int) 'a'; // convert character to a number from 0 to 25
				chCode += offset; // add the offset to the character code
				if (chCode >= 26) { // wrap around to the beginning of the alphabet
					chCode = chCode - 26;
				}
				if (chCode < 0) {
					chCode = 26 + chCode; //if offset is negative then subtract from largest value
				}
				encodedChar = (char) (chCode + (int) 'a'); // convert back to a letter

				cipherText += encodedChar; //add it in String
			}
		}

		return cipherText;
	}

}
