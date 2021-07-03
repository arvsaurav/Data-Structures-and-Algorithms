/*
Problem Statement :
You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively. 
You need to print their intersection; An intersection for this problem can be defined when 
both the arrays/lists contain a particular value or to put it in other words, when there is 
a common value that exists in both the arrays/lists.

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
The first line of each test case or query contains an integer 'N' representing the size of the first array/list.
The second line contains 'N' single space separated integers representing the elements of the first the array/list.
The third line contains an integer 'M' representing the size of the second array/list.
The fourth line contains 'M' single space separated integers representing the elements of the second array/list.

Output format :
For each test case, print the intersection elements in a row, separated by a single space.
Output for every test case will be printed in a separate line.
*/

import java.util.Arrays;
public class Solution {

	public static void intersection(int[] arr1, int[] arr2) 
    {
	    //Your code goes here
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        int j = 0;
        while(i < arr1.length && j < arr2.length)
        {
			if(arr1[i] > arr2[j])
            {
				j += 1;
            }
            else if(arr1[i] < arr2[j])
            {
				i += 1;
            }
            else
            {
				System.out.print(arr1[i] + " ");
                i += 1;
                j += 1;
            }
        }
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
            int[] arr1 = takeInput();
            int[] arr2 = takeInput();
            Solution.intersection(arr1, arr2);
            System.out.println();

            t -= 1;
        }
    }
}