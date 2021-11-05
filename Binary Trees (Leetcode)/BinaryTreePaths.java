/*
Problem Statement :
Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

Problem Link : https://leetcode.com/problems/binary-tree-paths/
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> output = new ArrayList<>();
        path(root, "", output);
        return output;
    }
    
    public void path(TreeNode root, String outputSoFar, List<String> output)
    {
        if(root == null)
        {
            return;
        }
        if(root.left == null && root.right == null)
        {
            outputSoFar += root.val;
            output.add(outputSoFar);
            return;
        }
        outputSoFar += root.val + "->";
        path(root.left, outputSoFar, output);
        path(root.right, outputSoFar, output);
    }
}