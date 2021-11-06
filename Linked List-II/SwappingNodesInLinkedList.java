/*

(Leetcode Problem)

Problem Statement :
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

Problem Link : https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
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
    public ListNode swapNodes(ListNode head, int k) {
        int n = lengthOfLL(head);
        if(n <= 1 || n-k+1 == k) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        ListNode prev1 = null;
        ListNode temp1 = null;
        ListNode prev2 = null;
        ListNode temp2 = null;
        int count = 1;
        while(temp != null) {
            if(count == k || count == n-k+1) {
                if(temp1 == null) {
                    prev1 = prev;
                    temp1 = temp;
                }
                else {
                    prev2 = prev;
                    temp2 = temp;
                }
            }
            prev = temp;
            temp = temp.next;
            count++;
        }
        if(prev1 == null) {
            head = temp2;
        }
        else {
            prev1.next = temp2;
        }
        ListNode nxt = temp2.next;
        if(temp1 == prev2) {
            temp2.next = temp1;
        }
        else {
            temp2.next = temp1.next;
            prev2.next = temp1;
        }
        temp1.next = nxt;
        return head;
    }
    
    public int lengthOfLL(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}