/*
    @author Aakash.Verma
	   
 	Problem:   Move Zeroes To the Left Of Array

	Given an integer array, move all elements that are 0 to the left while maintaining the order of 
	other elements in the array. The array has to be modified in-place.

	Let’s look at the following integer array:

	Example 1:

	Input: [1, 10, 20, 0, 59, 63, 0, 88, 0]
	Output: [0, 0, 0, 1, 10, 20, 59, 63, 88]
	Explanation: There exists two pairs (7,3) & (8,2) which make sum as 10.

	Approach: 
	Use the concept of reader/writer indexes

	Solution Explanation:

	Time Complexity:
	The Time complexity of this solution is linear, O(n).

	Space Complexity:
	The space complexity of this solution is linear, O(1).


	Solution Breakdown:

	In this solution, we have two temporary variables, readIndex & writeIndex both are poining to the last index of the array.
	So, starting from the last we are reading each element and if element is not equal to 0, we store it at the writeIndex position
	and decrement the writeIndex. readIndex is decremented everytime. writeIndex is decremented only when arr[readIndex] != 0.
	In this way, we shift all non-zero element to the right.
	Now writeIndex is z away.
	where z is equal to number of zeros present in the array.
	So while writeIndex doesn't become 0, we store 0 at each writeIndex.
	
*/
import java.io.*; 
import java.util.*; 

class MoveZeroesToLeft {

	static void moveZerosToLeft(int arr[]) {
		if(arr.length < 1)
			return;

		int readIndex = arr.length - 1;
		int writeIndex = arr.length - 1;

		while (readIndex >= 0) {
			if(arr[readIndex] != 0) {
				arr[writeIndex] = arr[readIndex];
				writeIndex--;
			}
			readIndex--;
		}

		while(writeIndex >= 0) {
			arr[writeIndex] = 0;
			writeIndex--;
		}

	}

	public static void main(String[] args) {

		int[] arr = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
		moveZerosToLeft(arr);
		System.out.println(Arrays.toString(arr));
  	}  

}