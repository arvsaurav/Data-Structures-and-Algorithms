/*
Problem Statement :
Given an integer N, count and return the number of zeros that are present in the given integer using recursion.

Input Format :
Integer N

Output Format :
Number of zeros in N
*/

public class solution 
{
	public static int countZerosRec(int n)
    {
        if(n < 10)
        {
			if(n == 0)         //means input is 0.
                return 1;
            else
                return 0;      //got anything b/w 1 to 9 (including 1 and 9) by performing n/10 operation.
        }
        int smallAnswer = countZerosRec(n/10);
        int lastDigit = n % 10;
        if(lastDigit == 0)
            return smallAnswer +1;
        else
            return smallAnswer;
    }
}


//Driver Code :
import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(solution.countZerosRec(n));
	}
}
