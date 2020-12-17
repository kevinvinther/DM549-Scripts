import	java.util.Scanner;
import 	java.util.ArrayList;
import	java.util.Arrays;
import 	java.lang.Math;

public class CongruenceCalculator{

	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
	
		//Test:
		System.out.println(Arrays.toString(congruenceArray(17,5,-40,40)));
		System.out.println(isCongruent(4, 1024, 6));
	}
	
	/*
	* returns an array of all integers that are congruent to a modulo b - in the range from min to max
	* precondition: min is a smaller number than max.
	*/
	private static Integer[] congruenceArray(int a, int b, int min, int max){
		int result = Math.floorMod(a, b);
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		for(int i = min; i < max; i++){
			if(Math.floorMod(i, b) == result){
				tempList.add(i);
			}
		}
		Integer[] congruenceArray = new Integer[tempList.size()];
		congruenceArray = tempList.toArray(congruenceArray);
		return congruenceArray;
	}
	
	/*
	* returns true if a is congruent to b modulo m
	*/
	private static boolean isCongruent(int a, int b, int modulus){
		return Math.floorMod(a, modulus) == Math.floorMod(b, modulus) ? true : false;
	}	
}
