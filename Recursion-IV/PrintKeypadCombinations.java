/*
Problem Statement :
Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.

Note : The order of strings are not important. Just print different strings in new lines.
*/



public class solution 
{
    public static void printKeypad(int n)
    {
	printKeypad(n, "");
    }
    //helper function
    public static void printKeypad(int n, String outputSoFar)
    {
	//base case
        if(n == 0)
        {
            System.out.println(outputSoFar);
            return;
        }
        char[] val = helper(n%10);
        for(int i = 0; i < val.length; i++)
        {
            printKeypad(n/10, val[i] + outputSoFar);
        }
    }
    
    public static char[] helper(int n)
    {
        if(n == 2)
        {
	    char[] val = {'a', 'b', 'c'};
            return val;
        }
        else if(n == 3)
        {
            char[] val = {'d', 'e', 'f'};
            return val;
        }
        else if(n == 4)
        {
	    char[] val = {'g', 'h', 'i'};
            return val;
        }
        else if(n == 5)
        {
	    char[] val = {'j', 'k', 'l'};
            return val;
        }
        else if(n == 6)
        {
	    char[] val = {'m', 'n', 'o'};
            return val;
        }
        else if(n == 7)
        {
	    char[] val = {'p', 'q', 'r', 's'};
            return val;
        }
        else if(n == 8)
        {
	    char[] val = {'t', 'u', 'v'};
            return val;
        }
        else  // n == 9
        {
	    char[] val = {'w', 'x', 'y', 'z'};
            return val;
        }
    }
}
