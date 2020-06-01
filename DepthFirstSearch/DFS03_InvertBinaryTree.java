/*
*	@author Aakash.Verma
*	
*	Problem: 
*
*	Given a binary tree, invert it and return the new root node.
*	
*	Example:
*	
*	Given binary tree: [4, 2, 1, 3, 7, 6, 9]
*	Output: [4, 7, 9, 6, 2, 3, 1]
*	Note: Above representation is Pre Order:
* 	If Level Order is given, the answer would be:
*	Given binary tree: [4, 2, 7, 1, 3, 6, 9]
*	Output: [4, 7, 2, 9, 6, 3, 1]
*
*	Example 1:
*
*	Input:
*
*		    4
*		   / \
*		  2   7
*		 / \ / \
*	    	1  3 6  9 
* 
*	Output:
*
*		    4
*		   / \
*		  7   2
*		 / \ / \
*	        9  6 3  1
*
*/


/* Creating a structure for the node.
   Initializing the nodes datas upon calling its constructor. */

class Node {
	int data;
	Node left;
	Node right;

	public Node(int key) {
		data = key;
		left = null;
		right = null;
	}
}

class DFS03_InvertBinaryTree {

	public Node dfs(Node root) {
		if(root == null) {
			return null;
		}

		/* taking two different utility nodes and assign them as null */
		Node tempLeft = null;
		Node tempRight = null;

		/* storing left node in some variable, if present */
		if(root.left != null) {
			tempLeft = root.left;
		}

		/* storing right node in some variable, if present */
		if(root.right != null) {
			tempRight = root.right;
		}

		/* changing left node to right node & right node to left node */
		root.left = tempRight;
		root.right = tempLeft;

		/* calling same function for child nodes and accepting in right & left node respectively */
		root.left = dfs(root.left);
		root.right = dfs(root.right);

		return root;
	}

	/* invert Tree function */
	public Node invertTree(Node root) {
		if(root == null) {
			return null;
		}
		Node newRoot = dfs(root);
		return newRoot;
	}

	/* utility function to print the tree */
	public void preOrder(Node root) {
		if(root == null) {
			return; 
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	/* main method */
    public static void main (String[] args) {
    	Node root = null;
        DFS03_InvertBinaryTree tree = new DFS03_InvertBinaryTree();
        root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(9);
        Node newRoot = tree.invertTree(root);
        tree.preOrder(newRoot);
        System.out.println();
    }
}
