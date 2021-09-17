/*
Problem Statement :
Given an array A and an integer K, print all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. 
But the order of elements should remain same as in the input array.

Note : The order of subsets are not important. Just print them in different lines.
*/


import java.util.ArrayList;
public class solution 
{
    public static void printSubsetsSumTok(int[] arr, int k) 
    {
	ArrayList<Integer> outputSoFar = new ArrayList<>();
        printSubsetsSumTok(arr, 0, k, outputSoFar);
    }
    
    public static void printSubsetsSumTok(int[] arr, int startIndex, int k, ArrayList<Integer> outputSoFar)
    {
        //base case
        if(startIndex > arr.length-1)
        {
            if(k == 0)
            {
                for(int i = 0; i < outputSoFar.size(); i++)
                {
                    System.out.print(outputSoFar.get(i) + " ");
                }
                System.out.println();
            }
            return;
        }
        // don't include element present at startIndex of arr to subset.
     	printSubsetsSumTok(arr, startIndex+1, k, outputSoFar);
        // include element present at startIndex of arr to subset.
        ArrayList<Integer> outputSoFar1 = new ArrayList<>(outputSoFar);
        outputSoFar1.add(arr[startIndex]);
        printSubsetsSumTok(arr, startIndex+1, k-arr[startIndex], outputSoFar1);
    }
}
