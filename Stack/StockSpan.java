/*
Problem Statement :
Afzal has been working with an organization called 'Money Traders' for the past few years. 
The organization is into the money trading business. His manager assigned him a task. 
For a given array/list of stock's prices for N days, find the stock's span for each day.
The span of the stock's price today is defined as the maximum number of consecutive 
days(starting from today and going backwards) for which the price of the stock was less than today's price.
For example, if the price of a stock over a period of 7 days are [100, 80, 60, 70, 60, 75, 85], 
then the stock spans will be [1, 1, 1, 2, 1, 4, 6].

Input Format:
The first line of input contains an integer N, denoting the total number of days.
The second line of input contains the stock prices of each day. A single space will separate them.

Output Format:
The only line of output will print the span for each day's stock price. A single space will separate them.
*/


//Driver Code :
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws NumberFormatException, IOException {
    	int size = Integer.parseInt(br.readLine().trim());
    	int[] input = new int[size];

    	if (size == 0) {
    		return input;
    	}

    	String[] values = br.readLine().trim().split(" ");

    	for(int i = 0; i < size; i++) {
    		input[i] = Integer.parseInt(values[i]);
    	}

    	return input;
    }

    public static void printArray(int[] arr) {
    	for (int i = 0 ; i < arr.length; i++) {
    		System.out.print(arr[i] + " ");
    	}

    	System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
    	int[] input = takeInput();

    	int[] output = Solution.stockSpan(input);

    	printArray(output);

    }
}




import java.util.Stack;
public class Solution {

	public static int[] stockSpan(int[] price) {
		//Your code goes here
        int span[] = new int[price.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;    //span value for 1st element is always 1.
        for(int i = 1; i < price.length; i++)
        {
			if(price[stack.peek()] >= price[i])
            {
                stack.push(i);
                span[i] = 1;
            }
            else
            {
                while(!stack.isEmpty()  && price[stack.peek()] < price[i])
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                {
                    span[i] = i + 1;
                }
                else
                {
                    span[i] = i - stack.peek();
                }
                stack.push(i);
            }
        }
        return span;
	}

}
