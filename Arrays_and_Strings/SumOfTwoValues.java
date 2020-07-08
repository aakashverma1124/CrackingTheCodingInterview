/*
    @author Aakash.Verma
	   
 	Problem:   Sum Of Two Values

	Given an array of integers and a value, determine if there are any two integers in the array whose sum is equal 
	to the given value. Return true if the sum exists and return false if it does not.

	Consider this array and the target sums:

	Example 1:

	Input: [5, 7, 1, 2, 8, 4, 3], 10
	Output: true
	Explanation: There exists two pairs (7,3) & (8,2) which make sum as 10.

	Example 2: 

	Input: [5, 7, 1, 2, 8, 4, 3], 19
	Output: false
	Explanation: There exists two pairs (7,3) & (8,2) which make sum as 10.

	Approach: 
	1. Use hashing
	2. Use comparison between elements

*/

import java.util.*;

class SumOfTwoValues {

	public static boolean findAnswer(int arr[], int targetSum) {
		Set<Integer> set = new HashSet<>();
		for(int a: arr) {
			if(set.contains(targetSum - a)) {
				return true;
			}
			set.add(a);
		}
		return false;
	}

	public static void main(String[] args) {

		int arr[] = {5, 7, 1, 2, 8, 4, 3};
		int targetSum = 10;
		boolean answer = findAnswer(arr, targetSum);
		System.out.println(answer);
		
	}
}