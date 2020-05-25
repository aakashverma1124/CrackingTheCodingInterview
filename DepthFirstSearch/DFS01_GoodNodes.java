/*
*	@author Aakash.Verma
*	
*	Problem: 
*
*	Given a binary tree root, 
*	a node X in the tree is named good if in the path from root to X 
*	there are no nodes with a value greater than X.
*
*	Return the number of good nodes in the binary tree.
*
*	Example 1:
*
*			3
*		   / \
*		  1	  4
*		 /	 / \
*		3	1	5
*
*	Input: root = [3,1,4,3,null,1,5]
*	Output: 4
*	Explanation: Nodes in blue are good.
*	Root Node (3) is always a good node.
*	Node 4 -> (3,4) is the maximum value in the path starting from the root.
*	Node 5 -> (3,4,5) is the maximum value in the path
*	Node 3 -> (3,1,3) is the maximum value in the path.
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

class DFS01_GoodNodes {

	/* Creating a root node for the Tree. */
    static Node root;
    
    /* Assigning root as null initially. */
    DFS01_GoodNodes() {
    	root = null;
    }

    /* Utility variable for storing number of good nodes. */
    int goodNodes = 0;
    
    /* dfs traversal over the tree. */
    public void dfs(Node root, int maxPathValue) {
        if(root == null) return;
        if(maxPathValue <= root.data){
            goodNodes++;
            maxPathValue = root.data;
        }
        dfs(root.left, maxPathValue);
        dfs(root.right, maxPathValue);
        
    }
    
    /* function which returns the number of good nodes */
    public int goodNodes(Node root) {
        if(root == null) return goodNodes;
        dfs(root, Integer.MIN_VALUE);
        return goodNodes;
    }

    /* main method */
    public static void main (String[] args) {
        DFS01_GoodNodes tree = new DFS01_GoodNodes();
        tree.root = new Node(3);
        tree.root.left = new Node(1);
        tree.root.right = new Node(4);
        tree.root.left.left = new Node(3);
        tree.root.right.left = new Node(1);
        tree.root.right.right = new Node(5);
        System.out.print("Number Of Good Nodes: " + tree.goodNodes(root));
        System.out.println();
    }


}