/******************************************************************
 *This Program will allow user to create and set matrix dimensions
 * It will then allow users to add, subtract or multiply the matrices
 * This calculator can handle matrices with dimensions greater than 2 x 2
 *
 *Date: September 22, 2014
 *Created By: Luis Lopez
 *
 * Modified by Kevin Vinther 
 * Date: 16/12/2020
 ******************************************************************/
import java.util.Scanner;

public class Matrix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Variable that controls whether the calculator is running or not
		boolean stat = true;
		// Option that will allow user to determine if they want to exit 
		int option;
		/*This loop will keep the calculator running as long as 
		the stat variable is true, the variable stat can be changed
		to false */
		while(stat){
			System.out.println("For at udregne en matrix tast 1 \nFor at gå ud af programmet, tast 2.");
			option = in.nextInt();
			switch(option){
			case 1: 
				// Invokes the create problem method to instantiate a new problem
				// The boolean value returned will indicate whether the calculator
				// should stop or whether it should continue running
					stat = createProblem(option);
					break;
			case 2:
				// If user types 2 then the calculator exits
					stat = false;
					break;
			default:
				// by default if an option other than one or two is selected the calculator 
				// will exit
					stat = false;
					break;
			}
		}
			System.out.println("Udregner lukket");
	}
	// This method starts the matrices calculator
	// It instantiates matrixes and invokes methods that
	// allow the user to insert values for matrices
	public static boolean createProblem(int i){
		Scanner in = new Scanner(System.in);
		boolean condition;
		// Integer option that will will store user numerical input on menu
		int contStat;
		boolean statusC;
		// Variables that count number of rows and columns in a matrix
		int frows;
		int fcolumns;
		int srows;
		int scolumns;
		// Matrix arrays
		int[][] matrix1;
		int[][] matrix2;
		int[][] matrix1Values;
		int[][] matrix2Values;
		// Sets the dimensions of matrices
		System.out.println("Indtast antal i rækker i *første* matrix");
		frows = in.nextInt();
		String operator;
		System.out.println("Indtast antal af kolonner i *første* matrice");
		fcolumns = in.nextInt();
		System.out.println("Intast antal af rækker i *anden* matrice");
		srows = in.nextInt();
		System.out.println("Intast antal af kolonner i *anden* matrice");		
		scolumns = in.nextInt();
		// Creates the matrices with the given dimensions
		matrix1 = createMatrix(frows, fcolumns);
		matrix2 = createMatrix(srows, scolumns);
		// Sets the matrices values
		matrix1Values = setMatrixValues(matrix1,"Første");
		matrix2Values = setMatrixValues(matrix2, "Anden");
		// variable that allows for user to work with the same matrices so  that 
		// they don't have to input them again
		// when this variable is false user is taken to main menu
		statusC = true;
		while(statusC){
			System.out.println("Vælg Matrix operation, \n \t + Addition \n \t - Subtraktion \n \t * Multiplikation");
			operator = in.next();
			statusC = performOperation(operator, matrix1Values, matrix2Values);
		}
		// Allows Users to go to main menu
		System.out.println("Tryk 1, hvis du vil fortsætte med at bruge udregneren. \nTryk 2, hvis du vil gå ud.");
		contStat = in.nextInt();
		switch(contStat){
		case 1:
			condition = true;
			break;
		case 2:
			condition = false;
			break;
		default:
			condition = false;
			break;
		}
		return condition;
		
	}
	// this method will provide users with options to either perform an 
	// arithmetic operation or exit
	public static boolean performOperation(String operator, int[][] matrix1, int[][] matrix2){
		Scanner in = new Scanner(System.in);
		int optSelected;
		boolean status = false;
		switch(operator){
		case "*":
			multiplyMatrices(matrix1, matrix2);
			break;
		case "+":
			addMatrices(matrix1, matrix2);
			break;
		case "-":
			subtractMatrices(matrix1, matrix2);
			break;
		default:
			System.out.println("Ikke en valid operator, mulighederne er: +, -, *");
			break;
		}
		// Dialogue informing users of options after arithmetic operation 
		// is done running. Options include performing additional operations
		// on the set matrices or to exit
		System.out.println("Hvis du gerne vil lave andre operationer på de 2 matricer allerede brugt, tryk 1. \n"
						+ "Hvis du vil bruge et andet par matricer, tryk 2\n" 
						+ "Hvis du vil ud, tryk 3");
		optSelected = in.nextInt();
		switch(optSelected){
		case 1:
			status = true;
			break;
		case 2:
			status = false;
			break;
		case 3:
			status = false;
			break;
		}
		return status;
	}
	// This method simply recurses through an array assigning values at each 
	// location
	public static int[][] setMatrixValues(int[][] matrix, String label){
		Scanner in = new Scanner(System.in);
		int dataEntered;
		int rows = matrix.length;
		int columns = matrix[0].length;
		for(int i=0; i<rows; i++){
			for(int j=0; j< columns; j++){
				System.out.println("Indtast værdien af " + label + " matrix ved række: "+i+" og kolonne:"+j+" :");
				dataEntered = in.nextInt();
				matrix[i][j] = dataEntered;
			}
		}
		return matrix;
	}
	// This method sets the dimensions of a matrix
	public static int[][] createMatrix(int numRows, int numColumns){
		int[][] matrix = new int[numRows][numColumns];
		return matrix;
	}
	// All methods below this line perform operations
	public static void multiplyMatrices(int[][] matrix1, int[][] matrix2){
		boolean status = checkIfValidMult(matrix1, matrix2);
		if(status == true){
			for(int i=0; i<matrix1.length; i++){
				int total = 0;
				for(int j = 0; j<matrix2[0].length; j++){
					int fnum = matrix1[i][j];
					int snum = matrix2[j][i];
					int product = fnum*snum;
					total += product;
				}
				System.out.println(total);
				
			}
		}else{
			System.out.println("Ugyldigt Input");
		}
	}
	public static void addMatrices(int[][] matrix1, int[][] matrix2){
		boolean status = checkIfValidAddSub(matrix1, matrix2);
		if(status == true){
			for(int i = 0; i < matrix1.length; i++){
				for(int j = 0; j < matrix1[0].length; j++){
					int charM1 = matrix1[i][j];
					int charM2 = matrix2[i][j];
					int resultant = charM1 + charM2;
					System.out.print(resultant+" ");
				}
				System.out.print("\n");
			}
		}else{
			System.out.println("For at addere matricer, skal de have same antal rækker og kolonner.");
		}
	}
	public static void subtractMatrices(int[][] matrix1, int[][] matrix2){
		boolean status = checkIfValidAddSub(matrix1, matrix2);
		if(status == true){
			for(int i = 0; i < matrix1.length; i++){
				for(int j = 0; j < matrix1[0].length; j++){
					int charM1 = matrix1[i][j];
					int charM2 = matrix2[i][j];
					int resultant = charM1 - charM2;
					System.out.print(resultant+ " ");
				}
				System.out.print("\n");
			}
		}else{
			System.out.println("For at subtrahere matricer, skal de have same antal rækker og kolonner.");
		}
	}
	// The methods below this line will check if operation can e performed on 
	// matrices
	public static boolean checkIfValidAddSub(int[][] matrix1, int[][] matrix2){
		boolean status;
		int numRows1 = matrix1.length;
		int numColumns1 = matrix1[0].length;
		int numRows2 = matrix2.length;
		int numColumns2 = matrix2[0].length;
		if(numRows1 == numRows2 && numColumns1 == numColumns2){
			status = true;
		}else{
			status = false;
		}
		return status;
	}
	public static boolean checkIfValidMult(int[][] matrix1, int[][] matrix2){
		boolean status;
		int columns = matrix1[0].length;
		int rows = matrix2.length;
		if( columns == rows){
			status = true;
		}else{
			status = false;
		}
		return status;
	}

}
