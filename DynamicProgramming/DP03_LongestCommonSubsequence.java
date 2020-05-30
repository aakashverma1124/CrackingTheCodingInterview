/*

	@author
	Aakash Verma

	Problem: 
	If a set of sequences are given, the longest common subsequence problem is to find a 
	common subsequence of all the sequences that is of maximal length.
	The longest common subsequence problem is a classic computer science problem, 
	the basis of data comparison programs such as the diff-utility, 
	and has applications in bioinformatics. 
	It is also widely used by revision control systems, such as SVN and Git, for 
	reconciling multiple changes made to a revision-controlled collection of files.

	Example 1: 

	Input:
	s1 = "BACDB"
	s2 = "BDCB"

	Output:
	3

	Explanation: 
	The first common appearance is B, after that the common contiguous element is C, 
	and then B again.

	The problem can be solved using Dynamic Programming.

*/


class DP03_LongestCommonSubsequence {

	public static int lcs(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];


		/* I'd suggest, make a 2-D array and iterate as per the example. You'll understand this. */
		for(int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		
		String s1 = "BACDB";
		String s2 = "BDCB";
		int length = lcs(s1, s2);
		System.out.println(length);

	}
}