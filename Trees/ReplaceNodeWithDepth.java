/*
Problem Statement :
In a given Generic Tree, replace each node with its depth value. 
You need to just update the data of each node, no need to return or print anything.
*/

public class Solution 
{
    public static void replaceWithDepthValue(TreeNode<Integer> root)
    {
	replaceWithDepthValue(root, 0);
    }
	   
    //helper function
    public static void replaceWithDepthValue(TreeNode<Integer> root, int k)
    {
        if(root == null)
            return;
        root.data = k;
        for(int i = 0; i < root.children.size(); i++)
        {
            replaceWithDepthValue(root.children.get(i), k+1);
        }
    }
}
