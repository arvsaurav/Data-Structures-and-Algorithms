/*
Problem Statement :
Given a generic tree, find and return the height of given tree.
*/


public class Solution 
{
    public static int getHeight(TreeNode<Integer> root)
    {
	if(root == null)
            return 0;
        int height = 0;
        for(int i = 0; i < root.children.size(); i++)
        {
            int childHeight = getHeight(root.children.get(i));
            if(childHeight > height)
            {
                height = childHeight;
            }
        }
        return 1 + height;   // 1 for root node.
    }

}