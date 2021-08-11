/*
Problem Statement :
Find node with largest data.
*/


public class TreeUse 
{
	public static int largestNode(TreeNode<Integer> root)
	{
		if(root == null)
			return Integer.MIN_VALUE;
		int ans = root.data;
		for(int i = 0; i < root.children.size(); i++)
		{
			int subTreeMax = largestNode(root.children.get(i));
			if(subTreeMax > ans)
			{
				ans = subTreeMax;
			}
		}
		return ans;
	}
}