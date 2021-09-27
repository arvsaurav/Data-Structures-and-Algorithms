/*
Problem Statement :
An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
From a cell (i, j), you can move in three directions:
1. ((i + 1),  j) which is, "down"
2. (i, (j + 1)) which is, "to the right"
3. ((i+1), (j+1)) which is, "to the diagonal"
The cost of a path is defined as the sum of each cell's values through which the route passes.
*/


// Iterative Dynamic Programming :
public class Solution
{
    public static int minCostPath(int[][] cost)
    {
	int m = cost.length;
        int n = cost[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < dp[i].length; j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = m-1; i >= 0; i--)
        {
            for(int j = n-1; j >= 0; j--)
            {
                // at destination
                if(i == m-1 && j == n-1)
                {
		    dp[i][j] = cost[i][j];
                    continue;
                }
                int subAns1 = dp[i+1][j];
                int subAns2 = dp[i][j+1];
                int subAns3 = dp[i+1][j+1];
                int ans = cost[i][j] + Math.min(subAns1, Math.min(subAns2, subAns3));
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }
}