/*
Problem Statement :
Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S.

Note:
1. Assume BST contains all unique elements.
2. In a pair, print the smaller element first.
*/



import java.util.ArrayList;
import java.lang.Math;
public class Solution 
{
    public static ArrayList<Integer> arr = new ArrayList<>();
    
    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) 
    {
        inOrder(root);   //it will create sorted arraylist.
        int i = 0;
        int j = arr.size() - 1;
        while(i < j)
        {
            if(arr.get(i)+arr.get(j) == s)
            {
                System.out.println(Math.min(arr.get(i), arr.get(j)) + " " + Math.max(arr.get(i), arr.get(j)));
                i++;
                j--;
            }
            else if(arr.get(i)+arr.get(j) > s)
            {
                j--;
            }
            else   // if arr.get(i)+arr.get(j) < s
            {
                i++;
            }
        }
        
    }
    
    public static void inOrder(BinaryTreeNode<Integer> root)
    {
	if(root == null)
            return;
        inOrder(root.left);
        arr.add(root.data);
        inOrder(root.right);
    }

}