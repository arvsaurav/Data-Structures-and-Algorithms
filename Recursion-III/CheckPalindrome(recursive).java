/*
Problem Statement :
Check whether a given String S is a palindrome using recursion. Return true or false.

Input Format :
String S

Output Format :
'true' or 'false'
*/


public class solution {

	public static boolean isStringPalindrome(String str) 
    {
		if(str.length() <= 1)
            return true;
        boolean out = isStringPalindrome(str.substring(1, str.length()-1));
        if(out == true)
        {
            if(str.charAt(0) == str.charAt(str.length()-1))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
			return false;
        }

	}
}



//Driver Code :
import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(solution.isStringPalindrome(input));
	}
}
