/*
Problem Statement :
Write a recursive function that returns the sum of the digits of a given integer.

Input format :
Integer N

Output format :
Sum of digits of N
*/



public class solution {
    
    //consider n = 12345

	public static int sumOfDigits(int n)
    {
		// Write your code here
        if(n == 0)
        {
			return 0;
        }
		int smallSum = sumOfDigits(n/10);  //Give sumOfDigits of 1234.
        int lastDigit = n % 10;            // Last digit is 5.
        int finalSum = smallSum + lastDigit;
        return finalSum;
	}
}


//Driver Code :
import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(solution.sumOfDigits(n));
	}
}
