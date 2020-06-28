/*	
	@author Aakash.Verma

	Problem: Given an array of sorted numbers, remove all duplicates from it. You should not use 
	any extra space; after removing the duplicates in-place return the new length of the array.

	Example 1:

	Input: [2, 3, 3, 3, 6, 9, 9]
	Output: 4
	Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].

	Example 2:

	Input: [2, 2, 2, 11]
	Output: 2
	Explanation: The first two elements after removing the duplicates will be [2, 11].

	Approach: 
	In this problem, we need to remove the duplicates in-place such that the resultant length 
	of the array remains sorted. As the input array is sorted, therefore, 
	one way to do this is to shift the elements left whenever we encounter duplicates. 
	In other words, we will keep one pointer for iterating the array and one pointer for placing 
	the next non-duplicate number. So our algorithm will be to iterate the array and 
	whenever we see a non-duplicate number we move it next to the last non-duplicate number 
	we’ve seen.

*/

class TP02_RemoveDuplicates {

	public static int removeDuplicates(int arr[]) {
		/* index of a next non duplicate element */
		int nextNonDuplicate = 1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != arr[nextNonDuplicate]) {
				arr[nextNonDuplicate] = arr[i];
				nextNonDuplicate++;
			}
		}
		return nextNonDuplicate;
	}

	public static void main(String[] args) {
		int arr[] = new int[] {2, 3, 3, 3, 6, 9, 9};
		int length = removeDuplicates(arr);
		System.out.println(length);
	}
}