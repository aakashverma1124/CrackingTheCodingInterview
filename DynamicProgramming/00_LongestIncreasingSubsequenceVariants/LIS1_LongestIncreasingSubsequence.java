/*

	@author
	Aakash Verma

	Given an unsorted array of integers, find the length of longest increasing subsequence.

	Example:

	Input: [10,9,2,5,3,7,101,18]
	Output: 4 

	Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
	Note: Here we are not looking for continuity of the arrays.

	Approach:

	Initially, we are assuming that, at each element, the maximum length of longest increasing
	subsequence is 1. (it's nothing but value itself)
	To do so, we are creating a tempArray[] to store all values as 1 which represents the
	longest increasing subsequence for each element in the given array.

	Now:
	We'll start itearting over the given array.
	Let's suppose, I am at 9 i.e arr[1]
	If I could have known, what's the length of longest increasing subsequence at 10.
	then, I could have added 1 to it, if 10 < 9, which could increase the length by 1.
	But because 10 > 9, so we can't increase the value.
	The idea is, the outer loop will keep track of each element.
	The inner loop will run from 0 to i everytime and which will calculate the length of longest
	increasing subsequence at each element by using already stored value in tempArrays
	and it'll store the new value in tempArray[], if condition is satisfied (see equation 1)

	Finally, I'll return the max of tempArray as the length of longest increasing subsequene.

	Just dry and run!

*/

import java.util.Arrays;
import java.lang.Math;

class LIS1_LongestIncreasingSubsequence {

	public static int longestIncreasingSubsequence(int arr[], int n) {

		/* creating an array and setting all values as 1 */
		int tempArray[] = new int[n];
		Arrays.fill(tempArray, 1);

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) { 		// equation 1
					tempArray[i] = Math.max(tempArray[i], tempArray[j] + 1);
				}
			}
		}

		int length = 0;
		for(int i = 0; i < n; i++) {
			length = Math.max(length, tempArray[i]);
		}
		return length;
	}

	public static void main(String[] args) {
		int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
		int n = arr.length;
		int length = longestIncreasingSubsequence(arr, n);
		System.out.println(length);
	}
	
}