/*
Problem Statement :
You have been given a singly linked list of integers where the elements are sorted in ascending order. 
Write a function that removes the consecutive duplicate values such that the given list only contains 
unique elements and returns the head to the updated list.
*/


public class Solution {

 	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) 
     {
 		//Your code goes here
         if(head == null)
         {
             return null;
         }
         LinkedListNode<Integer> temp1 = head.next;
         LinkedListNode<Integer> temp2 = head;
         while(temp1 != null)
         {
			if(temp1.data.equals(temp2.data))
            {
				if(temp1.next == null)
                {
					temp2.next = null;
                }
                temp1 = temp1.next;    
            }
            else
            {
                temp2.next = temp1;
                temp2 = temp1;
                temp1 = temp1.next;
            }
         }
         return head;
 	}

}
/*
public class Solution {

	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
		//Your code goes here
         if(head==null)
         {
            return head;
        }
            
		LinkedListNode<Integer> temp = head;
        
        while(temp.next != null)
        {
            if(temp.data.equals(temp.next.data))
            {
                temp.next = temp.next.next;
            }
            else
            {
                temp = temp.next;
            }
        }
        return head;
    }
    }
*/