/*

	@author
	Aakash Verma

	Problem: Given an array of integers and a sum, return true if there exists a subset with
	given sum in the given array.

	Task:

	Example: 

	Input: 

	2 3 7 8 10
	11

	Output:

	True

	Exaplantion: There exists a subset {3, 8} which results a sum of 11 which is equal to given sum.

	Approach: The problem relates to 0-1 Knapsack problem. How?
	Here the given array is acting as a weight array in 0-1 Knapsack Problem and given sum is acting
	as a capacity in 0-1 Knapsack Problem.

	In Knapsack Problem value array was acting as a property of weight array, the dependency was on 
	weight array and then value array.

	So the approach will be same, problem will be solved using dynamic array of 
	size dp[arr.size() + 1][sum + 1].

	Think of the smallest possible scenario.

	1. If the size of array is 0, and sum is given. It is not possible to find any subset with given sum.
	In this case my answer would be False.
	2. If the size of array is some thing and given sum is 0. Then, it is always possible to find a
	subset which will be empty "{}" subset. So the answer would be True.

	We can write it recursivley because we have a termination condition or base condition.

	So let's look at the code.

*/


class DP04_SubsetSum {

	public static boolean subsetSum(int arr[], int sum) {
		
		/* Creating a dynamic array as per given constraints. */
		boolean[][] dp = new boolean[sum + 1][arr.length + 1];
		
		/* Smallest Possible Scenario 2 */
		for(int i = 0; i <= arr.length; i++) {
			dp[0][i] = true;
		}

		/* Smallest Possible Scenario 1 */
		for(int i = 0; i <= sum; i++) {
			dp[i][0] = false;
		}

		for(int i = 1; i <= sum; i++) {
			for (int j = 1; j <= arr.length; j++) {
				dp[i][j] = dp[i][j - 1]; 
                if (i >= arr[j - 1]) 
                    dp[i][j] = dp[i][j] || dp[i - arr[j - 1]][j - 1];
			}
		}

		return dp[sum][arr.length];
	}

	public static void main(String[] args) {
		
		int arr[] = {2, 3, 7, 8, 10};
		int sum = 11;
		boolean answer = subsetSum(arr, sum);
		System.out.println(answer);

	}
}