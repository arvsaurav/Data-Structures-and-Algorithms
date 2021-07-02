/*
Problem Statement :
Given a string S, compute recursively a new string where identical chars that are adjacent in the original string 
are separated from each other by a "*".

Input format :
String S

Output format :
Modified string
*/


public class solution {

	// Return the updated string
	public static String addStars(String str) 
    {
		// Write your code here
		if(str.length() <= 1)
            return str;
        String subStr = str.substring(1);
        String subAns = addStars(subStr);
        if(str.charAt(0) == subStr.charAt(0))
            return str.charAt(0) + "*" + subAns;
        else
            return str.charAt(0) + subAns;
	}
}


//Driver Code :
import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(solution.addStars(input));
	}
}
