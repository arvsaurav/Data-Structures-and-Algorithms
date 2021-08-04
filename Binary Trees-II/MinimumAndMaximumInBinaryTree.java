/*
Problem Statement :
For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.
Return the output as an object of Pair class, which is already created.

Note:
All the node data will be unique and hence there will always exist a minimum and maximum node data.
*/


/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

*/



/*

	Representation of the Pair Class

	class Pair<T, U> {
		T minimum;
		U maximum;

		public Pair(T minimum, U maximum) {
			this.minimum = minimum;
			this.maximum = maximum;
		}

	}

*/
import java.lang.Math;
public class Solution 
{
	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) 
    {
        int maximum = max(root);
        int minimum = min(root);
	Pair<Integer, Integer> pair = new Pair<>(minimum, maximum);
        return pair;
	}
    
    public static int max(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return Integer.MIN_VALUE;
        }
        int maxLeft = max(root.left);
        int maxRight = max(root.right);
        return Math.max(root.data, Math.max(maxLeft, maxRight));
    }
    
    public static int min(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return Integer.MAX_VALUE;
        }
        int minLeft = min(root.left);
        int minRight = min(root.right);
        return Math.min(root.data, Math.min(minLeft, minRight));
    }

}





