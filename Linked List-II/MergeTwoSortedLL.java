/*
Problem Statement :
You have been given two sorted(in ascending order) singly linked lists of integers.
Write a function to merge them in such a way that the resulting singly linked list is also 
sorted(in ascending order) and return the new head to the list.
*/


public class Solution {
    
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) 
    {
        //Your code goes here
        LinkedListNode<Integer> tail = null;
        LinkedListNode<Integer> head = null;
        if(head1 == null)
        {
			if(head2 == null)
            {
				return null;
            }
            else
            {
                return head2;
            }
        }
        else if(head2 == null)
        {
            return head1;
        }
        else
        {
			if(head1.data <= head2.data)
            {
                head = head1;
            }
            else
            {
                head = head2;
            }
        }
        
        while(head1 != null && head2 != null)
        {
			if(head1.data <= head2.data)
            {
				if(tail != null)
                {
                    tail.next = head1;
                }
                tail = head1;
                head1 = head1.next;
            }
            else
            {
                if(tail != null)
                {
					tail.next = head2;
                }
                tail = head2;
                head2 = head2.next;
            }
        }
		if(head1 == null)
        {
			tail.next = head2;
        }
    	else
        {
            tail.next = head1;
        }
        return head;
    }

}