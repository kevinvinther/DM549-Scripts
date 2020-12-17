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
	
	//Converts the int universe to character universe and vise versa
	private static HashMap<Integer, String> intToStr = new HashMap<Integer, String>();
	private static HashMap<String, Integer> strToInt = new HashMap<String, Integer>();
	
	//If the universe is in numbers or strings
	private static boolean numberUniverse = true;
	
	//Holds a list of sets so the user can ass as many sets as they want
	private static ArrayList<HashSet<Integer>> sets = new ArrayList<HashSet<Integer>>();
	
	private static void menu() {
		System.out.println("1. Add a set.");
		System.out.println("2. Add sets from file.");
		System.out.println("3. Reset universe. (Only works if file contains numbers)");
		System.out.println("4. Reset universe from file, and add sets from same file. (Should only be done if you do not wish to use strings)");
		System.out.println("5. Add elements to existing set.");
		System.out.println("6. Get the union of two sets.");
		System.out.println("7. Get the intersection of two sets.");
		System.out.println("8. Get the difference of two sets.");
		System.out.println("9. Get the inverse of a set.");
		System.out.println("10. Print an already existing set.");
		System.out.println("11. Print the last made set from an operator.");
		System.out.println("12. Remember last made set from an operator.");
		System.out.println("13. Prints the universe.");
		System.out.println("14. Prints all the sets."); 
		System.out.println("15. Prints the option menu.");
		System.out.println("16. Chance between integer universe and string universe.");
		System.out.println("0. Exit.");
	}
	
	/*
	 * The main has the user interface 
	 */
	public static void main(String[]args) {
		init();
		
		menu();
		
		int choice = 0, setNumber, set1Number, set2Number;
		HashSet<Integer> lastMade = null;
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
					setNumber = 0;
					do{
						System.out.print("Please chose a set number (" + 1 + " to " + sets.size() + "): ");
						setNumber = input.nextInt() - 1;
					} while(setNumber < 0 || setNumber >= sets.size());
					addElements(sets.get(setNumber) );
				break;
				
				case 6: //Get the union of two sets
					set1Number = 0;
					set2Number = 0;
					do{
						System.out.print("Please chose a set number for the first set (" + 1 + " to " + sets.size() + "): ");
						set1Number = input.nextInt() - 1;
					} while(set1Number < 0 || set1Number >= sets.size() );
					do{
						System.out.print("Please chose a set number for the second set (" + 1 + " to " + sets.size() + "): ");
						set2Number = input.nextInt() - 1;
					} while(set2Number < 0 || set2Number >= sets.size());
					
					lastMade = union(sets.get(set1Number), sets.get(set2Number) );
				break;
				
				case 7: //Get the intersection of two sets
					set1Number = 0;
					set2Number = 0;
					do{
						System.out.print("Please chose a set number for the first set (" + 1 + " to " + sets.size() + "): ");
						set1Number = input.nextInt() - 1;
					} while(set1Number < 0 || set1Number >= sets.size() );
					do{
						System.out.print("Please chose a set number for the second set (" + 1 + " to " + sets.size() + "): ");
						set2Number = input.nextInt() - 1;
					} while(set2Number < 0 || set2Number >= sets.size() );
					
					lastMade = intersection(sets.get(set1Number), sets.get(set2Number) );
				break;
				
				case 8: //Get the difference of two sets
					set1Number = 0; 
					set2Number = 0;
					do{
						System.out.print("Please chose a set number for the first set (" + 1 + " to " + sets.size() + "): ");
						set1Number = input.nextInt() - 1;
					} while(set1Number < 0 || set1Number >= sets.size() );
					do{
						System.out.print("Please chose a set number for the second set (" + 1 + " to " + sets.size() + "): ");
						set2Number = input.nextInt() - 1;
					} while(set2Number < 0 || set2Number >= sets.size() );
					
					lastMade = difference(sets.get(set1Number), sets.get(set2Number) );
				break;
				
				case 9: //Get the inverse of a set
					setNumber = 0;
					do{
						System.out.print("Please chose a set number (" + 1 + " to " + sets.size() + "): ");
						setNumber = input.nextInt() - 1;
					} while(setNumber < 0 || setNumber >= sets.size() );
					
					lastMade = inverse(sets.get(setNumber) );
				break;
				
				case 10: //Print a already existing set
					setNumber = 0;
					do{
						System.out.print("Please chose a set number (" + 1 + " to " + sets.size() + "): ");
						setNumber = input.nextInt() - 1;
					} while(setNumber < 0 || setNumber >= sets.size() );
					
					printSet(sets.get(setNumber) );
				break;
				
				case 11: //Print last made set
					if(lastMade != null) {
						printSet(lastMade);
					}
					else {
						System.out.println("You need to run an operator function first");
					}
				break;
				
				case 12: //Remember set
					if(lastMade != null) {
						System.out.print("Set has been added: ");
						printSet(lastMade);
						rememberSet(lastMade);
					}	
					else {
						System.out.println("You need to run an operator function first");
					}
				break;
				
				case 13: //Print universe
					printSet(universe);
				break;
				
				case 14: //Print all sets
					int p = 1;
					for(HashSet<Integer> set : sets) {
						System.out.print(p++ + ". ");
						printSet(set);
					}
				break;
				
				case 15: //Prints the options menu 
					menu();
				break;
				
				case 16: //Chance universe
					numberUniverse = !numberUniverse;
					System.out.println("The universe is set to " + (numberUniverse ? "integers" : "strings") );
				break;
				
				case 0:break; //Exit
				
				default:
				System.out.println(choice + " is not a valid option.");
			}
			
		} while(choice != 0);
	}
	
	private static void rememberSet(HashSet<Integer> set) {
		sets.add(set);
	}
	
	/*
	 * Initializer
	 * Sets the universe to the integers in the file "intToCharMap.txt"
	 * and adds the mapping to the strings after the numbers
	 */
	private static void init() {
		try{
			FileReader file = new FileReader("intToCharMap.txt");
			Scanner reader = new Scanner(file);
			
			while (reader.hasNextLine()) {
				String[] strArr = reader.nextLine().trim().split(" ");
				intToStr.put(Integer.parseInt(strArr[0]), strArr[1]);
				strToInt.put(strArr[1], Integer.parseInt(strArr[0]) );
			}
			for(int n : intToStr.keySet() ) {
				universe.add(n);
			}
		}
		catch(FileNotFoundException e) { 
			System.out.println("File: intToCharMap.txt, could not be found\nThis file is needed");
		}
	}
	
	/*
	 * Sets a new universe and clears sets 
	 */
	private static void newUniverse() {
		universe.clear();
		sets.clear();
		System.out.println("Enter all the elements separated by spaces: ");
		input.nextLine(); //It tries to read something else otherwise
		String[] universeStr = input.nextLine().trim().split(" ");
		for(String element: universeStr) {
			//Only adds element contained in the integer universe
			if(numberUniverse) {				
				universe.add(Integer.parseInt(element) );
				
			}
			//Only adds elements contained in the string mapping universe
			else {
				if(strToInt.containsKey(element) ) {
					universe.add(strToInt.get(element) );
				}
			}
		}
	}
	
	/*
	 * Sets a new universe from file, and adds all the sets from same file.
	 * This also empties out all the old sets from sets 
	 */
	private static void newUniverseAndSetsFromFile() {
		System.out.print("Enter the name of the file: ");
		input.nextLine(); //It tries to read something else otherwise
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
		addElements(set);
		sets.add(set);
	}
	
	/*
	 * Adds all the sets from a file to sets
	 */
	private static void addSetsFromFile() {
		System.out.print("Enter the name of the file: ");
		input.nextLine(); //It tries to read something else otherwise
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
		System.out.println("Enter all the elements separated by spaces: ");
		input.nextLine(); //It tries to read something else otherwise
		String[] setStr = input.nextLine().trim().split(" ");
		for(String element: setStr) {
			//Only adds element contained in the universe 
			if(numberUniverse) {
				if(universe.contains(Integer.parseInt(element) ) ) {
					set.add(Integer.parseInt(element) );
				}
			}
			else {
				if(strToInt.containsKey(element) ) {
					set.add(strToInt.get(element) );
				}
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
		System.out.print("{");
		int i = 1;
		
		if(numberUniverse) {
			for(int n : set) {
				
				System.out.print(n);
				
				if(i != set.size() ) {
					System.out.print(", ");
				}
				i = i + 1;
			}
		}
		else {
			for(int n : set) {
				
				System.out.print(intToStr.get(n) );
				
				if(i != set.size() ) {
					System.out.print(", ");
				}
				i = i + 1;
			}
		}
		System.out.println("}");
	}
	
}