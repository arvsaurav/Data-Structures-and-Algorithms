/*
Problem Statement :
Given a large number represented in the form of a linked list. Write code to increment the number 
by 1 in-place(i.e. without using extra space).

Note: You don't need to print the elements, just update the elements and return the head of updated LL.
*/


/*************** 
 * Following is the Node class already written 
class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}
}
 ***************/

public class Solution {


    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) 
    {
   	LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> nxt = null;
        if(head == null)
            return head;
        while(current != null)
        {
            nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
        }
        head = prev;     //new head of reversed linked list.
        current = head;
        int carry = 0;
        while(current != null)
        {
            if(current == head)
            {
            	if(head.data == 9)
            	{
                	head.data = 0;
                	carry = 1;
                	current = current.next;
                	continue;
            	}
            	else
            	{
                	head.data = head.data + 1;
                	carry = 0;
                	current = current.next;
                	continue;
            	}
            }
            if(carry == 1 && current.data == 9)
            {
                current.data = 0;
                carry = 1;
            }
            else if(carry == 1 && current.data != 9)
            {
                current.data = current.data + 1;
                carry = 0;
            }
            else
            {
                carry = 0;
                break;
            }
            current = current.next;
        }
        current = head;
        prev = null;
        nxt = null;
        while(current != null)      //again reverse the linked list.
        {
            nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
        }
        head = prev;
        if(carry == 1)
        {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(1);
            newNode.next = head;
            head = newNode;
            carry = 0;
        }
        return head;
    }


}
