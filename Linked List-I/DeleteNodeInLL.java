/*
Problem Statement :
You have been given a linked list of integers. Your task is to write a function that deletes a node from a given position, 'pos'.
*/

public class Solution {

	public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) 
    {
		//Your code goes here
    	int i = 1;
        LinkedListNode<Integer> temp = head;
        if(head == null)
        {
            return null;
        }
        if(pos == 0)
        {
            head = head.next;
            return head;
        }
        while(temp.next != null)
        {
			if(i == pos)
        		break;
            i++;
            temp = temp.next;
        }
        if(pos <= i && temp.next != null)
        {
            temp.next = temp.next.next;
        }
        return head;
	}
}