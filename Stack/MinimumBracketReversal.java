/*
Problem Statement :
For a given expression in the form of a string, find the minimum number of brackets that can be reversed 
in order to make the expression balanced. The expression will only contain curly brackets.
If the expression can't be balanced, return -1.

Example:
Expression: {{{{
If we reverse the second and the fourth opening brackets, the whole expression will get balanced. Since we have to reverse two brackets to make the expression balanced, the expected output will be 2.

Expression: {{{
In this example, even if we reverse the last opening bracket, we would be left with the first opening bracket and hence will not be able to make the expression balanced and the output will be -1.

Input Format :
The first and the only line of input contains a string expression, without any spaces in between.

Output Format :
The only line of output will print the number of reversals required to balance the whole expression. Prints -1, otherwise.
*/


import java.util.Stack;
public class Solution {

	public static int countBracketReversals(String expression) {
		//Your code goes here
        Stack<Character> stack = new Stack<>();
        int count = 0;
        char c1, c2;
        if(expression.length()%2 != 0)
        {
            return -1;
        }
        for(int i = 0; i < expression.length(); i++)
        {
            if(expression.charAt(i) == '{')
            {
                stack.push(expression.charAt(i));
            }
            else      // expression.charAt(i) is }
            {
                if(stack.isEmpty())
                {
                    stack.push(expression.charAt(i));
                }
                else       // stack is not empty
                {
                    if(stack.peek() == '{')
                    {
                        stack.pop();
                    }
                    else    // stack.peek() is }
                    {
                        stack.push(expression.charAt(i));
                    }
                }
            }
        }
        while(!stack.isEmpty())
        {
        	c1 = stack.pop();
            c2 = stack.pop();
            if(c1 == c2)
            {
                count += 1;
            }
            else    // must be the case : }{
            {
                count += 2;
            }
        }
        return count;
	}

}


//Driver Code :
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

    	System.out.println(Solution.countBracketReversals(br.readLine().trim()));

    }
}