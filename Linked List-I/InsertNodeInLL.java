/*
Problem Statement :
You have been given a singly linked list of integers, an integer value called 'data' and a position with the name 'pos.'
 Write a function to add a node to the list with the 'data' at the specified position, 'pos.'
*/


public class Solution {

	public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int pos, int data)
    {
		//Your code goes here
        int i = 1;
        LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
 		LinkedListNode<Integer> temp = head;
        if(pos == 0)
        {
            newNode.next = head;
            head = newNode;
            return head;
        }
        while(temp.next != null)
        {
			if(pos == i)
                break;
            i++;
            temp = temp.next;
        }
        if(pos <= i)
        {
        	newNode.next = temp.next;
        	temp.next = newNode;
        }
        return head;
	}
}