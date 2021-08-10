/*
Problem Statement :
Given a generic tree, print the input tree in level wise order. 
That is, print the elements at same level in one line (separated by space). 
Print different levels in differnet lines.
*/


import java.util.LinkedList;
import java.util.Queue;
public class Solution 
{

/*	TreeNode structure 
 * 
 *	 class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}
*/
	
	
	
    public static void printLevelWise(TreeNode<Integer> root)
    {
		/* Your class should be named Solution 
 		 * Don't write main(). 
		 * Don't read input, it is passed as function argument. 
		 * Print output and don't return it. 
		 * Taking input is handled automatically. 
		 */
        if(root == null)
            return;
	Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty())
        {
            TreeNode<Integer> temp = queue.remove();
            System.out.print(temp.data + " ");
            for(int i = 0; i < temp.children.size(); i++)
            {
                queue.add(temp.children.get(i));
            }
            if(queue.peek() == null)
            {
                if(queue.size() == 1)
                    break;
                queue.remove();
                queue.add(null);
                System.out.println();
            }
        }
        
    }
		
}
