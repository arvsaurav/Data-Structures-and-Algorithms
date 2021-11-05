/*
Problem Statement : 
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Problem Link : https://leetcode.com/problems/minimum-depth-of-binary-tree/
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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // root is the leaf node
        if(root.left == null && root.right == null) {
            return 1;
        }
        if(root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        if(root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        // if root.left != null && root.right != null
        int subAns1 = minDepth(root.left);
        int subAns2 = minDepth(root.right);
        return 1 + Math.min(subAns1, subAns2);
    }
}