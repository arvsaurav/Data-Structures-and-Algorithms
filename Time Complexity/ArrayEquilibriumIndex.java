/*
Problem Statement :
For a given array/list(ARR) of size 'N,' find and return the 'Equilibrium Index' of the array/list.
Equilibrium Index of an array/list is an index 'i' such that the sum of elements at indices [0 to (i - 1)] 
is equal to the sum of elements at indices [(i + 1) to (N-1)]. One thing to note here is, the item at the 
index 'i' is not included in either part.
If more than one equilibrium indices are present, then the index appearing first in left to right fashion
should be returned. Negative one(-1) if no such index is present.

Input Format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
The first line of each test case or query contains an integer 'N' representing the size of the first array/list.
The second line contains 'N' single space separated integers representing the elements of the array/list

Output Format :
For each test case, print the 'Equilibrium Index'.
Output for every test case will be printed in a separate line.
*/


public class Solution {

	public static int arrayEquilibriumIndex(int[] arr)
    {  
		//Your code goes here
        if(arr.length == 0)
            return -1;
        
        int sumLeft = 0;
        int sumRight = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
			sumRight = sumRight + arr[i];
        }
        
        for(int i = 0; i < arr.length; i++)
        {
			sumRight = sumRight - arr[i];
            if(sumLeft == sumRight)
            {
                return i;
            }
            sumLeft = sumLeft + arr[i];
        }
        return -1;
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
            System.out.println(Solution.arrayEquilibriumIndex(arr));

            t -= 1;
        }
    }
}