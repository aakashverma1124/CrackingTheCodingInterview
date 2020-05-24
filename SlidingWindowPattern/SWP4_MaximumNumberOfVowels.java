/*
*	@author Aakash.Verma
*	
*	Problem: 
*	Given a string s and an integer k.
*	Return the maximum number of vowel letters in any substring of s with length k.
*	Vowel letters in English are (a, e, i, o, u).
*
*	Example 1:
*
*	Input: s = "abciiidef", k = 3
*	Output: 3
*	Explanation: The substring "iii" contains 3 vowel letters.	
*
*	Example 2:
*
*	Input: s = "weallloveyou", k = 7
*	Output: 4
*	Explanation: The substring "loveyou" contains 4 vowel letters.
*
*/



class SWP4_MaximumNumberOfVowels {

	public boolean isVowel(char x) {
        return (x == 'a' || x =='e' || x == 'i' || x == 'o' || x == 'u');
    }

    public int maxVowels(String s, int k) {
        int maxSum = 0;
		int windowSum = 0;
		int windowStart = 0;

		for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			if(isVowel(s.charAt(windowEnd)))
                windowSum += 1;

			if(windowEnd >= k - 1) {
				maxSum = Math.max(windowSum, maxSum);
				if(isVowel(s.charAt(windowStart)))
                    windowSum -= 1;
				windowStart++;
			}
		}
		return maxSum;
    }
	
	public static void main(String[] args) {
		SWP4_MaximumNumberOfVowels s = new SWP4_MaximumNumberOfVowels();
		String s = "weallloveyou";
		int k = 7;
		int ans = s.maxVowels(s, k);
		System.out.println(ans);
	}
}