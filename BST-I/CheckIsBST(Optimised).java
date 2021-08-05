/*
Problem Statement :
Check if given binary tree is BST or not.
*/

import java.lang.Math;
public class Solution
{
    	public static boolean isBST(BinaryTreeNode<Integer> root)
    	{
        	isBSTReturn ans = isBSTOptimised(root);
        	return ans.isBST;
    	}
    
    	public static isBSTReturn isBSTOptimised(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			isBSTReturn ans = new isBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
			return ans;
		}
		isBSTReturn leftAns = isBSTOptimised(root.left); //returns minimum, maximum, isBST from left subtree
		isBSTReturn rightAns = isBSTOptimised(root.right); //returns minimum, maximum, isBST from right subtree
		//minimum element of whole tree
		int minimum = Math.min(root.data, Math.min(leftAns.minimum, rightAns.minimum));
		//maximum element of whole tree
		int maximum = Math.max(root.data, Math.max(leftAns.maximum, rightAns.maximum));
		boolean isBST = true;
		if(leftAns.maximum >= root.data)
		{
			isBST = false;
		}
		if(rightAns.minimum < root.data)
		{
			isBST = false;
		}
		if(!leftAns.isBST || !rightAns.isBST)
		{
			isBST = false;
		}
		isBSTReturn ans = new isBSTReturn(minimum, maximum, isBST);
		return ans;
	}
}


class isBSTReturn 
{
	int minimum;
	int maximum;
	boolean isBST;

	public isBSTReturn(int minimum, int maximum, boolean isBST)
	{
		this.minimum = minimum;
		this.maximum = maximum;
		this.isBST = isBST;
	}
}
