/*
Problem Statement :
Given a BST and an integer k. Find and return the path from the node with data k and root 
(if a node with data k is present in given BST) in a list. Return empty list otherwise.

Note: Assume that BST contains all unique elements.
*/


import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data)
    {
	if(root == null)
        {
            return null;
        }
        if(root.data == data)
        {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }
        if(data < root.data)
        {
	    ArrayList<Integer> leftOutput = getPath(root.left, data);
            if(leftOutput != null)   //data found in left subtree.
            {
                leftOutput.add(root.data);
                return leftOutput;
            }
        }
        else
        {
            ArrayList<Integer> rightOutput = getPath(root.right, data);
            if(rightOutput != null)     //data found in right subtree.
            {
                rightOutput.add(root.data);
                return rightOutput;
            }
        }
        return null;  //data not found
    }
}