/*
Problem Statement :
Given a Singly Linked List of integers, delete all the alternate nodes in the list.

Example:
List: 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> null
Alternate nodes will be:  20, 40, and 60.

Hence after deleting, the list will be:
Output: 10 -> 30 -> 50 -> null

Note :
The head of the list will remain the same. Don't need to print or return anything.
*/



public class Solution 
{
    public static void deleteAlternateNodes(Node<Integer> head)
    {
        Node<Integer> current = head;
        Node<Integer> prev = null;
        while(current != null && current.next != null)
        {
            prev = current;
            current = current.next.next;
            prev.next = current;
        }
    }
}


