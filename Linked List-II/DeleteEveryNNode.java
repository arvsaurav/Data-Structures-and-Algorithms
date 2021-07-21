/*
Problem Statement :
You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' 
Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes. 
Continue the same until the end of the linked list.
To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.

Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
*/


public class Solution {
	
	public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int m, int n) 
    {
        if(head == null)
            return null;
        if(m == 0)
            return null;
        if(n == 0)
            return head;
        
        LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> tail = head;
        int countM = 0;
        int countN = 0;
        while(temp != null)
        {
            countM = countM + 1;
            if(countM == m)
            {
				tail = temp;
            }
            if(countM > m)
            {
                countN = countN + 1;
            }
            if(countN == n)
            {
				tail.next = temp.next;
                countN = 0;
                countM = 0;
            }
            temp = temp.next;
        }
        
        if(countN != 0)
        {
            tail.next = null;
        }
        return head;
	}
}