/*
Problem Statement :
Levelwise input binary tree.
*/


import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
	
	public static BinaryTreeNode<Integer> levelwiseInput()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter root data ");
		int rootData = sc.nextInt();
		if(rootData == -1)
		{
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryTreeNode<Integer> temp;
		while(!queue.isEmpty())
		{
			temp = queue.remove();
			System.out.println("Enter left child of " + temp.data);
			int left = sc.nextInt();
			if(left != -1)
			{
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
				temp.left = leftChild;
				queue.add(leftChild);
			}
			
			System.out.println("Enter right child of " + temp.data);
			int right = sc.nextInt();
			if(right != -1)
			{
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
				temp.right = rightChild;
				queue.add(rightChild);
			}
		}
		return root;
		
	}


	public static void main(String args[])
	{
		BinaryTreeNode<Integer> root = levelwiseInput();
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
}
