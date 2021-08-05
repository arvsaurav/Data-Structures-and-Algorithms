/*
Problem Statement :
Check if given binary tree is BST or not.
*/

import java.lang.Math;
public class Solution
{
    public static boolean isBST(BinaryTreeNode<Integer> root)
    {
        	if(root == null)
		{
			return true;
		}
		int leftSubtreeMax = maximum(root.left);
		if(root.data <= leftSubtreeMax)
		{
		    return false;
		}
		int rightSubtreeMin = minimum(root.right);
		if(root.data > rightSubtreeMin)
		{
		    return false;
		}
		boolean leftAns = isBST(root.left);
		boolean rightAns = isBST(root.right);
		return leftAns && rightAns;
    }
    
    public static int maximum(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return Integer.MIN_VALUE;
        }
        int leftMax = maximum(root.left);
        int rightMax = maximum(root.right);
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }
    
    public static int minimum(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return Integer.MAX_VALUE;
        }
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
}