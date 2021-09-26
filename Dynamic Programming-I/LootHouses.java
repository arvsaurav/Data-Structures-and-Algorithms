/*
Problem Statement :
A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses. 
Find the maximum amount of money he can loot.
*/



public class Solution 
{
    // Iterative Dynamic Programming :
    public static int maxMoneyLooted(int[] houses) 
    {
        if(houses.length == 0)
        {
             return 0;
        }
        if(houses.length == 1)
        {
             return houses[0];
        }
        int dp[] = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        for(int i = 2; i < houses.length; i++)
        {
	    	dp[i] = Math.max(dp[i-1], houses[i] + dp[i-2]);
        }
		return dp[dp.length-1];
    }
}


// Simple recursive approach (without dp) :

//     public static int maxMoneyLooted(int[] houses) 
//     {
// 	    return maxMoneyLooted(houses, 0, houses.length-1);   
//     }
    
//     public static int maxMoneyLooted(int[] houses, int startIndex, int endIndex)
//     {
//         //base case
//         if(startIndex > endIndex)
//         {
//             return 0;
//         }
//         if(endIndex-startIndex+1 == 1)
//         {
//             return houses[startIndex];
//         }
//         if(endIndex-startIndex+1 == 2)
//         {
//             return Math.max(houses[startIndex], houses[startIndex+1]);
//         }
        
//         int smallAns1 = houses[startIndex] + maxMoneyLooted(houses, startIndex+2, endIndex);
//         int smallAns2 = houses[startIndex+1] + maxMoneyLooted(houses, startIndex+3, endIndex);
//         return Math.max(smallAns1, smallAns2);
//     }