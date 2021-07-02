/*
Problem Statement :
Write a recursive function to convert a given string into the number it represents. 
That is input will be a numeric string that contains only numbers, you need to convert 
the string into corresponding integer and return the answer.

Input format :
Numeric string S (string, Eg. "1234")

Output format :
Corresponding integer N (int, Eg. 1234)
*/



public class solution 
{
	public static int convertStringToInt(String str)
    {
		// Write your code here
        if(str.length() == 0)
            return 0;
        String subString = str.substring(0, str.length() - 1);
        int subAnswer = convertStringToInt(subString);
		int lastInt = str.charAt(str.length()-1) - '0';
        int ans = (subAnswer * 10) + lastInt;
        return ans;
	}
}


//Driver Code :
import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(solution.convertStringToInt(input));
	}
}
