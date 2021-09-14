/*
Problem Statement :
Given an array A of size n and an integer K, return all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. 
But the order of elements should remain same as in the input array.

Note : The order of subsets are not important.
*/


import java.util.ArrayList;
public class solution 
{
    // Return a 2D array that contains all the subsets which sum to k
    public static int[][] subsetsSumK(int arr[], int k) 
    {
        ArrayList<Integer> outputSoFar = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	subsetsSumK(arr, 0, k, outputSoFar, ans);
	//output will be jagged array.
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
    
    private static void subsetsSumK(int arr[], int startIndex, int k, ArrayList<Integer> outputSoFar, ArrayList<ArrayList<Integer>> ans)
    {
        //base case
	if(startIndex > arr.length-1)
        {
	    if(k == 0 && outputSoFar.size() != 0)
            {
                ans.add(outputSoFar);
            }
            return;
        }
        //don't include element present at startIndex.
        subsetsSumK(arr, startIndex+1, k, outputSoFar, ans);
        
        //include element present at startIndex.
        ArrayList<Integer> outputSoFar1 = new ArrayList<>(outputSoFar);
        outputSoFar1.add(arr[startIndex]);
        subsetsSumK(arr, startIndex+1, k-arr[startIndex], outputSoFar1, ans);
    }
}
