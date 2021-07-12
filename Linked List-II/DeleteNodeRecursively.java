/*
Problem Statement :
Given a singly linked list of integers and position 'i', delete the node present at the 'i-th' position in the linked list recursively.
*/


public class Solution {


	public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) 
    {
    	//Your code goes here
        if(head == null && pos >= 0)
        {
			return head;
        }
        if(pos == 0)
        {
			head = head.next;
            return head;
        }
        else
        {
			LinkedListNode<Integer> smallHead = deleteNodeRec(head.next, pos - 1);
            head.next = smallHead;
            return head;
        }
	}

}