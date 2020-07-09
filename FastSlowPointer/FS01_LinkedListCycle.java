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
class FS01_LinkedListCycle {
	static Node head;

	FS01_LinkedListCycle() {
		head = null;
	}

	static boolean hasCycle() {
		Node slowPointer, fastPointer;
		slowPointer = fastPointer = head;

		while(fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				return true;	
			}
		}
		return false;
	}

	/* Main method */
	public static void main(String[] args) {
		FS01_LinkedListCycle list = new FS01_LinkedListCycle();
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		System.out.println(hasCycle());
		head.next.next.next.next.next = head.next.next;
		System.out.println(hasCycle());
		
	}
}
