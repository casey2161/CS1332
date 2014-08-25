/**
 * Assignment to teach dynamic programming using 3 simple example problems:
 * 1. Fibonacci numbers
 * 2. Longest common subsequence
 * 3. Edit distance
 * 
 * @author Naomi Robert
 */
public class DynamicProgramming {
	
	/**
	 * Calculates the nth fibonacci number: fib(n) = fib(n-1) + fib(n-2).
	 * Remember that fib(0) = 0 and fib(1) = 1.
	 * 
	 * This should NOT be done recursively - instead, use a 1 dimensional
	 * array so that intermediate fibonacci values are not re-calculated.
	 * 
	 * The running time of this function should be O(n).
	 * 
	 * @param n A number 
	 * @return The nth fibonacci number
	 */
	public static int fib(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 0) {
			return 0;
		}
		
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
				
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];		
	}
	
	/**
	 * Calculates the length of the longest common subsequence between a and b.
	 * 
	 * @param a
	 * @param b
	 * @return The length of the longest common subsequence between a and b
	 */
	public static int lcs(String a, String b) {
		if (a == null || b == null) {
			throw new IllegalArgumentException();
		} else if (a.equals("") || b.equals("")) {
			return 0;
		}
		
		int[][] matrix = new int[a.length() + 1][b.length() + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
		
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				} else {
					matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
				}
			}
		}
		return matrix[matrix.length - 1][matrix[0].length - 1];
	}

	/**
	 * Calculates the edit distance between two strings.
	 * 
	 * @param a A string
	 * @param b A string
	 * @return The edit distance between a and b
	 */
	public static int edit(String a, String b) {
		int[][] matrix  = new int[a.length() + 1][ b.length() + 1];
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][0] = i;
		}
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[0][i] = i;
		}
		
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = Math.min(matrix[i - 1][j] + 1,
							Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j - 1] + 1));
				}				
			}
		}
		return matrix[matrix.length - 1][matrix[0].length - 1];
	}
}
