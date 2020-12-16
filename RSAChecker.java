/*
 * This code helps use and check RSA - public key system 
 */

import java.util.Scanner;

public class RSAChecker {
	
	//For reading input
	private static Scanner input = new Scanner(System.in);
	
	//Stores the keys and modulo 
	private static int modulo; //modulo
	private static int privateKey; //private key
	private static int publicKey; //public key
	
	private static int p, q; //the primes composing modulo
	
	/*
	 * Main contains the user interface 
	 */
	public static void main(String[]args) {
		resetInput();
		boolean usable = valid();
		System.out.println("\nThe RSA is " + (usable ? "" : "not ") + "usable");
		
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
	 * Encrypts / decrypts message using private key
	 */
	private static int encrypt(int msg) {
		return 0;
	}
	
	/*
	 * Encrypts / decrypts message using public key
	 */
	private static int decrypt(int msg) {
		return 0;
	}
	
}