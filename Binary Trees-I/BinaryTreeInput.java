/*
Problem Statement :
Take user input to construct Binary Tree.
Also, print the created Binary Tree.
*/

import java.util.Scanner;
public class BinaryTreeInput {
	
	public static void printTree(BinaryTreeNode<Integer> root)
	{
		if(root == null)     //base case
			return;
		System.out.print(root.data + " : ");
		if(root.left != null)
		{
			System.out.print("L" + root.left.data + ", ");
		}
		if(root.right != null)
		{
			System.out.print("R" + root.right.data);
		}
		System.out.println();
		printTree(root.left);
		printTree(root.right);
	}
	
	public static BinaryTreeNode<Integer> inputBinaryTree()
	{
		System.out.println("Enter root data :");
		Scanner sc = new Scanner(System.in);
		int rootData = sc.nextInt();
		if(rootData == -1)   //There is no binary tree.
		{
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		BinaryTreeNode<Integer> leftChild = inputBinaryTree();
		BinaryTreeNode<Integer> rightChild = inputBinaryTree();
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}
	
	public static void main(String args[])
	{
		BinaryTreeNode<Integer> root = inputBinaryTree();
		System.out.println("Created Binary Tree is : ");
		printTree(root);
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
