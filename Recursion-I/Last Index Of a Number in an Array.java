/*
Problem Statement : 

Given an array of length N and an integer x, you need to find and return the last index of integer x present in the array. Return -1 if it is not present in the array.
Last index means - if x is present multiple times in the array, return the index at which x comes last in the array.
You should start traversing your array from 0, not from (N - 1).
Do this recursively. Indexing in the array starts from 0.

Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x

Output Format :
last index or -1
*/


//Driver Code :
import java.util.Scanner;

public class Runner {
	
	static Scanner s = new Scanner(System.in);
	
	public static int[] takeInput(){
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int x = s.nextInt();
		System.out.println(Solution.lastIndex(input, x));
	}
}


public class Solution {

	public static int lastIndex(int arr[], int x) 
    {
        return lastIndex(arr, x, 0);
	  }
    public static int lastIndex(int arr[], int x, int startIndex)
    {
		if(startIndex > arr.length - 1)
        {
            return -1;
        }
        int smallAns = lastIndex(arr, x, startIndex + 1);
        if(smallAns == -1)
        {
            if(arr[startIndex] == x)
                return startIndex;
            else
                return -1;
        }
        else
        {
            return smallAns;
        }
    }
	
}
