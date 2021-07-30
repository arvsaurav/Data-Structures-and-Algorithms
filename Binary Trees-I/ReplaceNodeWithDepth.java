/*
Problem Statement :
For a given a Binary Tree of integers, replace each of its data with the depth of the tree.
Root is at depth 0, hence the root data is updated with 0. Replicate the same further going 
down the in the depth of the given tree.
*/



public class Solution {

	public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
	    //Your code goes here
        changeToDepthTree(root, 0);
        
	}
    
    public static void changeToDepthTree(BinaryTreeNode<Integer> root, int k)
    {
        if(root == null)
            return;
        root.data = k;
        changeToDepthTree(root.left, k+1);
        changeToDepthTree(root.right, k+1);
    }

}