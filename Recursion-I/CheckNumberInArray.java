/*
Problem Statement :
Given an array of length N and an integer x, you need to find if x is present in the array or not. Return true or false.
Do this recursively.

Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x

Output Format :
'true' or 'false
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
		int x = s.nextInt();
		System.out.println(Solution.checkNumber(input, x));
	}
}


public class Solution {
	
	public static boolean checkNumber(int input[], int x) 
    {
        if(input.length == 0)
            return false;
        if(input[0] == x)
            return true;
        int subarray[] = new int[input.length - 1];
        for(int i = 1; i < input.length; i++)
        {
			subarray[i-1] = input[i];
        }
        return checkNumber(subarray, x);
	}
}
