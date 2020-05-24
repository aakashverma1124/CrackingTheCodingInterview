import java.util.Scanner;

// Problem Statement: Implement an algorithm to determine if a string has all unique characters. 
// What if you can not use additional data structures.


//  ==============================
// | Input:                       |
// |                              |
// | abcdefgh                     |
//  ==============================
//  =================================
// | Output:                         |
// |                                 |
// | True                      	     |
//  =================================

public class IsUnique {

	static boolean isUniqueCharacters(String s) {
		if(s.length() > 128) {
			return false;
		}
		boolean[] chars = new boolean[128];
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			
			if(chars[val]) { // Found repeated character already!
				return false;
			}
			chars[val] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String s = scan.nextLine();
		
		boolean a = isUniqueCharacters(s); 
		if(a) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		

	}

}
