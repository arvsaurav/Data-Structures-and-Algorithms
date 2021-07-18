/*
Problem Statement :
You have been given two stacks that can store integers as the data. 
Out of the two given stacks, one is populated and the other one is empty. 
You are required to write a function that reverses the populated stack using the one which is empty.

Input Format :
The first line of input contains an integer N, denoting the total number of elements in the stack.

The second line of input contains N integers separated by a single space, representing the order in which the elements are pushed into the stack.

Output Format:
The only line of output prints the order in which the stack elements are popped, all of them separated by a single space. 
*/


//Driver Code :
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Stack<Integer> takeInput() throws NumberFormatException, IOException {
    	int size = Integer.parseInt(br.readLine().trim());
    	Stack<Integer> input = new Stack<>();

    	if (size == 0) {
    		return input;
    	}
    	
    	String[] values = br.readLine().trim().split(" ");

    	for(int i = 0; i < size; i++) {
    		input.push(Integer.parseInt(values[i]));
    	}

    	return input;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
    	Stack<Integer> input = takeInput();
    	Stack<Integer> empty = new Stack<>();

    	Solution.reverseStack(input, empty);

    	while(!input.isEmpty()) {
    		System.out.print(input.pop() + " ");
    	}

    }
}


import java.util.Stack;
public class Solution {

	public static void reverseStack(Stack<Integer> originalStack, Stack<Integer> helperStack) {
		//Your code goes here
        if(originalStack.size() <= 1)    //base case
        {
            return;     //if only one element is present in the stack, it means stack is already reversed.
        }
        int temp = originalStack.pop();     //nth element will be poped out and stored in temp variable
        reverseStack(originalStack, helperStack);    //recursion will reverse the remaining elements of the stack.
        while(!originalStack.isEmpty())
        {
            helperStack.push(originalStack.pop());    //elements of original stack will be poped out and pushed into helper stack.
        }
        helperStack.push(temp);    //nth element will be pushed to the helper stack.
        while(!helperStack.isEmpty())
        {
            originalStack.push(helperStack.pop());   //elements of helper stack will be poped out and pushed into original stack.
        }
	}
}