/*
Print all subsequences of a string.
*/

public class Solution
{
    public static void printSubsequences(String str)
    {
	printSubsequences(str, "");
    }

    //helper function
    public static void printSubsequences(String inputString, String outputSoFar)
    {
        //base case
	if(inputString.length() == 0)
	{
	    System.out.println(outputSoFar);
	    return;
	}
	// we choose not to include first character of current string for output string. 
	printSubsequences(inputString.substring(1), outputSoFar);
	// we choose to include first character of current string for output string.
	printSubsequences(inputString.substring(1), outputSoFar + inputString.charAt(0));
    }
}