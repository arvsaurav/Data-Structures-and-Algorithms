/*
Problem Statement :
Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree. 
You have to return the height of largest BST.
*/


public class Solution 
{
	/*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  			this.data = data; 
	 *  		} 
	 *  }
	 */
	
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) 
    {
	BST ans = largestBST(root);
        return ans.height;
    }
    
    public static BST largestBST(BinaryTreeNode<Integer> root)
    {
     	if(root == null)
        {
            int maximumValue = Integer.MIN_VALUE;
            int minimumValue = Integer.MAX_VALUE;
            boolean isBST = true;
            int height = 0;
            BST ans = new BST(minimumValue, maximumValue, isBST, height);
            return ans;
        }
        BST leftAns = largestBST(root.left);
        BST rightAns = largestBST(root.right);
        
        int maximumValue;
        int minimumValue;
        boolean isBST;
        int height;
        if(leftAns.isBST && rightAns.isBST)
        {
            if(root.data > leftAns.maximumValue && root.data < rightAns.minimumValue)
            {
                isBST = true;
                height = Math.max(leftAns.height, rightAns.height) + 1;
            }
            else
            {
                isBST = false;
                height = Math.max(leftAns.height, rightAns.height);
            }
        }
        else
        {
            isBST = false;
            height = Math.max(leftAns.height, rightAns.height);
        }
        minimumValue = Math.min(root.data, Math.min(leftAns.minimumValue, rightAns.minimumValue));
        maximumValue = Math.max(root.data, Math.max(leftAns.maximumValue, rightAns.maximumValue));
        BST ans = new BST(minimumValue, maximumValue, isBST, height);
        return ans;
    }

}

class BST
{
    int maximumValue;
    int minimumValue;
    boolean isBST;
    int height;  //height of largest BST present in that tree.
    public BST(int minimumValue, int maximumValue, boolean isBST, int height)
    {
	this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        this.isBST = isBST;
        this.height = height;
    }
}