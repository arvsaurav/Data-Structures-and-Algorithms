/*
Problem Statement :
You have been given a head to a singly linked list of integers. Write a function check to whether the list given is a 'Palindrome' or not.
*/


public class Solution {

	public static boolean isPalindrome(LinkedListNode<Integer> head) 
    {
		//Your code goes here
        if(head == null || head.next == null)
        {
			return true;
        }
        LinkedListNode<Integer> head1;
        LinkedListNode<Integer> head2;
        LinkedListNode<Integer> temp1 = head;
        LinkedListNode<Integer> temp2 = head;
        
        //splitting linked list from mid
        int count = 0;
        while(temp1 != null)
        {
			count++;
            if(count%2 != 0 && count != 1)
            {
				temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        head1 = head;
        head2 = temp2.next;
        temp2.next = null;
        
        //now, reverse 2nd linked list
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = head2;
        LinkedListNode<Integer> nxt = head2.next;
        while(current.next != null)
        {
			current.next = prev;
            prev = current;
            current = nxt;
            nxt = nxt.next;
        }
        current.next = prev;
        head2 = current;
        
        //comparing both linked lists
        while(head1 != null && head2 != null)
        {
            if(head1.data != head2.data)
            {
				return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
	}

}