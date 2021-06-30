/*
Problem Statement :
Given two integers M & N, calculate and return their multiplication using recursion. 
You can only use subtraction and addition for your calculation. No other operators are allowed.

Input format :
Line 1 : Integer M
Line 2 : Integer N

Output format :
M x N
*/


public class solution {

	public static int multiplyTwoIntegers(int m, int n)
    {
		// Write your code here
        if(n == 0)
            return 0;
        int smallSum = multiplyTwoIntegers(m, n-1);
		return smallSum + m;
	}
}


//Driver Code :
import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		System.out.println(solution.multiplyTwoIntegers(m, n));
	}
}
