/*
Problem Statement :
You have been given a singly linked list of integers along with two integers, 'i,' and 'j.' 
Swap the nodes that are present at the 'i-th' and 'j-th' positions.

Note :
Remember, the nodes themselves must be swapped and not the datas.
No need to print the list, it has already been taken care. Only return the new head to the list.
*/


public class Solution 
{
     public static  LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head,int i,int j)
     {
      
	if(head==null)
    	    return null;
    	if (i == j)  
            return head;  
  
    	LinkedListNode<Integer> element1 = null;
        LinkedListNode<Integer> element2 = null;  
  	LinkedListNode<Integer> temp = head;
     	int count = 1;
        //keep track of just previous node.
    	while(temp.next!=null) 
        {  
            if(count == i) 
            {  
            	element1 = temp;  
            }  
            else if(count == j) 
            {  
            	element2 = temp;  
            }  
  	    count = count + 1;
       	    temp = temp.next;
    	}  
  
    	if(element1 != null &&  element2 != null) 
        {  
    		temp = element1.next;  
    		element1.next = element2.next;  
    		element2.next = temp;      
    		temp = element1.next.next;  
    		element1.next.next = element2.next.next;  
    		element2.next.next = temp;  
    	}  
    	return head; 
    } 
}
     

/* Alternate Approach

import java.util.*;
public class Solution
{
    public static  LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head,int i,int j)
    {
        if(head == null)
            return null;
        if(i == j)
            return head;
        int tempValI = i;
        int tempValJ = j;
        i = Math.min(tempValI, tempValJ);
        j = Math.max(tempValI, tempValJ);      //i will be always less than j.  //i can be 0. //j can't be 0.
        int count = 0;
        LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> element1 = null;
        LinkedListNode<Integer> prevElement1 = null;
        LinkedListNode<Integer> element2 = null;
        LinkedListNode<Integer> prevElement2 = null;
        LinkedListNode<Integer> tempElement = null;
        while(count <= j)
        {
            if(i != 0 && count == i-1)
            {
		prevElement1 = temp;
            }
	    if(count == i)
            {
                element1 = temp;
            }
            if(count == j-1)
            {
                prevElement2 = temp;
            }
            if(count == j)
            {
		element2 = temp;
            }
            temp = temp.next;
            count = count + 1;
        }
        if(i == 0 && (j-i) == 1)    //i is head and i & j are adjacent elements.
        {
            tempElement = element2.next;
            element2.next = element1;
            element1.next = tempElement;
            head = element2;
        }
        else if(i == 0)          //i is head and i & j are not adjacent elements.
        {
            tempElement = element2.next;
            element2.next = element1.next;
            element1.next = tempElement;
            prevElement2.next = element1;
            head = element2;
        }
        else if((j-i) == 1)      //i is not head and i & j are adjacent elements.
        {
            tempElement = element2.next;
            element2.next = element1;
            prevElement1.next = element2;
            element1.next = temp;
        }
        else       //i is not head and i & j are not adjacent elements.
        {
            tempElement = element2.next;
            element2.next = element1.next;
            prevElement1.next = element2;
            prevElement2.next = element1;
            element1.next = tempElement;
        }
        return head;
    }
}

*/
