/*
Problem Statement :
Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.
*/


import java.util.HashMap;
public class Solution 
{
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) 
    {
	HashMap<Integer, Integer> map = new HashMap<>();
        // key -> sum till that index
        // value -> index where sum appeared for first time
        int currentSum = 0;
    	int currentSequenceLength = 0;
        int maxSequenceLength = 0;
        for(int i = 0; i < arr.length; i++)
        {
            currentSum = currentSum + arr[i];
            if(currentSum == 0)   //edge case
            {
                currentSequenceLength = i + 1;
                if(currentSequenceLength > maxSequenceLength)
                {
		    maxSequenceLength = currentSequenceLength;
                }
            }
            else if(map.containsKey(currentSum))
            {
                int startIndex = map.get(currentSum);
                currentSequenceLength = i - startIndex;
                if(currentSequenceLength > maxSequenceLength)
                {
		    maxSequenceLength = currentSequenceLength;
                }
            }
            else
            {
                map.put(currentSum, i);
            }
        }
        return maxSequenceLength;
    }
}