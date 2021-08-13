/*
Problem Statement :
Given a generic tree, print the post-order traversal of given tree.
The post-order traversal is: visit child nodes first and then root node.
*/



public class Solution 
{
    public static void printPostOrder(TreeNode<Integer> root)
    {
	if(root == null)
            return;
        for(int i = 0; i < root.children.size(); i++)
        {
            printPostOrder(root.children.get(i));
        }
        System.out.print(root.data + " ");
    }

}