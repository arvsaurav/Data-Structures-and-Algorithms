/*
Problem Statement :
Count number of leaf nodes.
*/

public static int countLeafNode(BinaryTreeNode<Integer> root)
	{
		if(root == null)   //base case
			return 0;
		int countLeft = countLeafNode(root.left);
		int countRight = countLeafNode(root.right);
		if(countLeft == 0 && countRight == 0)
		{
			return 1;
		}
		return countLeft + countRight;
	}


//Alternate approach :
public static int countLeafNodeAlternate(BinaryTreeNode<Integer> root)
	{
		if(root == null)   //base case
			return 0;
		if(root.left == null && root.right == null)
		{
			return 1;
		}
		int countLeft = countLeafNodeAlternate(root.left);
		int countRight = countLeafNodeAlternate(root.right);
		return countLeft + countRight;
	}