/*
Problem Statement :
For a given binary tree of integers, print the in-order traversal.
*/


import java.util.Scanner;

public class BinaryTree {
	
	public static void inOrder(BinaryTreeNode<Integer> root) 
	{
        	if(root == null)
            		return;
        	inOrder(root.left);
        	System.out.print(root.data + " ");
        	inOrder(root.right);
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
		inOrder(root);
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