/*
Problem Statement :
For a given a Binary Tree of type integer, print it in a level order fashion where each level will be 
printed on a new line. Elements on every level will be printed in a linear fashion and a single space will separate them.
*/


import java.util.Queue;
import java.util.LinkedList;
public class Solution 
{
	public static void printLevelWise(BinaryTreeNode<Integer> root) 
    {
		if(root == null)
        {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);   //to differentiate between levels
        int count = 0;
        while(!queue.isEmpty())
        {
            BinaryTreeNode<Integer> temp = queue.remove();
            System.out.print(temp.data + " ");
            if(temp.left != null)
            {
                queue.add(temp.left);
            }
            if(temp.right != null)
            {
                queue.add(temp.right);
            }
            if(queue.peek() == null)
            {
                if(queue.size() == 1)
                {
                    queue.remove();
                    break;
                }
                System.out.println();
                queue.remove();
                queue.add(null);
            }
        }
	}
	
}