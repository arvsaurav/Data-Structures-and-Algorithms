/*
Problem Statement :
Given a singly linked list of integers, reverse the nodes of the linked list 'k' at a time and return its modified list.
'k' is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of 'k,' then left-out nodes, in the end, should be reversed as well.

Example :
Given this linked list: 1 -> 2 -> 3 -> 4 -> 5

For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5

For k = 3, you should return: 3 -> 2 -> 1 -> 5 -> 4
*/




public class Solution {

	public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		//Your code goes here
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> nxt = null;
        int count = 0;
        if(head == null || k == 0)
        {
            return head;
        }
        //our task is to reverse first k elements and remaining will be done by recursion.
        //out task.
        while(current != null && count < k)
        {
            nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
            count += 1;
        }
        //here prev will point ot the new updated head.
        //original head is pointing to the tail of the reversed linked list. 
        
        //task of recursion.
        if(nxt != null)     // if linked list is not fully traversed.
        {
            head.next = kReverse(nxt, k);      //here, we have joined tail of l.l. reversed by us to the new reversed
                                               //head by recursion.
        }
        
        return prev;
        
    }
}