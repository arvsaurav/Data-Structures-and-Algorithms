/*
Problem Statement :
Given a binary search tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes in the BST.

LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants.
*/


public class Solution 
{	
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b)    // assumption : a <= b
    {
        //base case
	if(root == null)
            return -1;
        if(a == root.data && b == root.data)   //if a == b == root.data
        {
            return root.data;
        }
        if(a <= root.data && b >= root.data)    //a is in left subtree and b is in right subtree. Therefore, this node is LCA.
        {
            return root.data;
        }
        int ans;
        if(b < root.data)     //both a & b is present in left subtree.
        {
            ans = getLCA(root.left, a, b);
        }
        else      //both a & b is present in right subtree.
        {
            ans = getLCA(root.right, a, b);
        }
        return ans;
    }
}