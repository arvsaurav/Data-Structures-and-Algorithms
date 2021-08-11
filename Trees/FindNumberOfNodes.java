/*
Problem Statement :
Count number of nodes.
*/

public class TreeUse 
{
	public static int countNodes(TreeNode<Integer> root)
	{
		if(root == null)
			return 0;
		int count = 0;
		for(int i = 0; i < root.children.size(); i++)
		{
			count = count + countNodes(root.children.get(i));
		}
		return count + 1;
	}
}