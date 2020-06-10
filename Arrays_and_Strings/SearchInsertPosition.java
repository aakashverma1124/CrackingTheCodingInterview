/*
    @author Aakash.Verma
	   
 	Problem:   Search Insert Position

	Given a sorted array and a target value, return the index if the target is found. 
	If not, return the index where it would be if it was to be inserted in the order.

	You may assume no duplicates in the array.

	Example 1:
	Input: [1,3,5,6], 5
	Output: 2

	Example 2:
	Input: [1,3,5,6], 2
	Output: 1
	
	Example 3:
	Input: [1,3,5,6], 7
	Output: 4

	Example 4:
	Input: [1,3,5,6], 0
	Output: 0

	Approach: 
	If element is equal to the target value, return i.
	While iterating, if at some point of time, target value becomes greater than arr[i], return i.
	If element is larger than all the values present in the array, it would occupy the last index + 1
	i.e arr.length, so we will return arr.length. 

*/


class SearchInsertPosition {

	public static int searchInsertPosition(int arr[], int target) {
		
		for(int i = 0; i < arr.length; i++) {
			if(target == arr[i] || target < arr[i]) {
				return i;
			}
		}
		return arr.length;

	}

	public static void main(String[] args) {
		
		int arr[] = {1, 3, 5, 6};
		int target = 7;
		int index = searchInsertPosition(arr, target);
		System.out.println(index);
	}

}