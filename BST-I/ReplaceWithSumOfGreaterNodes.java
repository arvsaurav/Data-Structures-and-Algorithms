/*
Problem Statement :
Given a binary search tree, you have to replace each node's data with the sum of all nodes which are greater or equal than it. 
You need to include the current node's data also.
That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) and all nodes 
whose data is greater than or equal to 5.

Note: You don't need to return or print, just change the data of each node.
*/


public class Solution 
{
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) 
    {
	int sum = replace(root, 0);
    }
    
    //this function will return sum of tree.
    // sum -> sum of nodes greater than current node
    public static int replace(BinaryTreeNode<Integer> root, int sum)
    {
        if(root == null)
        {
            return 0;
        }
        int rightSubtreeSum = replace(root.right, sum);
        int temp = root.data;    // temp will store the initial value of current node.
        root.data = root.data + rightSubtreeSum + sum;
        int leftSubtreeSum = replace(root.left, root.data);
        return leftSubtreeSum + rightSubtreeSum + temp;
    }
}