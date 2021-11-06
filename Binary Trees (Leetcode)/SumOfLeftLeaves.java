/*
Problem Statement :
Given the root of a binary tree, return the sum of all left leaves.

Problem Link : https://leetcode.com/problems/sum-of-left-leaves/
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }    
        
        int subAns1 = sumOfLeftLeaves(root.left);
        int subAns2 = sumOfLeftLeaves(root.right);
        
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) {
                return root.left.val + subAns1 + subAns2;
            }
        }
        return subAns1 + subAns2;
    }
}