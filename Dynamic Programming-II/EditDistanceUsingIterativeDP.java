/*
Problem Statement :
You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.
Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. 
In order to do so, you can perform the following three operations:
1. Delete a character
2. Replace a character with another one
3. Insert a character

Note :
Strings don't contain spaces in between.
*/


// Iterative Dynamic Programming :
public class Solution
{
    public static int editDistance(String str1, String str2)
    {
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        // initialize dp with base case values
        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < dp[i].length; j++)
            {
                if(i == str1.length())
                {
                    dp[i][j] = str2.length()-j;
                    continue;
                }
                if(j == str2.length())
                {
                    dp[i][j] = str1.length()-i;
                    continue;
                }
            }
        }
        for(int i = str1.length()-1; i >= 0; i--)
        {
            for(int j = str2.length()-1; j >= 0; j--)
            {
                if(str1.charAt(i) == str2.charAt(j))
                {
                    dp[i][j] = dp[i+1][j+1];
                }
                else
                {
                    int subAns1 = 1 + dp[i+1][j];
                    int subAns2 = 1 + dp[i+1][j+1];
                    int subAns3 = 1 + dp[i][j+1];
                    int myAns = Math.min(subAns1, Math.min(subAns2, subAns3));
                    dp[i][j] = myAns;
                }
            }
        }
        return dp[0][0];
    }
}
