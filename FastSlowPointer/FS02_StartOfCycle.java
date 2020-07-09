/*
*
*   @author
*   Aakash Verma
*	
* 	Detect a loop in a linked list.
*
*	Approach:
*	Traverse linked list using two pointers. Move one pointer by one and other pointer by two. 
*	If the fast pointer meets slow pointer then there is a loop otherwise not.
*	Now, if we find the loop, we point slowPointer to the head and now until slowPointer becomes equal to
*	fastPointer, we increment the pointer by one.
*	and finally return slowPointer data as a starting point of the cycle.
*
*	Output: 
*	false
*	true
*
*
*/

/* Below is the structute of a node which is used to create a new node every time. */
class Node {
	int data;
	Node next;

	public Node(int key) {
		data = key;
		next = null;
	}
}

/* Creating a class for implementing the code for getting Nth node in a Linked List. */
class FS02_StartOfCycle {
	static Node head;

	FS02_StartOfCycle() {
		head = null;
	}

	static int startOfCycle() {
		Node slowPointer, fastPointer;
		slowPointer = fastPointer = head;
		boolean cycleFound = false;
		while(fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				cycleFound = true;
				break;
			}
		}
		
		if(cycleFound) {
			slowPointer = head;
			while(slowPointer != fastPointer) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}
			return slowPointer.data;
		}
		return -1;
	}

	/* Main method */
	public static void main(String[] args) {
		FS02_StartOfCycle list = new FS02_StartOfCycle();
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		System.out.println(startOfCycle());
		head.next.next.next.next.next = head.next.next;
		System.out.println(startOfCycle());
		
	}
}
