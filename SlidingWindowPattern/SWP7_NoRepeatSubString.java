/*	
	@author Aakash.Verma

	Problem: Given a string, find the length of the longest substring which has no repeating characters.

	Example 1:

	Input: String="aabccbb"
	Output: 3
	Explanation: The longest substring without any repeating characters is "abc".	

	Example 2:

	Input: String="abccde"
	Output: 3
	Explanation: Longest substrings without any repeating characters are "abc" & "cde".

	Approach: 
	We can use a Map to remember the last index of each character we have processed. 
	Whenever we get a repeating character we will shrink our sliding window to ensure that we 
	always have distinct characters in the sliding window.

	i.e windowStart to windowEnd will always have unique characters.
	So, whenever I get any character which is already processed, I'll make my windowStart as 
	the last index of the character + 1.


*/

import java.util.*;

class SWP7_NoRepeatSubString {

	public static int findLength(String s) {
		int windowStart = 0, maxLength = 0;
		Map<Character, Integer> map = new HashMap<>();

		for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char rightChar = s.charAt(windowEnd);
			if(map.containsKey(rightChar)) {
				windowStart = Math.max(windowStart, map.get(rightChar) + 1);
			}
			map.put(rightChar, windowEnd);
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		String s = "aabccbb";
		int length = findLength(s);
		System.out.println(length);
	}
}