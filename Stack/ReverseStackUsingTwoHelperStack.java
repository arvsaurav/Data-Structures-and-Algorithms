import java.util.Stack;
public class ReverseStackUsingTwoHelperStack {
	
	public static void main(String args[])
	{
		int arr[] = {1,2,3,4,5};
		Stack<Integer> stack = new Stack<>();
		for(int element : arr)
		{
			stack.push(element);
		}
		reverseStack(stack);
		//printing reversed stack
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	}
	
	public static void reverseStack(Stack<Integer> stack)
	{
		Stack<Integer> helperStack1 = new Stack<>();
		Stack<Integer> helperStack2 = new Stack<>();
		while(!stack.isEmpty())
		{
			helperStack1.push(stack.pop());
		}
		while(!helperStack1.isEmpty())
		{
			helperStack2.push(helperStack1.pop());
		}
		while(!helperStack2.isEmpty())
		{
			stack.push(helperStack2.pop());
		}
	}

}
