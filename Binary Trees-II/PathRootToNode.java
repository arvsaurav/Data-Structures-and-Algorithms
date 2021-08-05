/*
Problem Statement :
Find path of a node from root.
*/

import java.util.*;
public class BinaryTree 
{
	
	public static ArrayList<Integer> rootToNodePath(BinaryTreeNode<Integer> root, int x)
	{
		if(root == null)   //base case
		{
			return null;
		}
		if(root.data == x)   //data found at the current node.
		{
			ArrayList<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		}
		ArrayList<Integer> leftOutput = rootToNodePath(root.left,  x);
		if(leftOutput != null)   //data found in left subtree.
		{
			//leftOutput will contain the path of data to left subtree's root.
			//path for whole tree will be : leftOutput -> root.data
			leftOutput.add(root.data);
			return leftOutput;
		}
		ArrayList<Integer> rightOutput = rootToNodePath(root.right,  x);
		if(rightOutput != null)  //data found in right subtree.
		{
			rightOutput.add(root.data);
			return rightOutput;
		}
		return null;   //data not found.
	}



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
		ArrayList<Integer> output = rootToNodePath(root, 5);
		if(output != null)
		{
			for(int i : output)
			{
				System.out.println(i);
			}
		}
		if(output == null)
		{
			System.out.println("Element not found.");
		}
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

