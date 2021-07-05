/*
Problem Statement :
Given two string s and t, write a function to check if s contains all characters of t (in the same order as they are in string t).
Return true or false.
Do it recursively.

E.g. : s = “abchjsgsuohhdhyrikkknddg” contains all characters of t=”coding” in the same order. So function will return true.

Input Format :
Line 1 : String s
Line 2 : String t

Output Format :
true or false
*/


public class Solution {
	public static boolean checkSequence(String s, String t) {
        int j = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(j >= t.length())
                break;
            if(t.charAt(j) == s.charAt(i))
            {
				count++;
                j++;
            }
        }
        if(count == t.length())
        {
			return true;
        }
		else
        {
            return false;
        }
	}
}


//Driver Code :
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String large = s.nextLine();
		String small = s.nextLine();

		System.out.println(Solution.checkSequence(large, small));
	}
}