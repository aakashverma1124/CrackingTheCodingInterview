/*
*	@author Aakash.Verma
*	
*	Problem: 
*
*	Given a binary tree, find its maximum depth.
*	The maximum depth is the number of nodes along the longest path 
*	from the root node down to the farthest leaf node.
*
*	Note: A leaf is a node with no children.
*	
*	Example:
*	
*	Given binary tree [3,9,20,null,null,15,7],
*
*	Example 1:
*
*		    3
*		   / \
*		  9   20
*		     /  \
*		    15	 7
*
*	return its depth = 3.
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

class DFS02_MaximumDepthBinaryTree {
	/* Creating a root node for the Tree. */
	static Node root;

	/* Assigning root as null initially. */
    DFS02_MaximumDepthBinaryTree() {
    	root = null;
    }

    /* Utility function for getting max depth. */
    public int maxDepth(Node root) {
    	if(root == null) return 0;
    	return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /* main method */
    public static void main (String[] args) {
        DFS02_MaximumDepthBinaryTree tree = new DFS02_MaximumDepthBinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);
        System.out.print("Max Depth: " + tree.maxDepth(root));
        System.out.println();
    }


}