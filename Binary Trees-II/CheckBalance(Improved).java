/*
Problem Statement :
Check if binary tree is balanced or not(Optimised).
*/


import java.util.Scanner;
import java.lang.Math;
public class BalancedTreeReturn {
	int height;
	boolean isBalanced;

}


public class BinaryTree {
	
	
	public static BalancedTreeReturn isTreeBalancedOptimised(BinaryTreeNode<Integer> root)
	{
		//base case
		if(root == null)
		{
			int height = 0;
			boolean isBalanced = true;
			BalancedTreeReturn ans = new BalancedTreeReturn();
			ans.height = height;
			ans.isBalanced = isBalanced;
			return ans;
		}
		BalancedTreeReturn leftOutput = isTreeBalancedOptimised(root.left);
		BalancedTreeReturn rightOutput = isTreeBalancedOptimised(root.right);
		int height = 1 + Math.max(leftOutput.height, rightOutput.height);     //height of binary tree
		boolean isBalanced = true;    //assume
		
		if(Math.abs(leftOutput.height - rightOutput.height) > 1)
		{
			isBalanced = false;
		}
		
		if(!leftOutput.isBalanced || !rightOutput.isBalanced)
		{
			isBalanced = false;
		}
		BalancedTreeReturn ans = new BalancedTreeReturn();
		ans.height = height;
		ans.isBalanced = isBalanced;
		return ans;
	}



	public static BinaryTreeNode<Integer> improvedInputBinaryTree(boolean isRoot, int parentData, boolean isLeftChild)
	{
		if(isRoot)
		{
			System.out.println("Enter root data :");
		}
		else
		{
			if(isLeftChild)
			{
				System.out.println("Enter left child of " + parentData);
			}
			else
			{
				System.out.println("Enter right child of " + parentData);
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int rootData = sc.nextInt();
		if(rootData == -1)   //There is no binary tree.
		{
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		BinaryTreeNode<Integer> leftChild = improvedInputBinaryTree(false, root.data, true);
		BinaryTreeNode<Integer> rightChild = improvedInputBinaryTree(false, root.data, false);
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}



	public static void main(String args[])
	{
		BinaryTreeNode<Integer> root = improvedInputBinaryTree(true, 0, true);
		System.out.println(isTreeBalancedOptimised(root).isBalanced);
	}

}
	

//Node of Binary Tree
class BinaryTreeNode<T>
{
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;
	public BinaryTreeNode(T data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
}



