/*
Problem Statement :
Given a generic tree and an integer x, check if x is present in the given tree or not. 
Return true if x is present, return false otherwise.
*/


public class Solution 
{
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x)
    {
	if(root == null)
            return false;
        if(root.data == x)
            return true;
        boolean ans = false;
        for(int i = 0; i < root.children.size(); i++)
        {
	    ans = ans || checkIfContainsX(root.children.get(i), x);
        }
	return ans;
    }
	
}
