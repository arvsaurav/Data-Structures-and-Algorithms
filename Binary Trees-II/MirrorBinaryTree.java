/*
Problem Statement :
For a given Binary Tree of type integer, update it with its corresponding mirror image.
*/

public class Solution 
{

	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root)
    {
		if(root == null)
        {
			return;
        }
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
	}
	
}