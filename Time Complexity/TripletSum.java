/*
Problem Statement :
You have been given a random integer array/list(ARR) and a number X. 
Find and return the triplet(s) in the array/list which sum to X.

Note :
Given array/list can contain duplicate elements.

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
Then the test cases follow.
First line of each test case or query contains an integer 'N' representing the size of the first array/list.
Second line contains 'N' single space separated integers representing the elements in the array/list.
Third line contains an integer 'X'.

Output format :
For each test case, print the total number of triplets present in the array/list.
Output for every test case will be printed in a separate line.
*/


import java.util.Arrays;

public class Solution 
{	
	public static int tripletSum(int[] arr, int num) 
    {
		int i = 0;                   //iterator for 1st element
        int j = 0;                   //iterator for 2nd element
        int k = 0;                   //iterator for 3rd element
        int tripletCount = 0;
        int sum = 0;
        int temp1, temp2;
        int countTemp1 = 0;
        int countTemp2 = 0;
        
        Arrays.sort(arr);
        
        for(i = 0; i < arr.length; i++)
        {
            j = i + 1;
        	k = arr.length - 1;
            while(j < k)
            {
				sum = arr[i] + arr[j] + arr[k];
                if(sum > num)
                {
					k--;
                }
                else if(sum < num)
                {
                    j++;
                }
                else
                {
					if(arr[j] == arr[k])
                    {
                        tripletCount += ((k-j) * (k-j+1)) / 2;
                        break;
                        //return tripletCount;
                    }
                    temp1 = j + 1;
                    temp2 = k - 1;
                    while(temp1 <= temp2 && arr[j] == arr[temp1])
                    {
                        temp1 += 1;
                    }
                    while(temp1 <= temp2 && arr[k] == arr[temp2])
                    {
                        temp2 -= 1;
                    }
                    countTemp1 = temp1 - j;
                    countTemp2 = k - temp2;
                    tripletCount += countTemp1 * countTemp2;
                    j = temp1;
                    k = temp2;
                }
            }
        }
        return tripletCount;
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
            System.out.println(Solution.tripletSum(arr, num));

            t -= 1;
        }
    }
}