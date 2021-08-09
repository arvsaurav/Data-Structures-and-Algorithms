/*
Problem Statement :
Take levelwise input of a tree.
*/


import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class TreeUse 
{
	public static TreeNode<Integer> takeInputLevelwise()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter root data :");
		int rootData = sc.nextInt();
		TreeNode<Integer> root = new TreeNode<>(rootData);
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			TreeNode<Integer> temp = queue.remove();
			System.out.println("Enter number of children of node " + temp.data + " :");
			int numChild = sc.nextInt();
			for(int i = 0; i < numChild; i++)
			{
				System.out.println("Enter data of " + (i+1) + "th child of node " + temp.data + " :");
				int childData = sc.nextInt();
				TreeNode<Integer> child = new TreeNode<>(childData);
				temp.children.add(child);
				queue.add(child);
			}
		}
		return root;
	}
}