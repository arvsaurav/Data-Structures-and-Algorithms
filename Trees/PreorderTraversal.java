/*
Problem Statement :
Preorder traversal of a generic tree.
*/



public class TreeUse 
{
	public static void preOrder(TreeNode<Integer> root)
	{
		if(root == null)
			return;
		System.out.println(root.data);
		for(int i = 0; i < root.children.size(); i++)
		{
			preOrder(root.children.get(i));
		}
	}
}