/*
Problem Statement :
A thief robbing a store can carry a maximal weight of W into his knapsack. 
There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' What would be the maximum value V, that the thief can steal?

Input Format :
The first line of the input contains an integer value N, which denotes the total number of items.

The second line of input contains the N number of weights separated by a single space.

The third line of input contains the N number of values separated by a single space.

The fourth line of the input contains an integer value W, which denotes the maximum weight the thief can steal.
*/


// Iterative Dynamic Programming :
public class Solution
{
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight)
    {
        int dp[][] = new int[n+1][maxWeight+1];
        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < dp[i].length; j++)
            {
                dp[i][j] = 0;
            }
        }
        
        for(int i = n-1; i >= 0; i--)
        {
            for(int w = 0; w <= maxWeight; w++)
            {
                // can't include i-th item in knapsack
                if(weights[i] > w)
                {
                    dp[i][w] = dp[i+1][w];
                }
                // can include i-th item in knapsack
                else
                {
                    // included i-th item
                    int subAns1 = values[i] + dp[i+1][w-weights[i]];
                    // don't include i-th item
                    int subAns2 = dp[i+1][w];
                    dp[i][w] = Math.max(subAns1, subAns2);
                }
            }
        }
        return dp[0][maxWeight];
    }
}