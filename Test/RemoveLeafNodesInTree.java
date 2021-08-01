/*
Problem Statement :
Remove all leaf nodes from a given generic Tree. Leaf nodes are those nodes, which don't have any children.
Note : Root will also be a leaf node if it doesn't have any child. You don't need to print the tree, 
just remove all leaf nodes and return the updated root.
*/


import java.util.ArrayList;
public class Solution
{
    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root)
    {
        if(root == null || root.children.size() == 0)
        {
            return null;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < root.children.size(); i++)
        {
            TreeNode<Integer> child = root.children.get(i);
            if(child.children.size() == 0)
            {
                arr.add(i);
            }
        }
        for(int i = arr.size() - 1; i >= 0; i--)
        {
            int j = arr.get(i);
            root.children.remove(j);
        }
        for(int i = 0; i < root.children.size(); i++)
        {
            TreeNode<Integer> subAns = removeLeafNodes(root.children.get(i));
            if(subAns == null)
            {
                root.children.remove(i);
            }
        }
        return root;
    }
}