/*
Problem Statement :
Given a string, compute recursively a new string where all 'x' chars have been removed.

Input format :
String S

Output format :
Modified String
*/


public class solution {

	// Return the changed string
	public static String removeX(String str)
    {
		if(str.length() == 0)
            //returns empty string
            return str;
        String subStr = removeX(str.substring(1));
        if(str.charAt(0) == 'x')
            return subStr;
        else
            return str.charAt(0) + subStr;

	}
}

//Driver Code :
import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(solution.removeX(input));
	}
}
