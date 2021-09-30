/*
LeetCode Problem :

Problem Statement :
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their 
nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [0], l2 = [0]
Output: [0]

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
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

import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        int i = 0;
        BigInteger num1 = new BigInteger("0");
        while(temp1 != null){
            BigInteger pow = power(10, i);
            BigInteger num = pow.multiply(BigInteger.valueOf(temp1.val));
            num1 = num1.add(num);
            temp1 = temp1.next;
            i++;
        }
        
        ListNode temp2 = l2;
        i = 0;
        BigInteger num2 = new BigInteger("0");
        while(temp2 != null){
            BigInteger pow = power(10, i);
            BigInteger num = pow.multiply(BigInteger.valueOf(temp2.val));
            num2 = num2.add(num);
            temp2 = temp2.next;
            i++;
        }
        
        BigInteger sum = new BigInteger("0");
        sum = num1.add(num2);
        
        ListNode head = new ListNode(sum.mod(BigInteger.valueOf(10)).intValue());
        ListNode temp = head;
        sum = sum.divide(BigInteger.valueOf(10));
        while(!sum.equals(BigInteger.valueOf(0))){
            ListNode currNode = new ListNode(sum.mod(BigInteger.valueOf(10)).intValue());
            temp.next = currNode;
            temp = currNode;
            sum = sum.divide(BigInteger.valueOf(10));
        }
        return head;
    }
    
    public static BigInteger power(int a, int n)
    {
        if(n == 0){
            BigInteger ans = new BigInteger("1");
            return ans;
        }
        BigInteger ans = BigInteger.valueOf(a).multiply(power(a, n-1));
        return ans;
    }
}