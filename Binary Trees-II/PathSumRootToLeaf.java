/*
Problem Statement :
For a given Binary Tree of type integer and a number K, print out all root-to-leaf paths where the 
sum of all the node data along the path is equal to K.
*/


public class Solution 
{
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) 
    {
	rootToLeafPathSumToK(root, k, "");
    }

    public static void rootToLeafPathSumToK(BinaryTreeNode<Integer> root, int k, String s)
    {
        if(root == null)   //base case for traversing binary tree
        {
            return;
        }
        
	if(root.left == null && root.right == null)     //leaf node
        {
            if(k == root.data)
            {
		s = s + root.data + " ";
                System.out.println(s);
            }
            return;
        }
        
        rootToLeafPathSumToK(root.left, k-root.data, s + root.data + " ");
        rootToLeafPathSumToK(root.right, k-root.data, s + root.data + " ");
        
    }
}