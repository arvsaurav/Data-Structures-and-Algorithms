/*
Problem Statement :
Implement Stack using Java Collections framework.
*/

import java.util.Stack;

public class StackInCollections {
	public static void main(String args[])
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(1);
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
	}
}
