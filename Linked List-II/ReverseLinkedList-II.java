/*
LeetCode Problem :

Problem Statement :
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position 
left to position right, and return the reversed list.

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Input: head = [5], left = 1, right = 1
Output: [5]

Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        ListNode temp = head;
        ListNode prev = null;
        ListNode nxt = null;
        int count = 0;
        ListNode head1 = null;
        ListNode prev1 = null;
        ListNode tail1 = null;
        ListNode tailNext1 = null;
        while(temp != null)
        {
            count++;
            if(count == left)
            {
                prev1 = prev;
                head1 = temp;
            }
            if(count == right)
            {
                tail1 = temp;
                tailNext1 = temp.next;
            }
            prev = temp;
            temp = temp.next;
        }
        if(prev1 != null){
            prev1.next = null;
        }
        tail1.next = null;
        LinkedListDetail ll = reverse(head1);
        if(prev1 != null){
            prev1.next = ll.head;
        }
        else{
            head = ll.head;
        }
        ll.tail.next = tailNext1;
        return head;
    }
    
    // helper function to reverse a given linked list
    public LinkedListDetail reverse(ListNode head)
    {
        ListNode temp = head;
        ListNode prev = null;
        ListNode nxt = null;
        while(temp != null)
        {
            nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
        }
        ListNode tail = head;
        head = prev;
        LinkedListDetail ll = new LinkedListDetail(head, tail);
        return ll;
    }
}

class LinkedListDetail
{
    ListNode head;
    ListNode tail;
    public LinkedListDetail(ListNode head, ListNode tail)
    {
        this.head = head;
        this.tail = tail;
    }
}