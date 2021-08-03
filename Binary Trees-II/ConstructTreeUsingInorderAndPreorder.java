/*
Problem Statement :
For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list, 
create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.

Note:
Assume that the Binary Tree contains only unique elements. 
*/


public class Solution 
{
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) 
    {
        //base case
        if(preOrder.length == 0 || inOrder.length == 0)
        {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[0]);
        Traversal traversal = subTree(preOrder, inOrder);
        
        BinaryTreeNode<Integer> leftSubTree = buildTree(traversal.leftPreOrder, traversal.leftInOrder);
        BinaryTreeNode<Integer> rightSubTree = buildTree(traversal.rightPreOrder, traversal.rightInOrder);
        root.left = leftSubTree;
        root.right = rightSubTree;
        return root;
	}
      
  
    public static Traversal subTree(int[] preOrder, int[] inOrder)
    {
		
        int index = 0;
        for(int i = 0; i < inOrder.length; i++)
        {
			if(preOrder[0] == inOrder[i])
            {
                index = i;
				break;
            }
        }
        int leftInOrder[] = new int[index];
        int leftPreOrder[] = new int[index];
        int rightInOrder[] = new int[inOrder.length - index - 1];
        int rightPreOrder[] = new int[inOrder.length - index - 1];
        for(int i = 0; i < index; i++)
        {
            leftInOrder[i] = inOrder[i];
            leftPreOrder[i] = preOrder[i+1];
        }
        int j = 0;
        for(int i = index + 1; i < inOrder.length; i++)
        {
			rightInOrder[j] = inOrder[i];
            rightPreOrder[j] = preOrder[i];
            j++;
        }
        
        Traversal traversal = new Traversal();
        traversal.leftInOrder = leftInOrder;
        traversal.leftPreOrder = leftPreOrder;
        traversal.rightInOrder = rightInOrder;
        traversal.rightPreOrder = rightPreOrder;
        return traversal;
    }

}


class Traversal
{
	int leftInOrder[];
    int rightInOrder[];
    int leftPreOrder[];
    int rightPreOrder[];
}








/*

//Alternate approach :

public class Solution 
{
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) 
    {
        //base case
        if(preOrder.length == 0 || inOrder.length == 0)
        {
            return null;
        }
        
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[0]);
        int index = 0;
        for(int i = 0; i < inOrder.length; i++)
        {
			if(preOrder[0] == inOrder[i])
            {
                index = i;
				break;
            }
        }
        int leftInOrder[] = new int[index];
        int leftPreOrder[] = new int[index];
        int rightInOrder[] = new int[inOrder.length - index - 1];
        int rightPreOrder[] = new int[inOrder.length - index - 1];
        for(int i = 0; i < index; i++)
        {
            leftInOrder[i] = inOrder[i];
        }
        int j = 0;
        for(int i = index + 1; i < inOrder.length; i++)
        {
			rightInOrder[j] = inOrder[i];
            j++;
        }
        for(int i = 0; i < index; i++)
        {
			leftPreOrder[i] = preOrder[i+1];
        }
        j = 0;
        for(int i = index + 1; i < preOrder.length; i++)
        {
			rightPreOrder[j] = preOrder[i];
            j++;
        }
        
        BinaryTreeNode<Integer> leftSubTree = buildTree(leftPreOrder, leftInOrder);
        BinaryTreeNode<Integer> rightSubTree = buildTree(rightPreOrder, rightInOrder);
        root.left = leftSubTree;
        root.right = rightSubTree;
        return root;
	}

}


*/