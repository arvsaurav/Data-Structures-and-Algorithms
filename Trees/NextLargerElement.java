/*
Problem Statement :
Given a generic tree and an integer n. Find and return the node with next larger element in the Tree 
i.e. find a node with value just greater than n.
*/



public class Solution 
{
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n)
    {
        Pair ans = nextLargerNodeHelper(root, n);
        return ans.nextLargerNode;    
    }

    //helper function.
    public static Pair nextLargerNodeHelper(TreeNode<Integer> root, int n)
    {
        if(root == null)
            return null;
        TreeNode<Integer> nextLargerNode = null;
        int nextLargerValue = Integer.MIN_VALUE;
        if(root.data > n)
        {
            nextLargerValue = root.data;
            nextLargerNode = root;
        }
        for(int i = 0; i < root.children.size(); i++)
        {
            Pair ans = nextLargerNodeHelper(root.children.get(i), n);
            if(ans.nextLargerValue > n)
            {
    		if(nextLargerNode != null)
                {
                    if(ans.nextLargerValue < nextLargerValue)
                    {
			nextLargerValue = ans.nextLargerValue;
               		nextLargerNode = ans.nextLargerNode;
                    }
                }
                else
                {
                    nextLargerValue = ans.nextLargerValue;
               	    nextLargerNode = ans.nextLargerNode;
                }
                
            }
        }
        Pair pair = new Pair(nextLargerNode, nextLargerValue);
        return pair;
    }
	
}

class Pair
{
    TreeNode<Integer> nextLargerNode;
    int nextLargerValue;
    public Pair(TreeNode<Integer> nextLargerNode, int nextLargerValue)
    {
        this.nextLargerNode = nextLargerNode;
        this.nextLargerValue = nextLargerValue;
    }
}
