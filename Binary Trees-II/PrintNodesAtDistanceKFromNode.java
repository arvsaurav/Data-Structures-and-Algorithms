/*
Problem Statement :
You are given a Binary Tree of type integer, a target node, and an integer value K.
Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.
*/


public class Solution
{
    
    public static void printDNodesK(BinaryTreeNode<Integer> root,int k)
    {
	if(root == null)
 	    return;
	if(k == 0)
	{
 	    System.out.println(root.data);
	    return;
	}
	printDNodesK(root.left, k-1);
	printDNodesK(root.right, k-1);
    }
    
    public static int nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) 
    {
        if(root == null)
        {
            return -1;
        }
	        
        if(root.data == node)
        {
            printDNodesK(root, k);
	    return 0;
        }
	        
	int left = nodesAtDistanceK(root.left, node, k);
        //Check if left != n-1
        if(left != -1)
        {
	    if(left + 1 == k)
            { 
                System.out.println(root.data);
            }
            else
            {
	         // if left+1 is not equal to k 
	         // call printNodesAtDepth function print nodes at k - left -2 
	         //ie k = 3 ,   3-0-2 = 1 from root.right
	         printDNodesK(root.right, k-left-2);
            }
            return left + 1;        
        }
	        
        int right = nodesAtDistanceK(root.right, node, k);
        if(right != -1)
        {
            if(right + 1 == k)
            {
                System.out.println(root.data);
            }
            else
            {
                printDNodesK(root.left, k-right-2);
            }
            return right + 1;
        }
        return -1;
    }

}