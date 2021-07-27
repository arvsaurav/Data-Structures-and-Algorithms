/*
Problem Statement :
For a given Binary Tree of type integer and a number X, find whether a node exists in the tree with data X or not.
*/


public class Solution 
{
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) 
    {
        if(root == null)
            return false;
        if(root.data == x)
            return true;
        boolean leftAns = isNodePresent(root.left, x);
        boolean rightAns = isNodePresent(root.right, x);
        if(leftAns || rightAns)
            return true;
        return false;
    }

}