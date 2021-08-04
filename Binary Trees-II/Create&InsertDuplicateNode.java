/*
Problem Statement :
For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.
The root will remain the same. So you just need to insert nodes in the given Binary Tree.
*/



public class Solution 
{
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) 
    {
	if(root == null)
        {
            return;
        }
        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(root.data);
        newNode.left = root.left;
        root.left = newNode;
    }
	
}