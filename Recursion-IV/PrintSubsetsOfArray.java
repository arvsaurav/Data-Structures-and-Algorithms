/*
Problem Statement :
Given an integer array (of length n), find and print all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. 
But the order of elements should remain same as in the input array.

Note : The order of subsets are not important. Just print the subsets in different lines.
*/



import java.util.ArrayList;
public class solution 
{
    public static void printSubsets(int[] arr) 
    {
        ArrayList<Integer> outputSoFar = new ArrayList<>();
	printSubsets(arr, 0, outputSoFar);
    }
    
    public static void printSubsets(int[] arr, int startIndex, ArrayList<Integer> outputSoFar)
    {
        //base case
        if(startIndex > arr.length-1)
        {
	    for(int i = 0; i < outputSoFar.size(); i++)
            {
                System.out.print(outputSoFar.get(i) + " ");
            }
            System.out.println();
            return;
        }
        // don't include arr[startIndex] in subset
        printSubsets(arr, startIndex+1, outputSoFar);
        //include arr[startIndex] in subset.
        ArrayList<Integer> outputSoFar1 = new ArrayList<>(outputSoFar);
        outputSoFar1.add(arr[startIndex]);
        printSubsets(arr, startIndex+1, outputSoFar1);
    }
}
