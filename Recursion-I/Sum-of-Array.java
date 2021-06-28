/*
Problem Statement :
Given an array of length N, you need to find and return the sum of all elements of the array.
Do this recursively.

Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces

Output Format :
Sum
*/


//Driver Code :
import java.util.Scanner;

public class Runner {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		System.out.println(Solution.sum(input));
	}
}



public class Solution {

    public static int sum(int input[]) 
    {
        if(input.length == 0)
            return 0;
        int subarray[] = new int[input.length-1];
        for(int i = 1; i < input.length; i++)
        {
            subarray[i-1] = input[i];
		}
        int val = input[0];
        int valSubarray = sum(subarray);
        return val + valSubarray;
	}
}
