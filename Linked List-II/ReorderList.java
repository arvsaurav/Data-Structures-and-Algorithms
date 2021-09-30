/*
LeetCode Problem :

Problem Statement :
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Constraints:
The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
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
    public void reorderList(ListNode head) {
        int size = 0;
        int mid, i;
        ListNode temp = head;
        while(temp != null)
        {
            size += 1;
            temp = temp.next;
        }
        mid = size / 2;
        temp = head;
        for(i = 0; i < mid; i++)
        {
            temp = temp.next;
        }
        ListNode head2 = temp.next;
        temp.next = null;
        ListNode head1 = head;
        ListNode prev, current, nxt;
        prev = null;
        nxt = null;
        current = head2;
        while(current != null)
        {
            nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
        }
        head2 = prev;
        ListNode temp1, temp2, next1, next2;
        temp1 = head1;
        temp2 = head2;
        while(temp1 != null && temp2 != null)
        {
            next1 = temp1.next;
            temp1.next = temp2;
            next2 = temp2.next;
            temp2.next = next1;
            temp1 = next1;
            temp2 = next2;
        }
        head = head1;
        
    }
}
