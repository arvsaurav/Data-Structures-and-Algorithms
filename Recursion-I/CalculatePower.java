/*
###Problem Statement :

Write a program to find x to the power n (i.e. x^n). Take x and n from the user. You need to return the answer.
Do this recursively.

Input format :
Two integers x and n (separated by space)

Output Format :
x^n (i.e. x raise to the power n)
*/

import java.util.Scanner;

class Solution {

        public static int power(int x, int n) {
        if(n == 0)
            return 1;
        return x*power(x, n-1);
		
	}
}

//Driver Code :
public class CalculatePower {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int x = s.nextInt();
		int n = s.nextInt();
		
		System.out.println(Solution.power(x, n));
	}
}

