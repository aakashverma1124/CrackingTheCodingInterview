/*
*
*	@author
*	Aakash Verma
*	
*	Problem: The Fibonacci numbers are the numbers in the following integer sequence.
*				
*			 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
*
*
*/



class DP01_FibonacciSeries {

	/* 	Method 1: Simplest way to solve this problem. 
		The problem with this solution is that it's time complexity is too high, i.e O(2^n).
		And for larger number it'll not be able to output the answer.
		Time Complexity: O(2^n)
		Space Complexity: O(n) (Stack Space)

	public static int fibonacci(int n) {
		if(n == 1) {
			return 0;
		}
		if(n == 2) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}

	*/



	/* 	Method 2:

		We'll create an array and store the previous two sums at the next index, and as soon as we'll
		reach n, we will return it.
		Time Complexity: O(n)
		Space Complexity: O(n)

		We are actually starting from index 1 to n (and not 0 to n-1).

	*/

	/* Method 2 */
	public static int fibonacci(int n) {
		int[] dp = new int[n+1];
		dp[1] = 0;
		dp[2] = 1;
		if(n == 1) {
			return dp[1];
		}
		if(n == 2) {
			return dp[2];
		}

		for (int i = 3; i <=n; i++) {
			dp[i] = dp[i - 1] + dp [i - 2];
		}
		return dp[n];
	}


	public static void main(String[] args) {
		int n  = 10;
		int nthNumber = fibonacci(n);
		System.out.println(nthNumber);
	}
}