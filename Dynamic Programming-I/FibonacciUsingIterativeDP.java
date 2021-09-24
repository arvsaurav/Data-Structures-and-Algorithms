/*
Fibonacci using Iterative Dynamic Programming.
*/


import java.util.Scanner;

public class FibonacciUsingIterativeDP 
{
	public static int fibonacci(int n)
	{
		if(n == 0 || n == 1)
		{
			return n;
		}
		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i < dp.length; i++)
		{
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int ans = fibonacci(n);
		System.out.println(ans);
	}
}
