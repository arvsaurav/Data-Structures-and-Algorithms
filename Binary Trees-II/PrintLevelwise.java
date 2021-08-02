/*
Problem Statement :
For a given a Binary Tree of type integer, print the complete information of every node, 
when traversed in a level-order fashion.
*/



import java.util.Queue;
import java.util.LinkedList;
public class Solution 
{
	public static void printLevelWise(BinaryTreeNode<Integer> root) 
    {
		if(root == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
			BinaryTreeNode<Integer> temp = queue.remove();
            System.out.print(temp.data + ":");
            if(temp.left == null)
            {
                System.out.print("L:-1,");
            }
            if(temp.left != null)
            {
                System.out.print("L:" + temp.left.data + ",");
                queue.add(temp.left);
            }
            if(temp.right == null)
            {
                System.out.println("R:-1");
            }
            if(temp.right != null)
            {
                System.out.println("R:" + temp.right.data);
                queue.add(temp.right);
            }
        }
	}
	
}