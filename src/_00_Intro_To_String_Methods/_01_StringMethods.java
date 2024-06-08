package _00_Intro_To_String_Methods;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1;
		}
		return s2;
	}

	// If String s contains the word "underscores", change all of the spaces
	// to underscores
	public static String formatSpaces(String s) {
		if (s.contains("underscores")) {
			s = s.replace(" ", "_");
		}
		return s;
	}

	// Return the name of the person whose LAST name would appear first if they
	// were in alphabetical order.
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		s1 = s1.trim();
		s2 = s2.trim();
		s3 = s3.trim();

		String e1 = s1.substring(s1.length()-2);
		String e2 = s2.substring(s2.length()-2);
		String e3 = s3.substring(s3.length()-2);



		if (e1.compareTo(e2) < 0) {
			if (e1.compareTo(e3) < 0) {
				return s1;
			} else if (e3.compareTo(e2) < 0){
				return s3;
			}
		} else {
			if (e2.compareTo(e3) < 0) {
				return s2;
			} else if (e3.compareTo(e1) < 0){
				return s3;
			}
		}
		return s1;




	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {

		int sum = 0;

		for (int i = 0; i < s.length(); i++) {
			for (int e = 1; e<10; e++) {
				if (Character.getNumericValue(s.charAt(i)) == e) {
					sum = sum + e;
				}
			}

		}

		return sum;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int total = 0;
for (int i = 0; i < s.length() - substring.length() + 1; i++) {
	String sub = s.substring(i, i+substring.length());
	if (sub.equals(substring)) {
		total++;
	}
}

		return total;
	}

	// Call Utilities.encrypt at the bottom of this file to encrypt String s
	public static String encrypt(String s, char key) {
		byte[] bytes = s.getBytes();
		
		
		String yippee = Utilities.encrypt(bytes, (byte)key);
		
		return yippee;
	}

	// Call Utilities.decrypt at the bottom of this file to decrypt the
	// cyphertext (encrypted text)
	public static String decrypt(String s, char key) {
		String yippee = Utilities.decrypt(s, (byte)key);
		
		return yippee;
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		String[] words = s.split(" ");
		int sum = 0;
		
		for (String i : words) {
			if (i.length() > substring.length()) {
			String sub = i.substring(i.length() - substring.length());
			
			if (sub.equals(substring)) {
				sum++;
			}
			}
		}
		
		return sum;
	}

	// Given String s, return the number of characters between the first
	// occurrence of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		
		
		return 0;
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		boolean pal = true;
		
		for (int i = 0; i  < s.length(); i++) {
			if (s.charAt(i) == s.charAt((s.length() - (i + 1)))) {
				pal = true;
			} else {
				pal = false;
			}
		}
		
		return pal;
	}
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a
	// single byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
