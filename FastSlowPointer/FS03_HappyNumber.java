/*	
	@author Aakash.Verma

	Problem: Any number will be called a happy number if, after repeatedly replacing it with a number 
	equal to the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) 
	numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.	

	Example 1:

	Input: 23   
	Output: true (23 is a happy number)  
	Explanations: Here are the steps to find out that 23 is a happy number:
	=> 2^2 + 3^2 = 4 + 9 = 13
	=> 1^2 + 3^2 = 1 + 9 = 10
	=> 1^2 + 0^2 = 1 + 0 = 1
		
	Example 2:

	Input: 12   
	Output: false (12 is not a happy number)  
	Explanations: Here are the steps to find out that 12 is not a happy number:
	=> 1^2 + 2^2 = 1 + 4 = 5
	=> 5^2 = 25
	=> 2^2 + 5^2 = 4 + 25 = 29
	=> 2^2 + 9^2 = 4 + 81 = 85
	=> 8^2 + 5^2 = 64 + 25 = 89
	=> 8^2 + 9^2 = 64 + 81 = 145
	=> 1^2 + 4^2 + 5^2 = 1 + 16 + 25 = 42
	=> 4^2 + 2^2 = 16 + 4 = 20
	=> 2^2 + 0^2 = 4 + 0 = 4
	=> 4^2 = 16
	=> 1^2 + 6^2 = 1 + 36 = 37
	=> 3^2 + 7^2 = 9 + 49 = 58
	=> 5^2 + 8^2 = 25 + 64 = 89

	Approach: 
	The process, defined above, to find out if a number is a happy number or not, always ends in a cycle. If the number is a happy number, 
	the process will be stuck in a cycle on number ‘1,’ and if the number is not a happy number then the process will be stuck in a cycle 
	with a set of numbers. As we saw in FS01_LinkedListCycle while determining if ‘12’ is a happy number or not, our process will get stuck 
	in a cycle with the following numbers: 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89

	We saw in the LinkedList Cycle problem that we can use the Fast & Slow pointers method to find a cycle among a set of elements. 
	As we have described above, each number will definitely have a cycle. Therefore, we will use the same fast & slow pointer strategy 
	to find the cycle and once the cycle is found, we will see if the cycle is stuck on number ‘1’ to find out if the number is happy or not.

*/


class FS03_HappyNumber {

	static int findDigitSumSquare(int num) {
		int newNumber = 0;
		while(num != 0) {
			int rem = num % 10;
			newNumber = newNumber + rem*rem;
			num = num/10;
		}
		return newNumber;
	}

	static boolean isHappyNumber(int num) {
		int slow, fast;
		slow = num;
		fast = num;
		do {
			slow = findDigitSumSquare(slow);
			fast = findDigitSumSquare(findDigitSumSquare(fast));
		} while(slow != fast);

		if(slow == 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(isHappyNumber(23));
		System.out.println(isHappyNumber(12));
	}
}