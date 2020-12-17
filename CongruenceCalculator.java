import 	java.util.ArrayList;
import	java.util.Arrays;
import 	java.lang.Math;
import	javax.swing.JOptionPane;

public class CongruenceCalculator{

	public static void main(String[]args){

		boolean flag = true;
		while(flag){
			Object[] options = { "1", "2" };
			int choice = (JOptionPane.showOptionDialog(null, "Hvordan er dit sp" + (char)248 + "rgsm" + (char)229 + "l udformet?" +
			"\n\n1: Hvilke tal er kongruente med a % m?\n2. Er a kongruent med b % m?", "|%%%%%%%%%%%%%%%%%%|",
			JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]));
			
			switch(choice){
				case 0:
					int a = Integer.parseInt(JOptionPane.showInputDialog("Hvilke tal er kongruente med a % m", "a"));
					int m = Integer.parseInt(JOptionPane.showInputDialog("Hvilke tal er kongruente med a % m", "m"));
					int min = Integer.parseInt(JOptionPane.showInputDialog("fra hvilket ", "min"));
					int max = Integer.parseInt(JOptionPane.showInputDialog("Hvilke tal er kongruente med a % m", "max"));
					
					System.out.println(a + " % " + m + " er kongruent med f" + (char)248 + "lgende tal mellem " + min + " og " + max + ":"); 
					System.out.println(Arrays.toString(congruenceArray(a, m, min, max)));
					int intF = JOptionPane.showConfirmDialog(null, "Igen?", 
					"|%%%%%%%%%%%%%%%%%%|", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(intF == 1){
							flag = false;
						}
					break;
				case 1:
					a = Integer.parseInt(JOptionPane.showInputDialog("Er a kongruent med b modulo m", "a"));
					int b = Integer.parseInt(JOptionPane.showInputDialog("Er a kongruent med b modulo m", "b"));
					int modulus = Integer.parseInt(JOptionPane.showInputDialog("Er a kongruent med b modulo m", "m"));
					
					if(isCongruent(a, b, modulus) == true){
						System.out.println(a + " er kongruent med " + b + " modulo " + modulus);
					} else {
						System.out.println(a + " er IKKE kongruent med " + b + " modulo " + modulus);
					}

					intF = JOptionPane.showConfirmDialog(null, "Igen?", 
					"|%%%%%%%%%%%%%%%%%%|", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(intF == 1){
							flag = false;
						}	
					break;
			}
		}
	System.exit(0); //exit på grund af JOptionPane.
	}
	
	/*
	* returns an array of all integers that are congruent to a modulo b - in the range from min to max
	* precondition: min is a smaller number than max.
	*/
	private static Integer[] congruenceArray(int a, int m, int min, int max){
		int result = Math.floorMod(a, m);
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		for(int i = min; i < max; i++){
			if(Math.floorMod(i, m) == result){
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
