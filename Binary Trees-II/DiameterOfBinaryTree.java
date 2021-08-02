/*
Problem Statement :
For a given Binary of type integer, find and return the ‘Diameter’.

Diameter of a Tree :
The diameter of a tree can be defined as the maximum distance between two leaf nodes.
Here, the distance is measured in terms of the total number of nodes present along the path of the two leaf nodes, 
including both the leaves.
*/



import java.lang.Math;
//Time Complexity : O(n)
public class Solution
{
    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root)
    {
        diameterHeightReturn ans = diameterOfBinaryTree(root, 1);
        return ans.diameter;
    }
    
	public static diameterHeightReturn diameterOfBinaryTree(BinaryTreeNode<Integer> root, int temp)
    {
        if(root == null)
        {
            int height = 0;
            int diameter = 0;
            diameterHeightReturn ans = new diameterHeightReturn();
            ans.height = height;
            ans.diameter = diameter;
            return ans;
        }
        diameterHeightReturn leftSubAns = diameterOfBinaryTree(root.left, 1);
        diameterHeightReturn rightSubAns = diameterOfBinaryTree(root.right, 1);
        int height = Math.max(leftSubAns.height, rightSubAns.height) + 1;
        int diameter = Math.max(1 + leftSubAns.height + rightSubAns.height, Math.max(leftSubAns.diameter, rightSubAns.diameter));
        diameterHeightReturn ans = new diameterHeightReturn();
        ans.height = height;
        ans.diameter = diameter;
        return ans;
    }
}


class diameterHeightReturn
{
    int height;
    int diameter;
}




//Alternate approach :
//Time Complexity : O(n^2)
/*
public class Solution 
{
	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root)
    {
		if(root == null)
        {
            return 0;
        }
        int diameterOfLeftSubTree = diameterOfBinaryTree(root.left);
        int diameterOfRightSubTree = diameterOfBinaryTree(root.right);
        
        int heightOfLeftSubTree = heightOfTree(root.left);
        int heightOfRightSubTree = heightOfTree(root.right);
        
        return Math.max(1 + heightOfLeftSubTree + heightOfRightSubTree, Math.max(diameterOfLeftSubTree, diameterOfRightSubTree));
	}
    
    public static int heightOfTree(BinaryTreeNode<Integer> root)
    {
		if(root == null)
            return 0;
        int heightOfLeftSubTree = heightOfTree(root.left);
        int heightOfRightSubTree = heightOfTree(root.right);
    	return 1 + Math.max(heightOfLeftSubTree, heightOfRightSubTree);
    }
	
}
*/