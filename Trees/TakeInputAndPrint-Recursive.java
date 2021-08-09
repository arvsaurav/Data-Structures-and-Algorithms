/*
Problem Statement :
Take input and print - recursive.
*/


import java.util.Scanner;

public class TreeUse 
{
	public static TreeNode<Integer> takeInput()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter node data :");
		int data = sc.nextInt();
		TreeNode<Integer> root = new TreeNode<>(data);
		System.out.println("Enter number of childen of node " + data + ":");
		int count = sc.nextInt();
		for(int i = 0; i < count; i++)
		{
			TreeNode<Integer> child = takeInput();  //will take input of child subtree and returns it's head.
			root.children.add(child);
		}
		return root;
	}
	
	public static void print(TreeNode<Integer> root)
	{
		System.out.print(root.data + " : ");
		for(int i = 0; i < root.children.size(); i++)
		{
			System.out.print(root.children.get(i).data + ",");
		}
		System.out.println();
		for(int i = 0; i < root.children.size(); i++)
		{
			print(root.children.get(i));
		}
	}
	
	public static void main(String args[])
	{
		TreeNode<Integer> root = takeInput();
		print(root);
	}
}




//Tree node class :

import java.util.ArrayList;

public class TreeNode<T> 
{
	public T data;
	public ArrayList<TreeNode<T>> children;
	public TreeNode(T data)
	{
		this.data = data;
		children = new ArrayList<>();
	}
}
