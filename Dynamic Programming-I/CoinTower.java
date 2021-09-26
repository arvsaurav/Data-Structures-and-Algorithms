/*
Problem Statement :
Whis and Beerus are playing a new game today. They form a tower of N coins and make a move in alternate turns. 
Beerus plays first. In one step, the player can remove either 1, X, or Y coins from the tower. 
The person to make the last move wins the game. Can you find out who wins the game?
*/


public class Solution 
{
    public static String findWinner(int n, int x, int y) 
    {
	int dp[] = new int[n+1];
        if(n == 1 || n == x || n == y)
        {
            return "Beerus";
        }
        // Since, both player will play smartly, so the player who wins at (n-1), (n-x) or (n-y) state will definitely
        // loose at n-th state.
        // since, player can either move to (n-1) or (n-x) or (n-y) state, therefore if player is loosing at
        // any one state among the above states, player will definitely move to that state to ensure win at n-th state.
        
        // for Beerus
        // 1 represents wins at that state
        // 0 represents loose at that state.
        dp[1] = 1;
        dp[x] = 1;
        dp[y] = 1;
        for(int i = 2; i < dp.length; i++)
        {
            if(i == x || i == y)
            {
                continue;
            }
            int subAns1 = dp[i-1]^1;
            int subAns2 = 0;
            if(i-x >= 1)
            {
                subAns2 = dp[i-x]^1;
            }
            int subAns3 = 0;
            if(i-y >= 1)
            {
                subAns3 = dp[i-y]^1;
            }
            dp[i] = subAns1 | subAns2 | subAns3;
        }
        if(dp[n] == 1)
        {
	    return "Beerus";
        }
        return "Whis";
    }
}
