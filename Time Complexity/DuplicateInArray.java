/*
Problem Statement :
You have been given an integer array/list(ARR) of size N which contains numbers from 0 to (N - 2). 
Each number is present at least once. That is, if N = 5, the array/list constitutes values ranging 
from 0 to 3, and among these, there is a single integer value that is present twice. 
You need to find and return that duplicate number present in the array.

Note :
Duplicate number is always present in the given array/list.

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
First line of each test case or query contains an integer 'N' representing the size of the array/list.
Second line contains 'N' single space separated integers representing the elements in the array/list.

Output Format :
For each test case, print the duplicate element in the array/list.
Output for every test case will be printed in a separate line.
*/


public class Solution {

	public static int findDuplicate(int[] arr) {
		//Your code goes here
        int expectedSum = 0;
        int actualSum = 0;
        int ans = 0;
        int n = arr.length;
        for(int i = 0; i <= n-2; i++)
        {
			expectedSum += i;
        }
        for(int i = 0; i < n; i++)
        {
			actualSum += arr[i];
        }
        ans = actualSum - expectedSum;
        return ans;
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

    		int[] input = takeInput();
        	System.out.println(Solution.findDuplicate(input));

        	t -= 1;
    	}
    }
}