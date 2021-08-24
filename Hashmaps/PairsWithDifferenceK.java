/*
Problem Statement :
You are given with an array of integers and an integer K. 
You have to find and print the count of all such pairs which have difference K.

Note: Take absolute difference between the elements of the array.
*/


import java.util.HashMap;
import java.lang.Math;
public class Solution 
{
    public static int getPairsWithDifferenceK(int arr[], int k) 
    {
	HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
        {
            if(map.containsKey(arr[i]))
            {
                int freq = map.get(arr[i]);
                map.put(arr[i], freq + 1);
            }
            else
            {
		map.put(arr[i], 1);
            }
        }
        int pairs = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(map.get(arr[i]) > 0)
            {
		int reqVal1 = arr[i] - k;
            	int reqVal2 = arr[i] + k;
                if(k == 0)
                {
                    int freq = map.get(arr[i]);
                    pairs += (freq*(freq-1)) / 2;
                    map.put(arr[i], 0);
                }
                if(k <= arr[i] && map.containsKey(reqVal1))
                {
                    int freq = map.get(reqVal1);
                    pairs += freq;
                }
                if(map.containsKey(reqVal2))
                {
                    int freq = map.get(reqVal2);
                    pairs += freq;
                }
                map.put(arr[i], map.get(arr[i]) - 1);
            }
        }
        return pairs;
    }
}