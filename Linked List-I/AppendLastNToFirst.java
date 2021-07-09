/*
Problem Statement :
You have been given a singly linked list of integers along with an integer 'N'. 
Write a function to append the last 'N' nodes towards the front of the singly linked list and returns the new head to the list.
*/


public class Solution {

	public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) 
    {
		//Your code goes here
        LinkedListNode<Integer> temp1 = head;
        LinkedListNode<Integer> temp2 = head;
        int count = 0;
        if(head == null)
            return null;
        while(temp1.next != null)
        {
            count++;
            if(count <= n)
            {
                temp1 = temp1.next;
            }
            else
            {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        temp1.next = head;
        head = temp2.next;
        temp2.next = null;
        return head;
	}
}


