/*	
	@author Aakash.Verma

	Problem: Given an array of characters where each character represents a fruit tree, 
	you are given two baskets and your goal is to put maximum number of fruits in each basket. 
	The only restriction is that each basket can have only one type of fruit.

	You can start with any tree, but once you have started you can’t skip a tree. 
	You will pick one fruit from each tree until you cannot, i.e., you will stop when you have 
	to pick from a third fruit type.

	Write a function to return the maximum number of fruits in both the baskets.

	Example 1:

	Input: fruits = {'A', 'B', 'C', 'B', 'B', 'C'}
	Output: 5
	Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
	This can be done if we start with the second letter: {'B', 'C', 'B', 'B', 'C'}

	Example 2:

	Input: fruits = {'A', 'B', 'C', 'A', 'C'}
	Ouput: 3
	Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray {'C', 'A', 'C'}

	Approach: 
	Same exactly SWP5_LongestSubstringWithKDistinctCharacters.java


*/


import java.util.*;

class SWP6_MaximumFruitsInBasket {

	public static int maxFruits(char fruits[]) {
		int windowStart = 0, maxLength = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
			char rightChar = fruits[windowEnd];
			map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

			while(map.size() > 2) {
				char leftChar = fruits[windowStart];
				map.put(leftChar, map.get(leftChar) - 1);
				if(map.get(leftChar) == 0) {
					map.remove(leftChar);
				}
				windowStart++;
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		char fruits[] = {'A', 'B', 'C', 'B', 'B', 'C'};
		int maxFruits = maxFruits(fruits);
		System.out.println(maxFruits);	
	}

}