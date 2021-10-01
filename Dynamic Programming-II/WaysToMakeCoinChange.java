/*
Problem Statement :
For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. 
You need to figure out the total number of ways W, in which you can make the change for Value V using coins of denominations D.
Return 0 if the change isn't possible.
*/


// Using Recursive Dynamic Programming
public class Solution 
{	
    public static int countWaysToMakeChange(int denominations[], int value)
    {
        int dp[][] = new int[denominations.length + 1][value + 1];
        for(int r = 0; r < dp.length; r++)
        {
            for(int c = 0; c < dp[r].length; c++)
            {
                dp[r][c] = -1;
            }
        }
        return countWaysToMakeChange(denominations, value, 0, dp);
    }
    // helper function
    public static int countWaysToMakeChange(int denominations[], int value, int i, int dp[][])
    {
        // special case
        if(value == 0)
        {
             return 1;
        }
        
        //base case
        if(i == denominations.length)
        {
            return 0;
        }
        
        // can not include current denomination to make change
        if(denominations[i] > value)
        {
            if(dp[i+1][value] == -1)
            {
                int subAns = countWaysToMakeChange(denominations, value, i+1, dp);
                dp[i][value] = subAns;
                return subAns;
            }
            else
            {
                return dp[i+1][value];
            }
        }
        // can include current denomination to make change
        else
        {
            
            int subAns1 = 0;
            for(int j = 1; j <= value/denominations[i]; j++)
            {
                if(dp[i+1][value-(denominations[i]*j)] == -1)
                {
                    subAns1 += countWaysToMakeChange(denominations, value-(denominations[i]*j), i+1, dp);
                }
                else
                {
                    subAns1 += dp[i+1][value-(denominations[i]*j)];
                }
            }
            int subAns2 = 0;
            if(dp[i+1][value] == -1)
            {
                subAns2 = countWaysToMakeChange(denominations, value, i+1, dp);
            }
            else
            {
                subAns2 = dp[i+1][value];
            }
            int myAns = subAns1 + subAns2;
            dp[i][value] = myAns;
            return myAns;
        }
    }
}


/*
//Recursive Approach :

public class Solution 
{	
    public static int countWaysToMakeChange(int denominations[], int value)
    {
        return countWaysToMakeChange(denominations, value, 0);
    }
    // helper function
    public static int countWaysToMakeChange(int denominations[], int value, int i)
    {
        // special case
        if(value == 0)
        {
             return 1;
        }
        
        //base case
        if(i == denominations.length)
        {
            return 0;
        }
        
        // can not include current denomination to make change
        if(denominations[i] > value)
        {
            return countWaysToMakeChange(denominations, value, i+1);
        }
        // can include current denomination to make change
        else
        {
            // included current denomination to make change
            // since, infinite number of coin supply of each denomination,
            // we can use as much number of current denomination as possible.
            int subAns1 = 0;
            // we can include current denomination j-th times.
            for(int j = 1; j <= value/denominations[i]; j++)
            {
                subAns1 += countWaysToMakeChange(denominations, value-(denominations[i]*j), i+1);
            }
            // not included current denomination to make change
            int subAns2 = countWaysToMakeChange(denominations, value, i+1);
            int myAns = subAns1 + subAns2;
            return myAns;
        }
    }
}
*/