/*
Problem Statement :
Given a singly linked list of integers, sort it using 'Bubble Sort.'

Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
*/


public class Solution {

	public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
		//Your code goes here
        if(head == null)
            return null;
        LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = null;
        LinkedListNode<Integer> nxt = null;
        int n = 0;  //length of linked list
        int i = 1;
        while(temp != null)
        {
            n += 1;
            temp = temp.next;
        }
        while(i < n)
        {
			current = head;
            prev = null;
            while(current.next != null)
            {
                nxt = current.next;
                if(current.data > nxt.data)
                {
					if(prev == null)
                    {
                        current.next = nxt.next;
                        nxt.next = current;
                        head = nxt;
                    }
                    else
                    {
                        prev.next = nxt;
                        current.next = nxt.next;
                        nxt.next = current;
                    }
                }
                prev = current;
                current = nxt;
            }
            i += 1;
        }
        return head;
	}
}