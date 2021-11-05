/*
Problem Statement :
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).


Problem Link : https://leetcode.com/problems/symmetric-tree/
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode leftSubTree, TreeNode rightSubTree) {
        if(leftSubTree == null && rightSubTree == null) {
            return true;
        }
        if(leftSubTree == null && rightSubTree != null) {
            return false;
        }
        if(leftSubTree != null && rightSubTree == null) {
            return false;
        }
        
        boolean subAns1 = isSymmetric(leftSubTree.left, rightSubTree.right);
        boolean subAns2 = isSymmetric(leftSubTree.right, rightSubTree.left);
        if(leftSubTree.val == rightSubTree.val && subAns1 && subAns2) {
            return true;
        }
        return false;
    }   
}