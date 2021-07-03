/*
Problem Statement :
You have been given an integer array/list(ARR) of size N. Where N is equal to [2M + 1].
Now, in the given array/list, 'M' numbers are present twice and one number is present only once.
You need to find and return that number which is unique in the array/list.

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
First line of each test case or query contains an integer 'N' representing the size of the array/list.
Second line contains 'N' single space separated integers representing the elements in the array/list.

Output Format :
For each test case, print the unique element present in the array.
Output for every test case will be printed in a separate line.
*/

import java.util.Arrays;

public class Solution {

	public static int findUnique(int[] arr) 
    {
		//Your code goes here
		int x = 0;
        for(int i = 0; i < arr.length; i++)
        {
			x = x ^ arr[i];
        }
        return x;
	}
}


//Driver Code :
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }
        
        String[] strNums; 
        strNums = br.readLine().split("\\s");
        

        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[] arr = takeInput();
            System.out.println(Solution.findUnique(arr));

            t -= 1;
        }
    }
}