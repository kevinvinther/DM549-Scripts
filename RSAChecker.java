/*
 * This document was written by William Bundgaard
 * 
 * This code helps use and check RSA - public key system 
 */

 //To get user input 
import java.util.Scanner;

public class RSAChecker {
	
	//For reading input
	private static Scanner input = new Scanner(System.in);
	
	//Stores the keys and modulo 
	private static int modulo; //modulo
	private static int privateKey; //private key
	private static int publicKey; //public key
	
	private static int p, q; //the primes composing modulo
	
	private static int msg = -1; //empty message
	
	/*
	 * Main contains the user interface 
	 */
	public static void main(String[]args) {
		resetInput();
		boolean usable = valid();
		System.out.println("\nThe RSA is " + (usable ? "" : "not ") + "usable");
		
		if(usable) {
			System.out.println("\n1. Insert a new message.");
			System.out.println("2. Encrypt/decrypt message using private key.");
			System.out.println("3. Encrypt/decrypt message using public key.");
			System.out.println("0. Exit system");
		}
		
		int choice = 1;
		while(usable && choice != 0) {
			System.out.print("\nPlease enter the number of the method you would like to use: ");
			choice = input.nextInt();
			switch(choice) {
				case 1:
					System.out.print("Please enter a message (as a positive integer): ");
					msg = input.nextInt();
				break;
				
				case 2:
				if(msg == -1) {
					System.out.println("You must first insert a message");
				}
				else {
					msg = exp(msg, privateKey, modulo);
					System.out.println("New message = " + msg);
				}
				break;
				
				case 3:
					if(msg == -1) {
					System.out.println("You must first insert a message");
				}
				else {
					msg = exp(msg, publicKey, modulo);
					System.out.println("New message = " + msg);
				}
				break;
				
				case 0: break;
				
				default:
				System.out.println(choice + " is not a valid option.");
			}
		}
		
		System.out.println("\nRSAChecker has terminated");
	}
	
	/*
	 * Resets the input and asks user for new keys 
	 */
	private static void resetInput() {
		System.out.print("modulo = ");
		modulo = input.nextInt();
		System.out.print("Private key = ");
		privateKey = input.nextInt();
		System.out.print("Public key = ");
		publicKey = input.nextInt();
		System.out.println();
	}
	
	/*
	 * Checks modulo, private key and public key if they are valid for RSA
	 */
	private static boolean valid() {
		boolean valid = false;
		
		int i = 2;
		while(!valid && i < modulo/2) {
			if(modulo % i == 0) { //If modulo is a multiple of i 
				boolean isPrime = true;
				for(int j = 2; j < i/2; j++) { //NOTE TO SELF: Is there a better way of doing this than brute force?
					if(i % j == 0) {
						isPrime = false;
					}
				}
				if(isPrime) { //If i is prime 
					for(int j = 2; j < (modulo/i)/2; j++) { 
						if( (modulo/i) % j == 0) {
							isPrime = false;
						}
					}
					if(isPrime) { //If modulo/i is also prime
						p = i;
						q = modulo/i;
						valid = true;
					}
				}
				
			}
			i = i + 1;
		}
		
		if(valid) {
			System.out.println(modulo + " is the product of the two primes; " + p + " and " + q);
		}
		else {
			System.out.println(modulo + " is not the product of two primes");
			return false;
		}
		
		//Checks if gcd(privateKey ,(p-1)(q-1)) = 1.
		int a = privateKey;
		int b = (p-1)*(q-1);
		int c = a % b;
		while(c != 0) {
			c = a % b;
			a = b;
			b = c;
		}
		System.out.println("gcd(" + privateKey + " ,(" + p + "-1)(" + q + "-1) ) = " + a);
		if(a != 1) {
			valid = false;
			return valid;
		}
		
		//Checks if privateKey * publicKey is equivalent to: 1 (mod (p-1)(q-1)).

		System.out.println(privateKey + "*" + publicKey + " is equivalent to: " + ((privateKey*publicKey) % ((p-1)*(q-1))) + "  (mod(" + p + "-1)(" + q + "-1) )");
		valid = (privateKey*publicKey) % ((p-1)*(q-1)) == 1;
		return valid;
	}
	
	/*
	 * Encrypts / decrypts message using k key
	 * 
	 * Computes a^k (mod n)
	 */
	private static int exp(int a, int k, int n) {
		if(k <= 0) {
			return 1;
		}
		if(k == 1) {
			return a % n;
		}
		if(k % 2 == 1) { //If k is odd
			return (a * exp(a,k-1,n) ) % n;
		}
		else { //If k is even
			int c = exp(a,k/2,n);
			return (c*c) % n;
		}
	}
	
}