/*
Problem Statement :
You are given an array of integers that contain numbers in random order. Write a program to find and return the number 
which occurs the maximum times in the given input.
If two or more elements contend for the maximum frequency, return the element which occurs in the array first.
*/



import java.util.HashMap;
public class Solution 
{
    public static int maxFrequencyNumber(int[] arr)
    { 
	HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
        {
            if(map.containsKey(arr[i]))
            {
                int freq = map.get(arr[i]);
                map.put(arr[i], freq+1);
            }
            else
            {
                map.put(arr[i], 1);
            }
        }
        int maxFreq = Integer.MIN_VALUE;
        int ans = -1;
        for(int i = 0; i < arr.length; i++)
        {
            if(map.get(arr[i]) > maxFreq)
            {
                ans = arr[i];
                maxFreq = map.get(arr[i]);
            }
        }    
        return ans;
    }
}

