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


	public static void main(String[] args) {
		int n  = 10;
		int nthNumber = fibonacci(n);
		System.out.println(nthNumber);
	}
}