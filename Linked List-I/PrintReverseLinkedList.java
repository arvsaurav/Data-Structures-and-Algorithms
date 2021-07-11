/*
Problem Statement :
You have been given a singly linked list of integers. Write a function to print the list in a reverse order.
To explain it further, you need to start printing the data from the tail and move towards the head of the list, 
printing the head data at the end.
*/


public class Solution {

	public static void printReverse(LinkedListNode<Integer> head) 
    {
		if(head == null)
            return;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> nxt = head.next;
        //reversing linked list
        while(current.next != null)
        {
			current.next = prev;
            prev = current;
            current = nxt;
            nxt = nxt.next;
        }
        current.next = prev;
        head = current;
        //printing the linked list
        current = head;
        while(current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
	}

}