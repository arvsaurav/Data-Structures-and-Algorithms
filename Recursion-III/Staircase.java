/*
Problem Statement :
A child is running up a staircase with N steps, and can hop either 1 step, 2 steps or 3 steps at a time. 
Implement a method to count how many possible ways the child can run up to the stairs. 
You need to return number of possible ways W.

Input format :
Integer N

Output Format :
Integer W
*/



public class Solution {
	
		
     public static int staircase(int n)
     {
         if(n <= 1)
             return 1;
         if(n == 2)
             return 2;
         int outOne = staircase(n-1);        //return all posibilities when first step taken is 1 step.
         int outTwo = staircase(n-2);        //returns all posibilities when first step taken is 2 step.
         int outThree = staircase(n-3);      //returns all posibilities when first step taken is 3 step.
         int finalAnswer = outOne + outTwo + outThree;
         return finalAnswer;
		
	}
	
}


//Driver Code :
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(Solution.staircase(n));
	}
}
