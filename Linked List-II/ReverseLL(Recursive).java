/*
Problem Statement :
Given a singly linked list of integers, reverse it using recursion and return the head to the modified list. 
You have to do this in O(N) time complexity where N is the size of the linked list.
*/



public class Solution {

	public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
		//Your code goes here
        if(head == null || head.next == null)
        {
            return head;
        }
        LinkedListNode<Integer> newHead = reverseLinkedListRec(head.next);
        head.next.next = head;
        head.next = null;
        head = newHead;
        return head;
	}

}