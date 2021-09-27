/*
Problem Statement :
Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.
For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative 
order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.
*/


// Iterative Dynamic Programming
public class Solution
{
    public static int lcs(String str1, String str2)
    {
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < dp[i].length; j++)
            {
                dp[i][j] = 0;
            }
        }
        for(int i = str1.length()-1; i >= 0; i--)
        {
            for(int j = str2.length()-1; j >= 0; j--)
            {
                if(str1.charAt(i) == str2.charAt(j))
                {
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}