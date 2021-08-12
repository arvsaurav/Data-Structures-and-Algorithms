/*
Problem Statement :
Given a tree and an integer x, find and return number of Nodes which are greater than x.
*/


public class Solution 
{	
    public static int numNodeGreater(TreeNode<Integer> root,int x)
    {
	if(root == null)
            return 0;
        int count = 0;
        for(int i = 0; i < root.children.size(); i++)
        {
            count = count + numNodeGreater(root.children.get(i), x);
        }
	if(root.data > x)
            count++;
        return count;
    }
}
