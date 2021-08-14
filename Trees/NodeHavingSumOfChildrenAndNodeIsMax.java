/*
Problem Statement :
Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. 
In the sum, data of node itself and data of immediate children is to be taken.
*/


public class Solution 
{
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root)
    {
	Pair ans = returnMaxNode(root);
        return ans.node;
    }	
    
    public static Pair returnMaxNode(TreeNode<Integer> root)
    {
	if(root == null)
            return null;
        TreeNode<Integer> maxNode = root;
        int maxSum = root.data;
        for(int i = 0; i < root.children.size(); i++)
        {
	    maxSum = maxSum + root.children.get(i).data;
        }
        for(int i = 0; i < root.children.size(); i++)
        {
	    Pair ans = returnMaxNode(root.children.get(i));
            if(ans.sum > maxSum)
            {
                maxSum = ans.sum;
                maxNode = ans.node;
            }
        }
        Pair pair = new Pair(maxNode, maxSum);
        return pair;
    }
}

class Pair
{
    TreeNode<Integer> node;
    int sum;
    public Pair(TreeNode<Integer> node, int sum)
    {
        this.node = node;
        this.sum = sum;
    }
}
