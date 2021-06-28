/*
Problem Statement :
Given an array of length N and an integer x, you need to find and return the first index of integer x present in the array. Return -1 if it is not present in the array.
First index means, the index of first occurrence of x in the input array.
Do this recursively. Indexing in the array starts from 0.

Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x

Output Format :
first index or -1
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
		System.out.println(Solution.firstIndex(input, x));
	}
}

public class Solution 
{

	public static int firstIndex(int arr[], int x) 
    {

        return firstIndex(arr, x, 0);
	  }
    
    public static int firstIndex(int arr[], int x, int startingIndex) 
    {
    	if(startingIndex > arr.length - 1) 
        { 										
            // startingIndex is beyond the indices of the array, so the number is not found.
        	return -1;
    	}

    	if(arr[startingIndex] == x) 
        { 
            // current index is the first index that contains x.
        	return startingIndex;
    	} 
        
        // make a recursive call to find the first index of x in the rest of the array.
        return firstIndex(arr, x, startingIndex + 1);
    }
    
}


