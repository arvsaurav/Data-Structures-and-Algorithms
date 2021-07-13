/*
Problem Statement :
Implement basic operations of stack using array.
*/

public class StackUsingArray {
	public static void main(String args[]) throws StackFullException, StackEmptyException
	{
		Stack stack = new Stack();
		stack.push(5);
		stack.push(2);
		System.out.println(stack.pop());
		stack.push(1);
		System.out.println(stack.top());
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
	}
	

}

class Stack
{
	private int data[];
	private int indexTop;    //index of topmost element of stack.
	private int temp;
	public Stack()    //constructor
	{
		data = new int[10];
		indexTop = -1; 
	}
	
	public void push(int element) throws StackFullException
	{
		if(indexTop == data.length-1)
		{
			//throw stack full exception.
			throw new StackFullException();
		}
		indexTop += 1;
		data[indexTop] = element;
	}
	
	public int pop() throws StackEmptyException
	{
		if(indexTop == -1)
		{
			//throw stack empty exception.
			throw new StackEmptyException();
		}
		temp = data[indexTop];
		indexTop -= 1;
		return temp;
	}
	
	public boolean isEmpty()
	{
		if(indexTop == -1)
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	public int size()
	{
		return indexTop + 1;
	}
	
	public int top() throws StackFullException
	{
		if(indexTop == -1)
		{
			throw new StackFullException();
		}
		return data[indexTop];
	}
}


//create new exception class


public class StackFullException extends Exception {
	public StackFullException()
	{
		System.out.println("Stack Overflow.");
	}

}


public class StackEmptyException extends Exception {
	public StackEmptyException()
	{
		System.out.println("Stack Underflow.");
	}
}
