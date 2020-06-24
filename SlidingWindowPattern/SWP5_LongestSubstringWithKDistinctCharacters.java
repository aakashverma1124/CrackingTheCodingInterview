/*	
	@author Aakash.Verma

	Problem: Given a string, find the length of the longest substring in it with no more than 
	K distinct characters.

	Example 1:

	Input: string = "araaci", k = 2
	Output: 4
	Explanation: The longest substring with no more than '2' distinct characters is "araa".

	Example 2:

	Input: string = "cbbebi", k = 3
	Ouput: 5
	Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

	Approach: 
	We've taken a map to keep count of distinct character that we'll encounter during the process.
	Until the size of map becomes greater than k, we'll keep adding the characters into map with their
	frequency & we'll keep finding the maxLength.

	As soon as size becomes greater than k, we will try to shrink the window from the beginning 
	if the count of distinct characters in the map is larger than ‘k’. We will shrink the window until 
	we have no more than ‘k’ distinct characters in the map. This is needed as we intend to find the longest window.

	While shrinking, we’ll decrement the frequency of the character going out of the window and 
	remove it from the map if its frequency becomes zero.

	At the end of each step, we’ll check if the current window length is the longest so far, 
	and if so, remember its length.


*/
class SWP5_LongestSubstringWithKDistinctCharacters {

	public static int findLength(String s, int k) {
		
		/* base conditions */
		if(s == null || s.length() == 0 || s.length() < k) {
			throw new IllegalArgumentException();
		}

		/* utility variables & map */
		int windowStart = 0; int maxLength = 0;
		Map<Character, Integer> map = new HashMap<>();

		for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			/* keep adding characters to the map until the size of map becomes greater than k */
			char rightChar = s.charAt(windowEnd);
			map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

			/* 
				as soon as size exceeds, start decrement the frequency of the characters from the map
				and keep shifting the window.
			*/
			while(map.size() > k) {
				char leftChar = s.charAt(windowStart);
				map.put(leftChar, map.get(leftChar) - 1);
				if(map.get(leftChar) == 0) {
					map.remove(leftChar);
				}
				windowStart++;
			}
			/* finding max with each iteration */
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		String s = "araaci";
		int k = 2;
		int length = findLength(s, k);
		System.out.println(length);
	}
}