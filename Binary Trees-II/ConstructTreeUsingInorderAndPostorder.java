/*
Problem Statement :
For a given postorder and inorder traversal of a Binary Tree of type integer stored in an array/list, 
create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.

Note:
Assume that the Binary Tree contains only unique elements.
*/


public class Solution 
{
	public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) 
    {
        //base case
        if(postOrder.length == 0 || inOrder.length == 0)
        {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(postOrder[postOrder.length - 1]);
        Traversal traversal = subTree(postOrder, inOrder);
        
        BinaryTreeNode<Integer> leftSubTree = buildTree(traversal.leftPostOrder, traversal.leftInOrder);
        BinaryTreeNode<Integer> rightSubTree = buildTree(traversal.rightPostOrder, traversal.rightInOrder);
        root.left = leftSubTree;
        root.right = rightSubTree;
        return root;
	}
      
  
    public static Traversal subTree(int[] postOrder, int[] inOrder)
    {
		
        int index = 0;
        for(int i = 0; i < inOrder.length; i++)
        {
			if(postOrder[postOrder.length - 1] == inOrder[i])
            {
                index = i;
				break;
            }
        }
        int leftInOrder[] = new int[index];
        int leftPostOrder[] = new int[index];
        int rightInOrder[] = new int[inOrder.length - index - 1];
        int rightPostOrder[] = new int[inOrder.length - index - 1];
        for(int i = 0; i < index; i++)
        {
            leftInOrder[i] = inOrder[i];
            leftPostOrder[i] = postOrder[i];
        }
        int j = 0;
        for(int i = index + 1; i < inOrder.length; i++)
        {
			rightInOrder[j] = inOrder[i];
            rightPostOrder[j] = postOrder[i-1];
            j++;
        }
        
        Traversal traversal = new Traversal();
        traversal.leftInOrder = leftInOrder;
        traversal.leftPostOrder = leftPostOrder;
        traversal.rightInOrder = rightInOrder;
        traversal.rightPostOrder = rightPostOrder;
        return traversal;
    }

}


class Traversal
{
    int leftInOrder[];
    int rightInOrder[];
    int leftPostOrder[];
    int rightPostOrder[];
}

 