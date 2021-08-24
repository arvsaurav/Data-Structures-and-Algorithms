/*
Problem Statement :
You are given an array of unique integers that contain numbers in random order. 
You have to find the longest possible sequence of consecutive numbers using the numbers from given array.
You need to return the output array which contains starting and ending element. 
If the length of the longest possible sequence is one, then the output array must contain only single element.

Note:
1. Best solution takes O(n) time.
2. If two sequences are of equal length, then return the sequence starting with the number whose occurrence is earlier in the array.
*/


import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr)
    {
	HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
        {
            map.put(arr[i], true);
        }
        int start = -1;  //start of sequence
        int maxSequenceLength = 0;
        for(int i = 0; i < arr.length; i++)
        {
            int currentSequenceLength = 1;
            if(map.get(arr[i]))  //if value is false, then it means we have considered this element in making of another sequence
            {
                //if value is true then, this line will execute
                int j = arr[i] + 1;
                map.put(arr[i], false);
                while(true)  //checking for consecutive numbers after arr[i]
                {
                    if(map.containsKey(j))
                    {
			currentSequenceLength++;
                        map.put(j, false);
                        j++;
                    }
                    else
                    {
                        break;
                    }
                }
                j = arr[i] - 1;
                while(true)  //checking for consecutive numbers before arr[i]
                {
                    if(map.containsKey(j))
                    {
                        currentSequenceLength++;
                        map.put(j, false);
                        j--;
                    }
                    else
                    {
                        break;
                    }
                }
                if(currentSequenceLength == maxSequenceLength)
                {
                    for(int k = 0; k < arr.length; k++)
                    {
                        if(arr[k] == j+1)
                        {
                            start = j+1;
                            break;
                        }
                        if(arr[k] == start)
                        {
                            break;
                        }
                    }
                }
                if(currentSequenceLength > maxSequenceLength)
                {
                    maxSequenceLength = currentSequenceLength;
                    start = j+1;
                }
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        output.add(start);
        if(maxSequenceLength > 1)
        	output.add(start + maxSequenceLength - 1);
        return output;
    }
}
