/*
Problem Statement :
An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
From a cell (i, j), you can move in three directions:
1. ((i + 1),  j) which is, "down"
2. (i, (j + 1)) which is, "to the right"
3. ((i+1), (j+1)) which is, "to the diagonal"
The cost of a path is defined as the sum of each cell's values through which the route passes.
*/


// Approach 1 :
// Recursive Dynamic Programming :

public class Solution
{
    public static int minCostPath(int[][] cost)
    {
	// create dp array with one extra row and column as compared to cost array
        // it will avoid index out of bound exception while checking whether value is 
        // present in dp array or we have to make a recursive call.
        int dp[][] = new int[cost.length+1][cost[0].length+1];
        // initialize dp array with -infinity because cost can be -ve, zero or +ve 
        // and for base condition we are returning +infinity
        // therefore, only value left is -ve infinity
        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < dp[i].length; j++)
            {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return minCostPath(cost, 0, 0, dp);
    }
    // helper function
    public static int minCostPath(int[][] cost, int i, int j, int[][] dp)
    {
    	int m = cost.length;
        int n = cost[0].length;
        // reached destination
        if(i == m-1 && j == n-1)
        {
            return cost[i][j];
        }
        // base case 
        // index out of bounds
        if(i >= m || j >= n)   
        {
            return Integer.MAX_VALUE;
        }
        int subAns1, subAns2, subAns3;
        if(dp[i+1][j] == Integer.MIN_VALUE)
        {
	    subAns1 = minCostPath(cost, i+1, j, dp);
        }
        else
        {
            subAns1 = dp[i+1][j];
        }
        if(dp[i][j+1] == Integer.MIN_VALUE)
        {
	    subAns2 = minCostPath(cost, i, j+1, dp);
        }
        else
        {
            subAns2 = dp[i][j+1];
        }
        if(dp[i+1][j+1] == Integer.MIN_VALUE)
        {
	    subAns3 = minCostPath(cost, i+1, j+1, dp);
        }
        else
        {
            subAns3 = dp[i+1][j+1];
        }
        int ans = cost[i][j] + Math.min(subAns1, Math.min(subAns2, subAns3));
        return ans;
    }
}


// Approach 2 :
// Recursive Solution

public class Solution 
{
    public static int minCostPath(int[][] cost) 
    {
	return minCost(cost, cost.length, cost[0].length, 0, 0);
    }
    // helper function
    public static int minCost(int[][] cost, int m, int n, int i, int j)
    {
        // reached destination
        if(i == m-1 && j == n-1)
        {
            return cost[i][j];
        }
        // base case 
        // index out of bounds
        if(i >= m || j >= n)   
        {
            return Integer.MAX_VALUE;
        }
        int subAns1 = minCost(cost, m, n, i+1, j);
        int subAns2 = minCost(cost, m, n, i, j+1);
        int subAns3 = minCost(cost, m, n, i+1, j+1);
        int ans = cost[i][j] + Math.min(subAns1, Math.min(subAns2, subAns3));
        return ans;
    }
}