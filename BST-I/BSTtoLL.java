/*
Problem Statement :
Given a BST, convert it into a sorted linked list. You have to return the head of LL.
*/


public class Solution {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	 * right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */

	/*
	 * LinkedList Node Class
	 *
	 * 
	 * class LinkedListNode<T> { T data; LinkedListNode<T> next;
	 * 
	 * public LinkedListNode(T data) { this.data = data; } }
	 */

    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) 
    {
	if(root == null)
        {
            return null;
        }
        LinkedListNode<Integer> headLeftLL = constructLinkedList(root.left);
        LinkedListNode<Integer> temp = new LinkedListNode<>(root.data);
        LinkedListNode<Integer> headRightLL = constructLinkedList(root.right);
        LinkedListNode<Integer> head = temp;  //if there is no leftsubtree
        temp.next = headRightLL;
        if(headLeftLL != null)
        {
            LinkedListNode<Integer> tailLeftLL = headLeftLL;
            while(tailLeftLL.next != null)
            {
		tailLeftLL = tailLeftLL.next;
            }
            head = headLeftLL;
            tailLeftLL.next = temp;
        }
        return head;
    }
}