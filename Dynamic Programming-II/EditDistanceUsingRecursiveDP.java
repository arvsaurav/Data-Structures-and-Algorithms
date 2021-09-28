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


// Recursive Dynamic Programming :
public class Solution
{
    public static int editDistance(String str1, String str2)
    {
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < dp[i].length; j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return editDistance(str1, str2, 0, 0, dp);
    }
    // helper function
    public static int editDistance(String str1, String str2, int i, int j, int dp[][])
    {
        // base case
        if(i == str1.length())
        {
            return str2.length()-j;
        }
        if(j == str2.length())
        {
            return str1.length()-i;
        }
        
        if(str1.charAt(i) == str2.charAt(j))
        {
            if(dp[i+1][j+1] == Integer.MAX_VALUE)
            {
                int myAns = editDistance(str1, str2, i+1, j+1, dp);
                dp[i][j] = myAns;
                return myAns;
            }
            else
            {
                int myAns = dp[i+1][j+1];
                return myAns;
            }
        }
        else
        {
            int subAns1, subAns2, subAns3;
            // delete a character from str1
            if(dp[i+1][j] == Integer.MAX_VALUE)
            {
                subAns1 = 1 + editDistance(str1, str2, i+1, j, dp);
            }
            else
            {
                subAns1 = 1 + dp[i+1][j];
            }
            // substitute a character from str1
            if(dp[i+1][j+1] == Integer.MAX_VALUE)
            {
                subAns2 = 1 + editDistance(str1, str2, i+1, j+1, dp);
            }
            else
            {
                subAns2 = 1 + dp[i+1][j+1];
            }
            // insert a character in str1
            if(dp[i][j+1] == Integer.MAX_VALUE)
            {
                subAns3 = 1 + editDistance(str1, str2, i, j+1, dp);
            }
            else
            {
                subAns3 = 1 + dp[i][j+1];
            }
            int myAns = Math.min(subAns1, Math.min(subAns2, subAns3));
            dp[i][j] = myAns;
            return myAns;
        }
    }
}

/*
// Recursive Approach 1 :

public class Solution 
{
    public static int editDistance(String str1, String str2)
    {
	return editDistance(str1, str2, 0, 0);
    }
    
    public static int editDistance(String str1, String str2, int i, int j) 
    {
        // base case
        if(i == str1.length())
        {
            return str2.length()-j;
        }
        if(j == str2.length())
        {
            return str1.length()-i;
        }
        
	if(str1.charAt(i) == str2.charAt(j))
        {
            int myAns = editDistance(str1, str2, i+1, j+1);
            return myAns;
        }
        else
        {
            // delete a character from str1
            int subAns1 = 1 + editDistance(str1, str2, i+1, j);
            // substitute a character from str1
            int subAns2 = 1 + editDistance(str1, str2, i+1, j+1);
            // insert a character in str1
            int subAns3 = 1 + editDistance(str1, str2, i, j+1);
            int myAns = Math.min(subAns1, Math.min(subAns2, subAns3));
            return myAns;
        }
    }
}
*/

/*
// Recursive Approach 2 :

public class Solution 
{
    public static int editDistance(String str1, String str2) 
    {
        // base case
        if(str1.length() == 0)
        {
            return str2.length();
        }
        if(str2.length() == 0)
        {
            return str1.length();
        }
        
	if(str1.charAt(0) == str2.charAt(0))
        {
            int myAns = editDistance(str1.substring(1), str2.substring(1));
            return myAns;
        }
        else
        {
            // delete a character from str1
            int subAns1 = 1 + editDistance(str1.substring(1), str2);
            // substitute a character from str1
            int subAns2 = 1 + editDistance(str1.substring(1), str2.substring(1));
            // insert a character in str1
            int subAns3 = 1 + editDistance(str1, str2.substring(1));
            int myAns = Math.min(subAns1, Math.min(subAns2, subAns3));
            return myAns;
        }
    }
}
*/