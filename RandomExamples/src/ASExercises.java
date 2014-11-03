
public class ASExercises {
	public static int f(int n) {
		if(n <= 3) {
			return n;
		}
		else {
			return f(n-1) + 2*f(n-2) + 3*f(n-3);
		}
	}
	
	public static int fIterative(int n) {
		//Running sum changed progressively
		int sum = 0;
		//Function rules
		int[][] operand =
			{{1,2,3},
			 {1,0,0},
			 {0,1,0}
			};
		int[][] base = 
			{{1,2,3}};
		if(n <=3) {
			return n;
		}
		return multiplyMatrices(exp(operand, n),base)[0][0];
	}rhuang114@gmail.com
	
	public static int[][] multiplyMatrices(int[][] m1, int[][] m2) {
		int[][] result = new int[m1.length][m2[0].length];
		
		//initialize array to 0's
		for(int i=0; i<result.length; i++) {
			for(int k=0; k<result[0].length; k++) {
				result[i][k] = 0;
			}
		}
		
		//Add in the correct results
		//For each row and column of the result
		for(int row=0; row<m1.length; row++) {
			for(int col=0; col<m2[0].length; col++) {
				//Add the dot product of the first column by the second's row
				for(int k=0; k<m1[0].length; k++) {
					result[row][col] += m1[row][k] * m2[k][k];
				}
			}
		}
		return new int[0][0];
	}
	
	public static int[][] exp(int[][] m, int pow) {
		int[][] result = new int[m.length][m[0].length];
		
		return result;
	}
	
	//The top element of the triangle is row 0
	//The column is 0 for furthest to the left
	public static int pascal(int row, int column) {
		//All the sides of the triangle are 1
		if(row <= 0) {
			return 1;
		}
		if(column <= 0) {
			return 1;
		}
		if(column == row) {
			return 1;
		}
		if(column > row) {
			return -1;
		}
		else {
			return pascal(row-1, column) + pascal(row-1, column-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(f(4));
	}
}
