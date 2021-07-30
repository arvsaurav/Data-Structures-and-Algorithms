/* 
Problem Statement :
For a given Binary Tree of type integer, print all the nodes without any siblings.
*/


public class Solution 
{

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) 
    {
        if(root == null)
            return;
        if(root.left == null && root.right != null)
            System.out.print(root.right.data + " ");
        if(root.left != null && root.right == null)
            System.out.print(root.left.data + " ");
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }

}