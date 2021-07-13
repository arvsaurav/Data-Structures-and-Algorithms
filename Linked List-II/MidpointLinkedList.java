/*
Problem Statement :
For a given singly linked list of integers, find and return the node present at the middle of the list.
*/


public class Solution {
    
    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) 
    {
        //Your code goes here
        if(head == null)
            return null;
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while(fast.next != null && fast.next.next != null)   
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}