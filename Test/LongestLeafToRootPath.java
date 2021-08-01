/*
Problem Statement :
Given a binary tree, return the longest path from leaf to root. 
Longest means, a path which contain maximum number of nodes from leaf to root.
*/



import java.util.ArrayList;

public class Solution 
{

    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root)
    {
	if(root == null)
            return null;
        if(root.left == null && root.right == null)
        {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(root.data);
            return arr;
        }
        ArrayList<Integer> leftAns = longestRootToLeafPath(root.left);
	ArrayList<Integer> rightAns = longestRootToLeafPath(root.right);
        if(leftAns == null)
        {
            rightAns.add(root.data);
            return rightAns;
        }
        if(rightAns == null)
        {
            leftAns.add(root.data);
            return leftAns;
        }
        if(leftAns.size() > rightAns.size())
        {
            leftAns.add(root.data);
            return leftAns;
        }
        else
        {
            rightAns.add(root.data);
            return rightAns;
        }
    }
}