/*
Problem Statement :
For a given a binary tree of integers and an integer X, find and return the total number of nodes 
of the given binary tree which are having data greater than X.
*/



public class Solution {

	public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		//Your code goes here
        if(root == null)
            return 0;
        int countLeft = countNodesGreaterThanX(root.left, x);
        int countRight = countNodesGreaterThanX(root.right, x);
        if(root.data > x)
        {
            return 1 + countLeft + countRight;
        }
        return countLeft + countRight;
	}

}


