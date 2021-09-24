/*
Problem Statement :
Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. 
The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.
*/



public class Solution
{	
	// Using Recursive DP
	// Time Complexity -> O(n*sqrt(n))  
	// n -> number of unique calls.
	// sqrt(n) -> task performed by each call. i.e., for loop
	public static int  minSquareUsingDP(int n)
	{
		int dp[] = new int[n+1];
		for(int i = 0; i < dp.length; i++)
		{
			dp[i] = -1;
		}
		return minSquareUsingDP(n, dp);
	}
	public static int minSquareUsingDP(int n, int dp[])
	{
		if(n == 0)
		{
			return 0;
		}
		int minAns = Integer.MAX_VALUE;
		for(int i = 1; i*i <= n; i++)
		{
			int val = n - (i*i);
			int currentAns;
			if(dp[val] == -1)
			{
				currentAns = minSquareUsingDP(val);
				dp[val] = currentAns;
			}
			else
			{
				currentAns = dp[val];
			}
			if(minAns > currentAns)
			{
				minAns = currentAns;
			}
		}
		int ans = minAns + 1;
		return ans;
	}
	
	// Using Recursion
	public static int minSquare(int n)
	{
		// base case
		if(n == 0)
			return 0;
		int minAns = Integer.MAX_VALUE;
		for(int i = 1; i*i <= n; i++)
		{
			int val = n - (i*i);
			int currentAns = minSquare(val);
			if(minAns > currentAns)
			{
				minAns = currentAns;
			}
		}
		int ans = minAns + 1;
		return ans;
	}
	
	public static void main(String args[])
	{
		//System.out.println(minSquare(41));
		System.out.println(minSquareUsingDP(51));
	}
}
