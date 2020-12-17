import	java.util.Scanner;
import 	java.lang.Math;

public class CongruenceCalculator{

	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		//introduktion til regnemaskinen her:
		/*System.out.println("  .-O  VELKOMMEN TIL DEN LILLE KONGRUENS-REGNEMASKINE  O-.\n" +
						   "  ---------------------------------------------------------\n" +
						   "   maskinen regner problemer ud fra formlen er a kongruent |\n" +
						   "   med b modulo \"modulus\" og returnerer true eller false.. |\n"+
						   "  ---------------------------------------------------------\n");*/
		
		System.out.print("Hvilke tal er kongruente med a modulo b:\n"+
						"indtast a: ");
		int a = sc.nextInt();
		System.out.print("indtast b: ");
		int b = sc.nextInt();
		System.out.print("Output fra: ");
		int min = sc.nextInt();					//precondition: min er mindre end max.
		System.out.print("til: ");
		int max = sc.nextInt();
		int result = Math.floorMod(a, b);
		System.out.print("[");
		for(int i = min; i < max; i++){
			if(Math.floorMod(i, b) == result){
				System.out.print(i+"][");
			}
		}
		System.out.println("]");
	}
	
	private static boolean isCongruent(int a, int b, int modulus){
		return Math.floorMod(a, modulus) == Math.floorMod(b, modulus) ? true : false;
	}
	
}