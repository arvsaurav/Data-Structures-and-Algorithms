/*
Problem Statement :
Given a string S, remove consecutive duplicates from it recursively.

Input Format :
String S

Output Format :
Output string
*/

//Driver Code :
import java.util.Scanner;

public class Main {
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
    	String input = s.next();
    	System.out.println(Solution.removeConsecutiveDuplicates(input));
    }
}


public class Solution {

	public static String removeConsecutiveDuplicates(String s) 
    {
		if(s.length() <= 1)
            return s;
        String subStr = removeConsecutiveDuplicates(s.substring(1));
        if(s.charAt(0) == subStr.charAt(0))
            //consecutive duplicate found.
            return subStr;
        else
            return s.charAt(0) + subStr;
        
	}

}


