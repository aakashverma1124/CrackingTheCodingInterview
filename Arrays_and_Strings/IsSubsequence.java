/*
*   @author Aakash.Verma
*   
*   Problem: 
*
*   Given a string s and a string t, check if s is subsequence of t.
*
*	A subsequence of a string is a new string which is formed from the original string by deleting some 
*	(can be none) of the characters without disturbing the relative positions of the remaining characters. 
*	(i.e, "ace" is a subsequence of "abcde" while "aec" is not).
*
*/

class IsSubsequence {

	public static boolean isSubsequence(String s, String t) {

		/* If length of s is greater than t, we directly return false */
		if(s.length() > t.length()) {
			return false;
		}

		int i,j;
		i = j = 0;
		/* 
			otherwise, we start checking each character one by one, if we find same character
			increment both the incides by 1 and if characters are not equal, we increment j only
			in string t.
			Finally, if i is equal to length of s, it means all the characters of string s are found
			in sequence in string t.
		*/
		while(i < s.length() && j < t.length()) {
			if(s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			}
			else {
				j++;
			}
		}

		if(i == s.length()) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgxc";
		boolean answer = isSubsequence(s, t);
		System.out.println(answer);
	}
}