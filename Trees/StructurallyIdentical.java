/*
Problem Statement :
Given two Generic trees, return true if they are structurally identical 
i.e. they are made of nodes with the same values arranged in the same way.
*/


public class Solution 
{	
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2)
    {
	if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)  //any one root is null and other root is not null
            return false;

        if(root1.data != root2.data)
            return false;
        if(root1.children.size() != root2.children.size())
            return false;
        boolean ans = true;
        for(int i = 0; i < root1.children.size(); i++)
        {
            ans = checkIdentical(root1.children.get(i), root2.children.get(i));
            if(!ans)
                break;
        }
        return ans;
    }
	
}
