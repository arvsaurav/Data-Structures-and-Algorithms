/*
Problem Statement :
Given the head of a linked list, rotate the list to the right by k places.

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Input: head = [0,1,2], k = 4
Output: [2,0,1]

Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        if(length == 0)
        {
            return head;
        }
        // to handle k > length of ll
        k = k % length;
        temp = head;
        ListNode head1 = null;
        int count = 0;
        while(temp != null)
        {
            count++;
            if(count == length-k)
            {
                head1 = temp.next;
                temp.next = null;
            }
            temp = temp.next;
        }
        ListNode tail = head1;
        while(tail != null && tail.next != null)
        {
            tail = tail.next;
        }
        
        if(tail != null)
        {
            tail.next = head;
        }
        if(head1 != null)
        {
            head = head1;
        }
        return head;
    }
}