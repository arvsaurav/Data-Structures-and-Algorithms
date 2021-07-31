/*
Problem Statement :
Check if binary tree is balanced.
*/

import java.util.Scanner;
import java.lang.Math;
public class BinaryTree {
	
	
	public static boolean isTreeBalanced(BinaryTreeNode<Integer> root)
	{
		if(root == null)
			return true;
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		if(Math.abs(leftHeight - rightHeight) > 1)
		{
			return false;
		}
		boolean isLeftBalanced = isTreeBalanced(root.left);
		boolean isRightBalanced = isTreeBalanced(root.right);
		return isLeftBalanced && isRightBalanced;
	}
	
	public static int heightOfTree(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return 0;
		}
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		return 1 + Math.max(leftHeight, rightHeight);
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
		System.out.println(isTreeBalanced(root));
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
