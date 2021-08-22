/*
Problem Statement :
Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.
Note: Array A can contain duplicate elements as well.
*/



import java.util.HashMap;

public class Solution 
{
    public static int PairSum(int[] arr, int size) 
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
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
	    int val1 = arr[i];
            int val2 = -val1;
            if(val1 == 0)
            {
                int pairs = (map.get(val1)*(map.get(val1)-1))/2;
                count += pairs;
                map.put(val1, 0);
                continue;
            }
            if(map.containsKey(val2))
            {
                int pairs = map.get(val1)*map.get(val2);
                count += pairs;
                map.put(val1, 0);
                map.put(val2, 0);
            }
           	
        }
        return count;
    }
}