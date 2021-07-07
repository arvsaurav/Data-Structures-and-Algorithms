/*
Problem Statement :
For a given a singly linked list of integers and a position 'i', print the node data at the 'i-th' position.
*/


public class Solution {

	public static void printIthNode(LinkedListNode<Integer> head, int i)
    {
		//Your code goes here
        LinkedListNode<Integer> temp = head;
        int count = 0;
        while(temp != null)
        {
            if(count == i)
            {
                System.out.println(temp.data);
                break;
            }
            count++;
            temp = temp.next;
        }
	}
}