import java.util.Scanner;

public class GCD{

	public static void main(String[]args){	
		Scanner sc = new Scanner(System.in);
		System.out.println("Hvad er dit f" + (char)248 + "rste tal du kunne t" + (char)230 + "nke dig at finde?");
		int a = sc.nextInt();
		System.out.println("Og det andet?");
		int b = sc.nextInt();
		
		int resultat = calcGCD(a, b);
		
		if(resultat == 1){
			System.out.println("\n" + a + " og " + b + " er indbyrdes primiske"); 
		}else{
			System.out.println("\nGCD(" + a + "," + b + ") = " + resultat);
		}
	}
	
	public static int calcGCD(int a, int b){
		if(b != 0)
			return calcGCD(b, a % b);
		else
			return a;
	}
}
