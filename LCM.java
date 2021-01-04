import java.util.ArrayList;
import java.util.Scanner;

public class LCM{

	public static void main(String[]args){
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hvilke tal kunne du t" + (char)230 + "nke dig at finde LCM for?");
		System.out.print("F" + (char)248 + "rste tal:");
		int a = sc.nextInt();
		System.out.print("Andet tal:");
		int b = sc.nextInt();
		
		ArrayList<Integer> aListe = new ArrayList<Integer>();
		ArrayList<Integer> bListe = new ArrayList<Integer>();
		boolean hasLCM = false;
		int tempA = a;
		int tempB = b;
		while(!hasLCM){
			tempA = tempA + a;
			aListe.add(tempA);
			tempB = tempB + b;
			bListe.add(tempB);
			for(int i = 0; i < bListe.size(); i++){
				if(aListe.contains(bListe.get(i))){
					System.out.println(bListe.get(i));
					hasLCM = true;
				}
			}
		}
	}
}
