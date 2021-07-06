/*
Problem Statement :
Given an integer array A of size N, check if the input array can be splitted in two parts such that -
- Sum of both parts is equal
- All elements in the input, which are divisible by 5 should be in same group.
- All elements in the input, which are divisible by 3 (but not divisible by 5) should be in other group.
- Elements which are neither divisible by 5 nor by 3, can be put in any group.
Groups can be made with any set of elements, i.e. elements need not to be continuous. And you need to 
consider each and every element of input array in some group.
Return true, if array can be split according to the above rules, else return false.

Input Format :
Line 1 : Integer N (size of array)
Line 2 : Array A elements (separated by space)

Output Format :
true or false
*/



public class solution {

	public static boolean splitArray(int arr[]) {
        return splitArray(arr, 0, 0, 0);
	}
	
	public static boolean splitArray(int arr[], int startIndex, int sumThree, int sumFive)
    {
        //base case
        if(startIndex >= arr.length)
        {
			if(sumThree == sumFive)
                return true;
            else
                return false;
        }
        
        if(arr[startIndex] % 5 == 0)
        {
			sumFive = sumFive + arr[startIndex];
        }
        else if(arr[startIndex] % 3 == 0)
        {
			sumThree = sumThree + arr[startIndex];
        }
        else
        {
            boolean ansFive = splitArray(arr, startIndex + 1, sumThree, sumFive + arr[startIndex]);
            boolean ansThree = splitArray(arr, startIndex + 1, sumThree + arr[startIndex], sumFive);
            return ansFive || ansThree;
        }
        return splitArray(arr, startIndex + 1, sumThree, sumFive);
    }
}


//Driver Code :
import java.util.Scanner;


public class runner {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		System.out.println(solution.splitArray(input));
	}
}
