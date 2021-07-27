/*
Problem Statement :
For a given Binary Tree of integers, find and return the height of the tree.
*/


import java.lang.Math;
public class Solution {

	public static int height(BinaryTreeNode<Integer> root) {
		//Your code goes here
        if(root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
	}

}