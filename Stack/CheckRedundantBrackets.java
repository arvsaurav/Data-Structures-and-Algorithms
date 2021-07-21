/*
Problem Statement :
For a given expression in the form of a string, find if there exist any redundant brackets or not. 
It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.
A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets.

Example:
Expression: (a+b)+c
Since there are no needless brackets, hence, the output must be 'false'.

Expression: ((a+b))
The expression can be reduced to (a+b). Hence the expression has redundant brackets and the output will be 'true'.

Input Format :
The first and the only line of input contains a string expression, without any spaces in between.

Output Format :
The first and the only line of output will print either 'true' or 'false'(without the quotes) denoting whether 
the input expression contains redundant brackets or not.
*/


//Driver Code :
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

    	String expression = br.readLine().trim();
    	System.out.println(Solution.checkRedundantBrackets(expression));
    }
}


import java.util.Stack;
public class Solution {

	public static boolean checkRedundantBrackets(String expression) {
		//Your code goes here
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < expression.length(); i++)
        {
            if(expression.charAt(i) != ')' && expression.charAt(i) != '}')
            {
                stack.push(expression.charAt(i));
                continue;
            }
            if(expression.charAt(i) == ')')
            {
				while(stack.peek() != '(')
                {
                    stack.pop();
                    count += 1;
                }
                stack.pop();  //for poping '(' from stack.
                if(count <= 1)
                {
					return true;
                }
                //else no redundant brackets.
                count = 0;
                continue;
            }
            if(expression.charAt(i) == '}')
            {
                while(stack.peek() != '{')
                {
                    stack.pop();
                    count += 1;
                }
                stack.pop();  //for poping '{' from stack.
                if(count <= 1)
                {
                    return true;
                }
                //else no redundant brackets.
                count = 0;
                continue;
            }
        }
        return false;
	}
}