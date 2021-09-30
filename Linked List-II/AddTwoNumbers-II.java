/*
LeetCode Problem :
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their 
nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]

Input: l1 = [0], l2 = [0]
Output: [0]

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 

Follow up: Could you solve it without reversing the input lists?
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

import java.util.Stack;
class Solution {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) 
    {
        // Solve it without reversing ll
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode temp1 = head1;
        while(temp1 != null)
        {
            s1.push(temp1.val);
            temp1 = temp1.next;
        }
        ListNode temp2 = head2;
        while(temp2 != null)
        {
            s2.push(temp2.val);
            temp2 = temp2.next;
        }
        
        int carry = 0;
        ListNode head = null;
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            int sum = 0;
            if(!s1.isEmpty())
            {
                sum += s1.pop();
            }
            if(!s2.isEmpty())
            {
                sum += s2.pop();
            }
            sum += carry;
            int value = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(value);
            newNode.next = head;
            head = newNode;
        }
        if(carry == 1)
        {
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}