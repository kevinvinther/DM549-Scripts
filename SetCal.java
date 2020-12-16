/*
 * This document was written by William Bundgaard
 *
 * Runs a few calculations on sets. 
 */ 

import java.util.Scanner; //To get user input 
import java.util.HashSet; //To use sets
import java.util.HashMap; //To use sets witch maps to other values
import java.util.ArrayList; //To hold the different sets
import java.io.FileReader; //To read files
import java.io.FileNotFoundException; //Thrown when file is not present 

public class SetCal {
	
	//For reading input
	private static Scanner input = new Scanner(System.in);
	
	private static HashSet<Integer> universe = new HashSet<Integer>();
	
	//Holds a list of sets so the user can ass as many sets as they want
	private static ArrayList<HashSet<Integer>> sets = new ArrayList<HashSet<Integer>>();
	
	/*
	 * The main has the user interface 
	 */
	public static void main(String[]args) {
		init();
		
		System.out.println("1. Add a set. Works with the operators as well.");
		System.out.println("2. Add sets from file.");
		System.out.println("3. Reset universe.");
		System.out.println("4. Reset universe from file, and add sets from same file.");
		System.out.println("5. Add elements to existing set.");
		System.out.println("6. Get the union of two sets.");
		System.out.println("7. Get the intersection of two sets.");
		System.out.println("8. Get the difference of two sets.");
		System.out.println("9. Get the inverse of a set.");
		System.out.println("10. Print a already existing set.");
		System.out.println("0. Exit.");
		
		int choice = 0;
		do {
			System.out.print("\nPlease enter an option: ");
			choice = input.nextInt();
			
			switch(choice) {
				
				case 1: //Add a set 
					addSet();
				break; 
				
				case 2: //Add sets from file
					addSetsFromFile();
				break;
				
				case 3: //Reset universe
					newUniverse();
				break;
				
				case 4: //Reset universe from file, and add sets from same file
					newUniverseAndSetsFromFile();
				break;
				
				case 5: //Add elements to existing set
				break;
				
				case 6: //Get the union of two sets
					
				break;
				
				case 7: //Get the intersection of two sets
					
				break;
				
				case 8: //Get the difference of two sets
					
				break;
				
				case 9: //Get the inverse of a set
					
				break;
				
				case 10: //Print a already existing set
					
				break;
				
				case 0:break; //Exit
				
				default:
				System.out.println(choice + " is not a valid option.");
			}
			
		} while(choice != 0);
	}
	
	/*
	 * Initializer
	 * Sets the universe to the integers from 0 to 9
	 */
	private static void init() {
		for(int i = 0; i < 10; i++) {
			universe.add(i);
		}
	}
	
	/*
	 * Sets a new universe and clears sets 
	 */
	private static void newUniverse() {
		universe.clear();
		sets.clear();
		String[] universeStr = input.nextLine().trim().split(" ");
		for(String element: universeStr) {
			universe.add(Integer.parseInt(element) );
		}
	}
	
	/*
	 * Sets a new universe from file, and adds all the sets from same file.
	 * This also empties out all the old sets from sets 
	 */
	private static void newUniverseAndSetsFromFile() {
		String fileName = input.nextLine();
		try{
			FileReader file = new FileReader(fileName);
			Scanner reader = new Scanner(file);
			
			universe.clear();
			sets.clear();
			
			String[] universeStr = reader.nextLine().trim().split(" ");
			for(String element: universeStr) {
				universe.add(Integer.parseInt(element) );
			}
			
			while (reader.hasNextLine()) {
				String[] setStr = reader.nextLine().trim().split(" ");
				HashSet<Integer> set = new HashSet<Integer>();
				for(String element: setStr) {
					//Only adds element contained in the universe 
					if(universe.contains(Integer.parseInt(element) ) ) {
						set.add(Integer.parseInt(element) );
					}
				}
				sets.add(set);
			}
		}
		catch(FileNotFoundException e) { 
			System.out.println("File: " + fileName + ", could not be found");
		}
	}
	
	/*
	 * Adds a new set to sets
	 */
	private static void addSet() {
		HashSet<Integer> set = new HashSet<Integer>();
		String[] setStr = input.nextLine().trim().split(" ");
		for(String element: setStr) {
			//Only adds element contained in the universe 
			if(universe.contains(Integer.parseInt(element) ) ) {
				set.add(Integer.parseInt(element) );
			}
		}
		sets.add(set);
	}
	
	/*
	 * Adds all the sets from a file to sets
	 */
	private static void addSetsFromFile() {
		String fileName = input.nextLine();
		try{
			FileReader file = new FileReader(fileName);
			Scanner reader = new Scanner(file);
			
			while (reader.hasNextLine()) {
				String[] setStr = reader.nextLine().trim().split(" ");
				HashSet<Integer> set = new HashSet<Integer>();
				for(String element: setStr) {
					//Only adds element contained in the universe 
					if(universe.contains(Integer.parseInt(element) ) ) {
						set.add(Integer.parseInt(element) );
					}
				}
				sets.add(set);
			}
		}
		catch(FileNotFoundException e) { 
			System.out.println("File: " + fileName + ", could not be found");
		}
	}
	
	/*
	 * Adds an element to a set
	 */
	private static void addElements(HashSet<Integer> set) {
		String[] setStr = input.nextLine().trim().split(" ");
		for(String element: setStr) {
			//Only adds element contained in the universe 
			if(universe.contains(Integer.parseInt(element) ) ) {
				set.add(Integer.parseInt(element) );
			}
		}
	}
	
	/*
	 * Returns the union of two sets 
	 */
	private static HashSet<Integer> union(HashSet<Integer> set1, HashSet<Integer> set2) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int n : set1) {
			set.add(n);
		}
		for(int n: set2) {
			set.add(n);
		}
		return set;
	}
	
	/*
	 * Returns the intersection of two sets 
	 */
	private static HashSet<Integer> intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int n : set1) {
			if(set2.contains(n) ) {
				set.add(n);
			}
		}
		return set;
	}
	
	/*
	 * Returns the difference of two sets 
	 */
	private static HashSet<Integer> difference(HashSet<Integer> set1, HashSet<Integer> set2) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int n : set1) {
			if(!set2.contains(n) ) {
				set.add(n);
			}
		}
		return set;
	}
	
	/*
	 * Returns the inverse of a set 
	 */
	private static HashSet<Integer> inverse(HashSet<Integer> set) {
		HashSet<Integer> newSet = new HashSet<Integer>();
		for(int n : universe) {
			if(!set.contains(n) ) {
				newSet.add(n);
			}
		}
		return newSet;
	}
	
	/*
	 * Prints all the elements of a set
	 */
	private static void printSet(HashSet<Integer> set) {
		System.out.print("{ ");
		for(int n : set) {
			System.out.print(n + ", ");
		}
		System.out.println("}");
	}
	
}