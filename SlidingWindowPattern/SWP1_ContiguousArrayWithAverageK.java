/*
*
*	@author
*	Aakash Verma
*	
*	Problem: Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
*	Sliding Window Pattern
*
*	Output: 2.2 2.8 2.4 3.6 2.8
*
*/



class SWP1_ContiguousArrayWithAverageK {

	public double[] contiguousSubArrayWithSumAverageK(int a[], int k) {
		double[] result = new double[a.length - k + 1];
		double windowSum = 0;
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < a.length; windowEnd++) {
			windowSum += a[windowEnd];

			if(windowEnd >= k - 1) {
				result[windowStart] = windowSum/k;
				windowSum -= a[windowStart];
				windowStart++;
			}
		}
		return result;
	}


	public static void main(String[] args) {
		SWP1_ContiguousArrayWithAverageK swp = new SWP1_ContiguousArrayWithAverageK();
		int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
		int k = 5;
		double[] ans = swp.contiguousSubArrayWithSumAverageK(arr, k);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}
