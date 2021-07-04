/*
Problem Statement :
You have been given an integer array/list(ARR) and a number 'num'. 
Find and return the total number of pairs in the array/list which sum to 'num'.

Note:
Given array/list can contain duplicate elements. 

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
First line of each test case or query contains an integer 'N' representing the size of the first array/list.
Second line contains 'N' single space separated integers representing the elements in the array/list.
Third line contains an integer 'num'.

Output format :
For each test case, print the total number of pairs present in the array/list.
Output for every test case will be printed in a separate line.
*/


import java.util.Arrays;

public class Solution {	

	public static int pairSum(int[] arr, int num) {
		//Your code goes here
        
        Arrays.sort(arr);
        
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int pairSum = 0;
        int pairCount = 0;
        int temp1;
        int temp2;
        int countTemp1, countTemp2;
        
        while(startIndex < endIndex)
        {
			pairSum = arr[startIndex] + arr[endIndex];
            
            if(pairSum > num)
            {
				endIndex = endIndex - 1;
            }
            else if(pairSum < num)
            {
				startIndex = startIndex + 1;
            }
            else
            {
                if(arr[startIndex] == arr[endIndex])      
                {
                    pairCount = pairCount + ((endIndex - startIndex) * (endIndex - startIndex + 1)) / 2;
					return pairCount;
                }
                
                temp1 = startIndex + 1;
                temp2 = endIndex - 1;
                
                while(temp1 <= temp2 && arr[startIndex] == arr[temp1])
                {
                    temp1 = temp1 + 1;
                }
                
                while(temp1 <= temp2 && arr[endIndex] == arr[temp2])
                {
					temp2 = temp2 - 1;
                }
                
                countTemp1 = temp1 - startIndex;
                countTemp2 = endIndex - temp2;
                
                pairCount = pairCount + (countTemp1 * countTemp2);
                
                startIndex = temp1;
                endIndex = temp2;
            }
        }
        return pairCount;
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
            int num = Integer.parseInt(br.readLine().trim());
            System.out.println(Solution.pairSum(arr, num));

            t -= 1;
        }
    }
}