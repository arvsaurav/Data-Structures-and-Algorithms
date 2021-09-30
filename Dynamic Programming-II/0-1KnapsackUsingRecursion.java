/*
Problem Statement :
A thief robbing a store can carry a maximal weight of W into his knapsack. There are N items, 
and i-th item weigh 'Wi' and the value being 'Vi.' What would be the maximum value V, that the thief can steal?

Input Format :
The first line of the input contains an integer value N, which denotes the total number of items.

The second line of input contains the N number of weights separated by a single space.

The third line of input contains the N number of values separated by a single space.

The fourth line of the input contains an integer value W, which denotes the maximum weight the thief can steal.
*/


public class Solution 
{
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) 
    {
        // maxWeight -> maximum capacity of knapsack or remaining capacity of knapsack
        // i -> starting index of items
	return knapsack(weights, values, n, maxWeight, 0);
    }
    // helper function 
    public static int knapsack(int weights[], int values[], int n, int maxWeight, int i)
    {
        // base case
        if(i == n)
        {
            return 0;
        }
        
        // can't include i-th item because it's weight is greater than maximum capacity of knapsack
        if(weights[i] > maxWeight)
        {
            int myAns = knapsack(weights, values, n, maxWeight, i+1);
            return myAns;
        }
        // can include i-th item in knapsack
        else
        {
            // included i-th item
            int subAns1 = values[i] + knapsack(weights, values, n, maxWeight-weights[i], i+1);
            // don't included i-th item
            int subAns2 = knapsack(weights, values, n, maxWeight, i+1);
            int myAns = Math.max(subAns1, subAns2);
            return myAns;
        }
    }
}