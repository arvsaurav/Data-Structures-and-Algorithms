/*
Problem Statement :
Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. 
The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.
*/



// Iterative Dynamic Programming
public class Solution 
{
    public static int minCount(int n) 
    {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++)
        {
            int minAns = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++)
            {
                int index = i - (j*j);
                if(minAns > dp[index])
                {
                    minAns = dp[index];
                }
            }
            int ans = minAns + 1;
            dp[i] = ans;
        }
        return dp[n];
    }
}