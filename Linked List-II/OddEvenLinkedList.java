/*
LeetCode Problem :

Problem Statement :
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return 
the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]

Constraints:
n == number of nodes in the linked list
0 <= n <= 104
-106 <= Node.val <= 106
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
    public ListNode oddEvenList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode head1 = null;
        ListNode odd = null;
        ListNode head2 = null;
        ListNode even = null;
        ListNode temp = head;
        int count = 1;
        while(temp != null)
        {
            if(count % 2 != 0)
            {
                if(head1 == null)
                {
                    head1 = temp;
                    odd = temp;
                }
                else
                {
                    odd.next = temp;
                    odd = temp;
                }
            }
            else
            {
                if(head2 == null)
                {
                    head2 = temp;
                    even = temp;
                }
                else
                {
                    even.next = temp;
                    even = temp;
                }
            }
            count++;
            temp = temp.next;
        }
        // to remove cycle from ll
        if(even != null)
        {
            even.next = null;
        }
        odd.next = head2;
        head = head1;
        return head;
    }
}