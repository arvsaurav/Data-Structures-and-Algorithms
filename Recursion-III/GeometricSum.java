/*
Problem Statement :
Given k, find the geometric sum i.e.
1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k) 

Input format :
Integer k

Output format :
Geometric sum (upto 5 decimal places)
*/

//Driver Code :
import java.text.DecimalFormat;
import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		double ans = solution.findGeometricSum(k);
		DecimalFormat dec = new DecimalFormat("#0.00000");
		System.out.println(dec.format(ans));
	}
}


import java.lang.Math;
public class solution {

	public static double findGeometricSum(int k)
    {
        if(k == 0)
        {
            return 1;                       //first term of the series.
        }
		double s = findGeometricSum(k-1);      //recursive call. It will give the sum of (k-1) terms.
        double lastTerm = 1 / Math.pow(2, k);         //last term of the series.
		return s + lastTerm;
	}
}
