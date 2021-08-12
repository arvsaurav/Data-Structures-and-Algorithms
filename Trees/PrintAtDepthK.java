/*
Problem Statement :
Print all nodes at depth k.
*/

public class TreeUse 
{
	public static void printAtDepthK(TreeNode<Integer> root, int k)
	{
		if(root == null || k < 0)
			return;
		if(k == 0)
		{
			System.out.println(root.data);
			return;
		}
		for(int i = 0; i < root.children.size(); i++)
		{
			printAtDepthK(root.children.get(i), k-1);
		}
	}
}