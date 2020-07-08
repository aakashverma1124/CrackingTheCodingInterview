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

	Solution Explanation:

	Time Complexity:
	The Time complexity of this solution is linear, O(n).

	Space Complexity:
	The space complexity of this solution is linear, O(n).


	Solution Breakdown
	In this solution, you can use the following algorithm to find a pair that add up to the target (say targetSum).

	Scan the whole array once and store visited elements in a hash set.
	During scan, for every element a in the array, we check if targetSum - a is present in the hash set i.e. targetSum - a is already visited.
	If targetSum - a is found in the hash set, it means there is a pair (e, targetSum - a) in array whose sum is equal to the given targetSum.
	If we have exhausted all elements in the array and didn’t find any such pair, the function will return false.

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