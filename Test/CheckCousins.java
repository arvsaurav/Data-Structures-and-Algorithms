/*
Problem Statement :
Given the binary Tree and two nodes say ‘p’ and ‘q’. Determine whether the two nodes are cousins of each other or not. 
Two nodes are said to be cousins of each other if they are at same level of the Binary Tree and have different parents.
Do it in O(n).
*/


import java.util.ArrayList;


public class solution 
{
    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) 
    {
        if(root == null)
            return false;
        return (depth(root, p) == depth(root, q)) && !isSibling(root, p, q);
    }
    
    public static boolean isSibling(BinaryTreeNode<Integer> root, int p, int q) 
    {
        if(root == null)
            return false;
        if(root.left != null && root.right != null)
        {
            if((root.left.data == p && root.right.data == q) || (root.left.data == q && root.right.data == p))
            {
                return true;
            }
            boolean leftAns = isSibling(root.left, p, q);
            boolean rightAns = isSibling(root.right, p, q);
            return leftAns || rightAns;
        }
        if(root.left == null)
            return isSibling(root.right, p, q);
        else
            return isSibling(root.right, p, q);
        
    }
    
    public static int depth(BinaryTreeNode<Integer> root, int n)
    {
        if(root == null)
            return -1;
        if(root.data == n)
            return 0;
        int leftAns = depth(root.left, n);
        if(leftAns != -1)
        {
            return leftAns + 1;
        }
        else
        {
            int rightAns = depth(root.right, n);
            if(rightAns != -1)
                return rightAns + 1;
            else
            	return -1;
        }
    }
}
