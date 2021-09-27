/*
Problem Statement :
Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.
For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative 
order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.
*/


// Recursive Dynamic Programming 
public class Solution
{
    public static int lcs(String str1, String str2)
    {
	int dp[][] = new int[str1.length()+1][str2.length()+1];
        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < dp[i].length; j++)
            {
                dp[i][j] = -1;
            }
        }
        return lcs(str1, str2, 0, 0, dp);
    }
    // helper function
    public static int lcs(String str1, String str2, int i, int j, int dp[][])
    {
        //base case
        if(i == str1.length() || j == str2.length())
        {
            return 0;
        }
        
        if(str1.charAt(i) == str2.charAt(j))
        {
            if(dp[i+1][j+1] == -1)
            {
                int subAns = lcs(str1, str2, i+1, j+1, dp);
                int myAns = 1 + subAns;
                dp[i][j] = myAns;
                return myAns;
            }
            else
            {
                int myAns = 1 + dp[i+1][j+1];
                return myAns;
            }
        }
        else
        {
            int subAns1, subAns2;
	    // exclude first character of str1
            if(dp[i+1][j] == -1)
            {
                subAns1 = lcs(str1, str2, i+1, j, dp);
            }
            else
            {
                subAns1 = dp[i+1][j];
            }
            // exclude first character of str2
            if(dp[i][j+1] == -1)
            {
                subAns2 = lcs(str1, str2, i, j+1, dp);
            }
            else
            {
                subAns2 = dp[i][j+1];
            }
            int myAns = Math.max(subAns1, subAns2);
            dp[i][j] = myAns;
            return myAns;
        }           
    }
}

/*
// Simple Recursive approach :
// Will get TLE for some test cases

public class Solution 
{
    public static int lcs(String str1, String str2)
    {
        return lcs(str1, str2, 0, 0);
    }
    // instead of making substring we have maintained i and j.
    // i is the starting point of str1.
    // j is the starting point of str2.
    
    // helper function
    public static int lcs(String str1, String str2, int i, int j) 
    {
        //base case
        if(i == str1.length() || j == str2.length())
        {
            return 0;
        }
        
        if(str1.charAt(i) == str2.charAt(j))
        {
            int subAns = lcs(str1, str2, i+1, j+1);
            int myAns = 1 + subAns;
            return myAns;
        }
        else
        {
	    // exclude first character of str1
            int subAns1 = lcs(str1, str2, i+1, j);
            // exclude first character of str2
            int subAns2 = lcs(str1, str2, i, j+1);
            int myAns = Math.max(subAns1, subAns2);
            return myAns;
        }           
    }
}
*/