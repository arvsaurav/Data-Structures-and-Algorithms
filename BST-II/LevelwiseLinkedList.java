/*
Problem Statement :
Given a binary tree, write code to create a separate linked list for each level. 
You need to return the array which contains head of each level linked list.
*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution 
{
	/*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 	T data; 
	 * 	BinaryTreeNode<T> left; 
	 * 	BinaryTreeNode<T> right;
	 *	public BinaryTreeNode(T data) 
	 *	{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	/*
	 * LinkedListNode Class
	 * class LinkedListNode<T> 
	 * { 
	 * 	T data; 
	 * 	LinkedListNode<T> next;
	 * 	public LinkedListNode(T data) 	
	 * 	{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root)
    {
	if(root == null)
        {
 	    return null;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        ArrayList<LinkedListNode<Integer>> arr = new ArrayList<>();
        while(!queue.isEmpty())
        {
            BinaryTreeNode<Integer> temp = queue.remove();
            LinkedListNode<Integer> currentNode = new LinkedListNode<>(temp.data);
            if(head == null)
            {
                head = currentNode;
                tail = currentNode;
            }
            else
            {
		tail.next = currentNode;
                tail = currentNode;
            }
            if(temp.left != null)
            	queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
            if(queue.peek() == null)
            {
                arr.add(head);
                head = null;
                tail = null;
		if(queue.size() == 1)
                    break;
                queue.remove();
                queue.add(null);
            }
        }
        return arr;
    }

}