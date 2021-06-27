/*
Problem Statement :
Given is the code to print numbers from 1 to n in increasing order recursively. But it contains few bugs that you need to rectify such that all the test cases pass.

Input Format :
Integer n

Output Format :
Numbers from 1 to n (separated by space)
*/

//Driver Code :
import java.util.Scanner;

public class Runner {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Solution.print(n);
	}
	
}
class Solution {

	public static void print(int n){
		if(n == 1){
			System.out.print(1+" ");
            return;
		}
        print(n-1);
		System.out.print(n+" ");
	}

}

