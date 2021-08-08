/*
Problem Statement :

Implement the BST class which includes following functions -
1. search
Given an element, find if that is present in BST or not. Return true or false.

2. insert -
Given an element, insert that element in the BST at the correct position. 
If element is equal to the data of the node, insert it in the left subtree.

3. delete -
Given an element, remove that element from the BST. If the element which is to be deleted has both children, 
replace that with the minimum element from right sub-tree.

4. printTree (recursive) -

Print the BST in ithe following format -
For printing a node with data N, you need to follow the exact format -
N:L:x,R:y
*/




/*
 * Binary Tree Node class
 * 
 * class BinaryTreeNode<T> { 
 * 		T data; 
 * 		BinaryTreeNode<T> left; 
 * 		BinaryTreeNode<T> right;
 * 		public BinaryTreeNode(T data) 
 * 		{ 
 * 			this.data = data; 
 * 		}
 * }
 */

 /* 
 * Main Method being used internally
 *	public static void main(String[] args) throws IOException {
 *		BinarySearchTree bst = new BinarySearchTree();
 *		int choice, input;
 *		int q = Integer.parseInt(br.readLine());
 *		while (q-- > 0) {
 *			st = new StringTokenizer(br.readLine());
 *			choice = Integer.parseInt(st.nextToken());
 *			switch (choice) {
 *			case 1:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.insert(input);
 *				break;
 *				case 2:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.remove(input);
 *				break;
 *			case 3:
 *				input = Integer.parseInt(st.nextToken());
 *				System.out.println(bst.search(input));
 *				break;
 *			default:
 *				bst.printTree();
 *				break;
 *			}
 *		}
 *	}
 */

public class BinarySearchTree 
{
    private BinaryTreeNode<Integer> root;
    
    public void insert(int data)
    {
        root = insert(root, data);
    }
    //helper function
    private BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) 
    {
        if(root == null)
        {
            root = new BinaryTreeNode<>(data);
            return root;
        }
        if(data <= root.data)
        {
            BinaryTreeNode<Integer> leftSubtreeRoot = insert(root.left, data);  //returns updated root of left subtree.
            root.left = leftSubtreeRoot;
        }
        else
        {
            BinaryTreeNode<Integer> rightSubtreeRoot = insert(root.right, data);  //returns updated root of right subtree.
            root.right = rightSubtreeRoot;
        }
        return root;
    }
	
    public void remove(int data) 
    {
	root = remove(root, data);   //will return the updated root after deletion.
    }
    //helper function
    private BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root, int data)
    {
        if(root == null)
        {
            return null;
        }
        if(root.data == data)  //node to be deleted is the current node.
        {
	    if(root.left == null && root.right == null)  //node to be deleted has 0 child.
            {
                return null;
            }
            if(root.left == null || root.right == null)  //node to be deleted has 1 child.
            {
                if(root.left == null)
                    return root.right;
                if(root.right == null)
                    return root.left;
            }
            if(root.left != null && root.right != null)  //node to be deleted has 2 child.
            {
                //node to be deleted must be replaced with minimum element of right subtree in order to remain a BST.
                int value = minimum(root.right);
                root.data =  value;
                //now delete value from right subtree
                BinaryTreeNode<Integer> rightHead = remove(root.right, value);  //will delete value from right subtree and returns the updated head.
                root.right = rightHead;
                return root;
            }
        }
        
    	if(data < root.data)   //node to be deleted is present in left subtree.
    	{
            BinaryTreeNode<Integer> leftHead = remove(root.left, data);  //returns updated head after deletion of node.
            root.left = leftHead;
    	}
        if(data > root.data)   //node to be deleted is present in right subtree.
        {
            BinaryTreeNode<Integer> rightHead = remove(root.right, data);  //returns updated head after deletion of node.
            root.right = rightHead;
        }
        return root;
    }
    private int minimum(BinaryTreeNode<Integer> root)
    {
        if(root == null)
            return Integer.MAX_VALUE;
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
    
    
    public void printTree() 
    {
	printTree(root);
    }
    //helper function
    private void printTree(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.data + ":");
        if(root.left != null)
        {
            System.out.print("L:" + root.left.data + ",");
        }
        if(root.right != null)
        {
            System.out.print("R:" + root.right.data);
        }
        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }
    
    
    public boolean search(int data) 
    {
	return search(root, data);
    }
    //helper function
    private boolean search(BinaryTreeNode<Integer> root, int data)
    {
        if(root == null)
        {
            return false;
        }
        if(root.data == data)
        {
            return true;
        }
        if(data < root.data)
        {
            return search(root.left, data);
        }
        else
        {
            return search(root.right, data);
        }
    }
}