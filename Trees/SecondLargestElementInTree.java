/*
Problem Statement :
Given a generic tree, find and return the node with second largest value in given tree. 
Return NULL if no node with required value is present.
*/




public class Solution 
{
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root)
    {
        Pair ans = findSecondMax(root);
        return ans.secondMaxNode;
    }
	
    //helper function
    public static Pair findSecondMax(TreeNode<Integer> root)
    {
        if(root == null)
            return null;
        TreeNode<Integer> maxNode = root;
        TreeNode<Integer> secondMaxNode = null;
        for(int i = 0; i < root.children.size(); i++)
        {
            Pair ans = findSecondMax(root.children.get(i));
            if(ans.maxNode.data > maxNode.data)
            {
                TreeNode<Integer> temp = maxNode;
                maxNode = ans.maxNode;
                if(ans.secondMaxNode != null && ans.secondMaxNode.data > temp.data)
                    secondMaxNode = ans.secondMaxNode;
                else
                    secondMaxNode = temp;
            }
            else if(ans.maxNode.data < maxNode.data)
            {
                if(secondMaxNode == null || secondMaxNode.data < ans.maxNode.data)
                    secondMaxNode = ans.maxNode;
            }
            else  //ans.maxNode.data == maxNode.data
            {
                if(secondMaxNode == null || (ans.secondMaxNode != null && ans.secondMaxNode.data > secondMaxNode.data))
                    secondMaxNode = ans.secondMaxNode;
            }
        }
        Pair pair = new Pair(maxNode, secondMaxNode);
        return pair;
    }
	
}

class Pair
{
    TreeNode<Integer> maxNode;
    TreeNode<Integer> secondMaxNode;
    public Pair(TreeNode<Integer> maxNode, TreeNode<Integer> secondMaxNode)
    {
        this.maxNode = maxNode;
        this.secondMaxNode = secondMaxNode;
    }
}