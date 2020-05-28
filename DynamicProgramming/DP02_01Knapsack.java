/*

	@author
	Aakash Verma

	Problem: Given weights and values of n items, put these items in a knapsack of 
	capacity W to get the maximum total value in the knapsack.
	In other words:
	I am given two arrays, one value array and another is, weight array associated with n items respectively.
	Also, a given int W which is the capacity of the knapsack.

	Task:

	Find out the maximum value subset of val[] such that sum of the weights of this subset 
	is smaller than or equal to W. 

	Note: You cannot break an item, either pick the complete item or don’t pick it (0-1 property.)

	Approach: Think of the smallest possible scenario.
	1. When there is no item available. (numberOfItems = 0)
	2. When item is available but no capacity is there. (numberOfItems = someNumber but capacity = 0)

	We can write it recursivley because we have a termination condition or base condition.
	

*/




class DP02_01Knapsack {


/*
	public static int knapsack(int value[], int weight[], int capacity, int numberOfItems) {	
		if(numberOfItems == 0 || capacity == 0) {
			return 0;
		}

		 	
		//	If weight of any item is greater than the capacity we'll directly ignore it.
		//	therefore, the same function will be called for n - 1 items available in the array.
		
		if(weight[numberOfItems - 1] > capacity) {
			return knapsack(value, weight, capacity, numberOfItems - 1);
		}
		else {
			return Math.max(
				value[numberOfItems - 1] + knapsack(value, weight, capacity - weight[numberOfItems - 1], numberOfItems - 1),
					knapsack(value, weight, capacity, numberOfItems - 1));
		}
	}

	But above problem is recursive and may have recomputations.
	*/


	public static int knapsack(int value[], int weight[], int capacity, int numberOfItems) {

		int[][] dp = new int[capacity + 1][numberOfItems + 1];


		/* Initializing dp array with -1 */
		for (int i = 0; i <= capacity; i++) {
			for (int j = 0; j <= numberOfItems; j++) {
				dp[i][j] = -1;
			}
		}

		/* Base Case */
		if(numberOfItems == 0 || capacity == 0) {
			return 0;
		}

		/* If already available in the array, no need to compute it */
		if(dp[capacity][numberOfItems] != -1) {
			return dp[capacity][numberOfItems];
		}
	
		/* Otherwise compute it and save it for further use */
		if(weight[numberOfItems - 1] > capacity) {
			return dp[capacity][numberOfItems] = knapsack(value, weight, capacity, numberOfItems - 1);
		}
		else {
			return dp[capacity][numberOfItems] =  Math.max(
				value[numberOfItems - 1] + knapsack(value, weight, capacity - weight[numberOfItems - 1], numberOfItems - 1),
					knapsack(value, weight, capacity, numberOfItems - 1));
		}
	}



	public static void main(String[] args) {
		int value[] = {10, 40, 30, 50};
		int weight[] = {5, 4, 6, 3};
		int capacity = 10;
		int numberOfItems = 4;
		int answer = knapsack(value, weight, capacity, numberOfItems);
		System.out.println(answer);
	}

}