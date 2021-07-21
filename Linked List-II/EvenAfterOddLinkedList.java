/*
Problem Statement :
For a given singly linked list of integers, arrange the elements such that all the even numbers are 
placed after the odd numbers. The relative order of the odd and even terms should remain unchanged.

Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
*/


public class Solution {

	public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) 
  	{
        	LinkedListNode<Integer> oddHead = null;
        	LinkedListNode<Integer> oddTail = null;
        	LinkedListNode<Integer> evenHead = null;
        	LinkedListNode<Integer> evenTail = null;
        	if(head == null)
        	{
            		return null;
		}
        	//separating odd and even linked list
        	while(head != null)
        	{
        	    	if(head.data % 2 == 0)   //even
            		{
				if(evenHead == null)
                		{
                    			evenHead = head;
                		}
                		if(evenTail != null)
                		{
					evenTail.next = head;
                		}
                		evenTail = head;
                		head = head.next;
                		evenTail.next = null;
            		}
            		else   //odd
            		{
				if(oddHead == null)
                		{
                    			oddHead = head;
                		}
                		if(oddTail != null)
                		{
                    			oddTail.next = head;
                		}
                		oddTail = head;
                		head = head.next;
                		oddTail.next = null;
            		}
        	}
        	//joining both linked list
        	if(oddTail != null)
        	{
			oddTail.next = evenHead;
        		head = oddHead;
        	}
        	else
        	{
            		head = evenHead;
        	}
        	return head;
	}
}