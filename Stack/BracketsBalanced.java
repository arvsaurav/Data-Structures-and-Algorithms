/*
Problem Statement :
For a given a string expression containing only round brackets or parentheses, check if they are balanced or not. Brackets are said to be balanced if the bracket which opens last, closes first.
Example:
Expression: (()())
Since all the opening brackets have their corresponding closing brackets, we say it is balanced and hence the output will be, 'true'.
You need to return a boolean value indicating whether the expression is balanced or not.

Note:
The input expression will not contain spaces in between.

Input Format:
The first and the only line of input contains a string expression without any spaces in between.
 
Output Format:
The only line of output prints 'true' or 'false'.
*/


//Driver Code
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String expression = br.readLine().trim();
        System.out.println(Solution.isBalanced(expression));
    }
}


import java.util.Stack;
public class Solution {

    public static boolean isBalanced(String expression) {
        //Your code goes here
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++)
        {
			if(expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[')
            {
				stack.push(expression.charAt(i));
                continue;
            }
            
            if(expression.charAt(i) == ')')
            {
                if(stack.isEmpty())      //means extra closing bracket )
                {
                    return false;
                }
                if(!stack.peek().equals('('))
                {
                    return false;
                }
                stack.pop();
                continue;
            }
            if(expression.charAt(i) == '}')
            {
                if(stack.isEmpty())      //means extra closing bracket }
                {
                    return false;
                }
                if(!stack.peek().equals('{'))
                {
                    return false;
                }
                stack.pop();
                continue;
            }
            if(expression.charAt(i) == ']')
            {
                if(stack.isEmpty())      //means extra closing bracket ]
                {
                    return false;
                }
                if(!stack.peek().equals('['))
                {
                    return false;
                }
                stack.pop();
                continue;
            }
            
        }
        if(stack.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}