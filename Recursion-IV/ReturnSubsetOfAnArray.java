/*
Problem Statement :
Given an integer array (of length n), find and return all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. 
But the order of elements should remain same as in the input array.

Note : The order of subsets are not important.
*/


import java.util.ArrayList;
public class solution 
{
    // Return a 2D array that contains all the subsets
    public static int[][] subsets(int[] arr) 
    {
	ArrayList<Integer> outputSoFar = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subsets(arr, 0, outputSoFar, ans);
        //convert arraylist into array
        // jagged array
        int[][] output = new int[ans.size()][];
        for(int i = 0; i < ans.size(); i++)
        {
            output[i] = new int[ans.get(i).size()];
            for(int j = 0; j < ans.get(i).size(); j++)
            {
                output[i][j] = ans.get(i).get(j);
            }
        }
        return output;
    }
    
    private static void subsets(int[] arr, int startIndex, ArrayList<Integer> outputSoFar, ArrayList<ArrayList<Integer>> ans)
    {
        if(startIndex > arr.length-1)
        {
            ans.add(outputSoFar);
            return;
        }
        //don't include arr[startIndex] in subset
        subsets(arr, startIndex+1, outputSoFar, ans);
        //include arr[startIndex] in subset
        ArrayList<Integer> outputSoFar1 = new ArrayList<>(outputSoFar);  //add elements of outputSoFar in outputSoFar1
        outputSoFar1.add(arr[startIndex]);  // included arr[startIndex]
        subsets(arr, startIndex+1, outputSoFar1, ans);
    }
}
