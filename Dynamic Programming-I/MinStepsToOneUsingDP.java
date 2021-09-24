/*
Problem Statement :
Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. 

You can perform any one of the following 3 steps:
1.) Subtract 1 from it. (n = n - ­1) ,
2.) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
*/




// Iterative DP
public class Solution
{
    public static int countMinStepsToOne(int n)
    {
        if(n == 1)
            return 0;
     	int dp[] = new int[n+1];
        dp[1] = 0;
        for(int i = 2; i < dp.length; i++)
        {
            int ans1 = dp[i-1];
            int ans2 = Integer.MAX_VALUE;
            if(i % 2 == 0)
            {
                ans2 = dp[i/2];
            }
            int ans3 = Integer.MAX_VALUE;
            if(i % 3 == 0)
            {
                ans3 = dp[i/3];
            }
            dp[i] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
        }
        return dp[n];
    }
}


// Recursive DP

// StackOverflowError for n >= 10^4

// Perfectly work for n < 9000

// public class Solution 
// {
//     public static int countMinStepsToOne(int n)
//     {
//         int dp[] = new int[n+1];
//         // 1 based indexing.
//         for(int i = 0; i < dp.length; i++)
//         {
//             dp[i] = -1;
//         }
//         return countMinStepsToOne(n, dp);
//     }
    
//    public static int countMinStepsToOne(int n, int dp[]) 
//    {
//         // base case
//         if(n == 1)
//         {
//             dp[1] = 0;
//             return 0;
//         }
        
//         int ans1;
//         if(dp[n-1] == -1)
//         {
//             ans1 = countMinStepsToOne(n-1, dp);
//             dp[n-1] = ans1;
//         }
//         else
//         {
//             ans1 = dp[n-1];
//         }
        
//         int ans2 = Integer.MAX_VALUE;
//         if(n % 2 == 0)
//         {
//             if(dp[n/2] == -1)
//             {
//                 ans2 = countMinStepsToOne(n/2, dp);
//                 dp[n/2] = ans2;
//             }
//             else
//             {
//                 ans2 = dp[n/2];
//             }
//         }
        
//         int ans3 = Integer.MAX_VALUE;
//         if(n % 3 == 0)
//         {
//             if(dp[n/3] == -1)
//             {
//                 ans3 = countMinStepsToOne(n/3, dp);
//                 dp[n/3] = ans3;
//             }
//             else
//             {
//                 ans3 = dp[n/3];
//             }
//         }
//         return Math.min(ans1, Math.min(ans2, ans3)) + 1;
//     }
// }