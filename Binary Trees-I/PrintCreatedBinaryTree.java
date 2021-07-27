/*
 Creating specific binary tree :
       
               1
             /   \
            /     \ 
           2       3 
          /\      /\ 
         /  \    /  \
       null  5  4  null
 */
public class BinaryTree {
	
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
	
	public static void main(String args[])
	{
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(2);
		BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(3);
		root.left = rootLeft;
		root.right = rootRight;
		BinaryTreeNode<Integer> TwoRight = new BinaryTreeNode<>(5);
		BinaryTreeNode<Integer> ThreeLeft = new BinaryTreeNode<>(4);
		rootLeft.right = TwoRight;
		rootRight.left = ThreeLeft;
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