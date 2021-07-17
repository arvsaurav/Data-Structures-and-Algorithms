/*
Problem Statement :
Push array elements into stack and then pop all the elements.
*/

import java.util.Stack;
public class arrayToStack {
	public static void main(String args[])
	{
		int arr[] = {1, 2, 3, 4, 5};
		Stack<Integer> stack = new Stack<>();
		for(int i : arr)
		{
			stack.push(i);
		}
		while(!stack.isEmpty())  //while stack is not empty
		{
			System.out.println(stack.pop());
		}
	}
}
