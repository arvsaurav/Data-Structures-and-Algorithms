/*
Problem Statement :
A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. 
Implement a method to count and return all possible ways in which the child can run-up to the stairs.
*/



// Iterative Dynamic Programming
public class Solution
{
    public static long staircase(int n)
    {
        if(n == 0 || n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(n == 3)
            return 4;
        
        long dp[] = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < dp.length; i++)
        {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}


// Recursive Dynamic Programming

// public class Solution 
// {
//     public static long staircase(int n)
//     {
//         long dp[] = new long[n+1];
//         for(int i = 0; i < dp.length; i++)
//         {
//             dp[i] = -1;
//         }
//         return staircase(n, dp);
//     }
//     public static long staircase(int n, long dp[]) 
//     {
// 	   if(n == 0 || n == 1)
//             return 1;
//         if(n == 2)
//             return 2;
//         if(n == 3)
//             return 4;
//         long ans1 = 0;
//         long ans2 = 0;
//         long ans3 = 0;
//         if(dp[n-1] == -1)
//         {
//             ans1 = staircase(n-1, dp);
//             dp[n-1] = ans1;
//         }
//         else
//         {
//             ans1 = dp[n-1];
//         }
//         if(dp[n-2] == -1)
//         {
//             ans2 = staircase(n-2, dp);
//             dp[n-2] = ans2;
//         }
//         else
//         {
//             ans2 = dp[n-2];
//         }
//         if(dp[n-3] == -1)
//         {
//             ans3 = staircase(n-3, dp);
//             dp[n-3] = ans3;
//         }
//         else
//         {
//             ans3 = dp[n-3];
//         }
        
//     	   long ans = ans1 + ans2 +ans3;
//         return ans;
//     }
// }