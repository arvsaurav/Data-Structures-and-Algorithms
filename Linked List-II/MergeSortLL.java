/*
Problem Statement :
Given a singly linked list of integers, sort it using 'Merge Sort.'
*/


public class Solution 
{

    public static LinkedListNode<Integer> midPointBreak(LinkedListNode<Integer> head) 
    {
        if(head == null)
            return null;
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> temp = null;
        while(fast.next != null && fast.next.next != null)   
        {
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;
        }
        if(fast.next == null)   //length is odd
        {
            temp.next = null;
        }
        else     //length is even
        {
			temp = slow;
            slow = slow.next;
            temp.next = null;
        }
        return slow;
    }
    
    public static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) 
    {
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
    
	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) 
    {
        //base case
        if(head == null || head.next == null)
        {
            return head;
        }
        
		LinkedListNode<Integer> head1 = head;
        LinkedListNode<Integer> head2 = midPointBreak(head);
        
        LinkedListNode<Integer> sortedHead1 = mergeSort(head1);
        LinkedListNode<Integer> sortedHead2 = mergeSort(head2);
        LinkedListNode<Integer> finalHead = merge(sortedHead1, sortedHead2);
        return finalHead;
	}

    
}