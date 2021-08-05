/*
Problem Statement :
Given a sorted integer array A of size n, which contains all unique elements. 
You need to construct a balanced BST from this input array. Return the root of constructed BST.

Note: If array size is even, take first mid as root.
*/


public class Solution 
{
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n)
    {
	return SortedArrayToBST(arr, 0, n-1);
    }
    
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int startIndex, int endIndex)
    {
	if(startIndex > endIndex)
        {
	    return null;
        }
        int midIndex = ((endIndex - startIndex) / 2) + startIndex; 
        int midElement = arr[midIndex];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(midElement);
        BinaryTreeNode<Integer> leftSubtree = SortedArrayToBST(arr, startIndex, midIndex - 1);
        BinaryTreeNode<Integer> rightSubtree = SortedArrayToBST(arr, midIndex + 1, endIndex);
        root.left = leftSubtree;
        root.right = rightSubtree;
        return root;
    }
}