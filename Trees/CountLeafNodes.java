/*
Problem Statement :
Given a generic tree, count and return the number of leaf nodes present in the given tree.
*/


public class Solution 
{	
    public static int countLeafNodes(TreeNode<Integer> root)
    {
	if(root == null)
            return 0;
        if(root.children.size() == 0)
            return 1;
        int countLeaf = 0;
        for(int i = 0; i < root.children.size(); i++)
        {
            countLeaf = countLeaf + countLeafNodes(root.children.get(i));
        }
        return countLeaf;
    }
}
