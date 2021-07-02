/*
Problem Statement :
Suppose you have a string, S, made up of only 'a's and 'b's. 
Write a recursive function that checks if the string was generated using the following rules:
a. The string begins with an 'a'
b. Each 'a' is followed by nothing or an 'a' or "bb"
c. Each "bb" is followed by nothing or an 'a'
If all the rules are followed by the given string, return true otherwise return false.

Input format :
String S

Output format :
'true' or 'false'
*/


public class Solution {

   public static boolean checkAB(String str) 
   {
	   if(str.length() == 0)
           return true;
       if(str.charAt(0) == 'b')
           return false;
       
       boolean ans;
		       
       if(str.length() >= 3 && str.substring(0, 3).equals("abb"))
           ans = checkAB(str.substring(3));
       else
		   ans = checkAB(str.substring(1));
	   
       return ans;
   }
}


//Driver Code :
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		System.out.println(Solution.checkAB(input));
	}

}