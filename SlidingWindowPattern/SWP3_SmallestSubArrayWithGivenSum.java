/*
*
*	@author
*	Aakash Verma
*	
*	Problem: Given an array, find the smallest subarray with given sum S.
*	SWP - Sliding Window Pattern
*
*	Output: 2
*		3
*/


class SWP3_SmallestSubArrayWithGivenSum {

	public int smallestSubArrayWithGivenSum(int arr[], int givenSum) {

		int windowSum = 0, minLength = Integer.MAX_VALUE;
		int windowStart = 0;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];

			while(windowSum >= givenSum) {
				minLength = Math.min(minLength, windowEnd - windowStart + 1);
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
		return minLength == Integer.MAX_VALUE ? -1 : minLength;

	}

	public static void main(String[] args) {

		SWP3_SmallestSubArrayWithGivenSum s = new SWP3_SmallestSubArrayWithGivenSum();
		/* Test Case 1 */
		int arr[] = {2, 1, 5, 2, 3, 2};
		int givenSum = 7;
		int ans = s.smallestSubArrayWithGivenSum(arr, givenSum);
		System.out.println(ans + " ");

		/* Test Case 2 */
		int arr2[] = {3, 4, 1, 1, 6};
		int givenSum2 = 8;
		int ans2 = s.smallestSubArrayWithGivenSum(arr2, givenSum2);
		System.out.println(ans2 + " ");
		
	}

}
